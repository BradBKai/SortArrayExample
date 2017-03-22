import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

/**
* This program is designed to scan input in the commandline argument
* then print out results
*
* @author: Kai, Bradley
* Date: 10/7/2016
*/
public class ArrayExample {
   
   /**
   * This is the main argument, it reads the commandline argument
   *
   * @param args reads the input
   */
   public static void main (String[] args) {
      //Error checking for input, if no input, will prompt user to enter.
         if(args.length == 0) {
            System.out.println("No input found in commandline.  Input is needed to start.");
         }//end if         
         else {
            String[ ] array = readFile(args[0]);
            sortPrint(array, args[0]);           
         }//end else  
                  	     
   }//end of main
   
   /**
   * This is the main argument, it reads the commandline argument
   *
   * @param filename string holds the file name
   * @return returns array
   */
   public static String[ ] readFile(String filename) throws ArrayIndexOutOfBoundsException {
      //Intialize variables
      File file = null;
      Scanner inputFromFile = null;
      String headerline = "";
      String headerline2 = "";
      String line = "";
      
      
      //array for file storing
      final Integer size = 1000;
      String[ ] array = new String[size];
      
      //reads one word at a time from file and stores it in array created
      //connecting to the file
      file = new File(filename);
      try{
         inputFromFile = new Scanner(file);
      }//end try
      catch (FileNotFoundException exception) {
         System.out.println("There is no file called \"" + filename +"\"." + " Try again.");
      }//end FileNotFoundException catch
            //if file is found, read the file   
            if (inputFromFile != null) {
               int i = 0;
               //continue loop to read the remaining lines
               while (inputFromFile.hasNextLine()) {
                  try {
                     //take and hold the next line
                     line = inputFromFile.next();
                     //add to array
                     array[i] = line;
                     //increment array by one
                     ++i;
                  }//end try
                  catch (InputMismatchException e) {
                     inputFromFile.next();
                  }//end InputMismatchException e)
                  catch (NoSuchElementException e) {
                  }//end NoSuchElementException catch
                  
               }//end while inputFromFile 
                
            }//end if
            
      //return array
      return array;
   }//end of readfileReturnWords method
   
   /**
   * This method sorts and prints out the array in ASCII order
   *
   * @param array array holds the words
   * @param filename string holds the file name
   */
   public static void sortPrint(String [ ] array, String filename) {
      //sorts the array
      for (int i = 0; i < array.length; i++) {
         if (array[i] != null) {
            try {
               //set Sorting.display to "false"
               Sorting.display = false; 
               //sort the array   
               Sorting.insertionSort(array);
               //display array
               Sorting.print(array);
            }//end try
            catch (NullPointerException exception){
            }//end catch
               
         }//end if
         
      }//end for
      
      //prints the array
      System.out.println("Alphabetical (ASCII) listing of words in file: " + filename); 
      for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
               System.out.print("\nindex = " + i + ", ");
               System.out.print("element = " + array[i]); 
               
            }//end if
            
      }//end for
      
   }//end sortAndPrintArray method
   
}//end of ArrayExample class
