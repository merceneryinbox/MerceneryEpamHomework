package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.DrawingTool;

public class PilotDrawingPen extends DrawingTool {

    public PilotDrawingPen() {
        super("Pilot drawing Pen firm", "Pilot Pen", 560.00, "Multi types kernels", "Three colors pen", true, true);
    }

    protected String superProperties() {
        return "Stylus included";
    }

    @Override
    protected int getKernelsCount() {
        return 4;
    }

    @Override
    public double getCost() {
        return 4000.00;
    }
}
