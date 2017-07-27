package ua.rafael.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtil {

	public static String readAllFromFile(final String fileName) {
		StringBuffer result = new StringBuffer();
		File file = new File(fileName);
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				result.append(scanner.nextLine()).append('\n');
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return result.toString();
	}
}
