import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class Main {
    public static void main(String args[]) {
        Properties p1 = new Properties();
        Properties p2 = new Properties();
        try {
            p1.load(new FileReader("examples/service.properties"));
            System.out.println(p1.toString());

            p2.load(new StringReader(p1.toString()));
            System.out.println(p2.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
