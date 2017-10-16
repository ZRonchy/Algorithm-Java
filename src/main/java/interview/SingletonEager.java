package interview;

public class SingletonEager {
	private static final SingletonEager INSTANCE = new SingletonEager(){};

	private SingletonEager(){};

	public synchronized static SingletonEager getInstance() {
		return INSTANCE;
	}
}
