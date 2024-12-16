import java.util.ArrayList;
import java.util.List;

public interface Move {
	boolean isPossible (List<Integer> counts);

	void play (Turn turn);

	String stringIfy();
}