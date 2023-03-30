/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.IterativeMergeSort;

/**
 *
 * @author Rohan
 */
//Importing all packages needed for the code
import java.util.Scanner;
import java.util.Random;
public class IterativeMergeSort {
     void printArray(int[] arr) {
    //This method is for the sole purpose of printing out the array
    System.out.print("{");
    for (int i = 0; i < arr.length; i++){
    System.out.print(arr[i] + ",  ");
    }
    System.out.println("}");
} public static void mergeSortIt(int[] test){
    //tests to see if the sort has no elements or one element, if so just returns it.
      if(test.length <= 1){
         return;
      }
      if(test.length > 1){
          // takes the middle point of the array
         int mid = test.length / 2;
         //Now, it sets a left array and right array based on this to hold the sorted values on each side
         int[] left = new int[mid];
         for(int i = 0; i < mid; i++){
            left[i] = test[i];
         } //takes the remaining values to the right of the midpoint and puts it in a different array
         int[] right = new int[test.length - mid];
         for(int i = mid; i < test.length; i++){
            right[i - mid] = test[i];
         }
         mergeSortIt(left);
         mergeSortIt(right);
         int a = 0;
         int b = 0;
         int c = 0;
         //This is where the assigning of values to the array happens!
         while(a < left.length && b < right.length){
             //if the left side value < right side value, it assigns the left side value to the original, otherwise it assigns the right side value to the original array
            if(left[a] < right[b]){
               test[c] = left[a];
               a++;
            } else {
                test[c] = right[b];
               b++;
            }
            c++;
         } //Once one side of the array is done, it starts using the rest of the values found in the other side to populate it
          while(a < left.length)
            {
                test[c] = left[a];
                a++;
                c++;
            }
            while(b < right.length)
            {
                test[c] = right[b];
                b++;
                c++;
            }
      }
   }
    public static void main(String[] args)
    {   //Initializes Scanner
        Scanner scan = new Scanner(System.in);
        System.out.println("how many elements?");
        //user inputs the amount of elements they want in the array
        int input = scan.nextInt();
        Random randomize = new Random();
        int[] testingArray = new int[input];
        //assigns random numbers to fill the array
        for (int i = 0; i < testingArray.length; i++) {
        testingArray[i] = randomize.nextInt(100);
       }
         
        IterativeMergeSort tester = new IterativeMergeSort();
        //prints out unsorted array
        System.out.println("Unsorted:");
        tester.printArray(testingArray);
        //times the algorithm in nanoseconds
        double start = System.nanoTime();
        mergeSortIt(testingArray);
        double end = System.nanoTime();
        double total = end - start;
        //prints out sorted array
        System.out.println("Sorted:");
        tester.printArray(testingArray);
        //This calculates the total amount of nanoseconds that it takes for the program to run
        System.out.println("It took " + total + " nanoseconds.");
    }
}
