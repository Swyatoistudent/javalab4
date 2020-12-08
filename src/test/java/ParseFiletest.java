import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ParseFiletest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();



    @Test
    public void testParseString() throws IOException, InterruptedException {
        final File inputFile = tempFolder.newFile("test.csv");
        BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile));
        bw.write("a,\"b\",c");
        bw.close();
        Parser inst = new Parser(inputFile.getAbsolutePath(),"1.txt");
        inst.parseFile(',',"len",'+',1);
        final File outputFile = new File("1.txt");
        BufferedReader br = new BufferedReader(new FileReader(outputFile));
        assertEquals("1+1+1", br.readLine());
        br.close();
    }
}
