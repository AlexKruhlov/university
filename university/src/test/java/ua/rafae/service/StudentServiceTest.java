package ua.rafae.service;

import static org.junit.Assert.assertEquals;
import static ua.rafael.util.JsonConverter.fromJson;

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
import ua.rafael.util.JsonConverter;

public class StudentServiceTest {

	private Student student;
	private StudentService service;

	@Before
	public final void startUp() {
		final List<Mark> markList = new ArrayList<>();
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(1, "Mathematics"), 3));
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(2, "History"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(3, "Chemistry"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 28), new Subject(4, "Mathematics"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(5, "English"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 29), new Subject(6, "Mathematics"), 5));
		student = new Student(1, "Mark", "Polo", markList);
		service = new StudentService(student);
	}

	@Test
	public final void testSolveAvarageMarkByMathematics() {
		final double expected = 4.0;
		final double actual = service.solveAvarageMarkBySubject(new Subject(1, "Mathematics"));
		assertEquals("Nubers must be equal", expected, actual, 0.1);
	}

	@Test
	public final void testSolveAvarageMarkByNotExsistentSubject() {
		final double expected = 0.0;
		final double actual = service.solveAvarageMarkBySubject(new Subject(1, "Geometry"));
		assertEquals("Nubers must be equal", expected, actual, 0.1);
	}

	@Test
	public final void testSolveAvarageMarkByEmptyMarks() {
		service = new StudentService(new Student(1, "Mark", "Polo", new ArrayList<Mark>()));
		final double expected = 0.0;
		final double actual = service.solveAvarageMarkBySubject(new Subject(1, "Geometry"));
		assertEquals("Nubers must be equal", expected, actual, 0.1);
	}

	@Test
	public final void testSortMarksByDate() throws FileNotFoundException, IOException {
		final String expected = fromJson("test/resources/ua/rafael/service/sorted-marks.json")
				.toString();
		service.sortMarksByDate();
		System.out.println(JsonConverter.jsonToString(student));
		final String actual = student.toString();
		assertEquals("Strigns must be equal", expected, actual);
	}

	@Test
	public final void testFindMarksBySubject() {
		final List<Mark> expected = new ArrayList<>();
		expected.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(1, "Mathematics"), 3));
		expected.add(new Mark(LocalDate.of(2017, 07, 28), new Subject(2, "Mathematics"), 4));
		expected.add(new Mark(LocalDate.of(2017, 07, 29), new Subject(3, "Mathematics"), 5));
		final List<Mark> actual = service.findMarksBySubject(new Subject(1, "Mathematics"));
		assertEquals("Strigns must be equal", expected.toString(), actual.toString());
	}

	@Test
	public final void testFindMarksBySubjectWithNonExistentSubject() {
		final List<Mark> expected = new ArrayList<>();
		final List<Mark> actual = service.findMarksBySubject(new Subject(1, "Biology"));
		assertEquals("Strings must be equal", expected.toString(), actual.toString());
	}

	@Test
	public final void testfindMarksByDate() {
		final List<Mark> expected = new ArrayList<>();
		expected.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(1, "Chemistry"), 4));
		expected.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(2, "English"), 4));
		expected.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(3, "History"), 4));
		expected.add(new Mark(LocalDate.of(2017, 07, 27), new Subject(4, "Mathematics"), 3));
		final List<Mark> actual = service.findMarksByDate(LocalDate.of(2017, 07, 27));
		assertEquals("Strigns must be equal", expected.toString(), actual.toString());
	}

	@Test
	public final void testFindMarksBySubjectWithNonExistentDate() {
		final List<Mark> expected = new ArrayList<>();
		final List<Mark> actual = service.findMarksByDate(LocalDate.of(2018, 07, 27));
		assertEquals("Strings must be equal", expected.toString(), actual.toString());
	}
}
