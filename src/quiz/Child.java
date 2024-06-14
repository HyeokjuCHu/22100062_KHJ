package quiz;

public class Child extends Human implements Walkable, Runnable, Swimmable {
    public Child(String name, int age) {
        super(name, age, 5);
    }

    @Override
    public void walkTo(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Child walking to (" + x + ", " + y + ")");
    }

    @Override
    public void runTo(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Child running to (" + x + ", " + y + ")");
    }

    @Override
    public void swimTo(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("Child swimming to (" + x + ", " + y + ")");
    }
}

