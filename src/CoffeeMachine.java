import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfWater = 400;
        int amountOfMilk = 540;
        int amountOfBeans = 120;
        int numOfCups = 9;
        int amountOfMoney = 550;
        int numOfCoffee = 0;
        int[] supplies = {amountOfWater, amountOfMilk, amountOfBeans, numOfCups, amountOfMoney, numOfCoffee};
        // int forCoffee = {waterForCup, milkForCup, beansForCup, cupsForCup, moneyForCup, amountOfWater / waterForCup};
        int[] forEspresso = {250, 0, 16, 1, 4, amountOfWater / 250};
        int[] forLatte = {350, 75, 20, 1, 7, amountOfWater / 350};
        int[] forCappuccino = {200, 100, 12, 1, 6, amountOfWater / 200};

        System.out.printf("The coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "%d of money\n\n", supplies[0], supplies[1], supplies[2], supplies[3], supplies[4]);

        System.out.println("Write action (buy, fill, take): ");
        String action = scanner.nextLine();
        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                int buy = scanner.nextInt();
                switch (buy) {
                    case 1:
                        for (int i = 0; i < supplies.length-2; i++) {
                            supplies[i] -= forEspresso[i];
                        }
                        supplies[4] += forEspresso[4];
                        break;
                    case 2:
                        for (int i = 0; i < supplies.length-2; i++) {
                            supplies[i] -= forLatte[i];
                        }
                        supplies[4] += forLatte[4];
                        break;
                    case 3:
                        for (int i = 0; i < supplies.length-2; i++) {
                            supplies[i] -= forCappuccino[i];
                        }
                        supplies[4] += forCappuccino[4];
                        break;
                }
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add: ");
                supplies[0] += scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add: ");
                supplies[1] += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                supplies[2] += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                supplies[3] += scanner.nextInt();
                break;
            case "take":
                System.out.printf("I gave you $%d\n", supplies[4]);
                supplies[4] = 0;
                break;
        }

        System.out.printf("\nThe coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "%d of money\n", supplies[0], supplies[1], supplies[2], supplies[3], supplies[4]);


        /*
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

         */
    }
}
