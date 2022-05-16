import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.abs;

class Main {

    public static void main(String[] args) throws IOException {
        int[] tmp = new int[]{1, 5, 5, 5, 7};
        int[] tmp2 = new int[]{22, 13, 31, 64, 82, 28, 73};
        ArrayList<Integer> test1 = new ArrayList<>(tmp.length);
        ArrayList<Integer> test2 = new ArrayList<>(tmp2.length);
        for (int i : tmp) {
            test1.add(i);
        }
        for (int i : tmp2) {
            test2.add(i);
        }
        System.out.println(maxSumSolution.maxSum(test2));
        System.out.println(distinctPair.distinct(test1));
        String filename = "D://text//f4.txt";
        Scanner sc = new Scanner(System.in);
        FileReader fr = new FileReader(filename);
        SolutionIter solutionIter = new SolutionIter(fr);
        for(Integer x : solutionIter){
            System.out.println(x);
        }
    }
}
