import java.util.ArrayList;
import java.util.List;

public class StraightMove implements Move {

	@Override
	public boolean isPossible (List<Integer> counts) {
		for (int count : counts) {
			if (count != 1) return false;
		}

		return true;
	}

	@Override
	public void play (Turn turn) {
		turn.dice.clear();
		turn.score += 150;
	}

	@Override
	public String stringIfy () {
		return "Straight";
	}
}
