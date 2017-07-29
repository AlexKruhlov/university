package validator;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import ua.rafael.model.AcademPerfomance;
import ua.rafael.util.JsonConverter;

public class AcademPerfomanceValidatorTest {

	private Validator<AcademPerfomance> validator = new AcademPerfomanceValidator();

	@Test
	public final void testValidateWithUniqueMarks() throws FileNotFoundException, IOException {
		final AcademPerfomance academPerfomance
				= JsonConverter.fromJson("test/resources/ua/rafael/validator/unique-marks.json");
		try {
			validator.validate(academPerfomance);
		} catch (Exception e) {
			fail("Validator must not generate exception");
		}
	}

	@Test(expected = RuntimeException.class)
	public final void testValidateWithDublicateOfMarks() throws FileNotFoundException, IOException {
		final AcademPerfomance academPerfomance
				= JsonConverter.fromJson(
						"test/resources/ua/rafael/validator/dublicate-of-marks.json");
		validator.validate(academPerfomance);
	}
}
