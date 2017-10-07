package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.DrawingTool;

public class AutomathicPencil extends DrawingTool {
    public AutomathicPencil() {
        super("Automathic Pencil type", "AutoPencil", 100.00, "AutoPencil", "Black", false, true);
    }

    protected String superProperties() {
        return "Plain black graphite";
    }

    @Override
    protected int getKernelsCount() {
        return 1;
    }

    @Override
    public double getCost() {
        return 100.00;
    }
}
