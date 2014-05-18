package cases;

import java.util.List;

import model.ParameterToTest;
import model.Task;

public class SmallestExponencialOfDuration extends ParameterToTest {

    @Override
    public boolean isLeft(List<Task> left, List<Task> right, int walkerToLeft,
	    int walkerToRight) {
	int exponencialLeft = left.get(walkerToLeft).getTaskDuration();
	exponencialLeft *= exponencialLeft;

	int exponencialRight = right.get(walkerToRight).getTaskDuration();
	exponencialRight *= exponencialRight;

	if (exponencialLeft < exponencialRight) {
	    return true;
	} else {
	    return false;
	}
    }

}
