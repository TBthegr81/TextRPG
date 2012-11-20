package rpg;

public class Fail extends Exception {
	private static final long serialVersionUID = 3214568341732809515L;

	public Fail(String message) {
        super(message);
    }
}
