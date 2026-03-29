package edu.norcocollege.cis18b.week2.demo;
import java.util.Scanner;
import java.util.InputMismatchException;

import edu.norcocollege.cis18b.week2.demo.LanguageBasicsReview.Square;
import edu.norcocollege.cis18b.week2.demo.LanguageBasicsReview.rightTriangle;



/**
 * This class is a review of basic Java language features. It’s not
 * meant to be comprehensive, but it should cover the basics and provide
 * a refresher on syntax and concepts.
 *
 * TODO:
 *  - Demonstrate variable declarations and types
 *  - Demonstrate control flow (if, switch, loops)
 *  - Demonstrate methods and parameters
 *  - Demonstrate basic OOP concepts (classes, objects, inheritance)
 */
public class LanguageBasicsReview {

    public void demonstrate() {
        // TODO: Implement demonstration of basic Java features
        Menu menu = new Menu();
        menu.start();
        // NOTE: Remove the exception below when you've implemented your code
        // throw new UnsupportedOperationException("Not implemented yet");
    }

    class Menu {
        Square option2 = new Square();
        Scanner input = new Scanner(System.in);
        public void start(){
            int option;
            do {
                System.out.println("\n\nPlease select an option:");
                System.out.println("1. Calculate Side C of Triangle.");
                System.out.println("2. Calculate Rectangular Area.");
                System.out.println("3. Exit Program.");
                option = input.nextInt();
                switch (option) {
                    case 1:
                        boolean valid = false;
                        while(!valid) {
                            try {
                                System.out.print("Please enter side A: ");
                                double A = input.nextDouble();
                                System.out.print("Please enter side B: ");
                                double B = input.nextDouble();
                                rightTriangle option1 = new rightTriangle(A,B);
                                double C = option1.rightTriangleCalculate();
                                System.out.print("Side C = " + C);
                                valid = true;
                            }  catch(IllegalArgumentException e){
                                 System.out.println(e.getMessage());
                            }  catch (InputMismatchException e) {
                                // TODO: handle exception
                                System.out.println("Numbers only.");
                                input.nextLine();
                            }
                        }
                        break;
                    case 2:
                        boolean valid2 = false;
                        while(!valid2) {
                            try {
                                System.out.print("Please enter side A: ");
                                double a = input.nextDouble();
                                System.out.print("Please enter side B: ");
                                double b = input.nextDouble();
                                Square option2 = new Square(a,b);
                                double area = option2.squareAreaCalculate();
                                System.out.print("Area = " + area);
                                valid2 = true;
                            }  catch(IllegalArgumentException e){
                                 System.out.println(e.getMessage());
                            }  catch (InputMismatchException e) {
                                // TODO: handle exception
                                System.out.println("Numbers only.");
                                input.nextLine();
                            }
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid Selection, please choose again.");
                        break;
                        
                }
            } while (option != 3);
        }
    }

    class rightTriangle {
        private double sideA;
        private double sideB;
        private double sideC;

        public rightTriangle() {
            this(0,0);
        }

        public rightTriangle(double sA, double sB) {

            if( sA< 0 || sB < 0){
                throw new IllegalArgumentException("Sides must be positive numbers.");
    }
            this.sideA = sA;
            this.sideB = sB;
        }

        public double rightTriangleCalculate() {
            sideC = Math.sqrt((sideA * sideA)+(sideB * sideB));
            return sideC;
        }
    }

     class Square {
        private double sideA;
        private double sideB;
        private double Area;

        public Square() {
            this(0,0);
        }

        public Square(double sA, double sB) {

            if(sA < 0 || sB < 0){
                throw new IllegalArgumentException("Sides must be positive numbers.");
    }
            this.sideA = sA;
            this.sideB = sB;
        }

        public double squareAreaCalculate() {
            Area = (sideA * sideB);
            return Area;
        }
    }


}