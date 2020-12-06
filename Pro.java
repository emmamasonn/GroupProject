package Project;
import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * Created by Group 11 on 28/11/2020
 * Author: Fearghal O'Boyle
 * Last Updated:06/12/2020
 * Pro Sub Class - to create a Professional
 * instagram user object and hold all the
 * methods specific to this.
 **/
public class Pro extends User
{
   private int accountsReached, interactions, gainedFollowers;
   private String accountsReachedTip, interactionsTip, gainedFollowersTip;

   static DecimalFormat df = new DecimalFormat("00");

   String [] userTips = new String[3];
   char [] grades = new char[3];

   public Pro(String pUserName, String pPassword, String pUserAt, int pTotalFollowers)
   {
      super(pUserName, pPassword, pUserAt, pTotalFollowers);
      proInfluencer = true;
      accountsReached = 0;
      interactions = 0;
      gainedFollowers = 0;
   }//Alternative Constructor.

   protected Pro(String userName, String password, String userAt, int totalFollowers, int pAccountsReached, int pInteractions, int pGainedFollowers)
   {
      super(userName, password, userAt, totalFollowers);
      accountsReached = pAccountsReached;
      interactions = pInteractions;
      gainedFollowers = pGainedFollowers;
   }// Alternative Constructor.

   protected void setAccountsReached(int pAccountsReached)
   {
      accountsReached = pAccountsReached;
   }// Set Accounts Reached.

   protected int getAccountsReached()
   {
      return accountsReached;
   }// Get Accounts Reached.

   protected void setInteractions(int pInteractions)
   {
      interactions = pInteractions;
   }// Set Interactions.

   protected int getInteractions()
   {
      return interactions;
   }// Get Interactions.

   protected void setGainedFollowers(int pGainedFollowers)
   {
      gainedFollowers = pGainedFollowers;
   }// Set Gained Followers.

   protected int getGainedFollowers()
   {
      return gainedFollowers;
   }// Get Gained Followers.

   protected void setAccountsReachedTip(String pAccountsReachedTip)
   {
      accountsReachedTip = pAccountsReachedTip;
   }// Set Accounts Reached Tip.

   protected String getAccountsReachedTip()
   {
      return accountsReachedTip;
   }// Get Accounts Reached Tip.

   protected void setInteractionsTip(String pInteractionsTip)
   {
      interactionsTip = pInteractionsTip;
   }// Set Interactions Tip.

   protected String getInteractionsTip()
   {
      return interactionsTip;
   }// Get Interactions Tip.

   protected void setGainedFollowersTip(String pGainedFollowersTip)
   {
      gainedFollowersTip = pGainedFollowersTip;
   }// Set Gained Followers Tip.

   protected String getGainedFollowersTip()
   {
      return gainedFollowersTip;
   }// Get Gained Followers Tip.

   protected static void welcome()
   {
      System.out.println("\n**************************************************\nWelcome to the Reach Pro Influencer Program");
   }// Welcome method.

   protected static String getText(String prompt)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print(prompt + "\n");
      return keyboard.nextLine();
   }// Get Text Method.

   protected void rankAccountsReached()
   {
      accountsReached = Integer.parseInt(Read.read("Number of Accounts Reached "));
      if ((double) accountsReached / super.getTotalFollowers() >= 1)
      {
         System.out.println("\nYour rank for Accounts Reached this week is an S \nYou have reached an audience of 100% or more of your follower count this week! You own an incredibly popular account!");
         grades[0] = 'S';
         userTips[0] = (getText("\nThis is an impressive grade, what did you do this week that helped you to reach so many accounts? "));
         //setAccountsReachedTip(getText("\nThis is an impressive grade, what did you do this week which helped you reach so many accounts? "));
         System.out.println("Thank you for the feedback!");
      }
      else if ((double) accountsReached / super.getTotalFollowers() >= 0.9)
            {
               System.out.println("\nYour rank for Accounts Reached this week is an A \nYou have reached an audience of over 90% your follower count this week! An incredibly impressive increase, keep it up!");
               grades[0] = 'A';
               userTips[0] = (getText("\nThis is an impressive grade, what did you do this week that helped you reach so many accounts? "));
               //setAccountsReachedTip(getText("\nThis is an impressive grade, what did you do this week which helped you reach so many accounts? "));
               System.out.println("Thank you for the feedback!");
            }
            else if ((double) accountsReached / super.getTotalFollowers() >= 0.75)
                  {
                     System.out.println("\nYour rank for Accounts Reached this week is an B \nYou have reached an audience of over 75% of your follower count this week! Your account is reaching lots of your potential customers!");
                     grades[0] = 'B';
                     userTips[0] = null;
                  }
                  else if ((double) accountsReached / super.getTotalFollowers() >= 0.50)
                        {
                           System.out.println("\nYour rank for Accounts Reached this week is an C \nYou have reached an audience of over 50% your follower count this week! Keep it up and your account will continue to grow!");
                           grades[0] = 'C';
                           userTips[0] = null;
                        }
                        else if ((double) accountsReached / super.getTotalFollowers() >= 0.25)
                              {
                                 System.out.println("\nYour rank for Accounts Reached this week is an D \nYou have reached an audience of over 25% of your follower count this week! The only way is up!");
                                 grades[0] = 'D';
                                 userTips[0] = null;
                                 System.out.println("\nReach Recommended Tip: " + showTip());
                              }
                              else
                              {
                                 System.out.println("\nYour rank for Accounts Reached this week is an F \nYou have reached an audience of less than 25% your follower account this week! This is a small increase.");
                                 grades[0] = 'F';
                                 userTips[0] = null;
                                 System.out.println("\nReach Recommended Tip: " + showTip());
                              }
   }// Rank Accounts Reached Method with Prompt to Enter Tips for Ranks of A or A+.

   protected void rankInteractions()
   {
      interactions = Integer.parseInt(Read.read("Number of Interactions "));
      if ((double) interactions / super.getTotalFollowers() >= 0.5)
      {
         System.out.println("\nYour rank for Interactions is an S \nOver 50% of your followers interacted with your account this week. Your tribe loves your content!");
         grades[1] = 'S';
         userTips[1] = getText("\nThis is an impressive grade, what did you do this week to boost your account interaction? ");
         //setInteractionsTip(getText("\nThis is an impressive grade, what did you do this week to boost your account interactions? "));
         System.out.println("Thank you for the feedback!");
      }
      else if ((double) interactions / super.getTotalFollowers() >= 0.4)
            {
               System.out.println("\nYour rank for Interactions is an A \nOver 40% of your followers have interacted with your account this week. You are growing a strong community!");
               grades[1] = 'A';
               userTips[1] = getText("\nThis is an impressive grade, what did you do this week to boost your account interaction? ");
               //setInteractionsTip(getText("\nThis is an impressive grade, what did you do this week to boost your account interactions? "));
               System.out.println("Thank you for the feedback!");
            }
            else if ((double) interactions / super.getTotalFollowers() >= 0.3)
                  {
                     System.out.println("\nYour rank for Interactions is an B \nOver 30% of your followers have interacted with your account this week. Keep it up!");
                     grades[1] = 'B';
                     userTips[1] = null;
                  }
                  else if ((double) interactions / super.getTotalFollowers() >= 0.2)
                        {
                           System.out.println("\nYour rank for Interactions is an C \nOver 20% of your followers have interacted with your account this week. Let's work on improving that!");
                           grades[1] = 'C';
                           userTips[1] = null;
                           System.out.println("\nReach Recommended Tip: " + showTip());
                        }
                        else
                        {
                           System.out.println("\nYour rank for Interactions is an D \nOver 10% of your followers have interacted with your account this week. Try something new this week to improve this score!!");
                           grades[1] = 'D';
                           userTips[1] = null;
                           System.out.println("\nReach Recommended Tip: " + showTip());
                        }
   }// Rank Interactions Method with Prompt to Enter Tips for Ranks of A or A+.

   protected void rankFollowers()
   {
      gainedFollowers = Integer.parseInt(Read.read("Number of Followers Gained "));
      if ((double) gainedFollowers / super.getTotalFollowers() >= 0.50)
      {
         System.out.println("\nYour rank for Gained Followers this week is an A \nYou gained over 50% of your original follower count this week! That's a massive increase, congrats!");
         grades[2] = 'A';
         userTips[2] = (getText("\nThis is an impressive grade, what did you do this week that helped you gain so many followers? "));
         //setGainedFollowersTip(getText("\nThis is an impressive grade, what did you do this week that helped you gain so many followers? "));
         System.out.println("Thank you for the feedback!");
      }
      else if ((double) gainedFollowers / super.getTotalFollowers() >= 0.4)
            {
               System.out.println("\nYour rank for Gained Followers this week is an B \nYou gained over 40% of your original follower count this week! That's a great increase.");
               grades[2] = 'B';
               userTips[2] = (getText("\nThis is an impressive grade, what did you do this week that helped you gain so many followers? "));
               //setGainedFollowersTip(getText("\nThis is an impressive grade, what did you do this week that helped you gain so many followers? "));
               System.out.println("Thank you for the feedback!");
            }
            else if ((double) gainedFollowers / super.getTotalFollowers() >= 0.3)
                  {
                     System.out.println("\nYour rank for Gained Followers this week is an C \nYou gained over 30% of your original follower count this week! That's a good increase.");
                     grades[2] = 'C';
                     userTips[2] = null;
                  }
                  else if ((double) gainedFollowers / super.getTotalFollowers() >= 0.2)
                        {
                           System.out.println("\nYour rank for Gained Followers this week is an D \nYou gained over 20% of your original follower count this week! That's an okay increase.");
                           grades[2] = 'D';
                           userTips[2] = null;
                           System.out.println("\nReach Recommended Tip: " + showTip());
                        }
                        else
                        {
                           System.out.println("\nYour rank for Gained Followers this week is an E \nYou gained over 10% of your original follower count this week! That's a small increase!");
                           grades[2] = 'E';
                           userTips[2] = null;
                           System.out.println("\nReach Recommended Tip: " + showTip());
                        }
   }// Rank Followers Method with Prompt to Enter Tips for Ranks of A or A+.

   protected void printUserEnteredTips()
   {
      if (userTips[0] != null)
      {
         System.out.println("\nHow you boosted your accounts reached this week: \n" + userTips[0]);
      }
      else
      {
         System.out.println("\nUnfortunately, you didn't gain a high enough rank this week to give a tip on boosting accounts reached.");
      }

      if(userTips[1] != null)
      {
         System.out.println("\nHow you boosted your interactions this week:\n" + userTips[1]);
      }
      else
      {
         System.out.println("\nUnfortunately, you didn't gain a high enough rank this week to give a tip on boosting interactions.");
      }

      if(userTips[2] != null)
      {
         System.out.println("\nHow you boosted your followers this week:\n" + userTips[2]);
      }
      else
      {
         System.out.println("\nUnfortunately, you didn't gain a high enough rank this week to give a tip on boosting followers.");
      }
   }//Method to print the user inputted tips.

   protected String showTip()
   {
      String [] tips = new String[8];
      tips[0] = "\nPost consistently, at LEAST once a day!";
      tips[1] = "\nTry posting videos, stories and going live. Photos can become boring";
      tips[2] = "\nStudy successful accounts, learn from your peers!";
      tips[3] = "\nPost content which shows off your personality.";
      tips[4] = "\nTry and collaborate with other influencers, this can boost the traffic to your account!";
      tips[5] = "\nPost at peak times, when the majority of users are active. This is usually around 6pm on Weekdays and 3pm on Weekends";
      tips[6] = "\nHold competitions to encourage followers to share your posts";
      tips[7] = "\nCreate other content online, look into creating YouTube videos or share screenshots of your Twitter posts. \nThis can help you gain an audience from other platforms.";
      return (tips[(int) (Math.random() * tips.length)]);
   }//Return a tip to the user.

   public String toString()
   {
      return super.toString() + "\nAccounts Reached Rank: " + grades[0] + "\nInteractions Rank: " + grades[1] + "\nFollowers Rank: " + grades[2];
   }//to String.

}//FullTimeClass
