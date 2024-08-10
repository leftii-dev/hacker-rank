package dev.austinbarnes.problemsolving.libraryfine;

import java.io.*;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;


class Result {

    /*
     * Complete the 'libraryFine' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d1
     *  2. INTEGER m1
     *  3. INTEGER y1
     *  4. INTEGER d2
     *  5. INTEGER m2
     *  6. INTEGER y2
     *
     * If return <= expected, fine = 0
     * If return > expected && return.month == expected.month, fine = 15 * numDaysLate
     * If return > expected.month && return.year == expected.year, fine = 500 * numMonthsLate
     * If return.year > expected year, fine = 10,000
     */

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        LocalDate dateReturn = LocalDate.of(y1, m1, d1);
        LocalDate dateExpected = LocalDate.of(y2, m2, d2);

        if(dateReturn.isBefore(dateExpected))
            return 0;

        if(y1 > y2){
            // Year after
            return 10_000;
        } else if(m1 > m2){
            // Month after
            return 500 * (m1 - m2);
        } else{
            // Days after
            return (int) (15 * DAYS.between(dateExpected, dateReturn));
        }
    }

}

public class LibraryFine {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d1 = Integer.parseInt(firstMultipleInput[0]);

        int m1 = Integer.parseInt(firstMultipleInput[1]);

        int y1 = Integer.parseInt(firstMultipleInput[2]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d2 = Integer.parseInt(secondMultipleInput[0]);

        int m2 = Integer.parseInt(secondMultipleInput[1]);

        int y2 = Integer.parseInt(secondMultipleInput[2]);

        int result = Result.libraryFine(d1, m1, y1, d2, m2, y2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
