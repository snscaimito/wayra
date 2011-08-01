package org.wayra;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProduceAvailableToPickTest {

	@Test
	public void calculateAvailableProduceBasedOnSamplePlot() {
		SamplePlot samplePlot = new SamplePlot(AreaSize.SQUARE_METER(100), new Produce("Broccoli")) ;
		samplePlot.countCrop(50) ;
		
		Field field = new Field(AreaSize.HECTARE(1), new Produce("Broccoli")) ;
		
		final int ripeCropCounted = 20 ;
		
		double factor = samplePlot.getSize().divide(field.getSize()) ;
		assertEquals(2000, ripeCropCounted * factor, 0.0) ;
	}
	
}
