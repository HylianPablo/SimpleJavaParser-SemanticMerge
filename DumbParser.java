import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.*;

public class DumbParser{
    public static void main (String args[]){
        try (PrintWriter out = new PrintWriter(args[1])) {
            out.println("READY");
            String flagfile= args[1];
            out.close();
            //Files.delete(Path.of(flagfile, ""));
        //}

        /*try{
            File flag = new File(args[1]);
            FileWriter fw = new FileWriter(flag);
            fw.write("READY");
            fw.close();
            flag.delete();*/
        }catch(IOException ex){
            ex.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);

        String firstFile = scanner.nextLine();
        //String firstEncoding = scanner.nextLine();
        String firstFileOutput = scanner.nextLine();
        ParseFile(firstFile,firstFileOutput);
        System.out.println("OK");

        String secondFile = scanner.nextLine();
        //String secondEncoding = scanner.nextLine();
        String secondFileOutput = scanner.nextLine();
        ParseFile(secondFile,secondFileOutput);
        System.out.println("OK");

        String end = scanner.nextLine();
        scanner.close();
        if(end.equals("end")){
            return;
        }

    }

    private static void ParseFile(String input, String output){
        try{
            String text = new String(Files.readAllBytes(Paths.get(input)), StandardCharsets.UTF_8);
            if(text.indexOf("yyy")<0){
                ParseSource(input,output);
                return;
            }
            ParseDestination(input,output);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        //ParseDestination(input,output);
    }

    private static void ParseSource(String input, String output){
        try{
            File outF = new File(output + ".txt");
            FileWriter fw = new FileWriter(outF);
            fw.write("Source 1\n");
            fw.write("Source 2\n");
            fw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private static void ParseDestination(String input, String output){
        try{
            File outF = new File(output + ".txt");
            FileWriter fw = new FileWriter(outF);
            fw.write("Destination 1\n");
            fw.write("Destination 2\n");
            fw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
