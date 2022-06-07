package machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);

    static int availableWaterAmount = 0;
    static int availableMilkAmount = 0;
    static int availableCoffeeBeansAmount = 0;

    static int availableCupCount = 0;
    static int requestedCupCount = 0;

    static int waterAmountPerCup = 200;
    static int milkAmountPerCup = 50;
    static int coffeeBeansAmountPerCup = 15;

    public static void main(String[] args) {
        startCoffeeMachine();

        // printTotalIngredientsAmount(requestedCupCount);
    }

    public static void startCoffeeMachine() {
        System.out.println("Write how many ml of water the coffee machine has: ");
        availableWaterAmount = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        availableMilkAmount = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        availableCoffeeBeansAmount = scanner.nextInt();

        availableCupCount = calculateAvailableCupCount();

        System.out.println("Write how many cups of coffee you will need:");
        requestedCupCount = scanner.nextInt();


    }

    public static int calculateAvailableCupCount() {
        List<Integer> ingredientsServingsCountList = new ArrayList();
        ingredientsServingsCountList.set(0, availableWaterAmount / waterAmountPerCup);
        ingredientsServingsCountList.set(1, availableMilkAmount / milkAmountPerCup);
        ingredientsServingsCountList.set(2, availableCoffeeBeansAmount / coffeeBeansAmountPerCup);

        return Collections.min(ingredientsServingsCountList);
    }

    public static void printTotalIngredientsAmount(int cups) {
        System.out.printf("For %d cups of coffee you will need:\n", cups);
        System.out.printf("%d ml of water\n", cups * waterAmountPerCup);
        System.out.printf("%d ml of milk\n", cups * milkAmountPerCup);
        System.out.printf("%d g of coffee beans", cups * coffeeBeansAmountPerCup);
    }
}
