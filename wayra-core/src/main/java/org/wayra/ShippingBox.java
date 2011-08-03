package org.wayra;

public class ShippingBox {

	private TagCollection rfidTags = new TagCollection() ;
	
	public ShippingBox(String id, Produce produce) {
		rfidTags.set(TagCollection.ID, id) ;
		rfidTags.set(TagCollection.CONTENT, produce.getName()) ;
	}

	public String getOriginName() {
		return rfidTags.get(TagCollection.ORIGIN) ;
	}

	public TagCollection getRfidTags() {
		return rfidTags ;
	}

	public String getId() {
		return rfidTags.get(TagCollection.ID) ;
	}

}
