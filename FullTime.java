package Project;
import java.util.Scanner;
/**
 * Created by Group 11 on 28/11/2020
 * FulLTime Sub Class.
 **/
public class FullTime extends User
{
   private int accountsReached, interactions, gainedFollowers;
   private String accountsReachedTip, interactionsTip, gainedFollowersTip;

   public FullTime(String pUserName, String pPassword, String pUserAt, int pTotalFollowers)
   {
      super(pUserName, pPassword, pUserAt, pTotalFollowers);
      fullTimeInfluencer = true;
      accountsReached = 0;
      interactions = 0;
      gainedFollowers = 0;
   }//Alternative Constructor.

   protected FullTime(String userName, String password, String userAt, int totalFollowers, int pAccountsReached, int pInteractions, int pGainedFollowers)
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
      System.out.println("\n**************************************************\nWelcome to the Reach Full Time Influencers Program");
   }// Welcome method.

   protected static String getText(String prompt)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print(prompt + "\n");
      return keyboard.nextLine();
   }// Get Text Method.

   protected void rankAccountsReached()
   {
      if ((double) accountsReached / super.getTotalFollowers() >= 1)
      {
         System.out.println("\nYour rank for Accounts Reached this week is an A+ \nYou have reached an audience of 100% or more of your follower count this week! You own an incredibly popular account!");
         setAccountsReachedTip(getText("\nThis is an impressive grade, what did you do this week which helped you reach so many accounts? "));
         System.out.println("Thank you for the feedback!");
      }
      else if ((double) accountsReached / super.getTotalFollowers() >= 0.9)
            {
               System.out.println("\nYour rank for Accounts Reached this week is an A \nYou have reached an audience of over 90% your follower count this week! An incredibly impressive increase, keep it up!");
               setAccountsReachedTip(getText("\nThis is an impressive grade, what did you do this week which helped you reach so many accounts? "));
               System.out.println("Thank you for the feedback!");
            }
            else if ((double) accountsReached / super.getTotalFollowers() >= 0.75)
                  {
                     System.out.println("\nYour rank for Accounts Reached this week is an B \nYou have reached an audience of over 75% your follower count this week! You're account is reaching lots of users!");
                  }
                  else if ((double) accountsReached / super.getTotalFollowers() >= 0.50)
                        {
                           System.out.println("\nYour rank for Accounts Reached this week is an C \nYou have reached an audience of over 50% your follower count this week! Keep it up and your account will continue to grow!");
                        }
                        else if ((double) accountsReached / super.getTotalFollowers() >= 0.25)
                              {
                                 System.out.println("\nYour rank for Accounts Reached this week is an D \nYou have reached an audience of over 25% your follower account this week! We all start somewhere!");
                              }
                              else
                              {
                                 System.out.println("\nYour rank for Accounts Reached this week is an F \nYou have reached an audience of less than 25% your follower account this week! This is a small increase.");
                              }
   }// Rank Accounts Reached Method with Prompt to Enter Tips for Ranks of A or A+.

   protected void rankInteractions()
   {
      if ((double) interactions / super.getTotalFollowers() >= 0.5)
      {
         System.out.println("Your rank for Interactions is an A+ \nOver 50% of your followers interacted with your account this week. You have a strong community!");
         setInteractionsTip(getText("\nThis is an impressive grade, what did you do this week to boost your account interactions? "));
         System.out.println("Thank you for the feedback!");
      }
      else if ((double) interactions / super.getTotalFollowers() >= 0.4)
            {
               System.out.println("Your rank for Interactions is an A \nOver 40% of your followers have interacted with your account this week. You are growing a strong community!");
               setInteractionsTip(getText("\nThis is an impressive grade, what did you do this week to boost your account interactions? "));
               System.out.println("Thank you for the feedback!");
            }
            else if ((double) interactions / super.getTotalFollowers() >= 0.3)
                  {
                     System.out.println("Your rank for Interactions is an B \nOver 30% of your followers have interacted with your account this week. Keep it up!");
                  }
                  else if ((double) interactions / super.getTotalFollowers() >= 0.2)
                        {
                           System.out.println("Your rank for Interactions is an C \nOver 20% of your followers have interacted with your account this week. It's a start!");
                        }
                        else
                        {
                           System.out.println("Your rank for Interactions is an D \nOver 10% of your followers have interacted with your account this week. Try Harder!");
                        }
   }// Rank Interactions Method with Prompt to Enter Tips for Ranks of A or A+.

   protected void rankFollowers()
   {
      if ((double) gainedFollowers / super.getTotalFollowers() >= 0.50)
      {
         System.out.println("Your rank for Gained Followers this week is an A+ \nYou gained over 50% of your original follower count this week! That's a massive increase, congrats!");
         setGainedFollowersTip(getText("\nThis is an impressive grade, what did you do this week that helped you gain so many followers? "));
         System.out.println("Thank you for the feedback!");
      }
      else if ((double) gainedFollowers / super.getTotalFollowers() >= 0.4)
            {
               System.out.println("Your rank for Gained Followers this week is an A \nYou gained over 40% of your original follower count this week! That's a great increase.");
               setGainedFollowersTip(getText("\nThis is an impressive grade, what did you do this week that helped you gain so many followers? "));
               System.out.println("Thank you for the feedback!");
            }
            else if ((double) gainedFollowers / super.getTotalFollowers() >= 0.3)
                  {
                     System.out.println("Your rank for Gained Followers this week is an B \nYou gained over 30% of your original follower count this week! That's a good increase.");
                  }
                  else if ((double) gainedFollowers / super.getTotalFollowers() >= 0.2)
                        {
                           System.out.println("Your rank for Gained Followers this week is an A+ \nYou gained over 20% of your original follower count this week! That's an okay increase.");
                        }
                        else
                        {
                           System.out.println("Your rank for Gained Followers this week is an A+ \nYou gained over 10% of your original follower count this week! That's a small increase!");
                        }
   }// Rank Followers Method with Prompt to Enter Tips for Ranks of A or A+.
}//FullTimeClass
