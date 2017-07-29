package ua.rafae.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Mark;
import ua.rafael.model.Subject;

public class AcademPerfomanceServiceTest {

	private AcademPerfomance academPerfomance;
	private AcademPerfomanceService service;

	@Before
	public final void startUp() {
		final List<Mark> markList = new ArrayList<>();
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject("Mathematics"), 3));
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject("History"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject("Chemistry"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 28), new Subject("Mathematics"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 27), new Subject("English"), 4));
		markList.add(new Mark(LocalDate.of(2017, 07, 29), new Subject("Mathematics"), 5));
		academPerfomance = new AcademPerfomance(markList);
		service = new AcademPerfomanceService(academPerfomance);
	}

	@Test
	public final void testSolveAvarageMarkByMathematics() {
		final double expected = 4.0;
		final double actual = service.solveAvarageMarkBySubject(new Subject("Mathematics"));
		Assert.assertEquals("Nubers must be equal", expected, actual, 0.1);
	}

	@Test
	public final void testSolveAvarageMarkByNotExsistentSubject() {
		final double expected = 0.0;
		final double actual = service.solveAvarageMarkBySubject(new Subject("Geometry"));
		Assert.assertEquals("Nubers must be equal", expected, actual, 0.1);
	}

	@Test
	public final void testSolveAvarageMarkByEmptyAcademicPerfomance() {
		service = new AcademPerfomanceService(new AcademPerfomance());
		final double expected = 0.0;
		final double actual = service.solveAvarageMarkBySubject(new Subject("Geometry"));
		Assert.assertEquals("Nubers must be equal", expected, actual, 0.1);
	}
	
	@Test
	public final void testSolveAvarageMarkByEmpty() {
		service = new AcademPerfomanceService(new AcademPerfomance());
		final double expected = 0.0;
		final double actual = service.solveAvarageMarkBySubject(new Subject("Geometry"));
		Assert.assertEquals("Nubers must be equal", expected, actual, 0.1);
	}
	
}
