package org.wayra;

import java.util.Map;

public class FakeTagReader implements TagReader {

	private Map<String, TagCollection> tags ;
	
	public FakeTagReader(Map<String, TagCollection> tags) {
		this.tags = tags ;
	}
	
	public Map<String, TagCollection> readTags() {
		return tags ;
	}

}
