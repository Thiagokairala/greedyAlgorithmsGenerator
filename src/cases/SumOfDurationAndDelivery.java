package cases;

import java.util.List;

import model.ParameterToTest;
import model.Task;

public class SumOfDurationAndDelivery extends ParameterToTest {

    @Override
    public boolean isLeft(List<Task> left, List<Task> right, int walkerToLeft,
	    int walkerToRight) {
	int sumLeft = left.get(walkerToLeft).getTaskDuration()
		+ left.get(walkerToLeft).getTaskTimeToDelivery();

	int sumRight = right.get(walkerToRight).getTaskDuration()
		+ right.get(walkerToRight).getTaskTimeToDelivery();

	if (sumLeft < sumRight) {
	    return true;
	} else {
	    return false;
	}
    }

}
