package cases;

import static org.junit.Assert.*;

import java.util.List;

import model.Task;
import model.TaskList;

import org.junit.Test;

import cases.SmallestDiferenceBetwenDurationAndDelivery;

public class TestSmallestDiferenceBetwenDurationAndDelivery {

    @Test
    public void testMergeNoneEmpty() {
	TaskList taskList1 = new TaskList();
	for (int i = 0; i < 20; i = i + 2) {
	    Task task = new Task();
	    task.setTaskDuration(i);
	    task.setTaskTimeToDelivery(10);
	    taskList1.getListOfTask().add(task);
	}

	TaskList taskList = new TaskList();
	for (int i = 1; i < 21; i = i + 2) {
	    Task task = new Task();
	    task.setTaskDuration(i);
	    task.setTaskTimeToDelivery(10);
	    taskList.getListOfTask().add(task);
	}

	SmallestDiferenceBetwenDurationAndDelivery smallest = new SmallestDiferenceBetwenDurationAndDelivery();

	List<Task> result = smallest.merge(taskList1.getListOfTask(),
		taskList.getListOfTask());

	for (int i = 1; i < result.size(); i++) {
	    int diferenceFirst = result.get(i - 1).getTaskDuration()
		    - result.get(i - 1).getTaskTimeToDelivery();
	    int diferenceSecond = result.get(i).getTaskDuration()
		    - result.get(i).getTaskTimeToDelivery();
	    assertTrue(diferenceFirst < diferenceSecond);

	}
    }
}
