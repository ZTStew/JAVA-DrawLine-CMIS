/*
 * Program that takes a string and the desired times for the string to be repeated
 *
 * @author Stewart
 * @version JAVA 8, 7/1/2019
 */

import java.util.Scanner;

public class DrawLine{
    public static void main(String[] args){

        /* Predefined Input Section */

        /* Creates new instance of 'DrawLineF' named 'drawn1' */
        DrawLineF drawn1 = new DrawLineF("=+=", 5);
        drawn1.draw();
        /* runs '.setLine(String)' method and changes the line pattern */
        drawn1.setLine("===");
        drawn1.draw();
        /* runs '.setRepeat(Int)' method to change the number of times the pattern is repeated */
        drawn1.setRepeat(2);
        drawn1.draw();
        /* runs '.getAttributes()' method which returns the information about the specified object */
        drawn1.getAttributes();

        System.out.print("\n");

        /* Creates new instance of 'DrawLineF' named 'drawn2' */
        DrawLineF drawn2 = new DrawLineF("#", 20);
        /* runs '.draw()' which prints the current pattern */
        drawn2.draw();
        /* runs '.getAttributes()' method which returns the information about the specified object */
        drawn2.getAttributes();

        System.out.println("\n");


        /* Manual Input Section */

        Scanner scan = new Scanner(System.in);
        DrawLineF drawManual = new DrawLineF();
        Boolean flag = true;
        int repeat = 0;

        /* Propts the user for a pattern to repeat */
        System.out.print("Enter the pattern you would like repeated: ");
        String pattern = scan.nextLine();

        /* Loops until the user inputs a valid value for 'repeat' */
        while(flag){
            try{
                /* Propts user for the number of times they would like their pattern repeated */
                System.out.print("Enter the number of times you would like the pattern repeated: ");
                String repeatIn = scan.nextLine();
                repeat = Integer.parseInt(repeatIn);
                flag = false;
            } catch(Exception e){
                System.out.println("ERROR: Invalid input. Please try again.");
            }
        }

        /* Sets the values of 'drawManual' and then draws the pattern the user entered */
        drawManual.setLine(pattern);
        drawManual.setRepeat(repeat);
        drawManual.draw();
    }
}

class DrawLineF{
    private String line;
    private int repeat;

    /* Constructor: requires a pattern (line) and the number of times the pattern should be repeated (repeat) */
    DrawLineF(String line, int repeat){
        setLine(line);
        setRepeat(repeat);
    }
    DrawLineF(){
        this("- - -", 1);
    }

    /* Method prints the line (this.repeat) times */
    public void draw(){
        for(int i = 0; i < repeat; i++){
            System.out.print(line);
        };
        System.out.println();
    }

    /* Setters and Getters for 'this.line' and 'this.repeat' */
    public void setLine(String line){
        this.line = line;
    }
    public String getLine(){
        return this.line;
    }

    public void setRepeat(int repeat){
        /// ensures user does not enter a negative value
        if(repeat < 0){
            this.repeat = 0;
        } else{
            this.repeat = repeat;
        }
    }
    public int getRepeat(){
        return this.repeat;
    }

    /* Prints for the user the specific information pertaining to the 'DrawLineF' object */
    public void getAttributes(){
        System.out.println("The pattern is " + getLine() + " repeated " + getRepeat() + " times.");
    }
}
