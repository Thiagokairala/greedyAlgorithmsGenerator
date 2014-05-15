package model;

import java.util.List;

import org.junit.Test;

public class TestTaskList {

    @Test
    public void testGenerateRandomListOfTask() {
	TaskList taskList = new TaskList();

	taskList.generateRandomListOfTask();

	List<Task> listToTest = taskList.getListOfTask();

	for (int i = 0; i < listToTest.size(); i++) {
	    System.out.println("duracao: " + listToTest.get(i).getTaskDuration());
	    System.out.println("entrega: " + listToTest.get(i).getTaskTimeToDelivery());
	    System.out.println(" ");
	}
    }
}
