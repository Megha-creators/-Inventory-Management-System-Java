import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        while (true) {

            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Search Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    products.add(new Product(id, name, quantity, price));
                    System.out.println("Product Added Successfully!");
                    break;

                case 2:
                    if (products.isEmpty()) {
                        System.out.println("No Products Found.");
                    } else {
                        for (Product p : products) {
                            p.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to Search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Product p : products) {
                        if (p.productId == searchId) {
                            p.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Product Not Found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Product ID to Delete: ");
                    int deleteId = sc.nextInt();

                    products.removeIf(p -> p.productId == deleteId);
                    System.out.println("Product Deleted Successfully!");
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
