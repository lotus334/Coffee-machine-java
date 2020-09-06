import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                            if (isEnough("espresso")) {
                                makeCoffee("espresso");
                                System.out.println("I have enough resources, making you a coffee!\n");
                            } else {
                                System.out.printf("Sorry, not enough %s!\n", outOf("espresso"));
                            }
                            break;
                        case "2":
                            if (isEnough("latte")) {
                                makeCoffee("latte");
                                System.out.println("I have enough resources, making you a coffee!\n");
                            } else {
                                System.out.printf("Sorry, not enough %s!\n", outOf("latte"));
                            }
                            break;
                        case "3":
                            if (isEnough("cappuccino")) {
                                makeCoffee("cappuccino");
                                System.out.println("I have enough resources, making you a coffee!\n");
                            } else {
                                System.out.printf("Sorry, not enough %s!\n", outOf("cappuccino"));
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add: ");
                    Coffee.MACHINE.water += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    Coffee.MACHINE.milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    Coffee.MACHINE.beans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    Coffee.MACHINE.cups += scanner.nextInt();
                    break;
                case "take":
                    System.out.printf("I gave you $%d\n", Coffee.MACHINE.getPrice());
                    Coffee.MACHINE.price = 0;
                    break;
                case "remaining":
                    System.out.printf("\nThe coffee machine has:\n" +
                            "%d of water\n" +
                            "%d of milk\n" +
                            "%d of coffee beans\n" +
                            "%d of disposable cups\n" +
                            "%d of money\n",
                            Coffee.MACHINE.getWater(),
                            Coffee.MACHINE.getMilk(),
                            Coffee.MACHINE.getBeans(),
                            Coffee.MACHINE.getCups(),
                            Coffee.MACHINE.getPrice());
                    break;
                case "exit":
                    turnOn = false;
                    break;
            }
        }
    }


    public static boolean isEnough(String value) {
        if (Coffee.MACHINE.getWater() - Coffee.valueOf(value.toUpperCase()).getWater() >= 0 &&
                Coffee.MACHINE.getMilk() - Coffee.valueOf(value.toUpperCase()).getMilk() >= 0 &&
                Coffee.MACHINE.getBeans() - Coffee.valueOf(value.toUpperCase()).getBeans() >= 0 &&
                Coffee.MACHINE.getCups() - Coffee.valueOf(value.toUpperCase()).getCups() >= 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void makeCoffee(String value) {
        Coffee.MACHINE.water -= Coffee.valueOf(value.toUpperCase()).getWater();
        Coffee.MACHINE.milk -= Coffee.valueOf(value.toUpperCase()).getMilk();
        Coffee.MACHINE.beans -= Coffee.valueOf(value.toUpperCase()).getBeans();
        Coffee.MACHINE.cups -= Coffee.valueOf(value.toUpperCase()).getCups();
        Coffee.MACHINE.price += Coffee.valueOf(value.toUpperCase()).getPrice();
    }
    public static String outOf(String value) {
        String supply = "mind";
        if (Coffee.MACHINE.getWater() - Coffee.valueOf(value.toUpperCase()).getWater() < 0) {
            supply = "water";
        } else if (Coffee.MACHINE.getMilk() - Coffee.valueOf(value.toUpperCase()).getMilk() < 0) {
            supply = "milk";
        } else if (Coffee.MACHINE.getBeans() - Coffee.valueOf(value.toUpperCase()).getBeans() < 0) {
            supply = "coffee beans";
        } else if (Coffee.MACHINE.getCups() - Coffee.valueOf(value.toUpperCase()).getCups() < 0) {
            supply = "disposable cups";
        }
        return supply;
    }

    public enum Coffee {
        MACHINE(400, 540, 120, 9, 550),
        ESPRESSO(250, 0, 16,1, 4),
        LATTE(350, 75, 20,1, 7),
        CAPPUCCINO(200, 100, 12,1, 6);

        int water;
        int milk;
        int beans;
        int price;
        int cups;

        Coffee (int water, int milk, int beans,int cups, int price) {
            this.water = water;
            this.milk = milk;
            this.beans = beans;
            this.cups = cups;
            this.price = price;
        }

        public int getWater() {
            return water;
        }
        public int getMilk() {
            return milk;
        }
        public int getBeans() {
            return beans;
        }
        public int getCups() {
            return cups;
        }
        public int getPrice() {
            return price;
        }
        public int takeMoney() {
            MACHINE.price = 10;
            return MACHINE.price;
        }
    }
}
