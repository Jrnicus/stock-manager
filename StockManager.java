import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Steve Cate 
 * @version 10/07/2019
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * This will also make sure that this id hasn't already been assigned
     * to another product if it has it will display a error message for the user
     * and the product will not be added.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if (findProduct(item.getID()) == null)
        {
            stock.add(item);
        }
        else
        {
            System.out.println("Error: This product can not be added because it " +
                "has the same ID as a product already in stock");
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * If the ID number is not found it will print a error message
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        if (findProduct(id) != null)
        {
            findProduct(id).increaseQuantity(amount);
        }
        else
        {
            System.out.println("That Product is not listed in the inventory please " +
                "add the product to stock first then try again.");
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @param ID of the product which is a int
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
                for (Product product : stock)
        {
            if (id == product.getID())
            {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Try to find a product in the stock by name.
     * @param name the name of the product which is a String
     * @return The identified product, or null if there is none with a matching name
     * 
     */
        public Product findProduct(String name)
    {
        for (Product product : stock)
        {
            if (name.equalsIgnoreCase(product.getName()))
            {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        if (findProduct(id) != null)
        {
            return findProduct(id).getQuantity();
        }
        return 0;
    }

    /**
     * Print details of all the products in the ArrayList stock
     */
    public void printProductDetails()
    {
        for (Product product : stock)
        {
            System.out.println(product.toString());
        }    
    }
    
     /**
     * This will print all products with stock level below a certain number 
     * that is give as a parameter
     * @param stockLevel the quantity to test if any products are below
     */
    public void printProductsBelowStockLevel(int stockLevel)
    {
        boolean anyProductsBelowStock = false;
        System.out.println("Items with stock levels below: " + stockLevel);
        for (Product product : stock)
        {
            if(product.getQuantity() < stockLevel)
            {
                anyProductsBelowStock = true;
                System.out.println(product.toString());
            }
        }
        if(!anyProductsBelowStock)
        {
            System.out.println("There are no items with stock levels below " + stockLevel);
        }
    }
}
