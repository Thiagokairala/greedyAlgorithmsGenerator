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

    public ParameterToTest testCases(List<ParameterToTest> listToTest) {

	while (listToTest.size() > 1) {
	    testOnce(listToTest);
	}

	return listToTest.get(0);
    }

    public List<ParameterToTest> testOnce(List<ParameterToTest> listToTest) {
	TaskList taskList = new TaskList();
	int biggerDelay = 0;

	taskList.generateRandomListOfTask();

	for (int i = 0; i < listToTest.size(); i++) {
	    listToTest.get(i).setOrderedList(taskList.getListOfTask());

	    int delay = listToTest.get(i).generateMaximumDelay();

	    if (delay > biggerDelay) {
		biggerDelay = delay;
	    }
	}

	remove(biggerDelay, listToTest);

	return listToTest;
    }

    public List<ParameterToTest> generateListOfParameters() {
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

    private void remove(final int biggerDelay, List<ParameterToTest> listToTest) {
	int cont = 0;

	for (int i = 0; i < listToTest.size(); i++) {
	    if (listToTest.get(i).getMaximumDelay() == biggerDelay) {
		cont++;
	    }
	}

	if (cont < 2) {
	    for (int i = 0; i < listToTest.size(); i++) {
		if (listToTest.get(i).getMaximumDelay() == biggerDelay) {
		    // System.out.println("removing " +
		    // listToTest.get(i).getClass());
		    listToTest.remove(i);
		    return;
		}
	    }
	}
    }

}
