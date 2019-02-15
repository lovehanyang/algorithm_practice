package Singleton;

public class SingletonOne {

    private static volatile SingletonOne instance;

    private SingletonOne() {

    }

    public static SingletonOne getInstance() {
        if (instance == null) {
            synchronized (SingletonOne.class) {
                if (instance == null) {
                    instance = new SingletonOne();
                }
            }
        }
        return instance;
    }

}
