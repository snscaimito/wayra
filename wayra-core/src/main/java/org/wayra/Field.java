package org.wayra;

public class Field {

	private String fieldName ;
	private AreaSize size ;
	private Produce produce ;
	private int cropCount ;
	private int ripeCropCount ;
	
	public Field(String fieldName, AreaSize size, Produce produce) {
		this.fieldName = fieldName ;
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

	public String getFieldName() {
		return fieldName ;
	}

}
