package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cases.SmallestDuration;

public class TestParameterToTest {

    @Test
    public void testMergerigthEmpty() {
	TaskList taskList = new TaskList();
	taskList.generateRandomListOfTask();

	List<Task> list1 = new ArrayList<Task>();
	List<Task> list2 = taskList.getListOfTask();

	ParameterToTest parameterToTest = new SmallestDuration();

	List<Task> result = parameterToTest.merge(list2, list1);

	for (int i = 0; i < result.size(); i++) {
	    assertTrue(result.get(i).equals(list2.get(i)));
	}

    }

    @Test
    public void testMergeLeftEmpty() {
	TaskList taskList = new TaskList();
	taskList.generateRandomListOfTask();

	List<Task> list1 = new ArrayList<Task>();
	List<Task> list2 = taskList.getListOfTask();

	ParameterToTest parameterToTest = new SmallestDuration();

	List<Task> result = parameterToTest.merge(list1, list2);

	for (int i = 0; i < result.size(); i++) {
	    assertTrue(result.get(i).equals(list2.get(i)));
	}
    }
}
