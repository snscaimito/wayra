package org.wayra;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class JsonTagWriterTest {

	@Test
	public void writeTags() throws Exception {
		File jsonTagFile = File.createTempFile("tag", null) ;
		jsonTagFile.deleteOnExit() ;

		final String jsonStringExpected = "[{\"content\":\"broccoli\",\"id\":\"id\",\"origin\":\"ABC\"}]" ;

		TagCollection tagCollection = new TagCollection() ;
		tagCollection.set(TagCollection.ID, "id") ;
		tagCollection.set(TagCollection.CONTENT, "broccoli") ;
		tagCollection.set(TagCollection.ORIGIN, "ABC") ;
		
		Map<String, TagCollection> tagCollections = new HashMap<String, TagCollection>() ;
		tagCollections.put(TagCollection.ID, tagCollection) ;

		TagWriter tagWriter = new JsonTagWriter(jsonTagFile) ;
		tagWriter.writeTags(tagCollections) ;
		
		assertEquals(jsonStringExpected, FileHelper.readFileIntoString(jsonTagFile)) ;
	}
	
}
