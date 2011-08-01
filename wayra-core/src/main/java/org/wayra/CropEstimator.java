package org.wayra;

public class CropEstimator {

	public double getEstimatedHarvestCount(Field samplePlot, Field field) {
		double factor = samplePlot.getSize().divide(field.getSize()) ;
		return samplePlot.getRipeCropCount() * factor ;
	}

}
