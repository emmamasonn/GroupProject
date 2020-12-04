package Project;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by Group 11 on 28/11/2020
 * Read Class.
 **/
public class Read {
   // Will return user input with exception handling.

   //A string class to read in the user input
   public static String read(String label) {
      String value = "";

      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("\nProvide your " + label + ":");

      //try - exception handling
      try
      {
            //While loop with if statement. If user enters null or an empty entry, they
           // will be prompted again.
            while (value == null || value.isEmpty())
            {
                System.out.print("> ");
                value = input.readLine();

                if (value.isEmpty())
                {
                   System.out.println("Sorry that was an invalid input. Try again.");
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
