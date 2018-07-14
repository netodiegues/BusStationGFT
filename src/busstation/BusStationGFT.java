package busstation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author NETO
 */
public class BusStationGFT {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int iSizeBus = scan.nextInt();

        int[] iFriends = new int[iSizeBus];
        for (int i = 0; i < iFriends.length; i++) {
            iFriends[i] = scan.nextInt();
        }

        // Solve
        boarding(iFriends);
        scan.close();
    }

    static void boarding(int[] iFriends) {

        List<Integer> listGroups = new ArrayList<Integer>();

        for (int i = 0; i < iFriends.length; i++) {
            if (listGroups.isEmpty()) {
                listGroups.add(iFriends[i]);
            } else {
                if (i == iFriends.length - 1) {
                    listGroups.set(listGroups.size() - 1, listGroups.get(listGroups.size() - 1) + iFriends[i]);
                    break;
                }
                if ((listGroups.get(listGroups.size() - 1) != iFriends[i]) && iFriends[i - 1] != iFriends[i]) {
                    listGroups.add(iFriends[i]);
                } else {
                    listGroups.set(listGroups.size() - 1, listGroups.get(listGroups.size() - 1) + iFriends[i]);
                }
            }
        }

        int iSumFriends = Arrays.stream(iFriends).sum();

        Set<Integer> auxGroup = new HashSet<Integer>();
        for (int i = 0; i < listGroups.size(); i++) {
            if (iSumFriends % listGroups.get(i) == 0) {
                auxGroup.add(iSumFriends / listGroups.get(i));
            }
        }
        System.out.println(auxGroup.toString());
    }
}
