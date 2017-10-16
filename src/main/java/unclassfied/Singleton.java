package unclassfied;

//单例模式有以下三个特点：
//        一、单例类在整个系统中只能有一个实例
//        二、单例类必须自己创建自己的实例
//        三、单例类必须系统中其他对象提供这个实例


public class Singleton {
    private static final ThreadLocal perThreadInstance = new ThreadLocal();
    private static Singleton singleton ;
    private Singleton() {}

    public static Singleton  getInstance() {
        if (perThreadInstance.get() == null){
            // 每个线程第一次都会调用
            createInstance();
        }
        return singleton;
    }

    private static  final void createInstance() {
        synchronized (Singleton.class) {
            if (singleton == null){
                singleton = new Singleton();
            }
        }
        perThreadInstance.set(perThreadInstance);
    }
}

