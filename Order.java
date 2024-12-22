
import java.util.ArrayList;
import java.util.List;

public class Order {
    private  int orderId;
    private  String customerName;
    private List<Book> books;

    public Order(int orderId, String customerName){
        this.orderId = orderId;
        this.customerName = customerName;
        this.books = new ArrayList<>();
    }

    public int getOrderId(){
        return orderId;
    }

    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public boolean addBookByTitle(String title, List<Book> availableBooks) {
        for (Book book : availableBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                this.books.add(book);
                return true;
            }
        }
        return false; // Book not found
    }

    public boolean addBookById(int id, List<Book> availableBooks) {
        for (Book book : availableBooks) {
            if (book.getId() == id) {
                this.books.add(book);
                return true;
            }
        }
        return false; // Book not found
    }

    public boolean removeBook(Book book) {
        return this.books.remove(book);
    }

    public void printOrderDetail(){
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Books in the Order:");
        if (books.isEmpty()) {
            System.out.println("No books in this order.");
        } else {
            for (Book book : books) {
                book.print(); // Assuming the `Book` class has a `print()` method
            }
        }
    }
}