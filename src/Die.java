public class Die {
	int val = 0;

	public void roll () {
		this.val = (int) (Math.random() * 6) + 1;
	}
}
