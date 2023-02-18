package HW;

public class ABC {

    static int x = 1;
    int y;
    ABC() {
        y++;
    }

    public static void main(String[] args) {
        ABC abc = new ABC();
        System.out.println(x);
        System.out.println(abc.y);
        abc = new ABC();
        System.out.println(x);
        System.out.println(abc.y);
    }

    static {
        x++;
    }
}
