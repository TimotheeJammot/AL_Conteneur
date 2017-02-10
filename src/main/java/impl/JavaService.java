package impl;

import services.OCService;

public class JavaService extends OCService {

	@Override
	public String getServiceName() {
		
		return name;
	}

	@Override
	public String getServiceProperties() {
		
		return properties.toString();
	}

}
