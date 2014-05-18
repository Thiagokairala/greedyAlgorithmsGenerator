package model;

import java.util.ArrayList;
import java.util.List;

public abstract class ParameterToTest {

    private int maximumDelay = 0;
    private List<Task> listOfTasks;

    public void setOrderedList(List<Task> listToOrder) {
	this.setListOfTasks(orderList(listToOrder));
    }

    private List<Task> orderList(List<Task> listToOrder) {
	if (listToOrder.size() > 1) {
	    int size = listToOrder.size();
	    List<Task> left = new ArrayList<Task>();
	    List<Task> right = new ArrayList<Task>();

	    for (int i = 0; i < size / 2; i++) {
		left.add(listToOrder.get(i));
	    }

	    for (int i = size / 2; i < size; i++) {
		right.add(listToOrder.get(i));
	    }

	    left = orderList(left);
	    right = orderList(right);

	    return merge(left, right);
	} else {
	    return listToOrder;
	}

    }

    public List<Task> merge(List<Task> left, List<Task> right) {

	if (left.isEmpty()) {
	    return right;
	} else {
	    if (right.isEmpty()) {
		return left;
	    } else {
		int contFirstArray = 0;
		int contSecondArray = 0;
		List<Task> arrayToReturn = new ArrayList<Task>();

		int total = left.size() + right.size();

		for (int i = 0; i < total; i++) {
		    if (contFirstArray == left.size()) {
			for (int j = i; j < total; j++) {
			    arrayToReturn.add(right.get(contSecondArray));

			    contSecondArray++;
			}
			return arrayToReturn;
		    } else {
			if (contSecondArray == right.size()) {
			    for (int j = i; j < total; j++) {
				arrayToReturn.add(left.get(contFirstArray));
				contFirstArray++;
			    }
			    return arrayToReturn;
			} else {
			    if (isLeft(left, right, contFirstArray,
				    contSecondArray)) {
				arrayToReturn.add(left.get(contFirstArray));
				contFirstArray++;
			    } else {
				arrayToReturn.add(right.get(contSecondArray));
				contSecondArray++;
			    }
			}
		    }

		}

		return arrayToReturn;
	    }
	}

    }

    public void generateMaximumDelay() {
	int delay = 0;
	int totalTime = 0;

	for (int i = 0; i < this.getListOfTasks().size(); i++) {
	    totalTime = totalTime
		    + this.getListOfTasks().get(i).getTaskDuration();

	    int timeToDelivery = this.getListOfTasks().get(i)
		    .getTaskTimeToDelivery();

	    if (timeToDelivery < totalTime) {

		if (totalTime - timeToDelivery > delay) {
		    delay = totalTime - timeToDelivery;
		}
	    }

	}

	this.setMaximumDelay(delay);
    }

    public int getMaximumDelay() {
	return maximumDelay;
    }

    public void setMaximumDelay(int maximumDelay) {
	this.maximumDelay = maximumDelay;
    }

    public List<Task> getListOfTasks() {
	return listOfTasks;
    }

    public void setListOfTasks(List<Task> listOfTasks) {
	this.listOfTasks = listOfTasks;
    }

    public abstract boolean isLeft(List<Task> left, List<Task> right,
	    int walkerToLeft, int walkerToRight);

}
