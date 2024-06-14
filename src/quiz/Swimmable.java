package quiz;

interface Swimmable {
    default void swimTo(int x, int y) {
        System.out.println("Swimming to (" + x + ", " + y + ")");
    }
}
