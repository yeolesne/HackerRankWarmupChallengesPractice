/*
 * Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.

Given an integer, n, find and print the number of letter a's in the first n letters of Lilah's infinite string.

For example, if the string s = 'abcac' and n = 10, the substring we consider is abcacabcac, the first 10 characters of her infinite string. There are 4 occurrences of a in the substring.

Function Description:

Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length n in the infinitely repeating string.

repeatedString has the following parameter(s):

1. s: a string to repeat
2. n: the number of characters to consider

Input Format:

The first line contains a single string, s.
The second line contains an integer, n.

Constraints:

1. 1 <= |s| <= 100
2. 1 <= n <= 10^12
3. For 25% of the test cases, n <= 10^6.

Output Format:

Print a single integer denoting the number of letter a's in the first n letters of the infinite string created by repeating s infinitely many times.

Sample Input 0:

aba
10

Sample Output 0:

7

Explanation 0:

The first n = 10 letters of the infinite string are abaabaabaa. Because there are 7 a's, we print 7 on a new line.

Sample Input 1:

a
1000000000000

Sample Output 1:

1000000000000

Explanation 1:

Because all of the first n = 1000000000000 letters of the infinite string are a, we print 1000000000000 on a new line.
 */

package com.sjsu.edu.repeatedstring;

import java.io.*;
import java.util.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long counter = 0; // Initialize the total occurrences of letter 'a'
        long div = n / s.length(); // Calculate the dividend 
        int rem = (int) (n % s.length()); // Calculate the remainder and parse to integer
        long initialCount = 0; // Initialize the number of occurrences of letter 'a' in the given initial string

        // Calculate the total no of a's in given initial string
        for(int i = 0; i < s.length(); i++){ // for loop to traverse through the given initial string
            if(s.charAt(i) == 'a'){ // If char 'a' is found
                initialCount++; // Increment the initial count of letter 'a'
            }
        }
        counter = initialCount * div; // Compute total no of a's found so far
        
        if(rem == 0) // Means we have gone through every single character we need to build, no remaining substring to traverse
        	return counter; // Return the count of 'a' as computed above
        else {
        	// substring(int beginIndex, int endIndex)
        	String part = s.substring(0, rem);     // Take care of the part of string which is not yet traversed to find total no of a's (grab the remaining substring)
        	for(int j = 0; j < part.length(); j++) { // for loop to traverse through the substring
        		if(part.charAt(j) == 'a') { // If char 'a' found in the substring
        			counter++; // Increment the total no of a's
        		}
        	}
        }
       
        return counter; // Return the number of occurrences of 'a' in infinitely repeated string
    
    }

    private static final Scanner scanner = new Scanner(System.in); // Creating the Scanner class object

    //Main method
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine(); // Reads the string from user

        long n = scanner.nextLong(); // Reads first 'n' letters to traverse in the infinitely repeated string
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n); // Calling the "repeatedString" method with given string and first n letters passed as an argument

        bufferedWriter.write(String.valueOf(result)); // Prints the value of result on console
        bufferedWriter.newLine();

        bufferedWriter.close(); // Close the bufferedWriter object

        scanner.close(); // Close the Scanner class object
    }
}
