import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        MoneyMachine moneyMachine = new MoneyMachine();
        CoffeeMaker coffeeMaker = new CoffeeMaker();
        Menu menu = new Menu();
        boolean isOn = true;
        Scanner scanner = new Scanner(System.in);

        coffeeMaker.report();
        moneyMachine.report();

        while (isOn) {
            String options = menu.getItems();
            System.out.print("Что вы хотите заказать? (" + options + "): ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("отчет")) {
                coffeeMaker.report();
                moneyMachine.report();
            } else if (userChoice.equals("выключ.")) {
                System.out.println("Автомат не работает.");
                isOn = false;
            } else {
                try {
                    Drink drink = menu.findDrink(userChoice);
                    boolean isEnoughIngredients = coffeeMaker.isResourceSufficient(drink);
                    if (isEnoughIngredients) {
                        boolean isPaymentSuccessful = moneyMachine.makePayment(drink.getCost());
                        if (isPaymentSuccessful) {
                            coffeeMaker.makeCoffee(drink);
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println("Извините, этого кофе нет.");
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}

