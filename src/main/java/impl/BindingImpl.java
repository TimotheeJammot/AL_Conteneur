package impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import services.*;

import java.util.Iterator;
import java.util.Properties;

public class BindingImpl implements Binding {
    ConteneurComposants conteneur;

    @Override
    public void bind(OCService service1, OCService service2) throws BindingFailure {
        //Recupération du composant pour faire le set
        JavaComponent component = (JavaComponent)((JavaService)service1).getParent();
        UserComponent userComponent = component.getUserComponent();

        //recupération des méthodes du composant pour pouvoir faire le set
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(component.getComponentProperty("methodesComposant")).getAsJsonArray();

        //Parcours des methodes pour trouver la bonne méthode set Set
        Iterator<JsonElement> jsonElementIterator = jsonArray.iterator();
        while (jsonElementIterator.hasNext()) {
            JsonObject methodeJson = jsonElementIterator.next().getAsJsonObject();
            //test si la methode est une methode set
            if(methodeJson.get("nom").getAsString().contains("set")){
                JsonArray parameters = methodeJson.get("parametres").getAsJsonArray();

                Iterator<JsonElement> jsonElementIterator2 = jsonArray.iterator();
                while (jsonElementIterator2.hasNext()) {
                    //on test si son type est bien du type de service2
                    if(methodeJson.get("type").getAsString().equals(service2.getServiceName())){
                        //Faire le set du premier composant vers le second
                        //userComponent.class.getMethod(methodeJson.get("type").getAsString(), IPlayVideo).invoke(c1, c2, null);
                    }
                }
            }
        }

    }

    @Override
    public void unbind(OCService service1, OCService service2) throws UnbindingFailure {

    }
}
