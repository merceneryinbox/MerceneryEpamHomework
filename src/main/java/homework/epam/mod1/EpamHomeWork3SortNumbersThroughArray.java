package homework.epam.mod1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EpamHomeWork3SortNumbersThroughArray {
    /**
     * Selftetest main
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Input how many numbers you'll be input:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfNum = Integer.parseInt(br.readLine());

        int[] testAr = new int[numOfNum];
        System.out.println("Input your numbers:");
        for (int i = 0; i <= numOfNum - 1; i++) { // create unsorted array
            int inNum = Integer.parseInt(br.readLine());
            testAr[i] = inNum;
        }
        System.out.println("The biggest number is = "+maxFromArray(testAr)); // output maximum value from it through sending it
        // to the maxFromArray(); witch in its turn use sort(); method for it's own.
    }

    /**
     * Get directway sorted array -
     *
     * @param sortedMasToMax
     * @return return last (biggest) element
     */
    public static int maxFromArray(int[] sortedMasToMax) {
        return sort(sortedMasToMax)[sortedMasToMax.length - 1];
    }

    /**
     * MergeSort-type sort of given unsorted array
     *
     * @param unsortedMass
     * @return sorted array
     */
    public static int[] sort(int[] unsortedMass) {
        if (unsortedMass.length < 2) {
            return unsortedMass;
        }
        int[] leftMass = new int[unsortedMass.length / 2];
        int[] rightMass = new int[unsortedMass.length - leftMass.length];

        int l = 0, r = 0;
        for (; l < leftMass.length; ) {
            leftMass[l] = unsortedMass[l];
            l++;
        }
        r = l;
        for (int rr = 0; rr < rightMass.length; ) {
            rightMass[rr] = unsortedMass[r];
            r++;
            rr++;
        }

        return mergeMass(sort(leftMass), sort(rightMass));
    }

    private static int[] mergeMass(int[] sortL, int[] sortR) {
        int[] resultMasInMerg = new int[sortL.length + sortR.length];
        int i = 0, j = 0, resI = 0;
        while (i < sortL.length && j < sortR.length) {
            if (sortL[i] < sortR[j]) {
                resultMasInMerg[resI] = sortL[i];
                i++;
                resI++;
                if (i == sortL.length) {
                    for (int k = j; k < sortR.length; k++, resI++) {
                        resultMasInMerg[resI] = sortR[k];
                    }
                }
            } else {
                resultMasInMerg[resI] = sortR[j];
                j++;
                resI++;

                if (j == sortR.length) {
                    for (int k = i; k < sortL.length; ) {
                        resultMasInMerg[resI] = sortL[k];
                        k++;
                        resI++;
                    }
                }
            }
        }
        return resultMasInMerg;
    }
}
