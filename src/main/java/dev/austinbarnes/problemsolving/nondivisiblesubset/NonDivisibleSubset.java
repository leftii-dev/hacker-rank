package dev.austinbarnes.problemsolving.nondivisiblesubset;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     *
     * GOOD BREAKDOWN ON HOW TO SOLVE
     * https://medium.com/@mrunankmistry52/non-divisible-subset-problem-comprehensive-explanation-c878a752f057
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        int[] counts = new int[k + 1];
        for(int i : s){
            counts[i % k]++;
        }

        int answer = Math.min(counts[0], 1);
        if (k % 2 == 0)
            answer += Math.min(counts[k/2], 1);

        for(int i = 1; i < k/2 + 1; i++){
            if(i != k - i){
                answer += Math.max(counts[i], counts[k-i]);
            }
        }
        return answer;
    }

}

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
