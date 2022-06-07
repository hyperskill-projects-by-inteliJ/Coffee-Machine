package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);

    

    static int cupCount = 0;

    static int waterAmountPerCup = 200;
    static int milkAmountPerCup = 50;
    static int coffeeBeansAmount = 15;

    public static void main(String[] args) {
        System.out.println("Write how many cups of coffee you will need:");
        cupCount = scanner.nextInt();

        printTotalIngredientsAmount(cupCount);
    }

    public static void startCoffeeMachine() {

    }

    public static void printTotalIngredientsAmount(int cups) {
        System.out.printf("For %d cups of coffee you will need:\n", cups);
        System.out.printf("%d ml of water\n", cups * waterAmountPerCup);
        System.out.printf("%d ml of milk\n", cups * milkAmountPerCup);
        System.out.printf("%d g of coffee beans", cups * coffeeBeansAmount);
    }
}
