package Project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by Group 11 on 28/11/2020
 * Author: Emma Mason and Donal Doherty
 * Last Updated:06/12/2020
 * Read Class - to use exception handling
 * to get a valid user input.
 **/
public class Read {
   // Will return user input with exception handling.

   //A string class to read in the user input
   public static String read(String label) {
      String value = "";

      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("\nProvide your " + label );

      //try - exception handling
      try
      {
            //While loop with if statement. If user enters null or an empty entry, they
           // will be prompted again.
            while (value == null || value.isEmpty())
            {
                System.out.print(": ");
                value = input.readLine();

                if (value.isEmpty())
                {
                   System.out.println("Sorry that was an invalid input. Please try again.");
                }
            }

      }
      catch (IOException e)
      {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }

      return value;
   }//Read Method.

   public static String menuOptions(String label) {
      String value = "";

      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("\nHow would you like to start? " + label + " (1 - 3) ");

      //try - exception handling
      try
      {
         //While loop with if statement. If user enters null or an empty entry, they
         // will be prompted again.
         while (value == null || value.isEmpty())
         {
            System.out.print(": ");
            value = input.readLine();

            if (value.isEmpty())
            {
               System.out.println("Sorry that was an invalid input. Please try again.");
            }
         }

      }
      catch (IOException e)
      {
         System.out.println("An error occurred.");
         e.printStackTrace();
      }

      return value;
   }//Read Method.
}
