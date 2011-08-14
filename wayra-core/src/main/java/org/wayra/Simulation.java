package org.wayra;

import java.io.File;

public class Simulation {

	public static void main(String[] args) {
		System.out.println("Wayra Simulation") ;
		
		if (args.length < 2) {
			System.out.println("Usage: simulation <rfid_file> <origin>") ;
			System.exit(1) ;
		} else {
			String originatingField = args[1] ;
			
			TagReader tagReader = new JsonTagReader(new File(args[0])) ;
			TagWriter tagWriter = new JsonTagWriter(new File(args[0])) ;
			
			Tagger tagger = new Tagger(tagReader, tagWriter) ;
			
			tagger.associateWithOrigin(originatingField) ;
			
			System.exit(0) ;
		}
	}
	
}
