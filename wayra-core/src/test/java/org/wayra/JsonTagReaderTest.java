package org.wayra;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

public class JsonTagReaderTest {

	@Test
	public void readCollections() throws Exception {
		File jsonTagFile = File.createTempFile("tag", null) ;
		jsonTagFile.deleteOnExit() ;

		
		String jsonString = "[{\"id\":\"id\", \"content\":\"broccoli\"}]" ;
		Writer writer = new FileWriter(jsonTagFile) ;
		writer.write(jsonString) ;
		writer.close() ;

		TagCollection tagCollection = new TagCollection() ;
		tagCollection.set(TagCollection.ID, "id") ;
		tagCollection.set(TagCollection.CONTENT, "broccoli") ;
		
		Map<String, TagCollection> tagCollectionsExpected = new HashMap<String, TagCollection>() ;
		tagCollectionsExpected.put(TagCollection.ID, tagCollection) ;
		
		JsonTagReader tagReader = new JsonTagReader(jsonTagFile) ;
		assertEquals(tagCollectionsExpected, tagReader.readTags()) ;
	}
	
}
