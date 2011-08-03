package org.wayra;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProduceAvailableToPickTest {

	/*
    Given there are 50 head of broccoli in the "100 sqm" sample plot
    And "20" head of broccoli are ripe
    And the field is "1 ha" in size
    When I estimate
    Then I know "2000" head of broccoli are ripe
	*/
	
	@Test
	public void calculateAvailableProduceBasedOnSamplePlot() {
		CropEstimator estimator = new CropEstimator() ;
		
		final Field field = new Field("ABC", AreaSize.HECTARE(1), new Produce("Broccoli")) ;
		final Field samplePlot = new Field("ABC", AreaSize.SQUARE_METER(100), new Produce("Broccoli")) ;
		samplePlot.cropCount(50) ;
		samplePlot.ripeCropCount(20) ;
		
		assertEquals(2000, estimator.getEstimatedHarvestCount(samplePlot, field), 0.0) ;
	}
	
}

