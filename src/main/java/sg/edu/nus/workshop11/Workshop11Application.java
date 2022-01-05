package sg.edu.nus.workshop11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// This is to get opts as list
import java.util.Collections;
import java.util.List;

// import third party library for logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Workshop11Application {
	// Instantiate the logger
	private static final Logger logger = LoggerFactory.getLogger(Workshop11Application.class);
	// The default fallback port used by the spring boot application
	private static final String DEFAULT_PORT = "3000";
	public static void main(String[] args) {
		logger.info("Workshop 11");
		// init the apring app
		SpringApplication app = new SpringApplication(Workshop11Application.class);
		// Decode the java app args using spring args helper
		DefaultApplicationArguments appArgs = 
			new DefaultApplicationArguments(args);
		// return the args from the java args as list of strings
		List optsVal = appArgs.getOptionValues("port");
		// var to hold up the port number to be pass on to the spring boot app
		String portNumber = null;
		// check if the opt arg is null or the first elem is null as 
		// before retrieving it from the env variable
		if(optsVal == null  || optsVal.get(0) == null){
			// retrieve from the OS env variable
			portNumber = System.getenv("PORT");
			// if OS env variable is null or empty
			// default a default port
			if(portNumber == null)
				portNumber = DEFAULT_PORT;
		}else{
			// if both above conditions is not met get from the args of the app
			portNumber = (String)optsVal.get(0);
		}
		
		// check if the port number is still null or empoty
		if(portNumber != null){	
			// override the spring boot app port number using the defaultproperties from spring boot framework
			app.setDefaultProperties(
				Collections.singletonMap("server.port", 
					portNumber));
		}
		app.run(args);
	}
}
