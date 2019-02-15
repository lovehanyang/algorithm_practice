package Singleton;

public class SingletonTwo {


    private SingletonTwo() {

    }

    public static SingletonTwo getInstance() {
        return Holder.instance;
    }

    private static class Holder {
        static SingletonTwo instance = new SingletonTwo();
    }

}
