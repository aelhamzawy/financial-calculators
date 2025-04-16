package com.plurasight;
import java.util.Scanner;

public class Main {
    Scanner InputScanner = new Scanner(System.in);
    public static void main(String[] args) {

        getCalculatorType();




    }
    //  ==========================================================================================
    // creating a function to get the type of the calculator
    /*
     * 1 --> Mortgage Calculator
     * 2 --> Future Calculator
     * 3 --> Present Calculator
     */
    public static void getCalculatorType (){
        Scanner InputScanner = new Scanner(System.in);
        // Ask the User to select the calculator type
        System.out.println("Please select what type of calculator you like to use: ");
        System.out.println(" -> 1 for Mortgage Calculator \n -> 2 for Future value Calculator \n -> 3 for Present value Calculator");
        int calculatorType = InputScanner.nextInt();
        selectTheCalculator(calculatorType);

    };


    //  =============================================================================================
    /*
        --> creating a function to decide what is the calculator depend on the user input Number
    */
    public static void selectTheCalculator(int calculatorTypeNumber){
        switch (calculatorTypeNumber){
            case 1:
                System.out.println("you have selected the Mortgage calculator");
                mortgageCalculator();
                break;
            case 2:
                System.out.println("you have selected the Future calculator");
                FutureValueCalculator();
                break;
            case 3:
                System.out.println("you have selected the Present calculator");
                break;
            default:
                System.out.println("you have entered an invalid input");
        }
    }

    //    ================================================================================================
//    Mortgage Calculator Function
    public static void mortgageCalculator(){
        Scanner InputScanner = new Scanner(System.in);
        double loanAmount;
        double interestRate;
        float loanLength;

        System.out.print("Please enter your loan amount: ");
        loanAmount = InputScanner.nextDouble();
        System.out.print("Please enter the interest rate: ");
        interestRate = InputScanner.nextDouble();
        System.out.print("How many years is this loan for? ");
        loanLength = InputScanner.nextFloat();

        mortgageCalculationFunction(loanAmount, interestRate,loanLength);
    };

    //    ================================================================================================
//    creating a function to do the calculation for the mortgage calculator
    public static void mortgageCalculationFunction(double loanAmount, double interestRate, float loanLength){
        if (loanAmount <= 0|| interestRate <= 0|| loanLength <= 0){
            System.out.println("You have entered an invalid number");
        }
        else{
            double annualInterestRate = ((interestRate / 100) / 12);
            int numberOfMonths = (int)(loanLength * 12);
            double upperFormula = annualInterestRate * Math.pow((1+ annualInterestRate), numberOfMonths);
            double lowerFormula = Math.pow((1+ annualInterestRate),numberOfMonths) - 1;
            double monthlyPayment = loanAmount * (upperFormula / lowerFormula);
            System.out.printf("Your monthly payment is $ %f", monthlyPayment);

        }
    }

//    ===========================================================================================================
//    creating the Future calculator
     public static void FutureValueCalculator(){
        Scanner InputScanner = new Scanner(System.in);
        double depositeAmount;
        float interestRate;
        int yearNumber;

        System.out.print("Please enter the Deposite Amoount: $ ");
        depositeAmount = InputScanner.nextDouble();

        System.out.print("Please enter the interest rate: ");
        interestRate = InputScanner.nextFloat();

        System.out.print("Please the number of the year: ");
        yearNumber = InputScanner.nextInt();
         validateFutureValueCalculator(depositeAmount,interestRate,yearNumber);

     }

     public static void validateFutureValueCalculator(double depositeAmount,float interestRate,int yearNumber){
        if (depositeAmount <= 0 || interestRate <= 0 || yearNumber <= 0){
            System.out.println("Please enter a valid number.");
        }
        else{
            double rate = interestRate / 100;
            double futureValueAmount = depositeAmount * Math.pow(1+(rate / 365), 365 * yearNumber);
            double interestAmount = futureValueAmount - depositeAmount;
            System.out.printf("Your Future value will $ %f be after %d years \n", futureValueAmount, yearNumber);
            System.out.printf("Your Interest Amount will be %f after %d",interestAmount,  yearNumber);

        }
     }






}

