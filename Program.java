import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Program {
    private static List<Book> books = new ArrayList<>();
    private static final int EXIT = 0;
    private static List<Order> orders = new ArrayList<>();

    public Program() {

    }

    public static void main(String[] args) {
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner's Sons", 1925, 180, "Borrow", 1));
        books.add(new Book("1984", "George Orwell", "Secker & Warburg", 1949, 328, "Borrow", 2));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1960, 281, "Order", 3));
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", 1951, 277, "In Stock", 4));
        books.add(new Book("Moby-Dick", "Herman Melville", "Harper & Brothers", 1851, 635, "Borrow", 5));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "T. Egerton, Whitehall", 1813, 432, "Borrow", 6));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "George Allen & Unwin", 1937, 310, "Order", 7));
        books.add(new Book("War and Peace", "Leo Tolstoy", "The Russian Messenger", 1869, 1225, "In Stock", 8));
        books.add(new Book("Brave New World", "Aldous Huxley", "Chatto & Windus", 1932, 311, "Borrow", 9));
        books.add(new Book("Fahrenheit 451", "Ray Bradbury", "Ballantine Books", 1953, 158, "Order", 10));
        books.add(new Book("Catch-22", "Joseph Heller", "Simon & Schuster", 1961, 453, "Borrow", 11));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoevsky", "The Russian Messenger", 1866, 430, "In Stock", 12));
        books.add(new Book("The Lord of the Rings: The Fellowship of the Ring", "J.R.R. Tolkien", "George Allen & Unwin", 1954, 423, "Order", 13));

        

        // Initialize Reader
        Reader reader1 = new Reader(1, "John Doe");
        Reader reader2 = new Reader(2, "Vinh Nguyen");

        Scanner scanner = new Scanner(System.in);


        // Main menu loop
        while (mainMenu(reader2, scanner) != EXIT) {
            // Loop until user exits
        }

        scanner.close();
    }

    // Main menu
    private static int mainMenu(Reader r, Scanner scanner) {
        System.out.println("*************************");
        System.out.println("Library Management System - Welcome " + r.getName() + "!");
        System.out.println("1. All books");
        System.out.println("2. Borrow books");
        System.out.println("3. Manage Order");
        System.out.println("4. Add a new book");
        System.out.println("5. Update book");
        System.out.println("6. Delete book");
        System.out.println(EXIT + ". Exit");
        System.out.print("Enter your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.println("List of all books:");
                for (Book book : books) {
                    book.print();
                }
                System.out.println(subMenu(r, scanner));
                break;
            case 2:
                System.out.println("List of borrow books:");
                borrowBooks();
                System.out.println(subMenu(r, scanner));
                break;
            case 3:
                System.out.println(orderMenu(r, scanner));
                break;
            case 4:
                addNewBook(scanner);
                break;
            case 5:
                UpdateBook(scanner);
                break;
            case 6:
                DeleteBookById(scanner);
                break;
            case EXIT:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        return choice;
    }

    // Sub Menu
    private static int subMenu(Reader r, Scanner scanner) {
        System.out.println("*************************");
        System.out.println("Sort by:");
        System.out.println("1. By Title");
        System.out.println("2. By Author");
        System.out.println("3. Search a book");
        System.out.println(EXIT + ". Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                // Implement sort by title logic here
                sortBooksByTitle();
                System.out.println("Books sorted by title:");
                for (Book book : books) {
                    book.print();
                    System.out.println("--------------------------");
                }
                break;
            case 2:
                sortBookByPulicationYear();
                System.out.println("Books sorted by publication year: ");
                for (Book book : books) {
                    book.print();
                    System.out.println("--------------------------");
                }
                // Implement sort by author logic here
                break;
            case 3:
                SearchBookByTitle(scanner);
                return subMenu(r, scanner);
            case EXIT:
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        return choice;
    }

    // Order Menu
    private static int orderMenu(Reader r, Scanner scanner){
        System.out.println("*************************");
        System.out.println("Order Manage");
        System.out.println("1. All Order");
        System.out.println("2. Create a new order");
        System.out.println(EXIT + ". Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                if (orders.isEmpty()){
                    System.out.println("No orders available.");
                    return orderMenu(r, scanner);
                }

                System.out.println("List of all books:");
                for (Order order : orders) {
                    order.printOrderDetail();
                    System.out.println("--------------------------");
                }
                break;
            case 2:
                createNewOrder(scanner);
                break;
            case EXIT:
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        return choice;
    }

    //Sort Book by title
    private static void sortBooksByTitle() {
        for (int i = 0; i < books.size() - 1; i++){
            for (int j = 0; j < books.size() - i - 1; j++){
                Book book1 = books.get(j);
                Book book2 = books.get(j + 1);
                int comparsion = 0;

                comparsion = book1.getTitle().compareToIgnoreCase(book2.getTitle());

                if (comparsion > 0){
                    books.set(j, book2);
                    books.set(j + 1, book1);
                }
            }
        }
    }

    //Sort Book by publication year 
    private static void sortBookByPulicationYear(){
        for (int i = 0; i < books.size() - 1; i++){
            for (int j = 0; j < books.size() - i - 1; j++){
                Book book1 = books.get(j);
                Book book2 = books.get(j + 1);
                int comparsion = 0;

                comparsion = Integer.compare(book1.getPublicationYear(), book2.getPublicationYear());

                if (comparsion > 0){
                    books.set(j, book2);
                    books.set(j + 1, book1);
                }
            }
        }
    }

    // Borrow Book
    private static void borrowBooks(){
        for (Book book : books){
            if("Borrow".equals(book.getStatus())){
                book.print();
            }
        }
    }

    // Add new book
    private static void addNewBook(Scanner scanner) {
        System.out.print("Enter the title of the book: ");
        String title = scanner.nextLine();

        System.out.print("Enter the author of the book: ");
        String author = scanner.nextLine();

        System.out.print("Enter the publisher of the book: ");
        String publisher = scanner.nextLine();

        System.out.print("Enter the publication year of the book: ");
        int publicationYear = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the number of pages: ");
        int pages = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the status of the book (e.g., Borrow, In Stock): ");
        String status = scanner.nextLine();

        int id = generateRandom();

        books.add(new Book(title, author, publisher, publicationYear, pages, status, id));
        System.out.println("New book added successfully!");
    }

    // Update Book
    private static void UpdateBook(Scanner scanner){
        System.out.println("Enter the id of the book: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Book book : books) {
            if (book.getId() == id){
                System.out.println("Updating details for: " + book.getTitle());

                System.out.print("Enter the new title (or press Enter to keep current): ");
                String title = scanner.nextLine();
                if (!title.isEmpty()) book.setTitle(title);

                System.out.print("Enter the new author (or press Enter to keep current): ");
                String author = scanner.nextLine();
                if (!author.isEmpty()) book.setAuthor(author);

                System.out.print("Enter the new publisher (or press Enter to keep current): ");
                String publisher = scanner.nextLine();
                if (!publisher.isEmpty()) book.setPublisher(publisher);

                System.out.print("Enter the new publication year (or press Enter to keep current): ");
                String yearInput = scanner.nextLine();
                if (!yearInput.isEmpty()) book.setPublicationYear(Integer.parseInt(yearInput));

                System.out.print("Enter the new number of pages (or press Enter to keep current): ");
                String pagesInput = scanner.nextLine();
                if (!pagesInput.isEmpty()) book.setPages(Integer.parseInt(pagesInput));

                System.out.print("Enter the new status (or press Enter to keep current): ");
                String status = scanner.nextLine();
                if (!status.isEmpty()) book.setStatus(status);

                System.out.println("Book updated successfully!");
                return;
            }
        }
    }

    //Delete Book
    private static void DeleteBookById(Scanner scanner){
        System.out.println("Enter the id of the book: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean bookFound = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                System.out.println("Deleting book: " + books.get(i).getTitle());
                books.remove(i);
                System.out.println("Book deleted successfully!");
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Book with the specified id not found.");
        }
    }


    // Search book by Title
    private static void SearchBookByTitle(Scanner scanner){
        System.out.println("Enter the title of book: ");
        String title = scanner.nextLine();
        boolean Search = false;

        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                System.out.println("Book found: ");
                book.print();
                Search = true;
                break;
            }
        }

        if (!Search){
            System.out.println("Book with the title \"" + title + "\" not found.");
        }
    }

    // Create a new order
    private static void  createNewOrder(Scanner scanner){
        System.out.println("Enter the CustomerName: ");
        String customerName = scanner.nextLine();
        int orderId = generateRandom();
        
        Order newOrder = new Order(orderId, customerName);

        System.out.println("Order created with ID: " + orderId);
        
        while (true) { 
            System.out.println("Do you want to add a book to the order? (yes/no)");
            String response = scanner.nextLine();

            if(response.equalsIgnoreCase("no")){
                break;
            }

            System.out.println("Enter book Id or title: ");
            String input = scanner.nextLine();

            Book selectedBook = null;
            for (Book book : books){
                if (String.valueOf(book.getId()).equalsIgnoreCase(input) || book.getTitle().equalsIgnoreCase(input)){
                    selectedBook = book;
                    break;
                }
            }

            if (selectedBook != null){
                newOrder.addBook(selectedBook);
                System.out.println("Book added to order: " + selectedBook.getTitle());
            } 
            else{
                System.out.println("Book not found. Please try again.");
            }
        }
        
        orders.add(newOrder);
        System.out.println("New order created successfully!");
    }

    private static int generateRandom(){
        return (int) (Math.random() * 10000);
    }
}
