package ua.rafael.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.google.gson.GsonBuilder;

import ua.rafael.model.AcademPerfomance;

public class JsonConverter {

	public static void toJson(final String jsonFilePath,
			AcademPerfomance academPerfomance) throws IOException {
		try (OutputStreamWriter file = new FileWriter(new File(jsonFilePath))) {
			file.write(jsonToString(academPerfomance));
		}
	}

	public static AcademPerfomance fromJson(final String filePath)
			throws FileNotFoundException, IOException {
		AcademPerfomance academPerfomance = null;
		try (InputStreamReader fileReader = new FileReader(filePath)) {
			academPerfomance = new GsonBuilder().create().fromJson(new FileReader(filePath),
					AcademPerfomance.class);
		}
		return academPerfomance;
	}

	public static String jsonToString(final AcademPerfomance academPerfomance) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(academPerfomance);
	}
}
