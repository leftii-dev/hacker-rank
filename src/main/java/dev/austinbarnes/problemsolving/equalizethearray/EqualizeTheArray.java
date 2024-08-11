package dev.austinbarnes.problemsolving.equalizethearray;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalizeArray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     *
     * Return minimal number elements need to be deleted to leave only equal numbers
     */

    public static int equalizeArray(List<Integer> arr) {
        // Write your code here
        int[] counts = new int[101];
        // Add count of each value to array
        for(int i : arr)
            counts[i]++;

        int max = 0;
        // Determine maximal occurrence
        for(int i : counts)
            max = Math.max(max, i);

        // return difference between size of array and number of maximal occurrence
        return arr.size() - max;
    }

}

public class EqualizeTheArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalizeArray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

