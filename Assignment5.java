import java.util.*;

//Custom Exception - Book Not Found
class BookNotFoundException extends Exception 
{
  public BookNotFoundException(String message) 
  {
      super(message);
  }
}
//Custom Exception - Book Already Issued
class BookAlreadyIssuedException extends Exception 
{
  public BookAlreadyIssuedException(String message) 
  {
      super(message);
  }
}
//Custom Exception - Invalid Return
class InvalidReturnException extends Exception 
{
  public InvalidReturnException(String message) 
  {
      super(message);
  }
}
//Book Class
class Book 
{
  String title;
  boolean isIssued;
  Book(String title) 
  {
      this.title = title;
      this.isIssued = false;
  }
}
//Library Class
class Library 
{
  ArrayList<Book> books = new ArrayList<>();
  // Constructor → Default Books
  Library() 
  {
      books.add(new Book("Java Programming"));
      books.add(new Book("Data Structures"));
      books.add(new Book("Operating Systems"));
      books.add(new Book("Database Management"));
      books.add(new Book("Computer Networks"));
  }
  // Search Book
  Book searchBook(String title) throws BookNotFoundException 
  {
      for (Book b : books) 
      {
          if (b.title.equalsIgnoreCase(title)) 
          {
              return b;
          }
      }
      throw new BookNotFoundException("Book '" + title + "' not found in the library.");
  }
  // Issue Book
  void issueBook(String title)
  throws BookNotFoundException, BookAlreadyIssuedException 
  {
      Book b = searchBook(title);
      if (b.isIssued) 
      {
          throw new BookAlreadyIssuedException(
                  "The book is already checked out!");
      }
      b.isIssued = true;
      System.out.println("\nBook checked out successfully: " + b.title);
  }
  // Return Book
  void returnBook(String title, int daysLate)
  throws BookNotFoundException, InvalidReturnException 
  {
      Book b = searchBook(title);
      if (!b.isIssued) 
      {
          throw new InvalidReturnException("Invalid return! Book was not checked out.");
      }
      if (daysLate < 0) 
      {
          throw new InvalidReturnException("Invalid return date! Days late cannot be negative.");
      }
      b.isIssued = false;
      System.out.println("\nBook returned successfully: " + b.title);
      if (daysLate > 0) 
      {
          int fine = daysLate * 10;
          System.out.println("Late Fee: ₹" + fine);
      }
  }
  // Display Books
  void displayBooks() 
  {
    System.out.println("\n--- Library Books ---");
    for (Book b : books) 
    {
        System.out.println(b.title + " - " +
                (b.isIssued ? "Checked Out" : "Available"));
    }
  }
}
//Main Class
public class Assignment5 
{
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    Library library = new Library();
    int choice;
    do 
    {
        System.out.println("\n===== Library Management System =====");
        System.out.println("1. Display Books");
        System.out.println("2. Issue Book");
        System.out.println("3. Return Book");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        try 
        {
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer
            switch (choice) 
            {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    library.issueBook(issueTitle);
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    System.out.print("Enter number of days late: ");
                    int daysLate = sc.nextInt();
                    sc.nextLine();
                    library.returnBook(returnTitle, daysLate);
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("\nError: Invalid input! Please enter correct data.");
            sc.nextLine();
            choice = 0;
        } 
        catch (BookNotFoundException |
                 BookAlreadyIssuedException |
                 InvalidReturnException e) 
        {
            System.out.println("\nError: " + e.getMessage());
        } 
        finally 
        {
            System.out.println();
        }
    } 
    while (true);
  }
}
