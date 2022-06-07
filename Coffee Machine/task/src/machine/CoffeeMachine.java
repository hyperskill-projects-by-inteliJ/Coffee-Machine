package machine;

import java.util.*;

public class CoffeeMachine {
    final static Scanner scanner = new Scanner(System.in);

    // available ingredients
    static int availableWaterAmount = 400;
    static int availableMilkAmount = 540;
    static int availableCoffeeBeansAmount = 120;
    static int availableDisposableCups = 9;
    static int availableMoney = 550;

    // espresso
    static int espressoWaterAmountPerCup = 250;
    static int espressoMilkAmountPerCup = 0;
    static int espressoCoffeeBeansAmountPerCup = 16;
    static int espressoValue = 4;

    // latte
    static int latteWaterAmountPerCup = 350;
    static int latteMilkAmountPerCup = 75;
    static int latteCoffeeBeansAmountPerCup = 20;
    static int latteValue = 7;

    // cappuccino
    static int cappuccinoWaterAmountPerCup = 200;
    static int cappuccinoMilkAmountPerCup = 100;
    static int cappuccinoCoffeeBeansAmountPerCup = 12;
    static int cappuccinoValue = 6;

    public static void main(String[] args) {
        startCoffeeMachine();
    }

    public static void startCoffeeMachine() {
        printMachineStats();

        String action = selectAction();
        switch (action) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
        }

        printMachineStats();

    }


    public static String selectAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return scanner.nextLine();
    }

    public static void buy() {
        int coffeeType = getIntegerInput("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");

        switch (coffeeType) {
            case 1:
                makeCoffee(espressoWaterAmountPerCup, espressoMilkAmountPerCup, espressoCoffeeBeansAmountPerCup, espressoValue);
                break;
            case 2:
                makeCoffee(latteWaterAmountPerCup, latteMilkAmountPerCup, latteCoffeeBeansAmountPerCup, latteValue);
                break;
            case 3:
                makeCoffee(cappuccinoWaterAmountPerCup, cappuccinoMilkAmountPerCup, cappuccinoCoffeeBeansAmountPerCup, cappuccinoValue);
                break;
        }

        System.out.println();
    }

    public static void makeCoffee(int water, int milk, int coffeeBeans, int value) {
        availableWaterAmount -= water;
        availableMilkAmount -= milk;
        availableCoffeeBeansAmount -= coffeeBeans;
        availableDisposableCups--;
        availableMoney += value;
    }

    public static void fill() {
        int water = getIntegerInput("Write how many ml of water you want to add:");
        int milk = getIntegerInput("Write how many ml of milk you want to add:");
        int coffeeBeans = getIntegerInput("Write how many grams of coffee beans you want to add:");
        int cups = getIntegerInput("Write how many disposable cups of coffee you want to add:");

        availableWaterAmount += water;
        availableMilkAmount += milk;
        availableCoffeeBeansAmount += coffeeBeans;
        availableDisposableCups += cups;
    }

    public static int getIntegerInput(String text) {
        System.out.println(text);
        return scanner.nextInt();
    }

    public static void take() {
        System.out.printf("I gave you $%d\n", availableMoney);
        availableMoney = 0;
        System.out.println();
    }

    public static void printMachineStats() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", availableWaterAmount);
        System.out.printf("%d ml of milk\n", availableMilkAmount);
        System.out.printf("%d g of coffee beans\n", availableCoffeeBeansAmount);
        System.out.printf("%d disposable cups\n", availableDisposableCups);
        System.out.printf("$%d of money\n", availableMoney);
        System.out.println();
    }

}
