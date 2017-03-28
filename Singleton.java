public class Singleton {

	private Singleton instance = null;

	public Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}