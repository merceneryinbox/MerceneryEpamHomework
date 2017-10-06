package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.StatsMainPaper;

public class AlbumForPainting extends StatsMainPaper {
    private String name = "Album";
    private double cost;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getMainProperty() {
        return mainProperty;
    }

    private String mainProperty = "size A3";

    public AlbumForPainting() {
        setMainProperty(mainProperty);
        setName(name);
        setCost(350.00);
    }

    @Override
    protected String extras() {
        return mainProperty;
    }

    public static void main(String[] args) {
        AlbumForPainting a = new AlbumForPainting();
        System.out.println("a = " + a.getMainProperty() + "  " + a.getName() + "  " + a.getCost());
    }

}
