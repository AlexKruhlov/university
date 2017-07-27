package ua.rafael.util;

import static org.junit.Assert.assertEquals;
import static ua.rafael.util.FileUtil.readAllFromFile;
import static ua.rafael.util.JsonConverter.toJson;

import java.time.LocalDate;

import javax.xml.bind.helpers.AbstractUnmarshallerImpl;

import org.junit.Before;
import org.junit.Test;

import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Mark;
import ua.rafael.model.Subject;

public class JsonConverterTest {

	private final String filePath = "test/resources/ua/rafael/util/final.json";
	private AcademPerfomance academPerfomance;

	@Before
	public final void startUp() {
		academPerfomance = new AcademPerfomance();
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("Mathematics"), 4));
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("History"), 4));
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("Chemistry"), 4));
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("Mathematics"), 4));
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("English"), 4));
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("Mathematics"), 4));
	}

	@Test
	public final void testJsonToString() {
		final String expected
				= readAllFromFile(filePath);
		final String actual = JsonConverter.jsonToString(academPerfomance) + "\n";
		assertEquals(expected, actual);
	}

	@Test
	public final void testToJson() {
		toJson("final.json", academPerfomance);
		final String expected = readAllFromFile(filePath);
		final String actual = readAllFromFile("final.json");
		assertEquals(expected, actual);
	}

}
