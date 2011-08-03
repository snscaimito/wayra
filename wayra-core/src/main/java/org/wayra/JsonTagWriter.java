package org.wayra;

import java.io.File;
import java.util.Map;

public class JsonTagWriter implements TagWriter {

	private File jsonTagFile ;
	
	public JsonTagWriter(File jsonTagFile) {
		this.jsonTagFile = jsonTagFile ;
	}

	public void writeTags(Map<String, TagCollection> tagCollection) {
		throw new RuntimeException("Not yet implemented");
	}

}
