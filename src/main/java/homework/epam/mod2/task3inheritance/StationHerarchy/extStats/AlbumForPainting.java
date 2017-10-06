package homework.epam.mod2.task3inheritance.StationHerarchy.extStats;

import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.StatsMainPaper;

public class AlbumForPainting extends StatsMainPaper {
    String name = "Album";

    @Override
    protected String getName() {
        return "Drawing album";
    }

    @Override
    protected String extras() {
        return "Paper size A3";
    }

    @Override
    protected double getCost() {
        return 350.00;
    }
}
