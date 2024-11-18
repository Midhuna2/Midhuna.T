import java.util.*;
class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
public class RestaurantBillSystem {
    private Map<String, MenuItem> menu = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public RestaurantBillSystem() {
        menu.put("1", new MenuItem("Burger", 5.99));
        menu.put("2", new MenuItem("Pizza", 8.99));
        menu.put("3", new MenuItem("Pasta", 7.49));
        menu.put("4", new MenuItem("Salad", 4.99));
        menu.put("5", new MenuItem("Soda", 1.99));
    }
    private void displayMenu() {
        System.out.println("Menu:");
        menu.forEach((key, item) -> System.out.printf("%s. %s - $%.2f%n", key, item.name, item.price));
    }
    public void takeOrder() {
        List<MenuItem> order = new ArrayList<>();
        String choice;
        do {
            displayMenu();
            System.out.print("Select an item by number (or type 'done' to finish): ");
            choice = scanner.nextLine();
            if (menu.containsKey(choice)) {
                order.add(menu.get(choice));
                System.out.println(menu.get(choice).name + " added to your order.");
            } else if (!choice.equalsIgnoreCase("done")) {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equalsIgnoreCase("done"));

        printBill(order);
    }

    private void printBill(List<MenuItem> order) {
        System.out.println("\nYour Bill:");
        double total = 0;
        for (MenuItem item : order) {
            System.out.printf("%s - $%.2f%n", item.name, item.price);
            total += item.price;
        }
        System.out.printf("Total: $%.2f%n", total);
    }

    public static void main(String[] args) {
        new RestaurantBillSystem().takeOrder();
    }
}