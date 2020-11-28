package GroupProject;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Emma Mason on 28/11/2020 UPDATE PROGRAM COMMENTS ABOUT PROGRAM
 * HERE
 **/
public class TestProgram {

   static List<User> userList = new ArrayList<User>();

   public static void main(String[] args) {

      String choice;
      //HARD CODED USERS FOR THE userList -- NO REGISTRATION NEED FOR THESE ACCOUNTS CAN JUST LOGIN
      userList.add(new FullTimeInfluencerNew("u1", "p1", "emmamason1000", 1120));
      userList.add(new CasualUser("u2", "p2", "emmamason2000", 394,46,130,250));
      userList.add(new FullTimeInfluencerNew("u3", "p3", "emmamason3000", 594));
      userList.add(new CasualUser("u4", "p4", "emmamason4000", 2));



      //welcome message to users - may move to a welcome class itself to keep things organised??
      UserInformation.welcome();
      System.out.print("************");


      //main menu, will keep looping till user exits!
      while (true) {

         System.out.println("\n0. Exit");
         System.out.println("1. Register");
         System.out.println("2. Login");
         choice = Read.read("choice");

         if (choice.equals("0")) // exit the system
            break;

         else if (choice.equals("1")) {// register a new user

            RegistrationTransaction registrationTransaction = new RegistrationTransaction();
            User user = registrationTransaction.register(); // make the new user
            userList.add(user); // add new user

         } else if (choice.equals("2")) {// login (scans through registered usernames passwords)

            UserLoginTransaction userLogin = new UserLoginTransaction(userList);
            userLogin.login();
            if (!userLogin.successfulLogin()) {
               // prints error and repeats whole while loop
            } else {

               int index = userLogin.getIndex();// this is to get the users index in the array
               User currentUser = userList.get(index);// this deals with which user has logged in

               System.out.println("\nWelcome " + currentUser.toString());

               if (currentUser.casualUser) { // emma's casual user operations

                  // a menu for casual user - if a newly registered user they must update their likes and followers
                  while (true) {
                     // this is a menu for the casual user
                     System.out.println("\nCasual User Account");
                     System.out.println("\n0. Log Out \n1. Print Your Details \n2. Update Followers \n3. Update Likes "
                           + "\n4. Get User interaction \n5. Receive Tips ");

                     choice = Read.read("choice");
                     if (choice.equals("0")) {// Log Out
                        break;
                     }
                     //print out user's details
                     if (choice.equals("1")) {//

                        System.out.println(((CasualUser) currentUser).toString());
                     }

                     // user can update following if they have gained/lost
                     if (choice.equals("2")) {//

                        ((CasualUser) currentUser).updateFollowers();
                     }
                     //update recent likes
                     else if (choice.equals("3")) {//

                        ((CasualUser) currentUser).updateLikes();

                     }
                     //prints users analytics on their interaction
                     else if (choice.equals("4")) {//

                        ((CasualUser) currentUser).printUserInteraction();

                     }
                     //tips on how to improve your reach
                     else if (choice.equals("5")) {//

                        ((CasualUser) currentUser).printYourReach();
                        ((CasualUser) currentUser).improveYourReach();

                     }
                  }




               } else if (currentUser.fullTimeInfluencer) { // fearghals fulltime influencer choices
                  //you could edit this loop for users to use how they like
                  while (true) {

                     System.out.println("\nFull Time Influencer Account");
                     System.out.println("\n0. Log Out \n1. Rank Accounts Reached \n2. Rank Interactions "
                           + "\n3. Rank Followers  ");

                     choice = Read.read("choice");
                     if (choice.equals("0")) {// Log Out
                        break;
                     }

                     if (choice.equals("3")) {//

                        ((FullTimeInfluencerNew) currentUser).rankAccountsReached();
                     }

                     else if (choice.equals("4")) {//

                        ((FullTimeInfluencerNew) currentUser).rankInteractions();
                     }

                     else if (choice.equals("5")) {//

                        ((FullTimeInfluencerNew) currentUser).rankFollowers();
                     }

                  }
               }

            }

         }

      }
   }
}

