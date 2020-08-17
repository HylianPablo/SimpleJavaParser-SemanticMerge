import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.util.*;

public class DumbParser {
    public static void main(String args[]) {
        try (PrintWriter out = new PrintWriter(args[1])) {
            out.println("READY");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);

        String firstFile = scanner.nextLine();
        String firstEncoding = scanner.nextLine();
        String firstFileOutput = scanner.nextLine();
        ParseFile(firstFile, firstFileOutput);
        System.out.println("OK");

        String secondFile = scanner.nextLine();
        String secondEncoding = scanner.nextLine();
        String secondFileOutput = scanner.nextLine();
        ParseFile(secondFile, secondFileOutput);
        System.out.println("OK");

        String end = scanner.nextLine();
        scanner.close();
        if (end.equals("end")) {
            return;
        }

    }

    private static void ParseFile(String input, String output) {
        try {
            String text = new String(Files.readAllBytes(Paths.get(input)));
            if (text.indexOf("mTimeout") < 0) {
                ParseSource(input, output);
                return;
            }
            ParseDestination(input, output);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void ParseSource(String input, String output) {
        try {
            File outF = new File(output);
            FileWriter fw = new FileWriter(outF);
            fw.write("---\r\n");
            fw.write("type: file\r\n");
            fw.write("name: {0} " + input+"\r\n");
            fw.write("locationSpan : {start: [1,0], end: [12,1]}\r\n");
            fw.write("footerSpan : [0,-1]\r\n");
            fw.write("parsingErrorsDetected : false\r\n");
            fw.write("children:\r\n");

            fw.write("  - type : class\r\n");
            fw.write("    name : Socket\r\n");
            fw.write("    locationSpan : {start: [1,0], end: [12,1]}\r\n");
            fw.write("    headerSpan : [0, 16]\r\n");
            fw.write("    footerSpan : [186, 186]\r\n");
            fw.write("    children :\r\n");

            fw.write("    - type : method\r\n");
            fw.write("      name : Connect\r\n");
            fw.write("      locationSpan : {start: [3, 0], end: [7,2]}\r\n");
            fw.write("      span : [17, 109]\r\n");

            fw.write("    - type : method\r\n");
            fw.write("      name : Disconnect\r\n");
            fw.write("      locationSpan : {start: [8,0], end: [11,6]}\r\n");
            fw.write("      span : [110, 185]\r\n");
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void ParseDestination(String input, String output) {
        try {
            File outF = new File(output);
            FileWriter fw = new FileWriter(outF);
            fw.write("---\r\n");
            fw.write("type: file\r\n");
            fw.write("name: {0} "+ input+"\r\n");
            fw.write("locationSpan : {start: [1,0], end: [14,1]}\r\n");
            fw.write("footerSpan : [0,-1]\r\n");
            fw.write("parsingErrorsDetected : false\r\n");
            fw.write("children:\r\n");

            fw.write("  - type : class\r\n");
            fw.write("    name : Socket\r\n");
            fw.write("    locationSpan : {start: [1,0], end: [14,1]}\r\n");
            fw.write("    headerSpan : [0, 20]\r\n");
            fw.write("    footerSpan : [200, 200]\r\n");
            fw.write("    children :\r\n");

            fw.write("    - type : method\r\n");
            fw.write("      name : Disconnect\r\n");
            fw.write("      locationSpan : {start: [5, 0], end: [9,2]}\r\n");
            fw.write("      span : [21, 98]\r\n");

            fw.write("    - type : method\r\n");
            fw.write("      name : Connect\r\n");
            fw.write("      locationSpan : {start: [10,0], end: [13,6]}\r\n");
            fw.write("      span : [99, 199]\r\n");
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
