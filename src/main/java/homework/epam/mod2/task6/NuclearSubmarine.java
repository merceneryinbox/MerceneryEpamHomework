package homework.epam.mod2.task6;

import java.util.Objects;

public class NuclearSubmarine {
    private final String name;

    public NuclearSubmarine(String name) {
        this.name = name;
    }

    /**
     * Test Atomic Submarine Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        NuclearSubmarine nuclearSubmarine = new NuclearSubmarine("My firs submarine");
        System.out.println(nuclearSubmarine.name);
        NuclearSubmarine.AtomicSubmarineNestedDrive nestedDrive = new NuclearSubmarine.AtomicSubmarineNestedDrive();
        nestedDrive.startEngine(); // not recommended forever

        NuclearSubmarine forInnerDrive = new NuclearSubmarine("Submarine with inner drive");
        NuclearSubmarine.AtomicSubmarineInnerDrive innerDrive = forInnerDrive.extractMyInnerDrive();
        innerDrive.startEngine();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NuclearSubmarine)) return false;
        NuclearSubmarine that = (NuclearSubmarine) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public AtomicSubmarineInnerDrive extractMyInnerDrive() {
        return new AtomicSubmarineInnerDrive();
    }

    public static class AtomicSubmarineNestedDrive {

        public static void startEngine() {
            System.out.println("\nBrrrrrrr ....Nested Drive starts , submarine going !");
        }

    }

    public class AtomicSubmarineInnerDrive {
        void startEngine() {
            System.out.println("Innnnernerner  drive starts, submarine go !");
        }

    }
}
