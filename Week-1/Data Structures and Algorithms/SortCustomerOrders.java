/*
Theory Questions :
Explain different sorting algorithms (Bubble Sort, Insertion Sort, Quick Sort, Merge Sort).

Answers :
Bubble Sort : Adjacent elements are compared and swapped if they are in wrong order,
              the process is repeated until the array get sorted : O(n^2)
Insertion Sort : It will build the final sorted array one item at a time : O(n^2)
Quick Sort : Divide and Conquer, uses pivot to place elements at right positions : O(n log n)
Merge Sort : Divide and Conquer, divide into halves and merge back as sorted : O(n log n)
 */

import java.util.*;

class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

class BubbleSort {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort {
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

public class SortCustomerOrders {
    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 250.0),
            new Order(2, "Bob", 150.0),
            new Order(3, "Charlie", 300.0),
            new Order(4, "David", 200.0)
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("1. Bubble Sort\n" +
                "2 for Quick Sort\n" +
                "Enter Your Choice : ");
        int choice = sc.nextInt();

        if (choice == 1) {
            BubbleSort.bubbleSort(orders);
        } else if (choice == 2) {
            QuickSort.quickSort(orders, 0, orders.length - 1);
        } else {
            System.out.println("Invalid choice.");
            sc.close();
            return;
        }

        System.out.println("Sorted Orders by Total Price:");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Customer Name: " + order.getCustomerName());
            System.out.println("Total Price: " + order.getTotalPrice());
        }

        sc.close();
    }
}