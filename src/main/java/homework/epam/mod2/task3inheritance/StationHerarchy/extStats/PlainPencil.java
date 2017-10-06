package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.DrawingTool;

public class PlainPencil extends DrawingTool {
    private double cost;
    private String firm;

    public PlainPencil() {
    }

    public PlainPencil(String typeDrawingTool, String drawColor, boolean writeingWithInk, boolean automatic) {
        super(typeDrawingTool, drawColor, writeingWithInk, automatic);
    }

    public PlainPencil(double cost, String firm) {
        this.cost = cost;
        this.firm = firm;
    }


    @Override
    protected String superProperties() {
        return null;
    }

    @Override
    protected int getKernelsCount() {
        return 0;
    }

    @Override
    protected double getCost() {
        return 0;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }
}
