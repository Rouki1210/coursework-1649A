
public  class Book{
    public String title;
    public String author;
    private String publisher;
    private  int publicationYear;
    private int pages;
    private int id;
    public String status;

    public Book(String title, String author, String publisher, int publicationYear, int pages, String status, int id){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.status = status;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }



    public void print() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publisher: " + publisher);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Pages: " + pages);
        System.out.println("Status: " + status);
        System.out.println("---------------------------");
    }
}