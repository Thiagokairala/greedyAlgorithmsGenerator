package cases;

import static org.junit.Assert.*;

import java.util.List;

import model.Task;
import model.TaskList;

import org.junit.Test;

import cases.SmallestTimeToDelivery;

public class TestSmallestTimeToDelivery {

    @Test
    public void testMergeNoneEmpty() {
	TaskList taskList1 = new TaskList();
	for (int i = 0; i < 20; i = i + 2) {
	    Task task = new Task();
	    task.setTaskTimeToDelivery(i);
	    taskList1.getListOfTask().add(task);
	}

	TaskList taskList = new TaskList();
	for (int i = 1; i < 21; i = i + 2) {
	    Task task = new Task();
	    task.setTaskTimeToDelivery(i);
	    taskList.getListOfTask().add(task);
	}

	SmallestTimeToDelivery smalestTimeToDelivery = new SmallestTimeToDelivery();

	List<Task> result = smalestTimeToDelivery.merge(
		taskList1.getListOfTask(), taskList.getListOfTask());

	for (int i = 1; i < result.size(); i++) {
	    assertTrue(result.get(i - 1).getTaskTimeToDelivery() < result
		    .get(i).getTaskTimeToDelivery());

	}
    }

}
