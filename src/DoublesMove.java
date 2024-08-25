import java.util.ArrayList;
import java.util.List;

public class DoublesMove implements Move {
	@Override
	public boolean isPossible(List<Integer> counts) {
		int doubleCount = 0;
		for (int c : counts) {
			if (c > 2) return false;
			if (c == 2) {
				doubleCount++;
			}
		}

		return doubleCount == 3;
	}

	@Override
	public void play(Turn turn) {
		turn.dice.clear();
		turn.score += 150;
	}

	@Override
	public String stringIfy() {
		return "3 Doubles";
	}
}
