package Project;
import java.text.DecimalFormat;
/**
 * Created by Group 11 on 28/11/2020
 * Author: Emma Mason
 * Last Updated:06/12/2020
 * Casual Sub Class - to create a casual
 * instagram user object and hold all the
 * methods specific to this.
 **/
public class Casual extends User
{

   //Create a DecimalFormat object
   static DecimalFormat df = new DecimalFormat("00.00");
   // Instance variables specific to the casual user.
   private int postsPerWeek, storiesPerDay;
   private double interactPercentage;

   //Alternative Constructor to use super from User class.
   public Casual(String userName, String password, String userAt, int totalFollowers)
   {
      super(userName, password, userAt, totalFollowers);
      this.postsPerWeek =0;
      this.storiesPerDay=0;
      this.interactPercentage = getUserInteraction();
      this.casualUser=true;
   }

   //Alternative Constructor to include users likes.
   public Casual(String userName, String password, String userAt, int totalFollowers, int likes1, int likes2, int likes3)
   {
      super(userName, password, userAt, totalFollowers, likes1, likes2, likes3);
      this.postsPerWeek =0;
      this.storiesPerDay=0;
      this.interactPercentage = getUserInteraction();
      this.casualUser=true; //This means they will be used as a casual user.
   }

   public int getPostsPerWeek()
   {
      return postsPerWeek;
   }//Get Posts Per Week.
   public void setPostsPerWeek(int postsPerWeek)
   {
      this.postsPerWeek = postsPerWeek;
   } //Set Posts Per Week.

   public double getInteractPercentage()
   {
      return interactPercentage;
   }//Get Interaction Percentage.
   public void setInteractPercentage(double interactPercentage)
   {
      this.interactPercentage = interactPercentage;
   }// Set interaction percentage.

   //Get User Interaction Percentage.
   public double getUserInteraction()
   {
      int followers = getTotalFollowers();
      interactPercentage = (100.0 / followers) * getAverage();
      return interactPercentage;
   }

   //Set User Interaction.
   public void setUserInteraction(double pInteractPercentage)
   {
      interactPercentage = pInteractPercentage;
   }

   //Method to Return a grade for Users Reach.
   private char yourReach() {
      char grade;
      if ((interactPercentage >= 70) && (interactPercentage <= 100))
      {
         grade = 'A';
      }
      else if ((interactPercentage >= 60) && (interactPercentage <= 69))
            {
               grade = 'B';
            }
            else if ((interactPercentage >= 50) && (interactPercentage <= 59))
                  {
                     grade = 'C';
                  }
                  else if ((interactPercentage >= 40) && (interactPercentage <= 49))
                        {
                           grade = 'D';
                        }
                        else if ((interactPercentage >= 30) && (interactPercentage <= 39))
                              {
                                 grade = 'E';
                              }
                              else
                               {
                                 grade = 'F';
                               }
      return grade;
   }


   //Method to print user reach.
   public void printYourReach()
   {
      System.out.print("Your reach score is: " + yourReach());
   }

   //Method to Check Users Reach.
   public void reachChecker()
   {
      if (yourReach() == 'A')
      {
         System.out.print("You have great reach on your account. Well done!");
      }
      else
      {
         improveYourReach();
      }
   }

   //Improve Your Reach Method.
   public void improveYourReach()
   {
      // Prompt user to enter info.
      postsPerWeek =Integer.parseInt(Read.read("number of weekly posts"));

      // String array of times to post
      String [] timeimprovement = new String[5];
      timeimprovement[0] = "Monday, Wednesday or Thursday: 11am - 1pm";
      timeimprovement[1] = "Monday to Friday: 6pm - 9pm";
      timeimprovement[2] = "Saturday: 11am";
      timeimprovement[3] = "Saturday: 11am";
      timeimprovement[4] = "Sunday: 11am or 5pm";

      //Nested if else to recommend a random tip from array time improvement.
      if (postsPerWeek <= 2)
      {
         System.out.println("You must increase your posts per week to at least three");
      }
      else if (postsPerWeek >= 3)
            {
               System.out.println("Try posting at these times to maximise your reach and interaction:");
               System.out.println("******************************************************************");
               System.out.println(timeimprovement[(int) (Math.random()%timeimprovement.length)]);
               System.out.println("******************************************************************");
            }

      //Prompt for user to enter info.
      storiesPerDay=Integer.parseInt(Read.read("number of instagram stories posted daily"));

      //Nested if else to recommend tips based on how many stories the user posts.
      if (storiesPerDay <= 1)
      {
         System.out.println("You must try to post at least one story daily to engage followers and increase interaction");
         System.out.println("Try using polls, meters and questions to encourage interaction.");
      }
      else if (storiesPerDay >= 2)
            {
               System.out.println("Ensure to post one story daily to engage followers and increase interaction");
               System.out.println("Try using polls, meters and questions to encourage interaction.");
            }
   }

   //Print User Interaction.
   public void printUserInteraction()
   {
      System.out.println("The percentage of followers that interact with your content is: "
                          + df.format(getUserInteraction()) + "%");
   }

   // To string method to print user's information.
   public String toString()
   {
      return super.toString() + "\nUser follower interaction: " + df.format(getUserInteraction()) + "%"
              + "\nUser posts per week: " + getPostsPerWeek() + "\nUser reach grade: " + yourReach();
   }
}// class