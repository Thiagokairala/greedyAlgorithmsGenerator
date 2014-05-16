package model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

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
}
