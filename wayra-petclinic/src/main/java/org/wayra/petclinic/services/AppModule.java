package org.wayra.petclinic.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;

public class AppModule {
	
	public static void bind(ServiceBinder binder) {
	}

	public static void contributeApplicationDefaults(
			MappedConfiguration<String, String> configuration) {
		configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
		configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
		configuration
				.add(SymbolConstants.APPLICATION_VERSION, "0.0.1-SNAPSHOT");
	}

}
