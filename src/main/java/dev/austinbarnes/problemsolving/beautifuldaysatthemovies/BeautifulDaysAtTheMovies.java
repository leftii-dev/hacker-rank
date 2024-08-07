package dev.austinbarnes.problemsolving.beautifuldaysatthemovies;

import java.io.*;

class Result {

    /*
     * Complete the 'beautifulDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER i
     *  2. INTEGER j
     *  3. INTEGER k
     */

    public static int beautifulDays(int i, int j, int k) {
        // Write your code here
        int numBeautifulDays = 0;
        for( int l = i; l <= j; l++) {
            if((l - reverseInt(l)) % k == 0) numBeautifulDays++;
        }
        return  numBeautifulDays;
    }

    private static int reverseInt(int i){
        int reversed = 0;

        while(i != 0){
            int digit = i % 10;
            reversed = reversed * 10 + digit;

            i /= 10;
        }
        return reversed;
    }

}

public class BeautifulDaysAtTheMovies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int i = Integer.parseInt(firstMultipleInput[0]);

        int j = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.beautifulDays(i, j, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
