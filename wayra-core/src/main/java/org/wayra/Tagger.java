package org.wayra;

import java.util.Map;

public class Tagger {

	private TagReader reader ;
	private TagWriter writer ;
	
	public Tagger(TagReader reader, TagWriter writer) {
		this.reader = reader ;
		this.writer = writer ;
	}

	public void associateWithOrigin(Field originatingField) {
		Map<String, TagCollection> tagCollections = reader.readTags() ;
		
		for (TagCollection tagCollection : tagCollections.values()) {
			tagCollection.set(TagCollection.ORIGIN, originatingField.getFieldName()) ;
		}

		writer.writeTags(tagCollections) ;
	}

}
