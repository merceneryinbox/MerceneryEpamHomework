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
    static String staticVar = "staticVar";
    private final String name;
    String notStaticVar = "notStaticVar";

    public NuclearSubmarine(String name) {
        this.name = name;
    }

    static String staticOuterStartEngineMethod() {
        System.out.println("\nStatic outer Start Engine.");
        return "\nStatic outer Start Engine.";
    }

    /**
     * Test Atomic Submarine Main method
     *
     * @param args
     */
    public static void main(String[] args) {
        //******* test of inner member class ******* //
        // create inner member through hierarchical invoke without super Class instance creation
        NuclearSubmarine.AtomicSubmarineMemberInnerDrive memberDrive = new NuclearSubmarine("2").new AtomicSubmarineMemberInnerDrive();
        memberDrive.startEngine(); // not recommended at all
        // test outer fields
        memberDrive.returnOuterVars();
        System.out.println();

        //******* test of inner member class ******* //
        // create inner member  through Outter class's builder method invocation from heir with super Class instance creation
        System.out.println("Make new instance of submarine");
        NuclearSubmarine nuclearSubmarine2 = new NuclearSubmarine("\nNuclear sub for test outer class method " + "creation of inner member class");
        NuclearSubmarine.AtomicSubmarineMemberInnerDrive localDrive = nuclearSubmarine2.extractMyInnerMemberDrive();
        localDrive.startEngine();
        localDrive.returnOuterVars();
        System.out.println();

        //******* test of inner member class ******* //
        NuclearSubmarine nuclearSubmarine6 = new NuclearSubmarine("666");
        NuclearSubmarine.AtomicSubmarineMemberInnerDrive innerMemberDrive6 = nuclearSubmarine6.new AtomicSubmarineMemberInnerDrive();
        System.out.println();

        //******* test of inner local class ******* //
        // Inner local class creation using outer especial builder method
        NuclearSubmarine nuclearSubmarine3 = new NuclearSubmarine("Sub for inner local test.");
        nuclearSubmarine3.testInnerLocal();
        System.out.println();

        //******* test of inner local class ******* //
        // creat inner local without instance of outer
        new NuclearSubmarine("create inner local without instance of outer").testInnerLocal();
        System.out.println();

        //******* test of inner nested class ******* //
        NuclearSubmarine nuclearSubmarine4 = new NuclearSubmarine("\nFor InnerLocal");
        AtomicSubmarineNestedDrive atomicSubmarineNestedDrive1 = new NuclearSubmarine.AtomicSubmarineNestedDrive();
        atomicSubmarineNestedDrive1.startEngine();
        atomicSubmarineNestedDrive1.testForOuterVarsAccess();
        System.out.println();

        //******* test of inner anonymous class ******* //

    }

    String notStaticStartEngineMethod() {
        System.out.println("\nNot static outer start Engine.");
        return "\nNot static outer start Engine.";
    }

    public void forInnerLocalClass() {
        String testFieldForInnerLocalClass = "testFieldForInnerLocalClass";
        class InnerLocalDrive {
            void methodInInnerLocalClass() {
                System.out.println("\nAttempt to take outer not static variable from inner local class " + notStaticVar);
                System.out.println("\nAttempt to take outer static variable from inner local class " + staticVar);

                System.out.println("\nAttempt to invoke outer not static method from inner local class ");
                notStaticStartEngineMethod();

                System.out.println("\nAttempt to invoke outer static method from inner local class ");
                staticOuterStartEngineMethod();
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

    public void testInnerLocal() {

        class InnerLocalClass {
            void startEngine() {
                System.out.println("\nInner Local Start engine.");
            }

            void testOuterVarsAndMethodsAccess() {
                System.out.println("Test for inner local access for outer static vars " + staticVar);
                System.out.println("Test for inner local access for outer not static vars " + notStaticVar);
                System.out.println("Test for inner local access for outer static methods " + staticOuterStartEngineMethod());
                System.out.println("Test for inner local access for outer not static vars " + notStaticStartEngineMethod());
            }
        }
        InnerLocalClass innerLocalClass = new InnerLocalClass();
        innerLocalClass.startEngine();
        innerLocalClass.testOuterVarsAndMethodsAccess();
    }

    public AtomicSubmarineMemberInnerDrive extractMyInnerMemberDrive() {
        return new AtomicSubmarineMemberInnerDrive();
    }

    static class AtomicSubmarineNestedDrive {

        void startEngine() {
            System.out.println("\nNested Drive starts , submarine go !");
        }

        void testForOuterVarsAccess() {
//            System.out.println("test not static outer var access " + notStaticVar);  compilation error
            System.out.println("test static outer var access " + staticVar);
//            System.out.println("test not static outer method access " + notStaticStartEngineMethod()); compilation error
            System.out.println("test static outer method access " + staticOuterStartEngineMethod());
        }
    }

    class AtomicSubmarineMemberInnerDrive {
        void startEngine() {
            System.out.println("\nInner Member drive starts, submarine go !");
        }

        void returnOuterVars() {
            System.out.println("\nTest to tough static outer var from Inner Member " + staticVar);
            System.out.println("\nTest to tough not static outer var from Inner Member " + notStaticVar);
            System.out.println("\nTest to tough not static outer method from Inner Member " + notStaticStartEngineMethod());
            System.out.println("\nTest to tough static outer method from Inner Member " + staticOuterStartEngineMethod());

        }
    }
}
