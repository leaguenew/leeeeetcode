import java.io.Serializable;

public class OuterClass implements Serializable {

    
    private int a;
    private int b;

    public static class InnerClass {
        private int c;
        private int d;

        public InnerClass(int c, int d) {
            this.c = c;
            this.d = d;
        }
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = new InnerClass(1, 2);
        System.out.println(innerClass.c);
    }
}
