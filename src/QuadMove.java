import java.util.List;

public class QuadMove implements Move {
	private final int num;

	public QuadMove (int num) {
		this.num = num;
	}

	@Override
	public boolean isPossible(List<Integer> counts) {
		return counts.get(num - 1) == 4;
	}

	@Override
	public void play(Turn turn) {
		int removedCount = 0;
		for (int i = 0; i < turn.dice.size(); i++) {
			if (turn.dice.get(i).val == num) {
				turn.dice.remove(i);
				i--;
				removedCount++;
				if (removedCount == 4) break;
			}
		}

		turn.score += num * 20;
	}

	@Override
	public String stringIfy() {
		return "Quad " + num;
	}
}
