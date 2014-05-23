package generator;

import java.util.ArrayList;
import java.util.List;

import model.ParameterToTest;
import model.TaskList;
import cases.SmallestDiferenceBetwenDurationAndDelivery;
import cases.SmallestDuration;
import cases.SmallestExponencialOfDuration;
import cases.SmallestTimeToDelivery;
import cases.SumOfDurationAndDelivery;

public class Generator {

    public ParameterToTest testCases() {

	List<ParameterToTest> listToTest = this.generateListOfParameters();

	System.out.println("Testing the following cases: \n");
	for (int i = 0; i < listToTest.size(); i++) {
	    System.out.println(listToTest.get(i).getClass().getName());
	}

	System.out.println("\n\n starting the tests:");

	while (listToTest.size() > 1) {
	    testOnce(listToTest);

	    System.out
		    .println("\t\t\tAfter this try, the options that are still availiable are: ");
	    for (int i = 0; i < listToTest.size(); i++) {
		System.out.println("\t\t\t\t\t" + listToTest.get(i).getClass().getName());
	    }

	    System.out.println("\n\n");
	}

	return listToTest.get(0);
    }

    public List<ParameterToTest> testOnce(List<ParameterToTest> listToTest) {
	TaskList taskList = new TaskList();
	int smallerDelay = 0;

	taskList.generateRandomListOfTask();

	for (int i = 0; i < listToTest.size(); i++) {
	    listToTest.get(i).setOrderedList(taskList.getListOfTask());

	    int delay = listToTest.get(i).generateMaximumDelay();

	    if (i == 0) {
		smallerDelay = delay;
	    }

	    if (delay < smallerDelay) {
		smallerDelay = delay;
	    }
	}

	listToTest = remove(smallerDelay, listToTest);

	return listToTest;
    }

    private List<ParameterToTest> generateListOfParameters() {
	List<ParameterToTest> listToReturn = new ArrayList<ParameterToTest>();

	SmallestDiferenceBetwenDurationAndDelivery smallestDiference = new SmallestDiferenceBetwenDurationAndDelivery();
	SmallestDuration smallestDuration = new SmallestDuration();
	SmallestTimeToDelivery smallestTimeToDelivery = new SmallestTimeToDelivery();
	SumOfDurationAndDelivery sum = new SumOfDurationAndDelivery();
	SmallestExponencialOfDuration smallesExponecial = new SmallestExponencialOfDuration();

	listToReturn.add(smallesExponecial);
	listToReturn.add(smallestTimeToDelivery);
	listToReturn.add(smallestDuration);
	listToReturn.add(smallestDiference);
	listToReturn.add(sum);

	return listToReturn;
    }

    private List<ParameterToTest> remove(final int smallerDelay,
	    List<ParameterToTest> listToTest) {
	int i = 0;

	System.out.println("\tThe smaller delay of this try is: "
		+ smallerDelay);
	for (i = 0; i < listToTest.size(); i++) {
	    ParameterToTest parameterToTest = listToTest.get(i);
	    if (parameterToTest.getMaximumDelay() > smallerDelay) {
		System.out.println("\t\tremoving "
			+ listToTest.remove(i).getClass() + " with delay of "
			+ parameterToTest.getMaximumDelay());

	    } else {
		System.out.println("\t\twont remove "
			+ parameterToTest.getClass() + " with delay of "
			+ parameterToTest.getMaximumDelay());
	    }
	}
	System.out.println(" ");

	return listToTest;
    }

}
