import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;


public class MyRouteBuilder extends RouteBuilder
{

    /**
     * Zum Senden die eigene, zum Empfangen die fremde Camel Instanz
     * Diese Route ist also zum Senden.
     */
    
    
    public void configure()
    {
    	final String transferFolder = "C:/Users/leona/Desktop/cameltry";
    	//Processor py_to_json = new PyToJsonProcessor();
    	
        from("file:" + transferFolder + "/input" + "?noop=false") 	// noop=false löscht die Files nach der Verarbeitung / verschiebt sie nach .camel
        
    	//from("zeromq:tcp://127.0.0.1:5555?socketType=PULL")
    		.convertBodyTo(String.class) 							// Der Body an sicht ist zunächst vom Typ GenericFile, repräsentiert also noch den urspr File Endpoint.
    		//.log("Input: ${body}")
    		//.process(py_to_json)									// Konvertieurng, siehe Klasse PyToJsonProcessor
	    	//.log("Sending:  ${body}")											// Print auf die Konsole
	    	.to("activemq:wonderfulQ");

	    	//.to("file:" + transferFolder + "/output");				// Neue Datei in den Output-Folder
    	
    }

}
