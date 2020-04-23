/*
 * Emma is playing a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2. She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. It is always possible to win the game.

For each game, Emma will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided. For example, c = [0,1,0,0,0,1,0] indexed from 0...6. The number on each cloud is its index in the list so she must avoid the clouds at indexes 1 and 5. She could follow the following two paths: 0 -> 2 -> 4 -> 6 or 0 -> 2 -> 3 -> 4 -> 6. The first path takes 3 jumps while the second takes 4.

Function Description:

Complete the jumpingOnClouds function in the editor below. It should return the minimum number of jumps required, as an integer.

jumpingOnClouds has the following parameter(s):

c: an array of binary integers

Input Format:

The first line contains an integer n, the total number of clouds. The second line contains n space-separated binary integers describing clouds c[i] where 0 <= i < n.

Constraints:

1. 2 <= n <= 100
2. c[i] E {0,1}
3. c[0] = c[n-1] = 0

Output Format:

Print the minimum number of jumps needed to win the game.

Sample Input 0:

7
0 0 1 0 0 1 0

Sample Output 0:

4

Explanation 0:

Emma must avoid c[2] and c[5]. She can win the game with a minimum of 4 jumps:
Path: 0 -> 1 -> 3 -> 4 -> 6     (2 and 5 are avoided)

Sample Input 1:

6
0 0 0 0 1 0

Sample Output 1:

3

Explanation 1:

The only thundercloud to avoid is c[4]. Emma can win the game in 3 jumps:
Minimum Path: 0 -> 2 -> 3 -> 5 (1 is skipped and 4 is avoided)
Maximum Path: 0 -> 1 -> 2 -> 3 -> 5 (4 is avoided)
 */

package com.sjsu.edu.jumpingclouds;

import java.io.*;
import java.util.*;

public class JumpingClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jump = 0; // Initialize the number of jumps as 0
        int i = 0; // Initialize the index of array 'c' to 0

        while(i < c.length-1){ // while loop to traverse through the array of integers starting at 0th index 
            if((i+2) <= c.length-1 && c[i+2] == 0){ // Checking if number of current cloud (i) + 2 == 0   (0 -> safe and 1 -> avoided)
                i = i + 2; // If yes, then increment the index by 2
                jump++; // Increment the jump counter
            }
            else{
                if((i+1) <= c.length-1 && c[i+1] == 0){ // Checking if number of current cloud (i) + 1 == 0 (0 -> safe and 1 -> avoided) 
                    i = i + 1; // Increment the index by 1
                    jump++; // Increment the jump counter
                }
            }
        }
        return jump; // Return the minimum number of jumps to reach from first cloud to last cloud
    }

    private static final Scanner scanner = new Scanner(System.in); // Creating the object of Scanner class

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt(); // Reads the number of clouds as input from user
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n]; // Create an array of integers of length 'n'

        String[] cItems = scanner.nextLine().split(" "); // Reads space separated strings from user in a String array "cItems"
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) { // for loop to traverse the array of Strings "cItems"
            int cItem = Integer.parseInt(cItems[i]); // Convert the String at index 'i' in "cItems" array to Integer and store it in an variable of type 'int'
            c[i] = cItem; // Store the int value in an array of integers 'c'
        }

        int result = jumpingOnClouds(c); // Calling the method jumpingOnClouds with the array passed as an argument that returns min number of jumps

        bufferedWriter.write(String.valueOf(result)); // Print the value of result on console
        bufferedWriter.newLine();

        bufferedWriter.close(); // Close the buffered writer object

        scanner.close(); // Close the Scanner class object
    }
}

