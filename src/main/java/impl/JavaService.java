package impl;
import com.google.gson.JsonObject;
import services.OCService;

import java.util.Properties;

public class JavaService extends OCService {
	public JavaService(JsonObject serviceJson) {
		properties = new Properties();
		name = serviceJson.get("nom").getAsString();
		properties.setProperty("type",serviceJson.get("type").getAsString());
		properties.setProperty("lien",serviceJson.get("lien").getAsString());
		properties.setProperty("composant",serviceJson.get("composant").getAsString());
		properties.setProperty("signature",serviceJson.get("signature").getAsString());
	}

	@Override
	public String getServiceName() {
		return name;
	}

	@Override
	public String getServiceProperties() {
		return properties.toString();
	}
}
