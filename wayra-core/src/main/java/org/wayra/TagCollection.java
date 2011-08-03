package org.wayra;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class TagCollection {

	public static final String ORIGIN = "ORIGIN" ;
	public static final String ID = "ID";
	public static final String CONTENT = "CONTENT";

	private Map<String, String> tags = new HashMap<String, String>() ;
	
	public void set(String tagKey, String tagValue) {
		tags.put(tagKey, tagValue) ;
	}

	public String get(String tagKey) {
		return tags.get(tagKey) ;
	}
	
	public Map<String, String> getTags() {
		return tags;
	}
	
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj) ;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this) ;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this) ;
	}

}
