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
                        System.out.println("\nCasual User Account");
                        System.out.println("\n0. Log Out \n1. Print Your Details \n2. Update Followers \n3. Update Likes " + "\n4. Get User interaction \n5. Receive Tips ");

                        choice = Read.read("choice");
                        switch (choice)
                        {
                           case "0":
                           {
                              System.out.println("\nThank You For Using Reach.");
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
                        System.out.println("\nFull Time Influencer Account");
                        System.out.println("\n0. Log Out \n1. Rank Accounts Reached \n2. Rank Interactions " + "\n3. Rank Followers  ");

                        choice = Read.read("choice");
                        switch (choice)
                        {
                           case "0":
                           {
                              System.out.println("\nThank You For Using Reach.");
                              fullTimeMenu = true;
                           }//Case 0, exit program.
                           break;

                           case "1":
                           {
                              ((FullTime) currentUser).rankAccountsReached();
                           }//Case 1, Rank Accounts Reached.
                           break;

                           case "2":
                           {
                              ((FullTime) currentUser).rankInteractions();
                           }//Case 2, Rank Interactions.
                           break;

                           case "3":
                           {
                              ((FullTime) currentUser).rankFollowers();
                           }//Case 3, Rank Followers.
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
