package org.wayra;

public class Field {

	private AreaSize size ;
	private Produce produce ;
	
	public Field(AreaSize size, Produce produce) {
		this.size = size ;
		this.produce = produce ;
	}

	public AreaSize getSize() {
		return size;
	}

}
