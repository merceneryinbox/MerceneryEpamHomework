package homework.epam.mod2.task3inheritance;

import homework.epam.mod2.task3inheritance.StationHerarchy.extStats.AutomathicPencil;
import homework.epam.mod2.task3inheritance.StationHerarchy.extStats.NoteBook;
import homework.epam.mod2.task3inheritance.StationHerarchy.extStats.PilotDrawingPen;
import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.DrawingTool;
import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.Stationaries;
import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.StatsMainPaper;

import java.util.ArrayList;
import java.util.List;

public final class NoviceSet {
    private static List<Stationaries> stationariesSet = new ArrayList<>();

    public NoviceSet() {
        StatsMainPaper tetrad = new NoteBook();
        stationariesSet.add(tetrad);
        DrawingTool pen = new PilotDrawingPen();
        stationariesSet.add(pen);
        DrawingTool pencil = new AutomathicPencil();
        stationariesSet.add(pencil);
    }

    public static List<Stationaries> getStationariesSet() {
        return stationariesSet;
    }

    public static void setStationariesSet(List<Stationaries> stationariesSet) {
        NoviceSet.stationariesSet = stationariesSet;
    }
}
