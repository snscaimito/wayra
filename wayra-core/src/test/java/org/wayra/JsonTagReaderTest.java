package org.wayra;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.junit.Test;

public class JsonTagReaderTest {

	@Test
	public void readCollections() throws Exception {
		File jsonTagFile = File.createTempFile("tag", null) ;
		jsonTagFile.deleteOnExit() ;

		TagCollection tagCollection = new TagCollection() ;
		tagCollection.set(TagCollection.ID, "id") ;
		Map<String, TagCollection> boxTags = new HashMap<String, TagCollection>() ;
		boxTags.put("boxKey", tagCollection) ;
		
		String jsonString = JSONObject.fromObject(boxTags).toString(2) ;
		Writer writer = new FileWriter(jsonTagFile) ;
		writer.write(jsonString) ;
		writer.close() ;
		
		Map<String, TagCollection> tagCollectionsExpected = new HashMap<String, TagCollection>() ;
		tagCollectionsExpected.put("boxKey", tagCollection) ;
		
		JsonTagReader tagReader = new JsonTagReader(jsonTagFile) ;
		assertEquals(tagCollectionsExpected, tagReader.readTags()) ;
	}
	
}
