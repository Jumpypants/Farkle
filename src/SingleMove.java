import java.util.List;

public class SingleMove implements Move {
	private final int num;

	public SingleMove (int num) {
		this.num = num;
	}

	@Override
	public boolean isPossible(List<Integer> counts) {
		return counts.get(num - 1) == 1;
	}

	@Override
	public void play(Turn turn) {
		for (int i = 0; i < turn.dice.size(); i++) {
			if (turn.dice.get(i).val == num) {
				turn.dice.remove(i);
				break;
			}
		}

		turn.score += num == 2 ? 10 : 5;
	}

	@Override
	public String stringIfy() {
		return "Single " + num;
	}
}
