package test;


public class SingletonTest {
    private SingletonTest(){};
    public static SingletonTest getInstance(){
        return InnerClass.INSTANCE;
    }

    private static class InnerClass {
        private static final SingletonTest INSTANCE = new SingletonTest();
    }
}
