package Project;
/**
 * Created by Group 11 on 28/11/2020
 * Registration Transaction Class.
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

      String userType = Read.read("Full Time or Casual Influencer (F/C)");


      //If statement to distinguish between the two types of users
      if (userType.equalsIgnoreCase("F"))
      {
         //ADD STUFF HERE INDIVIDUAL TO FTI USER
         user = new FullTime(userName, password, userAt, totalFollowers);
      }//if user indicates using 'F' that they are a FullTime influencer, create a FullTime object.

      if (userType.equalsIgnoreCase("C"))
      {
         //ADD STUFF HERE INDIVIDUAL TO CASUAL USER
         user = new Casual(userName, password, userAt, totalFollowers);
      }//if user indicates using 'C' that they are a Casual influencer, create a Casual object.

      return user;
   }
}//Register Transaction Class.
