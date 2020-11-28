package GroupProject;

import java.text.DecimalFormat;

/**
 * Created by Emma Mason on 18/11/2020 UPDATE PROGRAM COMMENTS ABOUT PROGRAM
 * HERE
 **/

public class CasualUser extends User {

   private int likes1;
   private int likes2;
   private int likes3;
   private int postsperWeek;
   private int storiesPerDay;
   private double interactPercentage;

   static DecimalFormat df = new DecimalFormat("0.00");

   //constructor to use super from User class
   public CasualUser(String userName, String password, String userAt, int totalFollowers) {
      super(userName, password, userAt, totalFollowers);

      this.likes1=0;
      this.likes2=0;
      this.likes3=0;
      this.postsperWeek=0;
      this.storiesPerDay=0;
      this.interactPercentage = getuserInteraction();

      this.casualUser=true;
   }
    //constructor to include users likes
   public CasualUser(String userName, String password, String userAt, int totalFollowers, int likes1, int likes2, int likes3) {
      super(userName, password, userAt, totalFollowers);
      this.likes1=likes1;
      this.likes2=likes2;
      this.likes3=likes3;
      this.postsperWeek=0;
      this.storiesPerDay=0;
      this.interactPercentage = getuserInteraction();

      //this means they will be used as a casual user
      this.casualUser=true;
   }

   //getters and setters
   public int getLikes1() {
      return likes1;
   }

   public void setLikes1(int likes1) {
      this.likes1 = likes1;
   }

   public int getLikes2() {
      return likes2;
   }

   public void setLikes2(int likes2) {
      this.likes2 = likes2;
   }

   public int getLikes3() {
      return likes3;
   }

   public void setLikes3(int likes3) {
      this.likes3 = likes3;
   }

   public int getPostsperWeek() {
      return postsperWeek;
   }

   public void setPostsperWeek(int postsperWeek) {
      this.postsperWeek = postsperWeek;
   }

   public double getInteractPercentage() {
      return interactPercentage;
   }

   public void setInteractPercentage(double interactPercentage) {
      this.interactPercentage = interactPercentage;
   }

   //method to return average likes
   private double getAverage() {
       return (likes1 + likes2 + likes3) / 3.0;

   }

   //method to print the average likes
   public void printAverage() {
      System.out.println("The average amount of likes achieved is: " + df.format(getAverage()));
   }

   //method to return user interaction
   public double getuserInteraction() {
      int followers = getTotalFollowers();
      interactPercentage = (100.0 / followers) * getAverage();
      return interactPercentage;
   }


   //setter for userInteraction
   public void setUserInteraction(double pInteractPercentage) {
      interactPercentage = pInteractPercentage;
   }

   //return a grade for your reach
   private char yourReach() {
      char grade;
      if ((interactPercentage >= 70) && (interactPercentage <= 100)) {
         grade = 'A';
      } else if ((interactPercentage >= 60) && (interactPercentage <= 69)) {
         grade = 'B';
      } else if ((interactPercentage >= 50) && (interactPercentage <= 59)) {
         grade = 'C';
      } else if ((interactPercentage >= 40) && (interactPercentage <= 49)) {
         grade = 'D';
      } else if ((interactPercentage >= 30) && (interactPercentage <= 39)) {
         grade = 'E';
      } else {
         grade = 'F';
      }
      return grade;
   }

   public void printYourReach()
   {
      System.out.print("Your reach score is: " + yourReach());
   }

   public void reachChecker() {
      switch (yourReach()) {
         case 'A':
            System.out.print("You have great reach on your account. Well done!");
            break;
//		case 'B', 'C', 'D', 'E', 'F':
//			improveYourReach();
//			break;

         default:
            improveYourReach();
            break;
      }
   }

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


   public void improveYourReach() {
//		System.out.println("How many times do you post a week? ");
//		postsperWeek = keyboard.nextInt();
      postsperWeek=Integer.parseInt(Read.read("times you post a week?"));
      String [] timeimprovement = new String[4];
      timeimprovement[0] = "Monday, Wednesday or Thursday - 11am-1pm";
      timeimprovement[1] = "Monday to Friday - 6pm-9pm";
      timeimprovement[2] = "Saturday - 11am";
      timeimprovement[3] = "Saturday - 11am";
      timeimprovement[3] = "Sunday - 11am, 5pm";



      if (postsperWeek <= 2) {
         System.out.println("You must increase your posts per week to at least three");
      }
      if (postsperWeek >= 3) {

         //prints a random tip from array time imporvement
         System.out.println("Try posting at these times to maximise your reach and interaction:");
         System.out.println("******************************************************************");
         System.out.println(timeimprovement[(int) (Math.random()%timeimprovement.length)]);
         System.out.println("******************************************************************");
      }
//    The read method replaces this
//		System.out.println("How many instagram stories do you post each day?");
//		storiesPerDay = keyboard.nextInt();

      storiesPerDay=Integer.parseInt(Read.read("number of instagram stories posted daily:"));

      if (storiesPerDay < 1) {
         System.out.println(
               "You must try to post at least one story daily to engage followers and increase interaction");
         System.out.println("Try using polls, meters and questions to encourage interaction.");
      }
      if (storiesPerDay >= 1) {
         System.out.println(
               "Ensure to maintaining posting one story daily to engage followers and increase interaction");
         System.out.println("Try using polls, meters and questions to encourage interaction.");
      }

   }

   public void printUserInteraction() {
      System.out.println("The percentage of followers that interact with your content is: "
            + df.format(getuserInteraction()) + "%");
   }

   public String toStringfinal() {
      return super.toString() + "\nUser average likes: " + getAverage() + "\nUser follower interaction: "
            + getuserInteraction() + "\nUser posts per week: " + getPostsperWeek() + "\nUser reach grade + "
            + yourReach();
   }

}// class