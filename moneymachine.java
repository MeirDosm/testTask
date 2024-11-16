import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MoneyMachine {

    private static final String CURRENCY = "KZT";

    private static final Map<String, Integer> COIN_VALUES = new HashMap<String, Integer>() {{
        put("купюр в 5 тысяч тенге", 5000);
        put("купюр в 1 тысяча тенге", 1000);
        put("купюр в 500 тенге ", 500);
        put("монет в 100 тенге", 100);
    }};

    private int profit;
    private int moneyReceived;

    public MoneyMachine() {
        this.profit = 0;
        this.moneyReceived = 0;
    }

    public void report() {
        System.out.println("Итого: " + profit + CURRENCY);
    }

    public int processCoins() {
        System.out.println("Пожалуйста внесите купюру или монету.");
        Scanner scanner = new Scanner(System.in);
        for (String coin : COIN_VALUES.keySet()) {
            System.out.print("Как много " + coin + "?: ");
            int count = scanner.nextInt();
            moneyReceived += count * COIN_VALUES.get(coin);
        }
        return moneyReceived;
    }

    public boolean makePayment(int cost) {
        processCoins();
        if (moneyReceived >= cost) {
            int change = moneyReceived - cost;
            System.out.println("Здесь ваша сдача " + change + CURRENCY);
            profit += cost;
            moneyReceived = 0;
            return true;
        } else {
            System.out.println("Извините, средств недостаточно. Деньги возвращены.");
            moneyReceived = 0;
            return false;
        }
    }
}
