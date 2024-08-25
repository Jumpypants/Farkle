import java.util.List;

public class TripleMove implements Move {
	private final int num;

	public TripleMove (int num) {
		this.num = num;
	}

	@Override
	public boolean isPossible(List<Integer> counts) {
		return counts.get(num - 1) == 3;
	}

	@Override
	public void play(Turn turn) {
		int removedCount = 0;
		for (int i = 0; i < turn.dice.size(); i++) {
			if (turn.dice.get(i).val == num) {
				turn.dice.remove(i);
				i--;
				removedCount++;
				if (removedCount == 3) break;
			}
		}

		turn.score += num * 10;
	}

	@Override
	public String stringIfy() {
		return "Triple " + num;
	}
}
