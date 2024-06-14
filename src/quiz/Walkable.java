package quiz;

interface Walkable {
    default void walkTo(int x, int y) {
        System.out.println("Walking to (" + x + ", " + y + ")");
    }
}
