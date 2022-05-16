import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;

public class distinctPair {
    public static int distinct(ArrayList<Integer> arr) {
        //O(nlogn) to sort the array
        Collections.sort(arr);
        int count = 0;

        //O(n) to traverse the array and calculate the number of moves
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != (i + 1)) {
                count += abs(arr.get(i) - (i + 1));
            }
        }
        //O(n2logn) total time complexity
        return count;
    }

    public static int continuousArraySolution(ArrayList<Integer> arr) {
        //Sort the array -> O(nlogn)
        Collections.sort(arr);
        //Minimum offset -> always arr[0] after sorting
        int minOffset = 1;
        int intHolder = 0;
        int holderOffset = 1;
        int answer = 0;

        //Most efficient continuous arrays of size N -> [1,2,3....N+1] with offset = 1 (minimum value is 1)
        //E.g [4,4,6,9,9,10] -> with offset = 4 -> [4,5,6] then minimum offset is 6 (arr[3] - 3) => [9,10,11]
        for (int i = 0; i < arr.size(); i++) {
            int tempOffset = arr.get(i) - i;
            if (tempOffset < minOffset) {
                if (intHolder == 0) {
                    answer += minOffset - tempOffset;
                    holderOffset = 1;
                } else {
                    answer += holderOffset;
                    minOffset = arr.get(i) - holderOffset - i;
                    intHolder -= 1;
                    holderOffset += 1;
                }
            } else if (tempOffset > minOffset) {
                intHolder = tempOffset - minOffset;
                minOffset = tempOffset;
            }
        }
        return answer;
    }
}
