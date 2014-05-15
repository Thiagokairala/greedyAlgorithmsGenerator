package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskList {
    private List<Task> listOfTask = new ArrayList<Task>();
    private final int NUMBER_OF_TASKS = 10;

    public void generateRandomListOfTask() {
	Random random = new Random();

	for (int i = 0; i < NUMBER_OF_TASKS; i++) {
	    int duration = -1;

	    while (duration < 1) {
		duration = random.nextInt();
	    }
	    int timeToDelivery = duration - 1;

	    while (timeToDelivery < duration) {
		timeToDelivery = random.nextInt();
	    }

	    Task task = new Task();
	    task.setTaskDuration(duration);
	    task.setTaskTimeToDelivery(timeToDelivery);

	    listOfTask.add(task);
	}
    }

    public List<Task> getListOfTask() {
	return listOfTask;
    }

    public void setListOfTask(List<Task> listOfTask) {
	this.listOfTask = listOfTask;
    }

}
