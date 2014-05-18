package cases;

import static org.junit.Assert.*;

import java.util.List;

import model.Task;
import model.TaskList;

import org.junit.Test;

public class TestSumOfDurationAndDelivery {
    @Test
    public void testMergeNoneEmpty() {
	TaskList taskList1 = new TaskList();
	for (int i = 0; i < 20; i = i + 2) {
	    Task task = new Task();
	    task.setTaskTimeToDelivery(i);
	    task.setTaskTimeToDelivery(10 + i);
	    taskList1.getListOfTask().add(task);
	}

	TaskList taskList = new TaskList();
	for (int i = 1; i < 21; i = i + 2) {
	    Task task = new Task();
	    task.setTaskTimeToDelivery(i);
	    task.setTaskTimeToDelivery(10 + i);
	    taskList.getListOfTask().add(task);
	}

	SumOfDurationAndDelivery sum = new SumOfDurationAndDelivery();

	List<Task> result = sum.merge(taskList1.getListOfTask(),
		taskList.getListOfTask());

	for (int i = 1; i < result.size(); i++) {
	    int sumFirst = result.get(i - 1).getTaskDuration()
		    + result.get(i - 1).getTaskTimeToDelivery();
	    int sumSecond = result.get(i).getTaskDuration()
		    + result.get(i).getTaskTimeToDelivery();
	    assertTrue(sumFirst < sumSecond);

	}
    }
}
