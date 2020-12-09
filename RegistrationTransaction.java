package Project;
/**
 * Created by Group 11 on 28/11/2020
 * Author: Emma Mason, Fearghal O'Boyle
 * and Donal Doherty.
 * Last Updated:06/12/2020
 * RegistrationTransaction Class - to
 * register a new user into the system
 * based on whether they are a Pro
 * or Casual user.
 **/
public class RegistrationTransaction
{
   public User register()
   {

      //Creating a default user.
      User user = null;


      //Variables for the register class.
      String userName, password, userAt;
      int totalFollowers;

      //Prompts for user to enter info.
      userName = Read.read("Username");
      password = Read.read("Password");
      userAt = Read.read("Instagram @");
      totalFollowers = Integer.parseInt(Read.read("Total Followers"));

      String userType = Read.read("instagram use. Do you use Instagram for fun (Casual Influencer) or for business " +
            "(Pro Influencer) (C/P)?");


      //If statement to distinguish between the two types of users.
      if (userType.equalsIgnoreCase("P"))
      {
         //Variables specific to a pro user can be added here.
         user = new Pro(userName, password, userAt, totalFollowers);
      }//if user indicates using 'P' that they are Pro influencer, create a Pro object.

      if (userType.equalsIgnoreCase("C"))
      {
         //Variables specific to a casual user can be added here.
         user = new Casual(userName, password, userAt, totalFollowers);
      }//if user indicates using 'C' that they are a Casual influencer, create a Casual object.

      return user;
   }
}//Register Transaction Class.
