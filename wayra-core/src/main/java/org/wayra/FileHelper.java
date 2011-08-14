package org.wayra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class FileHelper {

	public static String readFileIntoString(File jsonTagFile) {
		try {
			Reader reader = new BufferedReader(new FileReader(jsonTagFile));
			StringBuffer s = new StringBuffer();
			char[] c = new char[1];
			int i = reader.read(c);
			while (i > 0) {
				s.append(c);
				i = reader.read(c);
			}

			return s.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
