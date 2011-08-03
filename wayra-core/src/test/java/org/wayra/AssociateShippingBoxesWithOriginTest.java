package org.wayra;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;

/*
 Given there is a trailer loaded with 20 boxes of broccoli
 And the trailer came from the "ABC" field
 When the RFID reader reads the RFID tags
 Then all 20 boxes are associated with the "ABC" field
 */
public class AssociateShippingBoxesWithOriginTest {

	@Test
	public void associateBoxesWithOriginatingField() throws Exception {
		final Produce produce = new Produce("Broccoli") ;
		final Field originatingField = new Field("ABC", AreaSize.HECTARE(1), produce) ;
		final Map<String, TagCollection> tags = simulateReadingTags(loadOfBoxes(20, produce)) ;
		
		TagReader reader = new FakeTagReader(tags) ;
		TagWriter writer = new FakeTagWriter() ;
		Tagger tagger = new Tagger(reader, writer) ;

		// an event is triggered by the trailer entering the gate
		// we assume manual input of the origin
		tagger.associateWithOrigin(originatingField) ;
		
		verifyOriginTags(tags, originatingField) ;
	}

	private Map<String, TagCollection> simulateReadingTags(Collection<ShippingBox> trailerLoad) {
		Map<String, TagCollection> boxTags = new HashMap<String, TagCollection>() ;
		
		for (ShippingBox box : trailerLoad) {
			boxTags.put(box.getId(), box.getRfidTags()) ;
		}
		
		return boxTags ;
	}

	private void verifyOriginTags(Map<String, TagCollection> tags,
			Field originatingField) {
		for (TagCollection tagCollection : tags.values()) {
			assertEquals(originatingField.getFieldName(), tagCollection.get(TagCollection.ORIGIN)) ;
		}
	}

	private Collection<ShippingBox> loadOfBoxes(int boxCount, Produce produce) {
		Collection<ShippingBox> loadOfBoxes = new ArrayList<ShippingBox>() ;
		for (int i = 0 ; i < boxCount; i++)
			loadOfBoxes.add(new ShippingBox(UUID.randomUUID().toString(), produce)) ;
		
		return loadOfBoxes ;
	}
	
}
