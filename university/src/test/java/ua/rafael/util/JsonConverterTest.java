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

import ua.rafael.model.Mark;
import ua.rafael.model.Student;
import ua.rafael.model.Subject;

public class JsonConverterTest {

//	private final String filePath = "test/resources/ua/rafael/util/academ-perfomance.json";
//	private Student student;
//
//	@Before
//	public final void startUp() {
//		final List<Mark> markList = new ArrayList<>();
//		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(1, "Mathematics"), 4));
//		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(2, "History"), 4));
//		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(3, "Chemistry"), 4));
//		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(4, "Mathematics"), 4));
//		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(5, "English"), 4));
//		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(6, "Mathematics"), 4));
//		student = new Student(1, "Mark", "Polo", markList);
//	}
//
//	@Test
//	public final void testJsonToString() {
//		final String expected = readAllFromFile(filePath);
//		final String actual = JsonConverter.jsonToString(student) + "\n";
//		assertEquals("Strings should be the same in value", expected, actual);
//	}
//
//	@Test
//	public void testToJson() throws IOException {
//		toJson("academ-perfomance.json", student);
//		final String expected = readAllFromFile(filePath);
//		final String actual = readAllFromFile("academ-perfomance.json");
//		assertEquals("Strings should be the same in value", expected, actual);
//	}
//
//	@Test
//	public final void testFromJson() throws IOException {
//		toJson("academ-perfomance.json", student);
//		final Student actual = fromJson("academ-perfomance.json");
//		assertEquals("Object should be the same in value", student.toString(),
//				actual.toString());
//	}
//
//	@Test(expected = FileNotFoundException.class)
//	public final void testFromJson_fileNotFound() throws FileNotFoundException, IOException {
//		final String wrongFileNameFileName = "adem-perfomance.json";
//		fromJson(wrongFileNameFileName);
//	}
}
