package org.wayra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class JsonTagReader implements TagReader {

	private File jsonTagFile ;
	
	public JsonTagReader(File jsonTagFile) {
		this.jsonTagFile = jsonTagFile ;
	}

	public Map<String, TagCollection> readTags() {
		Map<String, TagCollection> tagCollections = new HashMap<String, TagCollection>() ;
		
		try {
			Reader reader = new BufferedReader(new FileReader(jsonTagFile)) ;
			StringBuffer s = new StringBuffer() ;
			char[] c = new char[1];
			int i = reader.read(c) ;
			while (i > 0) {
				s.append(c) ;
				i = reader.read(c) ;
			}
			
			JSONObject jsonObject = JSONObject.fromObject(s.toString()) ;

			for (Object boxKey : jsonObject.keySet()) {
				JSONObject boxValue = (JSONObject) jsonObject.get(boxKey) ;
				JSONObject tags = (JSONObject) boxValue.get("tags") ;
				
				TagCollection tagCollection = new TagCollection() ;
				for (Object tagKey : tags.keySet()) {
					tagCollection.set((String)tagKey, (String)tags.get(tagKey)) ;
				}
				
				tagCollections.put((String)boxKey, tagCollection) ;
			}
			
			return tagCollections ;
		} catch (Exception e) {
			throw new RuntimeException(e) ;
		}
	}

}
