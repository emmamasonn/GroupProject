package Project;
import java.text.DecimalFormat;
/**
 * Created by Group 11 on 28/11/2020
 * Casual Sub Class.
 **/
public class Casual extends User
{

   // Instance variables specific to the casual user.
   private int likes1, likes2, likes3, postsPerWeek, storiesPerDay;
   private double interactPercentage;

   static DecimalFormat df = new DecimalFormat("0.00");

   //Alternative Constructor to use super from User class.
   public Casual(String userName, String password, String userAt, int totalFollowers)
   {
      super(userName, password, userAt, totalFollowers);
      this.likes1=0;
      this.likes2=0;
      this.likes3=0;
      this.postsPerWeek =0;
      this.storiesPerDay=0;
      this.interactPercentage = getUserInteraction();
      this.casualUser=true;
   }

   //Alternative Constructor to include users likes.
   public Casual(String userName, String password, String userAt, int totalFollowers, int likes1, int likes2, int likes3)
   {
      super(userName, password, userAt, totalFollowers);
      this.likes1=likes1;
      this.likes2=likes2;
      this.likes3=likes3;
      this.postsPerWeek =0;
      this.storiesPerDay=0;
      this.interactPercentage = getUserInteraction();
      this.casualUser=true; //This means they will be used as a casual user.
   }


   public int getLikes1()
   {
      return likes1;
   }//Get Likes 1.
   public void setLikes1(int likes1)
   {
      this.likes1 = likes1;
   }//Set Likes 1.

   public int getLikes2()
   {
      return likes2;
   }//Get Likes 2.
   public void setLikes2(int likes2)
   {
      this.likes2 = likes2;
   } //Set Likes 2.


   public int getLikes3()
   {
      return likes3;
   }//Get Likes 3.
   public void setLikes3(int likes3)
   {
      this.likes3 = likes3;
   }//Set Likes 3.

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

   private double getAverage()
   {
      return (likes1 + likes2 + likes3) / 3.0;
   }   //Get Average.

   //Print Average Likes Method.
   public void printAverage()
   {
      System.out.println("The average amount of likes achieved is: " + df.format(getAverage()));
   }

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

   //Method to update users likes and calculate their average.
   public void updateLikes()
   {
      likes1=Integer.parseInt(Read.read("likes that your latest post received"));
      setLikes1(likes1);

      likes2=Integer.parseInt(Read.read("likes that your second latest post received"));
      setLikes2(likes2);

      likes3=Integer.parseInt(Read.read("likes that your third latest post received"));
      setLikes3(likes3);

      System.out.print("Your average amount of likes is: " + df.format(getAverage()));
   }

   //Improve Your Reach Method.
   public void improveYourReach()
   {
      // Prompt user to enter info.
      postsPerWeek =Integer.parseInt(Read.read("times you post a week?"));

      // String array of times to post
      String [] timeimprovement = new String[4];
      timeimprovement[0] = "Monday, Wednesday or Thursday: 11am - 1pm";
      timeimprovement[1] = "Monday to Friday: 6pm - 9pm";
      timeimprovement[2] = "Saturday: 11am";
      timeimprovement[3] = "Saturday: 11am";
      timeimprovement[3] = "Sunday: 11am or 5pm";

      //Nested if else to recommend a random tip from array timeimprovement.
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
               System.out.println("Ensure to maintaining posting one story daily to engage followers and increase interaction");
               System.out.println("Try using polls, meters and questions to encourage interaction.");
            }
   }

   //Print User Interaction.
   public void printUserInteraction()
   {
      System.out.println("The percentage of followers that interact with your content is: " + df.format(getUserInteraction()) + "%");
   }

   // To string method to print user's information.
   public String toString()
   {
      return super.toString() + "\nUser average likes: " + getAverage() + "\nUser follower interaction: " + getUserInteraction() + "\nUser posts per week: " + getPostsPerWeek() + "\nUser reach grade + " + yourReach();
   }
}// class