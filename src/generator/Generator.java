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

	while (listToTest.size() > 1) {
	    testOnce(listToTest);
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

	System.out.println("The smaller delay of this try is: " + smallerDelay);
	for (i = 0; i < listToTest.size(); i++) {
	    ParameterToTest parameterToTest = listToTest.get(i);
	    if (parameterToTest.getMaximumDelay() > smallerDelay) {
		System.out.println("removing "
			+ listToTest.remove(i).getClass() + " with delay of "
			+ parameterToTest.getMaximumDelay());

	    } else {
		System.out
			.println("wont remove " + parameterToTest.getClass()
				+ " with delay of "
				+ parameterToTest.getMaximumDelay());
	    }
	}
	System.out.println(" ");

	return listToTest;
    }

}
