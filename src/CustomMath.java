public class CustomMath {

    public static int sum(int x, int y) {
        return x + y;
    }

    public static int division(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return (x / y);
    }
}