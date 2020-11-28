package GroupProject;

/**
 * Created by Emma Mason on 28/11/2020
 * UPDATE PROGRAM COMMENTS ABOUT PROGRAM HERE
 **/
public class User {

   private String userAt;
   private int totalFollowers;

   private String username;
   private String password;
   public boolean fullTimeInfluencer=false;
   public boolean casualUser=false;

   public User(String userName, String password, String userAt, int totalFollowers) {

      this.userAt = userAt;
      this.totalFollowers = totalFollowers;

      this.username = userName;
      this.password = password;

   }

   public String getUserAt() {
      return userAt;
   }

   public int getTotalFollowers() {
      return totalFollowers;
   }

   public String getUsername() {
      return username;
   }

   public String getPassword() {
      return password;
   }
   public int updateFollowers()
   {
      totalFollowers = Integer.parseInt(Read.read("follower count today"));
      return getTotalFollowers();
   }

   /*
    * return user details
    */
   public String toString() {
      return (getUsername() + "\n(@" + getUserAt() + ")\nYou currently have " + getTotalFollowers()
            + " followers on Instagram.");
   }

}
