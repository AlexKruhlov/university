package ua.rafael.util;

import static ua.rafael.util.GsonConverter.toJson;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ua.rafael.model.AcademPerfomance;
import ua.rafael.model.Mark;
import ua.rafael.model.Subject;

public class JsonConverterTest {
	
	private AcademPerfomance academPerfomance;
	
	@Before
	public final void startUp(){
		academPerfomance = new AcademPerfomance();
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("Mathematics"), 4));
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("History"), 4));
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("Chemistry"), 4));
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("Mathematics"), 4));
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("English"), 4));
		academPerfomance.addMark(new Mark(LocalDate.now(), new Subject("Mathematics"), 4));
	}

	@Test
	public final void testToJson() {
		toJson("final.json", academPerfomance);
		
	}
}
