/*
Задание 6. Классы внутри классов
Разработайте класс АтомнаяЛодка, создайте внутренний класс –
ДвигательДляАтомнойЛодки. Создайте объект АтомнаяЛодка и “запустите его в плавание”.
 */

/*
There are four variants may exists:
    -) Inner class
        --) Member Class;
        --) Local Class.
    -) Nested Inner Class
    -) Anonymous inner Class
 */
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
        System.out.println();
        System.out.println(nuclearSubmarine.name);
        NuclearSubmarine.AtomicSubmarineNestedDrive nestedDrive = new NuclearSubmarine.AtomicSubmarineNestedDrive();
        nestedDrive.startEngine(); // not recommended forever

        System.out.println();

        NuclearSubmarine forInnerDrive = new NuclearSubmarine("Submarine with inner drive");
        NuclearSubmarine.AtomicSubmarineMemberInnerDrive innerMemberDrive = forInnerDrive.extractMyInnerDrive();
        innerMemberDrive.startEngine();

        System.out.println();

        NuclearSubmarine.InnerLocalClass innerLocalDrive = new NuclearSubmarine.InnerLocalClass("InnerLocal");
    }

    public void forInnerLocalClass() {
        String testFieldForInnerLocalClass = "testFieldForInnerLocalClass";
        class InnerLocalDrive {
            NuclearSubmarine nuclearSubmarine = new NuclearSubmarine("Nuclear sub created in inner local class");

            InnerLocalDrive() {
                printFromInnerLocalClass();
                touchOutterClassName();
            }

            void printFromInnerLocalClass() {
                System.out.println(nuclearSubmarine.name);
            }

            void touchOutterClassName() {
                System.out.println(name + " From inner local Class.");
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
            System.out.println("\nNested Drive starts , submarine going !");
        }

    }

    private static class InnerLocalClass {
        public InnerLocalClass(String innerLocal) {

        }
    }

    public class AtomicSubmarineMemberInnerDrive {
        void startEngine() {
            System.out.println("\nMember Inner drive starts, submarine go !");
        }
    }
}
