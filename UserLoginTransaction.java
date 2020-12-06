package Project;
import java.util.List;
/**
 * Created by Group 11 on 28/11/2020
 * Author: Emma Mason
 * Last Updated:06/12/2020
 * UserLoginTransaction Class - to
 * prompt for login from a user
 * using a username and password.
 **/
public class UserLoginTransaction
{
   //Variables for the class
   public boolean successfulLogin = false;
   public int index = 0;
   private List<User> users;

   //Constructor for the class
   public UserLoginTransaction(List<User> users)
   {
      this.users = users;
   }

   //Will return whether the login is successful or not.
   public boolean login()
   {
      String username = Read.read("Username");
      String password = Read.read("Password");

      int pos = 0;

      for (pos = 0; pos < users.size(); ++pos)
      {
         if (users.get(pos).getUsername().equals(username) && users.get(pos).getPassword().equals(password))
            break;
      }

      this.index=pos;

      if (pos < 0 || pos >= users.size())
      {
         System.out.println("User not found.");
         return false;
      }
      else
      {
         this.successfulLogin = true;
         users.get(pos).toString();
         return true;
      }
   }


   //returns index of users that is logged in
   public int getIndex()
   {
      return this.index;
   }


   // Returns if login was successful.
   public boolean successfulLogin()
   {
      return this.successfulLogin;
   }
}
