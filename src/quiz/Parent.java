package quiz;

public class Parent extends Human implements Walkable, Runnable {
    public Parent(String name, int age) {
        super(name, age, 3);
    }

    @Override
    public void walkTo(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Parent walking to (" + x + ", " + y + ")");
    }

    @Override
    public void runTo(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Parent running to (" + x + ", " + y + ")");
    }
}
