package GroupProject;
/**
 * Created by Fearghal O'Boyle on 18/11/2020
 * Super User Information Class.
 **/
public class UserInformation
{
   private String userAt, realName;
   private int totalFollowers;

   protected UserInformation()
   {

   }//Default Constructor.

   protected UserInformation(String pUserAt, String pRealName, int pTotalFollowers)
   {
      userAt = pUserAt;
      realName = pRealName;
      totalFollowers = pTotalFollowers;
   }//Alternative Constructor.

   protected void setUserAt(String pUserAt)
   {
      userAt = pUserAt;
   }//Set User At.

   protected String getUserAt()
   {
      return userAt;
   }//Get User At.

   protected void setRealName(String pRealName)
   {
      realName = pRealName;
   }//Set Real Name.

   protected String getRealName()
   {
      return realName;
   }//Get Real Name.

   protected void setTotalFollowers(int pTotalFollowers)
   {
      totalFollowers = pTotalFollowers;
   }//Set Total Followers.

   protected int getTotalFollowers()
   {
      return totalFollowers;
   }//Get Total Followers.

   protected static void welcome()
   {
      System.out.println("\nWelcome to Reach, an Instagram Analytics Tool\n");
   }//Print Welcome Method.

   public String toString()
   {
      return (getRealName() + " (" + getUserAt() + ") currently has " + getTotalFollowers() + " followers on Instagram.");
   }//toString to display all object information.
}//class
