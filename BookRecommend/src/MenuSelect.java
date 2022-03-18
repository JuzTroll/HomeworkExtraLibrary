import java.util.Arrays;
import java.util.Scanner;

public class MenuSelect {
    public void start(Library l){
        boolean condition = true;
        while(condition == true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Please select your choice by typing the number: \n(0)Stop the program\n(1)Add Books\n(2)Sort and show books by: age recommendation, year, alphabetical order");
            int choice = input.nextInt();
            switch(choice) {
                case 0:
                    condition=false;
                    break;
                case 1:
                    l.readBooks();
                    break;
                case 2:
                    System.out.println(Arrays.toString(l.sortBooks()));
                    break;
            }
        }
    }
}
