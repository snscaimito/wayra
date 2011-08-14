package org.wayra;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTagWriter implements TagWriter {

	private File jsonTagFile;

	public JsonTagWriter(File jsonTagFile) {
		this.jsonTagFile = jsonTagFile;
	}

	public void writeTags(Map<String, TagCollection> tagCollection) {
		JSONArray jsonArray = new JSONArray() ;

		for (TagCollection tags : tagCollection.values()) {
			JSONObject jsonObject = new JSONObject() ;
			
			for (String tagKey : tags.getTags().keySet()) {
				jsonObject.element(tagKey, tags.getTags().get(tagKey)) ;
			}
			
			jsonArray.add(jsonObject) ;
		}

		try {
			Writer writer = new FileWriter(jsonTagFile);
			writer.write(jsonArray.toString());
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
