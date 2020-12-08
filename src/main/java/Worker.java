import java.io.IOException;

class worker
{


    private final char delim;
    private final String mode;
    private final char out_delim;
    private final Parser parser;

    public worker(Parser parser,char delim,String mode,char out_delim) {

        this.out_delim =out_delim;

        this.delim = delim;
        this.mode = mode;
        this.parser = parser;
    }

    public void  parse(int pos) throws IOException {

                    parser.file_strings.set(pos, parser.parseString(parser.file_strings.get(pos), delim, mode,out_delim).toString());



                    parser.active_worker--;


    }
}