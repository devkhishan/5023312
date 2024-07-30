/*
Theory Question :
        ◦ Explain Big O notation and how it helps in analyzing algorithms.
        ◦ Describe the best, average, and worst-case scenarios for search operations.

Answer :
1.  Big O notation is used to describe the upper bound of an algorithm's running time.  It is used to analyze the
    performance and efficiency of algorithms.

2.  Linear Search :
    Best Case : O(1)
    Average Case : O(n/2) -> O(n)
    Worst Case : O(n)

    Binary Search :
    Best Case : O(1)
    Average Case : O(log n)
    Worst Case : O(log n)


 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class EcomProduct {
    private int productId;
    private String productName;
    private String category;

    public EcomProduct(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }
}

class LinearSearch {
    public static EcomProduct linearSearch(EcomProduct[] products, int productId) {
        for (EcomProduct product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
}

class BinarySearch {
    public static EcomProduct binarySearch(EcomProduct[] products, int productId) {
        Arrays.sort(products, Comparator.comparingInt(EcomProduct::getProductId));
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid];
            } else if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

public class EcommercePlatformSearch {
    public static void main(String[] args) {
        EcomProduct[] products = {
            new EcomProduct(1, "Laptop", "Electronics"),
            new EcomProduct(2, "Smartphone", "Electronics"),
            new EcomProduct(3, "Shoes", "Fashion"),
            new EcomProduct(4, "Watch", "Accessories")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product ID to search: ");
        int productId = sc.nextInt();


        EcomProduct product = LinearSearch.linearSearch(products, productId);
        if (product != null) {
            System.out.println("Product found using Linear Search: " + product.getProductName());
        } else {
            System.out.println("Product not found using Linear Search.");
        }

        product = BinarySearch.binarySearch(products, productId);
        if (product != null) {
            System.out.println("Product found using Binary Search: " + product.getProductName());
        } else {
            System.out.println("Product not found using Binary Search.");
        }

        sc.close();
    }
}
