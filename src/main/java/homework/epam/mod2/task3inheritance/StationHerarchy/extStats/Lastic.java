package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.AdditionalOfficeTools;

public class Lastic extends AdditionalOfficeTools {
    public Lastic() {
        setCost(15.55);
    }

    public Lastic(double cost) {
        super(cost, "Crause");
    }

    @Override
    public String whatForProperty() {
        return "Errase pencil draw";
    }
}
