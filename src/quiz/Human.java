package quiz;

public abstract class Human {
    protected String name;
    protected int age;
    protected int x, y;
    protected int baseSpeed;

    public Human(String name, int age, int baseSpeed) {
        this.name = name;
        this.age = age;
        this.x = 0;
        this.y = 0;
        this.baseSpeed = baseSpeed;
    }

    public void getInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", Speed: " + baseSpeed + ", Location: (" + x + ", " + y + ")");
    }
}
