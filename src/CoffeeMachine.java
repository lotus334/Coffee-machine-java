import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int milkForCup = 50;
        int waterForCup = 200;
        int beansForCup = 15;
        System.out.println("Write how many ml of water the coffee machine has:");
        int amountOfWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int amountOfMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int amountOfBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int numberOfCups = scanner.nextInt();
        int[] supplies = {amountOfWater, amountOfMilk, amountOfBeans, numberOfCups};
        int[] forCup = {waterForCup, milkForCup, beansForCup, amountOfWater / waterForCup};

        for (int i = 0; i < 3; i++) {
            if (supplies[i] / forCup[i] < forCup[3]) {
                forCup[3] = supplies[i] / forCup[i];
            }
        }
        if (supplies[3] == forCup[3]) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (supplies[3] > forCup[3]) {
            System.out.printf("No, I can make only %d cup(s) of coffee", forCup[3]);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", forCup[3] - supplies[3]);
        }
    }
}
