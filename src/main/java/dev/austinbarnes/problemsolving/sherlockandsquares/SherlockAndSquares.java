package dev.austinbarnes.problemsolving.sherlockandsquares;

import java.io.*;
import java.util.stream.*;


class Result {

    /*
     * Complete the 'squares' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER a
     *  2. INTEGER b
     * Squares end with 1, 4, 5, 6, or 9
     * Had to research this one to find the formula regarding squares in a range
     */

    public static int squares(int a, int b) {
        // Write your code here
        int first = (int) Math.ceil(Math.sqrt(a));
        int last = (int) Math.floor(Math.sqrt(b));
        return (last - first) + 1;
    }

}

public class SherlockAndSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int a = Integer.parseInt(firstMultipleInput[0]);

                int b = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.squares(a, b);

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

