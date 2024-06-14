package quiz;

interface Runnable {
    default void runTo(int x, int y) {
        System.out.println("Running to (" + x + ", " + y + ")");
    }
}