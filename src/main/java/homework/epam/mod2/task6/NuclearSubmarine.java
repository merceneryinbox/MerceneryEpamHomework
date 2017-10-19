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
        nuclearSubmarine.engineAccess();
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

    void engineAccess() {
        AtomicSubmarineDrive.startEngine();
    }

    public static class AtomicSubmarineDrive {

        String name = "Internal Drive of atomic submarine";

        public static void startEngine() {
            System.out.println("\nBrrrrrrr .... Drive starts , submarine going !");
        }

        public String getName() {
            return name;
        }

    }
}
