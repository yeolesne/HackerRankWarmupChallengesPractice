/*
 * Problem Statement:
 * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. During his last hike he took exactly n steps. For every step he took, he noted if it was an uphill, U, or a downhill, D step. Gary's hikes start and end at sea level and each step up or down represents a 1 unit change in altitude. We define the following terms:

1. A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
2. A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.

Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.

For example, if Gary's path is s=[DDUUUUDD], he first enters a valley 2 units deep. Then he climbs out an up onto a mountain 2 units high. Finally, he returns to sea level and ends his hike.

Function Description:

Complete the countingValleys function in the editor below. It must return an integer that denotes the number of valleys Gary traversed.

countingValleys has the following parameter(s):

1. n: the number of steps Gary takes
2. s: a string describing his path

Input Format:

The first line contains an integer n, the number of steps in Gary's hike.
The second line contains a single string s, of n characters that describe his path.

Constraints:

2 <= n <= 10^6
s[i] E {UD}

Output Format:

Print a single integer that denotes the number of valleys Gary walked through during his hike.

Sample Input:

8
UDDDUDUU

Sample Output:

1

Explanation:

If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:

_/\      _
   \    /
    \/\/
He enters and leaves one valley.
 */

/*
 * For explanation:
 * 
 * Please refer the video below for explanation:
 * 
 * https://www.youtube.com/watch?v=MMmFELo0QjM&feature=youtu.be
 */

package com.sjsu.edu.countingvalleys;

import java.io.*;
import java.util.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int altitude = 0; 
        int noOfValleys = 0;
        for(int i = 0; i < n; i++){ // Traverse through the given string 's' describing Garry's path, n = length of string (no of characters)
            if(s.charAt(i) == 'U'){ // If character at index ith is 'U', then 
                altitude++; //increment the altitude
                if(altitude == 0){ // If the altitude reaches value of 0 (sea level)
                    noOfValleys++; // Increment the count of number of valleys
                }
            }else{
                altitude--; // If the characterin string 's' at ith index is 'D', then decrement the altitude 
            }
        }
        return noOfValleys; // Return the number of valleys
    }

    private static final Scanner scanner = new Scanner(System.in);
    
    //Main method
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt(); // Takes number of characters from user
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine(); // Takes string describing Garry's path from user

        int result = countingValleys(n, s); // Call the function with n = length of string and s = string describing Garry's path as arguments

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close(); // Close the scanner object
    }
}
