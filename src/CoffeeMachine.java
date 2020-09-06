import java.util.Scanner;
import java.util.Arrays;

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
        String[] forCoffee = {"water", "milk", "coffee beans", "cups", "money", "needed coffee cups"};
        int[] forEspresso = {250, 0, 16, 1, 4, amountOfWater / 250};
        int[] forLatte = {350, 75, 20, 1, 7, amountOfWater / 350};
        int[] forCappuccino = {200, 100, 12, 1, 6, amountOfWater / 200};
        int[] forCup = Arrays.copyOf(supplies, supplies.length);
        String outOf = forCoffee[5];

        String action;
        boolean turnOn = true;
        while (turnOn) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, " +
                            "2 - latte, 3 - cappuccino or back - to main menu: ");
                    String buy = scanner.next();
                    switch (buy) {
                        case "1":
                            forCup = Arrays.copyOf(forEspresso, forEspresso.length);
                            for (int i = 0; i < 4; i++) {
                                if (supplies[i] == 0 || forCup[i] == 0) {
                                    continue;
                                } else if (supplies[i] / forCup[i] < forCup[5]) {
                                    forCup[5] = supplies[i] / forCup[i];
                                    outOf = forCoffee[i];
                                }
                            }
                            break;
                        case "2":
                            forCup = Arrays.copyOf(forLatte, forLatte.length);
                            for (int i = 0; i < 4; i++) {
                                if (supplies[i] == 0 || forCup[i] == 0) {
                                    continue;
                                } else if (supplies[i] / forCup[i] < forCup[5]) {
                                    forCup[5] = supplies[i] / forCup[i];
                                    outOf = forCoffee[i];
                                }
                            }
                            break;
                        case "3":
                            forCup = Arrays.copyOf(forCappuccino, forCappuccino.length);
                            for (int i = 0; i < 4; i++) {
                                if (supplies[i] == 0 || forCup[i] == 0) {
                                    continue;
                                } else if (supplies[i] / forCup[i] < forCup[5]) {
                                    forCup[5] = supplies[i] / forCup[i];
                                    outOf = forCoffee[i];
                                }
                            }
                            break;
                        default:
                            break;
                    }
                    if (buy.equals("1") || buy.equals("2") || buy.equals("3")) {
                        if (forCup[5] > 0) {
                            System.out.println("I have enough resources, making you a coffee!\n");
                            for (int i = 0; i < supplies.length-2; i++) {
                                supplies[i] -= forCup[i];
                            }
                            supplies[4] += forCup[4];
                        } else {
                            System.out.printf("Sorry, not enough %s!\n", outOf);
                        }
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
                case "remaining":
                    System.out.printf("\nThe coffee machine has:\n" +
                            "%d of water\n" +
                            "%d of milk\n" +
                            "%d of coffee beans\n" +
                            "%d of disposable cups\n" +
                            "%d of money\n", supplies[0], supplies[1], supplies[2], supplies[3], supplies[4]);
                    break;
                case "exit":
                    turnOn = false;
                    break;
            }
        }
    }
}
