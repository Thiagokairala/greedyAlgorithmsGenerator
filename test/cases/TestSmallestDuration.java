package cases;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import model.Task;
import model.TaskList;

import org.junit.Test;

import cases.SmallestDuration;

public class TestSmallestDuration {

    @Test
    public void testMergeNoneEmpty() {
	TaskList taskList1 = new TaskList();
	for (int i = 0; i < 20; i = i + 2) {
	    Task task = new Task();
	    task.setTaskDuration(i);
	    taskList1.getListOfTask().add(task);
	}

	TaskList taskList = new TaskList();
	for (int i = 1; i < 21; i = i + 2) {
	    Task task = new Task();
	    task.setTaskDuration(i);
	    taskList.getListOfTask().add(task);
	}

	SmallestDuration parameterToTest = new SmallestDuration();

	List<Task> result = parameterToTest.merge(taskList1.getListOfTask(),
		taskList.getListOfTask());

	for (int i = 1; i < result.size(); i++) {
	    assertTrue(result.get(i - 1).getTaskDuration() < result.get(i)
		    .getTaskDuration());

	}
    }

    @Test
    public void testGenerateMaximumDelay() {
	Task task1 = new Task();
	task1.setTaskDuration(2);
	task1.setTaskTimeToDelivery(4);

	Task task2 = new Task();
	task2.setTaskDuration(4);
	task2.setTaskTimeToDelivery(5);

	List<Task> tasks = new ArrayList<Task>();

	tasks.add(task2);
	tasks.add(task1);

	SmallestDuration smallest = new SmallestDuration();

	smallest.setListOfTasks(tasks);

	smallest.generateMaximumDelay();

	assertTrue(smallest.getMaximumDelay() == 2);
    }

}
