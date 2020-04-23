/*
 * 
 * Problem Statement: John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

For example, there are n=7 socks with colors ar=[1,2,1,2,1,3,2]. There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color. The number of pairs is 2.

Function Description:

Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

sockMerchant has the following parameter(s):

1. n: the number of socks in the pile
2. ar: the colors of each sock

Input Format:

The first line contains an integer n, the number of socks represented in ar.
The second line contains n space-separated integers describing the colors ar[i] of the socks in the pile.

Constraints:

1 <= n <= 100
1 <= ar[i] <= 100 where 0 <= i < n  

Output Format:

Return the total number of matching pairs of socks that John can sell.

Sample Input:

9
10 20 20 10 10 30 50 10 20

Sample Output:

3

Explanation:

sock.png

John can match three pairs of socks.
 */

package com.sjsu.edu.sockmerchant;

import java.io.*;
import java.util.*;


public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int noOfPairs = 0;
        int max = getMax(ar); // Get the max value in given array -> ar (50 in the above example)
        int[] temp = new int[max+1]; // Create a temporary array with length (maxValue+1) -> range, 0-50 

        for(int i = 0; i < ar.length; i++){ // Traverse through the given array
            temp[ar[i]] = temp[ar[i]] + 1; // and count the occurence of each number, storing that count at ith index (count of number 10 at 10th index in "temp" array)
        }

        for(int j = 0; j < temp.length; j++){ // Traverse through the "temp" array
            noOfPairs = noOfPairs + (temp[j]/2); // Calculate total number of pairs
        }
        return noOfPairs; // Return total number of pairs....

    }

    public static int getMax(int[] array){
        int maxValue = array[0]; // Assign first element of array "ar" to maxValue
        for(int i = 1; i < array.length; i++){ // Traverse through rest of the elements of array
            if(array[i] > maxValue){ // If the element at index 'i' is > the assigned maxValue, then....
                maxValue = array[i]; // Assign the element at index 'i' to maxValue
            }
        }
        return maxValue; // Return the max value
    }



    private static final Scanner scanner = new Scanner(System.in);

    //Main method 
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt(); // Takes total no of elements from user
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n]; // Declare an array of Integers

        String[] arItems = scanner.nextLine().split(" "); // Takes comma separated Integer values from user in a String array
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) { // For each element
            int arItem = Integer.parseInt(arItems[i]); // Convert String to Integers
            ar[i] = arItem; // Store the integer element in array "ar"
        }

        int result = sockMerchant(n, ar); // Call the method with length, and given array as arguments....

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close(); // Close the scanner object..
    }
}
