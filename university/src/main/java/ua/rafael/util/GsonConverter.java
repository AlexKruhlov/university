package ua.rafael.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.google.gson.GsonBuilder;

import ua.rafael.model.AcademPerfomance;

public class GsonConverter {

	public static void toJson(final String jsonFilePath,
			AcademPerfomance academPerfomance) {
		final String jsonString
				= new GsonBuilder().create().toJson(academPerfomance);
		try (OutputStreamWriter file = new FileWriter(new File(jsonFilePath))) {
			file.write(jsonString);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static AcademPerfomance fromJson(final String filePath) {
		AcademPerfomance academPerfomance = null;
		try (InputStreamReader fileReader = new FileReader(filePath)) {
			academPerfomance = new GsonBuilder().create().fromJson(new FileReader(filePath),
					AcademPerfomance.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return academPerfomance;
	}
}
