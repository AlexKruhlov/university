package ua.rafael.util;

import static org.junit.Assert.assertEquals;
import static ua.rafael.util.FileUtil.readAllFromFile;
import static ua.rafael.util.JsonConverter.fromJson;
import static ua.rafael.util.JsonConverter.toJson;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Mark;
import ua.rafael.model.Subject;

public class JsonConverterTest {

	private final String filePath = "test/resources/ua/rafael/util/academ-perfomance.json";
	private AcademPerfomance academPerfomance;

	@Before
	public final void startUp() {
		final List<Mark> markList = new ArrayList<>();
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject("Mathematics"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject("History"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject("Chemistry"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject("Mathematics"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject("English"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject("Mathematics"), 4));
		academPerfomance = new AcademPerfomance(markList);
	}

	@Test
	public final void testJsonToString() {
		final String expected
				= readAllFromFile(filePath);
		final String actual = JsonConverter.jsonToString(academPerfomance) + "\n";
		assertEquals("Strings should be the same in value", expected, actual);
	}

	@Test
	public void testToJson() throws IOException {
		toJson("academ-perfomance.json", academPerfomance);
		final String expected = readAllFromFile(filePath);
		final String actual = readAllFromFile("academ-perfomance.json");
		assertEquals("Strings should be the same in value", expected, actual);
	}

	@Test
	public final void testFromJson() throws IOException {
		toJson("academ-perfomance.json", academPerfomance);
		final AcademPerfomance actual = fromJson("academ-perfomance.json");
		assertEquals("Object should be the same in value", academPerfomance.toString(),
				actual.toString());
	}

	@Test(expected = FileNotFoundException.class)
	public final void testFromJson_fileNotFound() throws FileNotFoundException, IOException {
		final String wrongFileNameFileName = "adem-perfomance.json";
		fromJson(wrongFileNameFileName);
	}
}
