package org.wayra;

public class Field {

	private AreaSize size ;
	private Produce produce ;
	private int cropCount ;
	private int ripeCropCount ;
	
	public Field(AreaSize size, Produce produce) {
		this.size = size ;
		this.produce = produce ;
	}

	public void cropCount(int count) {
		cropCount = count ;
	}

	public AreaSize getSize() {
		return size;
	}

	public void ripeCropCount(int ripeCount) {
		ripeCropCount = ripeCount ;
	}

	public int getRipeCropCount() {
		return ripeCropCount ;
	}

}
