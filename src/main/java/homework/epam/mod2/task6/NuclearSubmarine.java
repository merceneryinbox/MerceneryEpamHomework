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

        System.out.println();

        NuclearSubmarine forInnerDrive = new NuclearSubmarine("Submarine with inner drive");
        AtomicSubmarineMemberInnerDrive innerDrive = forInnerDrive.extractMyInnerDrive();
        innerDrive.startEngine();

        System.out.println();

        NuclearSubmarine.InnerLocalClass innerLocalClass  = new NuclearSubmarine.InnerLocalClass("InnerLocal");
        System.out.println(innerDrive.returnNameInnerLocalClass());
    }

    public void forInnerLocalClass(){
        String testFieldForInnerLocalClass = "testFieldForInnerLocalClass";
        class InnerLocalClass{
            public InnerLocalClass(String innerLocalClassName) {
                this.innerLocalClassName = innerLocalClassName;
            }

            String innerLocalClassName = testFieldForInnerLocalClass;
            String returnNameInnerLocalClass(){
                return innerLocalClassName;
            }
        }
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

    public AtomicSubmarineMemberInnerDrive extractMyInnerDrive() {
        return new AtomicSubmarineMemberInnerDrive();
    }

    public static class AtomicSubmarineNestedDrive {

        public static void startEngine() {
            System.out.println("\nBrrrrrrr ....Nested Drive starts , submarine going !");
        }

    }

    private static class InnerLocalClass {
        public InnerLocalClass(String innerLocal) {

        }
    }

    public class AtomicSubmarineMemberInnerDrive {
        void startEngine() {
            System.out.println("MemmberrInnnnernerner  drive starts, submarine go !");
        }

    }
}
