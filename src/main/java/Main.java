import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {



        Scanner scanner = new Scanner(System.in);

        System.out.println("Input file : ");
        String inputFilePath = scanner.next();

        System.out.println("Output file : ");
        String outputFilePath = scanner.next();

        System.out.println("input delim : ");
        String delim = scanner.next();

        System.out.println("output delim : ");
        String out_delim = scanner.next();

        System.out.println("num of Threads: ");
        String num_thr = scanner.next();


        File newFile = new File(inputFilePath);
        if (!newFile.exists()){
            throw new FileNotFoundException(newFile.getName());
        }
        File[] a = newFile.listFiles();
        assert a != null;
        for(File item:a){
            Parser b = new Parser(item.getAbsolutePath(), outputFilePath);
            b.parseFile(delim.charAt(0),"len",out_delim.charAt(0),Integer.parseInt(num_thr));
        }
    }
}


