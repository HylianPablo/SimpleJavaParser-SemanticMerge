import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
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
            String text = new String(Files.readAllBytes(Paths.get(input)), StandardCharsets.UTF_8);
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
            fw.write("---\n");
            fw.write("type: file\n");
            fw.write("name: {0} " + input+"\n");
            fw.write("locationSpan : {start: [1,0], end: [12,1]}\n");
            fw.write("footerSpan : [0,-1]\n");
            fw.write("parsingErrorsDetected : false\n");
            fw.write("children:\n");

            fw.write("  - type : class\n");
            fw.write("    name : Socket\n");
            fw.write("    locationSpan : {start: [1,0], end: [12,1]}\n");
            fw.write("    headerSpan : [0, 16]\n");
            fw.write("    footerSpan : [186, 186]\n");
            fw.write("    children :\n");

            fw.write("    - type : method\n");
            fw.write("      name : Connect\n");
            fw.write("      locationSpan : {start: [3, 0], end: [7,2]}\n");
            fw.write("      span : [17, 109]\n");

            fw.write("    - type : method\n");
            fw.write("      name : Disconnect\n");
            fw.write("      locationSpan : {start: [8,0], end: [11,6]}\n");
            fw.write("      span : [110, 185]\n");
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void ParseDestination(String input, String output) {
        try {
            File outF = new File(output);
            FileWriter fw = new FileWriter(outF);
            fw.write("---\n");
            fw.write("type: file\n");
            fw.write("name: {0} "+ input+"\n");
            fw.write("locationSpan : {start: [1,0], end: [14,1]}\n");
            fw.write("footerSpan : [0,-1]\n");
            fw.write("parsingErrorsDetected : false\n");
            fw.write("children:\n");

            fw.write("  - type : class\n");
            fw.write("    name : Socket\n");
            fw.write("    locationSpan : {start: [1,0], end: [14,1]}\n");
            fw.write("    headerSpan : [0, 20]\n");
            fw.write("    footerSpan : [200, 200]\n");
            fw.write("    children :\n");

            fw.write("    - type : method\n");
            fw.write("      name : Disconnect\n");
            fw.write("      locationSpan : {start: [5, 0], end: [9,2]}\n");
            fw.write("      span : [21, 98]\n");

            fw.write("    - type : method\n");
            fw.write("      name : Connect\n");
            fw.write("      locationSpan : {start: [10,0], end: [13,6]}\n");
            fw.write("      span : [99, 199]\n");
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
