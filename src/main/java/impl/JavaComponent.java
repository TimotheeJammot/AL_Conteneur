package impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import services.OCComponent;
import services.OCService;

public class JavaComponent extends OCComponent {
	public JavaComponent(Properties componantProperties) {
		properties = componantProperties;
        required = new ArrayList<OCService>();
        provided = new ArrayList<OCService>();

        JsonParser jp = new JsonParser();
        JsonArray ja = jp.parse(componantProperties.getProperty("services")).getAsJsonArray();
        Iterator<JsonElement> ijo = ja.iterator();
        while(ijo.hasNext()){
            JsonObject serviceJson = ijo.next().getAsJsonObject();
            JavaService javaService = new JavaService(serviceJson);
            if (serviceJson.get("type").getAsString().equals("required")){
                required.add(javaService);
            }else if (serviceJson.get("type").getAsString().equals("provided"){
                provided.add(javaService);
            }
        }

	}

	@Override
	public ArrayList<OCService> getRequiredServices() {

		return required;
	}

	@Override
	public ArrayList<OCService> getProvidedServices() {

		return provided;
	}

	@Override
	public String getComponentProperties() {

		return properties.toString();
	}


	public String getComponentProperty(String prop) {
		return (String)properties.get(prop);
	}

	public void setComponentProperty(String prop, String value) {
		properties.put(prop, value);
	}
}
