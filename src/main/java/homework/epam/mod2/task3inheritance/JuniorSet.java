package homework.epam.mod2.task3inheritance;

import homework.epam.mod2.task3inheritance.StationHerarchy.extStats.AutomathicPencil;
import homework.epam.mod2.task3inheritance.StationHerarchy.extStats.NoteBook;
import homework.epam.mod2.task3inheritance.StationHerarchy.extStats.PilotDrawingPen;
import homework.epam.mod2.task3inheritance.StationHerarchy.extStats.PlainPencil;
import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.AdditionalOfficeTools;
import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.DrawingTool;
import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.Stationaries;
import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.StatsMainPaper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class JuniorSet {
    private static List<Stationaries> stationariesSet = new ArrayList<>();

    public JuniorSet() {
        StatsMainPaper tetrad = new NoteBook();
        tetrad.setFirm("Junior firm");
        tetrad.setName("Junior tetrad");
        tetrad.setCost(550.02);
        DrawingTool pen = new PilotDrawingPen();
        DrawingTool pencil = new AutomathicPencil();

        stationariesSet.add(tetrad);
        stationariesSet.add(pen);
        stationariesSet.add(pencil);
    }

    /**
     * regex using to update type of Set after it change into MiddleSet
     */
    public void extendToMiddleSet() {
        Pattern pattern = Pattern.compile("Junior");
        for (Stationaries st : stationariesSet) {
            Matcher matcher = pattern.matcher(st.getFirm());
            if (matcher.find()) {
                st.setFirm("Middle firm");
            }
        }
        AdditionalOfficeTools clip = new AdditionalOfficeTools(12.25, "My firm", "Clip", 12) {
            @Override
            public String newProperty() {
                return "Clipping the papers";
            }
        };
        DrawingTool middlePen = new DrawingTool("middle firm", "Pilot pen", 156.22, "Middle type", "Three colors", true, true) {
            @Override
            protected int getKernelsCount() {
                return 4;
            }
        };

        stationariesSet.add(clip);
        stationariesSet.add(middlePen);
    }

    /**
     * regex using to update type of Set after it change into SeniorSet
     */
    public void extendToSeniorSet() {
        this.extendToMiddleSet();
        Pattern pattern = Pattern.compile("Middle");
        for (Stationaries st : stationariesSet) {
            Matcher matcher = pattern.matcher(st.getFirm());
            if (matcher.find()) {
                st.setFirm("Senior firm");
            }
        }
        stationariesSet.addAll(List.of(new PlainPencil(), new PilotDrawingPen()));
    }


    public List<Stationaries> getStationariesSet() {
        return stationariesSet;
    }

    public double getSumOfStats() {
        double sum = 0;
        for (Stationaries st : stationariesSet) {
            sum = sum + st.getCost();
        }
        return sum;
    }

    public static void main(String[] args) {
        JuniorSet n = new JuniorSet();
        List<Stationaries> noviceSet = n.getStationariesSet();
        for (Stationaries st : noviceSet) {
            System.out.println(st.getName() + " " + st.getFirm() + " " + st.getCost());
        }
        System.out.println("Let's see how much does JuniorSet cost " + n.getSumOfStats() + "\n");

        System.out.println("\nNow extend our set to Middle Set\n ");
        n.extendToMiddleSet();

        for (Stationaries st : noviceSet) {
            System.out.println(st.getName() + " " + st.getFirm() + " " + st.getCost());
        }
        System.out.println("Let's see how much does MiddleSet cost " + n.getSumOfStats() + "\n");

        n.extendToSeniorSet();
        System.out.println("\nNow extend our set to Senior Set\n");
        for (Stationaries st : noviceSet) {
            System.out.println(st.getName() + " " + st.getFirm() + " " + st.getCost());
        }
        System.out.println("Let's see how much does SeniorSet cost " + n.getSumOfStats() + "\n");
    }
}
