package interview;

public class SingletonLazy {
	private SingletonLazy(){};
	public static SingletonLazy getInstance(){
		return InnerClass.INSTANCE;
	}

	private static class InnerClass {
		private static final SingletonLazy INSTANCE = new SingletonLazy();
	}
}
