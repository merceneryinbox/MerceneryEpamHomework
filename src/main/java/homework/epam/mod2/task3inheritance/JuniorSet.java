package homework.epam.mod2.task3inheritance;

import homework.epam.mod2.task3inheritance.StationHerarchy.extStats.AutomathicPencil;
import homework.epam.mod2.task3inheritance.StationHerarchy.extStats.NoteBook;
import homework.epam.mod2.task3inheritance.StationHerarchy.extStats.PilotDrawingPen;
import homework.epam.mod2.task3inheritance.StationHerarchy.extStats.PlainPencil;
import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.AdditionalOfficeTools;
import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.DrawingTool;
import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.Stationaries;
import homework.epam.mod2.task3inheritance.StationHerarchy.mainStats.StatsMainPaper;

import java.text.Collator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JuniorSet class may be extended to middle and senior set
 */
public final class JuniorSet {
    private static List<Stationaries> stationariesSet = new ArrayList<>();
    private static double packSetCost = 0.00;

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

    public List<Stationaries> getSortedByCostStationariesSet() {
        sortMySetByCost();
        return stationariesSet;
    }

    public List<Stationaries> getSortedByNameStationariesSet() {
        sortMySetByName();
        return stationariesSet;
    }

    public List<Stationaries> getSortedByCostAndNameStationariesSet() {
        sortMySetByCost();
        sortMySetByName();
        return stationariesSet;
    }

    public static double getSumOfStatsInSet() {
        double sum = 0;
        for (Stationaries st : stationariesSet) {
            sum = sum + st.getCost();
        }
        return sum;
    }

//    public static void main(String[] args) {
//        JuniorSet n = new JuniorSet();
//        List<Stationaries> noviceSet = n.getStationariesSet();
//        for (Stationaries st : noviceSet) {
//            System.out.println(st.getName() + " " + st.getFirm() + " " + st.getCost());
//        }
//        System.out.println("Let's see how much does JuniorSet cost " + n.getSumOfStatsInSet() + "\n");
//
//        System.out.println("\nNow extend our set to Middle Set\n ");
//        n.extendToMiddleSet();
//
//        for (Stationaries st : noviceSet) {
//            System.out.println(st.getName() + " " + st.getFirm() + " " + st.getCost());
//        }
//        System.out.println("Let's see how much does MiddleSet cost " + n.getSumOfStatsInSet() + "\n");
//
//        n.extendToSeniorSet();
//        System.out.println("\nNow extend our set to Senior Set\n");
//        for (Stationaries st : noviceSet) {
//            System.out.println(st.getName() + " " + st.getFirm() + " " + st.getCost());
//        }
//        System.out.println("Let's see how much does SeniorSet cost " + n.getSumOfStatsInSet() + "\n");
//    }

    public static double getPackSetCost() {
        return getSumOfStatsInSet();
    }

    private List<Stationaries> sortMySetByCost() {
        double[] sortingCost = new double[stationariesSet.size()];

        int i = 0;
        for (Stationaries d : stationariesSet) {
            sortingCost[i] = d.getCost();
            i++;
        }
        stationariesSet.clear(); // clearing base List for fulFilling it by sorted List
        stationariesSet.addAll(new ArrayList(Arrays.asList(mergingSort(sortingCost)))); // fulfilling  cleared List by sorted elements of it
        return stationariesSet;
    }

    /**
     * Simple MergeSort algorithm realising
     *
     * @param inputAr
     * @return sorted inputAr
     */
    private double[] mergingSort(double[] inputAr) {

        if (inputAr.length < 2) {
            return inputAr;
        } else {
            double[] left = new double[inputAr.length / 2];
            double[] rigth = new double[inputAr.length - inputAr.length / 2];
            return merge(mergingSort(left), mergingSort(rigth));
        }
    }

    /**
     * Merging method as tool for MergeSort algorithm realising method
     *
     * @param left  array
     * @param rigth array
     * @return two unsorted arrays splited in one sorted array
     */
    private double[] merge(double[] left, double[] rigth) {
        double[] resultArInMerge = new double[left.length + rigth.length];

        int resultpointer = 0;
        int leftPointer = 0;
        int rigthPointer = 0;

        while (leftPointer < left.length) {
            for (; rigthPointer < rigth.length; ) {
                resultArInMerge[resultpointer] = left[leftPointer] < rigth[rigthPointer] ? left[leftPointer++] : rigth[rigthPointer++];

                if (leftPointer >= left.length) {
                    for (int i = rigthPointer; i < rigth.length; i++) {
                        resultArInMerge[resultpointer] = rigth[rigthPointer];
                    }
                    break;
                }
                if (rigthPointer >= rigth.length) {
                    for (int i = leftPointer; i < left.length; i++) {
                        resultArInMerge[resultpointer] = left[leftPointer];
                    }
                    break;
                }
            }
        }
        return resultArInMerge;
    }

    public List<Stationaries> sortMySetByName() {
        Collator collator = Collator.getInstance();
        Collections.sort(stationariesSet, collator);

        return stationariesSet;
    }
}
