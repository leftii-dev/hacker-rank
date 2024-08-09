package dev.austinbarnes.problemsolving.finddigits;

import java.io.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int findDigits(int n) {
        // Write your code here
        int digitsDivisible = 0;
        int originalNumber = n;
        while(n > 0){
            int currentDigit = n % 10;
            n /= 10;
            if(currentDigit == 0) continue;
            digitsDivisible += originalNumber % currentDigit == 0 ? 1 : 0;
        }

        return digitsDivisible;
    }

}

public class FindDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.findDigits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
