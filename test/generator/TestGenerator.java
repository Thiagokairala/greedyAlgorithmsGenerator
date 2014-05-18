package generator;

import model.ParameterToTest;

import org.junit.Test;

public class TestGenerator {

    @Test
    public void testGenerator() {
	Generator generator = new Generator();

	ParameterToTest parameter = null;
	for (int i = 0; i < 100; i++) {
	    parameter = generator.testCases(generator
		    .generateListOfParameters());

	    System.out.println(parameter);
	}

    }
}
