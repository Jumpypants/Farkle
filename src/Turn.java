import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turn {
	public ArrayList<Die> dice = new ArrayList<Die>();
	public int score = 0;

	private boolean hasRolled = true;

	public Turn(){
		for (int i = 0; i < 6; i++) {
			dice.add(new Die());
		}

		roll();

		while (!dice.isEmpty()) {
			printDice();
			checkMoves();
			System.out.println("Turn score: " + score);
		}
	}

	private void printDice () {
		StringBuilder display = new StringBuilder();
		for (Die d : dice) {
			display.append("|").append(d.val).append("| ");
		}
		System.out.println(display);
	}

	private void roll () {
		hasRolled = true;
		for (Die d : dice) {
			d.roll();
		}
	}

	private void checkMoves () {
		ArrayList<Integer> counts = new ArrayList<Integer>();
		for (int i = 1; i <= 6; i++) {
			counts.add(howMany(i));
		}

		ArrayList<Move> moves = new ArrayList<Move>();

		// Straight
		StraightMove straight = new StraightMove();
		if (straight.isPossible(counts)) moves.add(straight);

		// Single 2
		SingleMove single2 = new SingleMove(2);
		if (single2.isPossible(counts)) moves.add(single2);

		// Single 4
		SingleMove single4 = new SingleMove(4);
		if (single4.isPossible(counts)) moves.add(single4);

		// Triples
		checkTriples(counts, moves);

		// Quads
		checkQuads(counts, moves);

		// Doubles
		DoublesMove doubles = new DoublesMove();
		if (doubles.isPossible(counts)) moves.add (doubles);

		// Check farkle
		if (moves.isEmpty() && hasRolled) {
			dice.clear();
			System.out.println("FARKLE!");
			score = 0;
			return;
		}
		hasRolled = false;

		// Print moves
		System.out.println("-2: End turn");
		System.out.println("-1: Roll");

		for (int i = 0; i < moves.size(); i++) {
			System.out.println(i + ": " + moves.get(i).stringIfy());
		}

		// Get user choice
		Scanner scanner = new Scanner(System.in);

		int input = scanner.nextInt();

		if (input == -2) {
			dice.clear();
			return;
		}

		if (input == -1) {
			roll();
			return;
		}

		moves.get(input).play(this);
	}

	private void checkTriples (List<Integer> counts, List<Move> moves) {
		for (int i = 1; i <= 6; i++) {
			TripleMove triple = new TripleMove(i);
			if (triple.isPossible(counts)) moves.add(triple);
		}
	}

	private void checkQuads (List<Integer> counts, List<Move> moves) {
		for (int i = 1; i <= 6; i++) {
			QuadMove quad = new QuadMove(i);
			if (quad.isPossible(counts)) {
				moves.add(quad);
				break;
			}
		}
	}

	private int howMany (int val) {
		int counter = 0;
		for (Die d : dice) {
			if (d.val == val) counter++;
		}

		return counter;
	}
}
