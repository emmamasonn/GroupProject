package GroupProject;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Group 11 on 28/11/2020
 * Author: Fearghal O'Boyle, Donal
 * Doherty and Emma Mason.
 * Last Updated:06/12/2020
 * User Interface - to test the
 * program using a menu system with
 * switch statements.
 **/
public class UserInterface
{
   static List<User> userList = new ArrayList<User>();

   public static void main(String[] args)
   {
      String choice;
      boolean menu = false, casualMenu, proMenu;

      //Hard coded users for the userList. These users can login without registration.
      userList.add(new Pro("user1", "password1", "ProUserExample", 15000));
      userList.add(new Casual("user3", "password3", "CasualUserExample", 400, 100, 300, 500));
      User.welcome();
      //Call to welcome method in User super class.

      //Main Menu, will keep looping till user exits!
      while (!menu)
      {
         System.out.print("************");

         System.out.println("\n1. Login");
         System.out.println("2. Register");
         System.out.println("3. Exit");
         choice = Read.menuOptions("Enter choice");

         switch (choice)
         {
            case "3":
            {
               System.out.println("\nThank You For Using Reach. Come back soon!");
               menu = true;
            }//Case 0, exit the program.
            break;
            case "2":
            {
               RegistrationTransaction registrationTransaction = new RegistrationTransaction();
               User user = registrationTransaction.register(); // make the new user
               userList.add(user); // add new user
               System.out.println("\nAccount Created, please login below.\n");
            }//Case One Register User.
            break;
            case "1":
            {
               UserLoginTransaction userLogin = new UserLoginTransaction(userList);
               userLogin.login();
               casualMenu = false;
               proMenu = false;

               if (!userLogin.successfulLogin())
               {
                  // prints error and repeats whole while loop
               }
               else
               {
                  int index = userLogin.getIndex();// this is to get the users index in the array
                  User currentUser = userList.get(index);// this deals with which user has logged in

                  if (currentUser.casualUser)
                  {
                     // a menu for casual user - if a newly registered user they must update their likes and followers
                     while (!casualMenu)
                     {
                        // this is a menu for the casual user
                        System.out.println("\n********************");
                        System.out.println("Casual User Account");
                        System.out.println("\n1. Print Your Details \n2. Update Followers \n3. Update Likes " + "\n4. Get User interaction \n5. Receive Tips \n6. Log Out ");

                        choice = Read.read("choice");
                        switch (choice)
                        {
                           case "6":
                           {
                              System.out.println("\nReturning to Main Menu.\n");
                              casualMenu = true;
                           }//Case 0, exit the program.
                           break;

                           case "1":
                           {
                              System.out.println(((Casual) currentUser).toString());
                           }//Case 1, print user's details.
                           break;

                           case "2":
                           {
                              ((Casual) currentUser).updateFollowers();
                           }//Case 2, update followers.
                           break;

                           case "3":
                           {
                              ((Casual) currentUser).updateLikes();
                              ((Casual) currentUser).printAverage();
                           }//Case 3. update likes.
                           break;

                           case "4":
                           {
                              ((Casual) currentUser).printUserInteraction();
                           }//Case 4, print user interaction.
                           break;

                           case "5":
                           {
                              ((Casual) currentUser).printYourReach();
                              ((Casual) currentUser).improveYourReach();
                           }//Case 5, print reach and tips to improve.
                           break;
                        }//Switch Statement for Menu System.
                     }//While Loop for Menu Choices.
                  }//if Current User is a Casual User.

                  else if (currentUser.proInfluencer)
                  {
                     while (!proMenu)
                     {
                        System.out.println("\n*****************************");
                        System.out.println("Pro Influencer Account");
                        System.out.println("\n1. Enter Last 3 Posts Likes \n2. Get Average Likes \n3. Rank Accounts Reached \n4. Rank Interactions "
                                + "\n5. Rank Followers " + "\n6. Show Steps You Took to Achieve Great Reach Grades " + "\n7. Get a Reach Tip " + "\n8. Account Summary (View After All Options Completed)\n9. Log Out");

                        choice = Read.read("choice");
                        switch (choice)
                        {
                           case "9":
                           {
                              System.out.println("\nReturning to Main Menu.\n");
                              proMenu = true;
                           }//Case 0, exit program.
                           break;

                           case "1":
                           {
                              ((Pro) currentUser).updateLikes();
                           }//Case 1, Enter Last Three Posts Likes.
                           break;

                           case "2":
                           {
                              ((Pro) currentUser).printAverage();
                           }//Case 2, Print Average Likes of Last 3 Posts.
                           break;

                           case "3":
                           {
                              ((Pro) currentUser).rankAccountsReached();
                           }//Case 1, Rank Accounts Reached.
                           break;

                           case "4":
                           {
                              ((Pro) currentUser).rankInteractions();
                           }//Case 2, Rank Interactions.
                           break;

                           case "5":
                           {
                              ((Pro) currentUser).rankFollowers();
                           }//Case 3, Rank Followers.
                           break;

                           case "6":
                           {
                              ((Pro) currentUser).printUserEnteredTips();
                           }//Case 6, Print the tips entered by the user.
                           break;

                           case "7":
                           {
                              System.out.println(((Pro) currentUser).showTip());
                           }//Case 7, Display Random Tip to User.
                           break;

                           case "8":
                           {
                              System.out.println(((Pro) currentUser).toString());
                           }//Case 8, Print Account Summary.
                        }//Switch Statement.
                     }//While loop for menu.
                  }//else commands for when User can log in.
               }//else if login is ok.
               break;
            }//Case 2 User Login.
         }//Switch Statement Menu.
      }//While Loop

   }//Main Method
}//User Interface class