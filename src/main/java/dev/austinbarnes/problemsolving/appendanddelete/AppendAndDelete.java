package dev.austinbarnes.problemsolving.appendanddelete;


import java.io.*;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     *
     * Can convert s to t in EXACTLY k operations?
     * (Some do not match this requirement, but work. Think there may be an error in the prompt)
     * Return "Yes" or "No"
     */

    public static String appendAndDelete(String s, String t, int k) {
        // Write your code here
        if(k >= s.length() + t.length()) return "Yes";
        int delete = 0;
        int shorter = Math.min(s.length(), t.length());
        for(int i = 0; i < shorter; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                delete += s.length() - i;
                break;
            }
        }
        int append = Math.abs((s.length() - delete) - t.length());
        int total = k - (delete + append);

        return total >= 0 && total % 2 == 0|| s.equals(t) ? "Yes" : "No";
    }

}

public class AppendAndDelete {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
