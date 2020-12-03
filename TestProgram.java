package Project;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Group 11 on 28/11/2020
 * Test Program.
 **/
public class TestProgram
{
   static List<User> userList = new ArrayList<User>();

   public static void main(String[] args)
   {
      String choice;
      boolean menu = false, casualMenu = false, fullTimeMenu = false;

      //HARD CODED USERS FOR THE userList -- NO REGISTRATION NEED FOR THESE ACCOUNTS CAN JUST LOGIN
      userList.add(new FullTime("u1", "p1", "emmamason1000", 1120));
      userList.add(new Casual("u2", "p2", "emmamason2000", 394, 46, 130, 250));
      userList.add(new FullTime("u3", "p3", "emmamason3000", 594));
      userList.add(new Casual("u4", "p4", "emmamason4000", 2));

      User.welcome();
      //Call to welcome method in User super class.

      //Main Menu, will keep looping till user exits!
      while (!menu)
      {
         System.out.print("************");
         System.out.println("\n0. Exit");
         System.out.println("1. Register");
         System.out.println("2. Login");
         choice = Read.read("choice");

         switch (choice)
         {
            case "0":
            {
               System.out.println("\nThank You For Using Reach.");
               menu = true;
            }//Case 0, exit the program.
            break;
            case "1":
            {
               RegistrationTransaction registrationTransaction = new RegistrationTransaction();
               User user = registrationTransaction.register(); // make the new user
               userList.add(user); // add new user
               System.out.println("\nAccount Created, please login below.\n");
            }//Case One Register User.
            break;
            case "2":
            {
               UserLoginTransaction userLogin = new UserLoginTransaction(userList);
               userLogin.login();

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
                        System.out.println("\n0. Log Out \n1. Print Your Details \n2. Update Followers \n3. Update Likes " + "\n4. Get User interaction \n5. Receive Tips ");

                        choice = Read.read("choice");
                        switch (choice)
                        {
                           case "0":
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

                  else if (currentUser.fullTimeInfluencer)
                  {
                     while (!fullTimeMenu)
                     {
                        System.out.println("\n*****************************");
                        System.out.println("Full Time Influencer Account");
                        System.out.println("\n0. Log Out \n1. Enter Last 3 Posts Likes \n2. Get Average Likes \n3. Rank Accounts Reached \n4. Rank Interactions "
                                + "\n5. Rank Followers " + "\n6. Show Steps You Took to Achieve Great Reach Grades " + "\n7. Get a Reach Tip " + "\n8. Account Summary (View After All Options Completed)");

                        choice = Read.read("choice");
                        switch (choice)
                        {
                           case "0":
                           {
                              System.out.println("\nReturning to Main Menu.\n");
                              fullTimeMenu = true;
                           }//Case 0, exit program.
                           break;

                           case "1":
                           {
                              ((FullTime) currentUser).updateLikes();
                           }//Case 1, Enter Last Three Posts Likes.
                           break;

                           case "2":
                           {
                              ((FullTime) currentUser).getAverageLikes();
                           }//Case 2, Print Average Likes of Last 3 Posts.
                           break;

                           case "3":
                           {
                              ((FullTime) currentUser).rankAccountsReached();
                           }//Case 1, Rank Accounts Reached.
                           break;

                           case "4":
                           {
                              ((FullTime) currentUser).rankInteractions();
                           }//Case 2, Rank Interactions.
                           break;

                           case "5":
                           {
                              ((FullTime) currentUser).rankFollowers();
                           }//Case 3, Rank Followers.
                           break;

                           case "6":
                           {
                              ((FullTime) currentUser).printUserEnteredTips();
                           }//Case 6, Print the tips entered by the user.
                           break;

                           case "7":
                           {
                              System.out.println(((FullTime) currentUser).showTip());
                           }//Case 7, Display Random Tip to User.
                           break;

                           case "8":
                           {
                              System.out.println(((FullTime) currentUser).toString());
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
}//Test Program Class
