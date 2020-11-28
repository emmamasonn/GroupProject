package GroupProject;
/**
 * Created by Emma Mason on 28/11/2020 UPDATE PROGRAM COMMENTS ABOUT PROGRAM
 * HERE
 **/

public class RegistrationTransaction {

   public User register() {

      User user = null;// new user

      String userName, password, userAt;
      int totalFollowers;

      userName = Read.read("username");
      password = Read.read("password");
      userAt = Read.read("@userAt");
      totalFollowers = Integer.parseInt(Read.read("Total Followers"));

      String userType = Read.read("full time or casual influencer (f/c)");

      if (userType.contains("f")) {

         //ADD STUFF HERE INDIVUAL TO FTI USER
         user = new FullTimeInfluencerNew(userName, password, userAt, totalFollowers);
      }

      if (userType.contains("c")) {

         //ADD STUFF HERE INDIVIDUAL TO CASUAL USER
         user = new CasualUser(userName, password, userAt, totalFollowers);
      }

      return user;
   }
}
