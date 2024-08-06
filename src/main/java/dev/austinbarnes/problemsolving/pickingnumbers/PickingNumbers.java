package dev.austinbarnes.problemsolving.pickingnumbers;

import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    // 6
    // 4 6 5 3 3 1
    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        Collections.sort(a);
        int[] frequency = new int[a.getLast() + 1];

        for (int i : a) frequency[i] += 1;

        int max = 0;
        for(int i = 1; i < frequency.length - 1; i++) {
            max = Math.max(max, frequency[i] + frequency[i + 1]);
        }

        return max;
    }

}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
