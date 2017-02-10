package impl;

import java.util.ArrayList;

import services.OCComponent;
import services.OCService;

public class JavaComponent extends OCComponent {

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
