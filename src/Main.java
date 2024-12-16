import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int numPlayers = 2;
		int numRounds = 1;

		ArrayList<Integer> scores = new ArrayList<>();
		for (int i = 0; i < numPlayers; i++) {
			scores.add(0);
		}

		play(numPlayers, numRounds, scores);

		int highIndex = 0;
		int highScore = 0;
		for (int i = 0; i < numPlayers; i++) {
			if (scores.get(i) > highScore) {
				highScore = scores.get(i);
				highIndex = i;
			}
		}

		System.out.println();
		System.out.println("PLAYER " + (highIndex + 1) + " WINS!");
	}

	private static void play(int numPlayers, int numRounds, List<Integer> scores) {
		for (int i = 0; i < numRounds; i++) {
			for (int j = 0; j < numPlayers; j++) {
				System.out.println("--PLAYER " + (j + 1) + " TURN");
				Turn turn = new Turn();
				scores.set(j, scores.get(j) + turn.score);

				System.out.println("--Scores:");
				for (int k = 0; k < numPlayers; k++) {
					System.out.println("Player " + (k + 1) + ": " + scores.get(k));
				}
			}
		}
	}
}
