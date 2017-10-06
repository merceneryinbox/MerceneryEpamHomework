package homework.epam.mod2.task2stationeryCost;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by karapuz on 04.10.2017.
 */
public class Person {
    private Set<Tools> toolsSet = new HashSet<>();
    private int numOfTools;

    public Person(Tools tools, int i) {
        this.appendTool(tools, i);
    }

    public Person appendTool(Tools t, int count) {
        toolsSet.add(t);
        return this;
    }

    public double getSumPrice() {
        double sum = 0;

        for (Tools t : toolsSet) {
            sum = sum + t.getPrice();
        }
        return sum;
    }

    public int getNumOfTools() {
        numOfTools = toolsSet.size();
        return numOfTools;
    }

//    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.appendTool(new Tools(TypeOfTool.CIRCLE, 1000), 4)
//                .appendTool(new Tools(TypeOfTool.LASTIC, 500), 3)
//                .appendTool(new Tools(TypeOfTool.PAPER, 350), 10);
//
//    }
}
