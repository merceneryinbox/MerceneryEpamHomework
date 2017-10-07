package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.DrawingTool;

public class PlainPencil extends DrawingTool {
    private double cost = 1.23;
    private String name = "Plain Pencil";
    private String firm;
    private String drawColor = "Plain";

    public PlainPencil() {
        super("Pencil for Senior", "Plain Pencil", 1.23, "Plain", "Black", false, false);
    }

    public PlainPencil(String drawColor, boolean writeingWithInk, boolean automatic) {
        this();
        setDrawColor(drawColor);
        setWriteingWithInk(writeingWithInk);
        setAutomatic(automatic);
    }

    public PlainPencil(double cost, String firm) {
        super(firm, "Plain Pencil", cost, "Plain", "Black", false, false);
        this.cost = cost;
        this.firm = firm;
    }


    protected String superProperties() {
        return null;
    }

    @Override
    protected int getKernelsCount() {
        return 1;
    }

    @Override
    public double getCost() {
        return cost;
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