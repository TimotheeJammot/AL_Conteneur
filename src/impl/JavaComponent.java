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

}
