package dev.austinbarnes.problemsolving.extralongfactorials;

import java.io.*;
import java.math.BigInteger;

class Result {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void extraLongFactorials(int n) {
        // Write your code here
        BigInteger result = BigInteger.valueOf(n);
        for(int i = n - 1; i > 0; i--){
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }

}

public class ExtraLongFactorials {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}

