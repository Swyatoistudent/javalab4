import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;





public class Parser {
    public int active_worker =0;
    public int position =0;
    Scanner scanner ;
    FileReader reader;
    public LinkedList<String> file_strings = new LinkedList<>();
    public LinkedList<StringBuilder> result = new LinkedList<>();
    FileWriter writer;



    public  Parser(String input_file,String output_file) throws IOException {
        reader = new FileReader(input_file);
        scanner = new Scanner(reader);
        writer = new FileWriter(output_file,true);

    }
    void delimFile(){

        while(scanner.hasNextLine()){
           String  a=scanner.nextLine();
            file_strings.addLast(a);
        }

    }
    StringBuilder parseString(String string, char delimeter, String mode,char out_delim) throws IOException {

        StringBuilder linkedList = new StringBuilder();
        int c;
        if(string.length()==0){
            return linkedList;
        }

        boolean active = false;
        boolean del = false;
        int first = -1;
        int second = -1;
        int j = 0;
        char[] chars = string.toCharArray();
        StringBuilder buffer = new StringBuilder();

        for (char aChar : chars) {
            c = aChar;
            j++;




            if ((char) c != '\n' ) {
                buffer.append((char) c);
            }

            if (first == 1 && second != -1 && buffer.length() != 0 && !del) {
                buffer.deleteCharAt(0);
                buffer.deleteCharAt(second - 2);
                del = true;
            }

            if (c == '"') {
                if (first == -1) {
                    first = j;
                } else if (second == -1) {
                    second = j;
                }
                active = !active;
            }

            if (c == delimeter && !active) {
                j = 0;
                first = -1;
                second = -1;
                del = false;

                if(mode.equals("parse")) {
                    buffer.deleteCharAt(buffer.length() - 1);
                    buffer.append(out_delim);
                    linkedList.append(buffer);
                }
                if(mode.equals("len")){
                    buffer.deleteCharAt(buffer.length() - 1);
                    linkedList.append(buffer.length()).append("+");
                }
                buffer = new StringBuilder();
            }

        }
        if(mode.equals("parse")) {
            linkedList.append(buffer);
        }
        if(mode.equals("len")){
            linkedList.append(buffer.length());
        }
        return linkedList;
    }

    void parseFile(char delim,String mode,char output_delim, int num_of_worker) throws IOException, InterruptedException {
        delimFile();
        int number_strings = file_strings.size();
        delimFile();




            while(position<number_strings) {
                System.out.println(active_worker);
                if(active_worker<num_of_worker) {
                    worker a = new worker(this, delim, mode,output_delim);
                    Thr wor = new Thr(a, position);
                    Thread b = new Thread(wor);
                    b.start();
                    active_worker++;
                    position++;
                }

            }
        Thread.sleep(100);

        for (String file_string : file_strings) {

            writer.write(file_string);
            writer.write("\n");

        }
            writer.close();
    }
        }





