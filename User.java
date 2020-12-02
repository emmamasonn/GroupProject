package Project;
/**
 * Created by Group 11 on 28/11/2020
 * User Super Class.
 **/
public class User
{
   private String userAt, username, password;
   private int totalFollowers;
   public boolean fullTimeInfluencer = false, casualUser = false;

   public User(String userName, String password, String userAt, int totalFollowers)
   {
      this.userAt = userAt;
      this.totalFollowers = totalFollowers;
      this.username = userName;
      this.password = password;
   }//Constructor.

   public String getUserAt()
   {
      return userAt;
   }//Get User At.

   public int getTotalFollowers()
   {
      return totalFollowers;
   }//Get Total Followers.

   public String getUsername()
   {
      return username;
   }//Get User Name.

   public String getPassword()
   {
      return password;
   }//Get Password.

   public int updateFollowers()
   {
      totalFollowers = Integer.parseInt(Read.read("follower count today"));
      return getTotalFollowers();
   }//Method to Update Follower Count.

   protected static void welcome()
   {
      System.out.println("\nWelcome to Reach, an Instagram Analytics Tool\n");
   }//Print Welcome Method.

   public String toString()
   {
      return (getUsername() + "\n(@" + getUserAt() + ")\nYou currently have " + getTotalFollowers() + " followers on Instagram.");
   }//To String.
}//Class