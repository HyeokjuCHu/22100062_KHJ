package quiz;

public class Main {
    public static void main(String[] args) {
        Child child = new Child("ChildName", 10);
        Parent parent = new Parent("ParentName", 40);
        GrandParent grandParent = new GrandParent("GrandParentName", 70);

        Human[] people = {child, parent, grandParent};

        System.out.println("Initial states:");
        for (Human person : people) {
            person.getInfo();
        }

        System.out.println("\nWalking to (1, 1):");
        for (Human person : people) {
            if (person instanceof Walkable) {
                ((Walkable) person).walkTo(1, 1);
                person.getInfo();
            }
        }

        System.out.println("\nRunning to (2, 2):");
        for (Human person : people) {
            if (person instanceof Runnable) {
                ((Runnable) person).runTo(2, 2);
                person.getInfo();
            }
        }

        System.out.println("\nSwimming to (3, -1):");
        for (Human person : people) {
            if (person instanceof Swimmable) {
                ((Swimmable) person).swimTo(3, -1);
                person.getInfo();
            }
        }
    }
}
