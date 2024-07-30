/*
Theory Questions :
        ◦ Explain why data structures and algorithms are essential in handling large inventories.
        ◦ Discuss the types of data structures suitable for this problem.

Answers :
1.  Performance can be Optimized
    Efficient Memory management can be done
    Scalability can be achieved

2.  HashMap
    ArrayList
    ( I have used HashMap but List can also be used )
 */


import java.util.*;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private int price;

    public Product(int productId, String productName, int quantity, int price)
    {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }


    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public void display()
    {
        System.out.println("Product ID : "+this.productId);
        System.out.println("Name : "+this.productName);
        System.out.println("Quantity : "+this.quantity);
        System.out.println("Price : "+this.price);
    }
}

class Inventory{
    private HashMap<Integer, Product> products;

    public Inventory()
    {
        products = new HashMap<>();
    }

    public void addProduct(Product product)
    {
        products.put(product.getProductId(),product);
    }

    public void removeProduct(int productId)
    {
        products.remove(productId);
    }

    public void updateProduct(int productId, Product newProduct)
    {
        products.put(productId, newProduct);
    }

    public Product getProduct(int productId)
    {
        return products.get(productId);
    }

    public void showProducts()
    {
        for(Integer key : products.keySet())
        {
            this.getProduct(key).display();
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        Inventory inventory = new Inventory();
        while(loop)
        {
            System.out.print("1. Add Product\n" +
                    "2. Remove Product\n" +
                    "3. Update Product\n" +
                    "4. Show Products\n" +
                    "5. Exit\n" +
                    "Enter your choice : ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter Product Id : ");
                    int id = sc.nextInt();

                    System.out.print("Enter Product Name : ");
                    String name = sc.next();

                    System.out.print("Enter Product Quantity : ");
                    int qty = sc.nextInt();

                    System.out.print("Enter Product Price : ");
                    int price = sc.nextInt();

                    Product product = new Product(id, name, qty, price);
                    inventory.addProduct(product);
                    break;

                case 2:
                    System.out.print("Enter Product Id : ");
                    int removeId = sc.nextInt();
                    inventory.removeProduct(removeId);
                    break;

                case 3:
                    System.out.print("Enter Product Id : ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter Product Name : ");
                    String newName = sc.nextLine();

                    System.out.print("Enter Product Quantity : ");
                    int newQty = sc.nextInt();

                    System.out.print("Enter Product Price : ");
                    int newPrice = sc.nextInt();

                    Product newProduct = new Product(updateId,newName,newQty,newPrice);
                    inventory.updateProduct(updateId, newProduct);
                    break;
                case 4:
                    inventory.showProducts();
                    break;
                case 5:
                    loop = false;
                    break;

                default:
                    System.out.println("Invalid Choice, Please Try Again..");
            }

        }
        sc.close();
    }
}
