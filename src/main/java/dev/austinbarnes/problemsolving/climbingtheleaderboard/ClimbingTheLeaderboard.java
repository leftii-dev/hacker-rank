package dev.austinbarnes.problemsolving.climbingtheleaderboard;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     *
     * TEST
     * 7
     * 100 100 50 40 40 20 10
     * 4
     * 5 25 50 120
     *
     * ANSWER 6 4 2 1
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        Set<Integer> cleanRanks = new LinkedHashSet<>(ranked);
        List<Integer> deDupedRanks = new ArrayList<>(cleanRanks);
        Collections.reverse(player);    // Reverse order to match descending ranks
        List<Integer> playerRanks = new ArrayList<>();  // Placeholder list for each player score rank

        int playerIndex = 0;
        for(int i = 0; i < deDupedRanks.size(); i++) {
            while(playerIndex < player.size() && player.get(playerIndex) >= deDupedRanks.get(i)){
                playerRanks.add(i + 1);
                playerIndex++;
            }
        }
        // If there are scores less than all values in ranks, add last place for each
        while(playerIndex < player.size()){
            playerRanks.add(deDupedRanks.size() + 1);
            playerIndex++;
        }
        Collections.reverse(playerRanks);   // Reverse again to ascending as expected in results
        return playerRanks;
    }

    private static int binarySearch(List<Integer> a, int target){
        return binarySearch(a, 0, a.size() - 1, target);
    }

    private static int binarySearch(List<Integer> a, int start, int end, int target){
        int mid = (start + end) / 2;
        if(end < start){
            if(target < a.get(mid)){
                return mid + 1;
            } else if(target > a.get(mid)){
                return mid - 1;
            }
            return a.size() + 1;
        }

        if(target == a.get(mid)){
            return mid;
        } else if(target < a.get(mid)){
            return binarySearch(a, start, mid - 1, target);
        } else {
            return binarySearch(a, mid + 1, end, target);
        }
    }
}

public class ClimbingTheLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(System.out));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
