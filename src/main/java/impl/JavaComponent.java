package impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import services.OCComponent;
import services.OCService;
import services.UserComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

public class JavaComponent extends OCComponent {
    /**
     * Le composant lié doit respecter le manuel utilisateur
     */
    private UserComponent userComponent;
    public JavaComponent(Properties componantProperties, UserComponent userComponent) {
        this.userComponent = userComponent;

        properties = componantProperties;
        required = new ArrayList<OCService>();
        provided = new ArrayList<OCService>();

        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(componantProperties.getProperty("services")).getAsJsonArray();

        Iterator<JsonElement> jsonElementIterator = jsonArray.iterator();
        while (jsonElementIterator.hasNext()) {
            JsonObject serviceJson = jsonElementIterator.next().getAsJsonObject();
            JavaService javaService = new JavaService(serviceJson, this);
            if (serviceJson.get("type").getAsString().equals("required")) {
                required.add(javaService);
            } else if (serviceJson.get("type").getAsString().equals("provided")) {
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
        return properties.getProperty(prop);
    }

    public void setComponentProperty(String prop, String value) {
        properties.setProperty(prop, value);
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }

}
