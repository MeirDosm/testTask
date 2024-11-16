import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MenuItem {
    String name;
    double cost;
    Map<String, Integer> ingredients;

    public MenuItem(String name, int water, int milk, int coffee, int cost) {
        this.name = name;
        this.cost = cost;
        this.ingredients = new HashMap<>();
        this.ingredients.put("вода", water);
        this.ingredients.put("молоко", milk);
        this.ingredients.put("кофе", coffee);
    }
}

class Menu {
    List<MenuItem> menu;

    public Menu() {
        menu = new ArrayList<>();
        menu.add(new MenuItem("американо", 254, 0, 18, 2500));
        menu.add(new MenuItem("эспрессо", 50, 0, 18, 1500));
        menu.add(new MenuItem("капучино", 250, 50, 24, 3000));
    }

    public String getItems() {
        StringBuilder options = new StringBuilder();
        for (MenuItem item : menu) {
            options.append(item.name).append("/");
        }
        return options.toString();
    }

    public MenuItem findDrink(String orderName) {
        for (MenuItem item : menu) {
            if (item.name.equals(orderName)) {
                return item;
            }
        }
        return null;
    }
}
