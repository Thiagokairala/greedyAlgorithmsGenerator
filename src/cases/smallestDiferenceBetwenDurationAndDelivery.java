package cases;

import java.util.List;

import model.ParameterToTest;
import model.Task;

public class smallestDiferenceBetwenDurationAndDelivery extends ParameterToTest {

    @Override
    public boolean isLeft(List<Task> left, List<Task> right, int walkerToLeft,
	    int walkerToRight) {
	int diferenceLeft = left.get(walkerToLeft).getTaskDuration()
		- left.get(walkerToLeft).getTaskTimeToDelivery();
	int diferenceRight = right.get(walkerToRight).getTaskDuration()
		- right.get(walkerToRight).getTaskTimeToDelivery();

	if (diferenceLeft < diferenceRight) {
	    return true;
	} else {
	    return false;
	}
    }

}
