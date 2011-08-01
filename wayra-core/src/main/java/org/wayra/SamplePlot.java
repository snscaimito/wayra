package org.wayra;

public class SamplePlot {

	private AreaSize size ;
	private Produce produce ;
	private int cropCount ;
	
	public SamplePlot(AreaSize size, Produce produce) {
		this.size = size ;
		this.produce = produce ;
	}

	public void countCrop(int count) {
		cropCount = count ;
	}

	public AreaSize getSize() {
		return size;
	}

}
