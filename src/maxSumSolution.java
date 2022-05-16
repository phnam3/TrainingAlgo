import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class maxSumSolution {
    public static int maxSum(ArrayList<Integer> arr) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int maximum = -1;

        //The hashmap contains (K: sum of digits -> V: integers) if there are 2 integers with the same sum of digits
        //we can find one from the hashmap
        for (Integer number : arr) {
            if (sumMap.containsKey(getSum(number))) {
                //if there are 2 ints with the same sum of digits -> calculate their sum
                int temp = sumMap.get(getSum(number)) + number;
                //save it into the maximum variable
                if (temp > maximum) {
                    maximum = temp;
                }
                //if the integer in the hashmap is smaller than the current integer then we always pick the
                //larger one to calculate the maximum sum -> replace the value from the key inside the hashmap
                if (number > sumMap.get(getSum(number))) {
                    sumMap.put(getSum(number), number);
                }
            } else {
                //if there is no key -> insert it into the hashmap
                sumMap.put(getSum(number), number);
            }
        }
        //O(logn) to find the pair inside the hashmap * O(n) to traverse the array
        return maximum;
    }

    //get the sum of digits from an integer
    public static int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
