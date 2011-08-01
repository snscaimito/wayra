package org.wayra;

public class AreaSize {

	private double size ;
	private AreaUnit unit ;
	
	private AreaSize(double size, AreaUnit unit) {
		this.size = size ;
		this.unit = unit ;
	}
	
	public static AreaSize SQUARE_METER(double size) {
		return new AreaSize(size, AreaUnit.SQUARE_METER) ;
	}
	
	public static AreaSize HECTARE(double size) {
		return new AreaSize(size, AreaUnit.HECTARE) ;
	}

	public double divide(AreaSize otherSize) {
		return size / otherSize.size ;
	}
	
}
