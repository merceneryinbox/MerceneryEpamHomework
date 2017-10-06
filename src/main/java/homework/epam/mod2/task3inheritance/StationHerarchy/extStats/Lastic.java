package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.AdditionalOfficeTools;

public class Lastic extends AdditionalOfficeTools {
    private String name = "Lastic";
    private String mainProperty = "Rubber";

    public Lastic() {
        setName(name);
        setCost(155.55);
        setFirm("Zarya");
    }

    public Lastic(double cost) {
        setName(name);
        setCost(cost);
        setFirm("Zarya");
    }

    public Lastic(double cost, String firm, String mainProperty) {
        super(cost, firm);
        setName(name);
        this.mainProperty = mainProperty;
    }

    @Override
    public String newProperty() {
        return mainProperty;
    }

//    public static void main(String[] args) {
//        Lastic l = new Lastic();
//        System.out.println(l.getCost() + " " + l.newProperty() + " " + l.getFirm() + " ");
//
//        Lastic l2 = new Lastic(56, "sun", "none");
//        System.out.println(l2.mainProperty + " " + l2.getFirm() + " " + l2.newProperty() + " "
// + l2.getCost() + " " + l2.getName() + "  " + l2.mainProperty + " " + l2.getFirm() + " "
// + l2.newProperty() + " " + l2.getCost() + " " + l2.getName());
//    }

}
