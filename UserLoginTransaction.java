package Project;
import java.util.List;
/**
 * Created by Group 11 on 28/11/2020
 * User Login Transaction Class.
 **/
public class UserLoginTransaction
{
   public boolean successfulLogin = false;
   public int index = 0;
   private List<User> users;

   public UserLoginTransaction(List<User> users)
   {
      this.users = users;
   }

   /**
    * returns if login was successful
    * @return
    */
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

   /**
    * returns index of users that is logged in
    * @return
    */
   public int getIndex()
   {
      return this.index;
   }

   /**
    * returns if login was successful
    * @return
    */
   public boolean successfulLogin()
   {
      return this.successfulLogin;
   }
}
