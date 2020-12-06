package Project;

import java.text.DecimalFormat;

/**
 * Created by Group 11 on 28/11/2020
 * Author: Fearghal O'Boyle and Donal Doherty
 * Last Updated:06/12/2020
 * User Super Class - a super class to hold
 * attributes and methods common to both
 * sub classes.
 **/
public class User
{
   //Create instance varibles for the class
   static private DecimalFormat df=new DecimalFormat("0.00");
   private String userAt, username, password;
   private int totalFollowers, likes1, likes2, likes3;
   public boolean proInfluencer = false, casualUser = false;

   public User(String userName, String password, String userAt, int totalFollowers)
   {
      this.userAt = userAt;
      this.totalFollowers = totalFollowers;
      this.username = userName;
      this.password = password;
   }//Constructor.

   public User(String userName, String password, String userAt, int totalFollowers, int likes1, int likes2, int likes3)
   {
      this.userAt = userAt;
      this.totalFollowers = totalFollowers;
      this.username = userName;
      this.password = password;
      this.likes1 = likes1;
      this.likes2 = likes2;
      this.likes3 = likes3;
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

   protected void setLikes1(int pLikes1)
   {
      likes1 = pLikes1;
   }//Set Likes1.

   protected int getLikes1()
   {
      return likes1;
   }//Get Likes1.

   protected void setLikes2(int pLikes2)
   {
      likes2 = pLikes2;
   }//Set Likes2.

   protected int getLikes2()
   {
      return likes2;
   }//Get Likes2.

   protected void setLikes3(int pLikes3)
   {
      likes3 = pLikes3;
   }//Set Likes3.

   protected int getLikes3()
   {
      return likes3;
   }//Get Likes3.

   public int updateFollowers()
   {
      totalFollowers = Integer.parseInt(Read.read("follower count today"));
      return getTotalFollowers();
   }//Method to Update Follower Count.

   //Method to update users likes and calculate their average.
   public void updateLikes()
   {
      likes1=Integer.parseInt(Read.read("likes that your latest post received"));
      setLikes1(likes1);

      likes2=Integer.parseInt(Read.read("likes that your second latest post received"));
      setLikes2(likes2);

      likes3=Integer.parseInt(Read.read("likes that your third latest post received"));
      setLikes3(likes3);
   }

   public double getAverage()
   {
      return (likes1 + likes2 + likes3) / 3.0;
   }   //Get Average.

   //Print Average Likes Method.
   public void printAverage()
   {
      System.out.println("\nThe average amount of likes achieved is: " + df.format(getAverage()));
   }

   protected static void welcome()
   {
      System.out.println("\nWelcome to Reach!");
      System.out.println("The Instagram Insights Tool to grow your tribe and convert followers to clients. " +
                          "Lets GO!\n");
   }//Print Welcome Method.

   public String toString()
   {
      return ("\nReach Username:" + getUsername() + "\nInstagram (@" + getUserAt() + ")\n" +
             "You currently have " + getTotalFollowers() + " followers on Instagram." + "\nAverage likes:"
             + df.format(getAverage()));
   }//To String.
}//Class