import java.util.HashMap;
import java.util.Map;

class CoffeeMaker {
    private Map<String, Integer> resources;

    public CoffeeMaker() {
        resources = new HashMap<>();
        resources.put("вода", 300);
        resources.put("молоко", 200);
        resources.put("кофе", 100);
    }

    public void report() {
        System.out.println("Вода: " + resources.get("вода") + "мл");
        System.out.println("Молоко: " + resources.get("молоко") + "мл");
        System.out.println("Кофе: " + resources.get("кофе") + "г");
    }

    public boolean isResourceSufficient(Drink drink) {
        boolean canMake = true;
        for (String item : drink.ingredients.keySet()) {
            if (drink.ingredients.get(item) > resources.get(item)) {
                System.out.println("Извините, "+ item + " не достаточно.");
                canMake = false;
            }
        }
        return canMake;
    }

    public void makeCoffee(Order order) {
        for (String item : order.ingredients.keySet()) {
            resources.put(item, resources.get(item) - order.ingredients.get(item));
        }
        System.out.println("Здесь ваше " + order.name + " ☕️. Пейте на здоровье!");
    }
}
