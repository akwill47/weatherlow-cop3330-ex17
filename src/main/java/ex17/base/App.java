package ex17.base;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
Exercise 17 - Blood Alcohol Calculator
Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make a determination.

Create a program that prompts for your weight, gender, total alcohol consumed (in ounces), and the amount of time since your last drink. Calculate your blood alcohol content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H
where

A is total alcohol consumed, in ounces (oz).
W is body weight in pounds.
r is the alcohol distribution ratio:
0.73 for men
0.66 for women
H is number of hours since the last drink.
Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output
Your BAC is 0.08
It is not legal for you to drive.
Constraint
Prevent the user from entering non-numeric values.
Challenges
Handle metric units.
Look up the legal BAC limit by state and prompt for the state. Display a message that states whether or not it’s legal to drive based on the computed BAC.
Develop this as a mobile application that makes it easy to record each drink, updating the BAC each time a drink is entered.
 */
public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        App myApp = new App();

        System.out.print("What is your weight? ");
        float weight = myApp.readInput();
        String gender = myApp.readGender();
        System.out.print("What is the total alcohol consumed (in ounces)? ");
        float totalAlc = myApp.readInput();
        System.out.print("What is the amount of time since your last drink? ");
        float time = myApp.readInput();

        String output = myApp.bacCheck(weight,gender,totalAlc,time);

        myApp.displayOutput(output);


    }
    private float readInput() {

        float num;
        while (true) {
            try {
                num = Float.parseFloat(in.next());
                break;

            } catch (NumberFormatException e) {
            }
            System.out.println("Error, please enter a number!");
        }
        return num;
    }
    private String readGender(){
        System.out.print("What is your gender, either male or female? ");
        String gender = in.next();
        gender.toLowerCase();
        String absGender = (gender.equals("male")) ? "m" : "f";

        return absGender;
    }
    private String bacCheck(float weight, String gender, float totalAlc, float time){
        //BAC = (A × 5.14 / W × r) − .015 × H
        double bac = 0.0;
        String output = "error";
        if (gender.equals("m")) {
            bac = ((totalAlc * 5.14 / weight * 0.73) - (0.015 * time));
        }
        else if(gender.equals("f")){
             bac = ((totalAlc * 5.14 / weight * 0.66) - (0.015 * time));
        }

        if(bac >= 0.08){
            output = "Your BAC is " + String.format("%.2f",bac) + "\nIt is legal for you to drive.";
        }
        else if( bac > 0.08){
            output = "Your BAC is " + String.format("%.2f",bac) + "\nIt is not legal for you to drive.";
        }
      return output;
    }
    private void displayOutput(String output){
        System.out.println(output);
    }
}
