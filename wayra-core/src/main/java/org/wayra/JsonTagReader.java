package org.wayra;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTagReader implements TagReader {

	private File jsonTagFile;

	public JsonTagReader(File jsonTagFile) {
		this.jsonTagFile = jsonTagFile;
	}

	public Map<String, TagCollection> readTags() {
		Map<String, TagCollection> tagCollections = new HashMap<String, TagCollection>();

		String jsonString = FileHelper.readFileIntoString(jsonTagFile);

		JSONArray jsonArray = JSONArray.fromObject(jsonString);

		for (Object element : jsonArray) {
			JSONObject jsonBoxTags = (JSONObject) element;
			String boxId = jsonBoxTags.getString(TagCollection.ID);

			TagCollection boxTags = new TagCollection();
			boxTags.set(TagCollection.ID,
					jsonBoxTags.getString(TagCollection.ID));
			boxTags.set(TagCollection.CONTENT,
					jsonBoxTags.getString(TagCollection.CONTENT));

			tagCollections.put(boxId, boxTags);
		}

		return tagCollections;
	}

}
