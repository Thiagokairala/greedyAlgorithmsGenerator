package model;

import java.util.List;

public class SmallestDuration extends ParameterToTest {

    @Override
    public boolean isLeft(List<Task> left, List<Task> right, int walkerToLeft,
	    int walkerToRight) {
	if (left.get(walkerToLeft).getTaskDuration() < right.get(walkerToRight)
		.getTaskDuration()) {
	    return true;
	} else {
	    return false;
	}
    }
}
