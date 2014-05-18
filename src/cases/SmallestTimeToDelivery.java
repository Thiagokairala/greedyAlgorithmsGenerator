package cases;

import java.util.List;

import model.ParameterToTest;
import model.Task;

public class SmallestTimeToDelivery extends ParameterToTest {

    @Override
    public boolean isLeft(List<Task> left, List<Task> right, int walkerToLeft,
	    int walkerToRight) {
	if (left.get(walkerToLeft).getTaskTimeToDelivery() < right.get(
		walkerToRight).getTaskTimeToDelivery()) {
	    return true;
	} else {
	    return false;
	}
    }
}
