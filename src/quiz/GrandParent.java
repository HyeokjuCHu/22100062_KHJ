package quiz;

public class GrandParent extends Human implements Walkable {
    public GrandParent(String name, int age) {
        super(name, age, 1);
    }

    @Override
    public void walkTo(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("GrandParent walking to (" + x + ", " + y + ")");
    }
}
