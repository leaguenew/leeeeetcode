package company;

public class Tesla1 {

    private static volatile Tesla1 instance;

    private Tesla1() {

    }

    public static Tesla1 getInstance() {
        if (null == instance) {
            synchronized(Tesla1.class) {
                if (null == instance) {
                    instance = new Tesla1();
                    return instance;
                }
            }
        }

        return instance;
    }
}
