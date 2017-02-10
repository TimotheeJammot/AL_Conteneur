import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

public class Main {
    public static void main(String args[]) {
        Properties p1 = new Properties();
        Properties p2 = new Properties();
        try {
            p1.load(new FileReader("examples/service.properties"));
            System.out.println(p1.toString());
            System.out.println(p1.getProperty("type"));
            System.out.println(p1.getProperty("signature"));

            StringWriter sw = new StringWriter();
            p1.store(sw, null);

            String genStr = sw.toString();
            p2.load(new StringReader(genStr));
            System.out.println(p2.toString());
            System.out.println(p2.getProperty("type"));
            System.out.println(p2.getProperty("signature"));

            FileWriter fw = new FileWriter("examples/service_generated.properties");
            fw.write(genStr);
            fw.flush();
            System.out.println(genStr);

            JsonParser jp = new JsonParser();
            JsonArray ja = jp.parse(p2.getProperty("signature")).getAsJsonArray();
            Iterator<JsonElement> ijo = ja.iterator();
            while (ijo.hasNext()) {
                System.out.println(ijo.next().getAsJsonObject().get("nom").getAsString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
