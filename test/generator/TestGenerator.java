package generator;

import static org.junit.Assert.*;
import model.ParameterToTest;

import org.junit.Test;

public class TestGenerator {

    @Test
    public void testGenerator() {
	Generator generator = new Generator();

	ParameterToTest firstParameter = null;
	ParameterToTest secondParameter = null;
	for (int i = 0; i < 1000; i++) {
	    if (i == 0) {
		firstParameter = generator.testCases();
		secondParameter = firstParameter;
	    } else {
		firstParameter = secondParameter;
		secondParameter = generator.testCases();
		assertTrue(firstParameter.getClass() == secondParameter
			.getClass());
	    }
	}

    }
}
