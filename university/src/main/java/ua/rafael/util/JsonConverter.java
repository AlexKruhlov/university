package ua.rafael.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.google.gson.GsonBuilder;

import ua.rafael.model.Student;

public class JsonConverter {

	public static void toJson(final String jsonFilePath,
			Student student) throws IOException {
		try (OutputStreamWriter file = new FileWriter(new File(jsonFilePath))) {
			file.write(jsonToString(student));
		}
	}

	public static Student fromJson(final String filePath)
			throws FileNotFoundException, IOException {
		Student student = null;
		try (InputStreamReader fileReader = new FileReader(filePath)) {
			student = new GsonBuilder().create().fromJson(new FileReader(filePath),
					Student.class);
		}
		return student;
	}

	public static String jsonToString(final Student student) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(student);
	}
}
