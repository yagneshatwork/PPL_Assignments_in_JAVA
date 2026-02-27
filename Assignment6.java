import java.util.*;


//Expense Class
class Expense
{
 private String date;   // Format: YYYY-MM-DD
 private double amount;
 private String category;


 public Expense(String date, double amount, String category)
 {
     this.date = date;
     this.amount = amount;
     this.category = category;
 }


 public String getDate()
 {
     return date;
 }


 public double getAmount()
 {
     return amount;
 }


 public String getCategory()
 {
     return category;
 }


 // Extract Month-Year in MM-YYYY format
 public String getMonthYear()
 {
     return date.substring(5, 7) + "-" + date.substring(0, 4);
 }


 // Display Method
 public void display()
 {
     System.out.println("Date: " + date +
                        " | Amount: ₹" + amount +
                        " | Category: " + category);
 }
}


//Expense Manager Class
class ExpenseManager
{
 private ArrayList<Expense> expenseList = new ArrayList<>();


 // Add Expense
 public void addExpense(String date, double amount, String category)
 {
     Expense e = new Expense(date, amount, category);
     expenseList.add(e);
     System.out.println("Expense added successfully!");
 }


 // Delete Expense
 public void deleteExpense(int index)
 {
     if (expenseList.isEmpty())
     {
         System.out.println("Empty records!");
         return;
     }


     if (index >= 0 && index < expenseList.size())
     {
         Expense removed = expenseList.remove(index);
         System.out.print("Deleted Expense: ");
         removed.display();
     }
     else
     {
         System.out.println("Error: Invalid expense index!");
     }
 }


 // View Expenses
 public void viewExpenses()
 {
     if (expenseList.isEmpty())
     {
         System.out.println("No expenses recorded.");
         return;
     }


     System.out.println("\n===== ALL EXPENSES =====");


     for (int i = 0; i < expenseList.size(); i++)
     {
         System.out.print(i + ". ");
         expenseList.get(i).display();
     }
 }


 // Generate Monthly Report 
 public void generateReport(String monthYear)
 {
     if (expenseList.isEmpty())
     {
         System.out.println("No expenses recorded.");
         return;
     }


     HashMap<String, Double> categoryTotal = new HashMap<>();
     double totalExpense = 0;


     for (Expense e : expenseList)
     {
         if (e.getMonthYear().equals(monthYear))
         {
             totalExpense += e.getAmount();


             categoryTotal.put(
                 e.getCategory(),
                 categoryTotal.getOrDefault(e.getCategory(), 0.0) + e.getAmount()
             );
         }
     }


     if (totalExpense == 0)
     {
         System.out.println("No expenses found for " + monthYear);
         return;
     }


     System.out.println("\n===== MONTHLY REPORT: " + monthYear + " =====");
     System.out.println("Total Expenses: ₹" + totalExpense);


     System.out.println("\nBy Category:");
     for (String category : categoryTotal.keySet())
     {
         System.out.println(category + " : ₹" + categoryTotal.get(category));
     }
 }
}


//Main Class 
public class Assignment6
{
 public static void main(String[] args)
 {
     Scanner sc = new Scanner(System.in);
     ExpenseManager manager = new ExpenseManager();
     int choice;


     do
     {
         System.out.println("\n===== EXPENSE TRACKER MENU =====");
         System.out.println("1. Add Expense");
         System.out.println("2. Delete Expense");
         System.out.println("3. View Expenses");
         System.out.println("4. Generate Monthly Report");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");


         choice = sc.nextInt();
         sc.nextLine();


         switch (choice)
         {
             case 1:
                 System.out.print("Enter Date (YYYY-MM-DD): ");
                 String date = sc.nextLine();


                 System.out.print("Enter Amount: ");
                 double amount = sc.nextDouble();
                 sc.nextLine();


                 System.out.print("Enter Category: ");
                 String category = sc.nextLine();


                 manager.addExpense(date, amount, category);
                 break;


             case 2:
                 manager.viewExpenses();
                 System.out.print("Enter index to delete: ");
                 int index = sc.nextInt();
                 manager.deleteExpense(index);
                 break;


             case 3:
                 manager.viewExpenses();
                 break;

 
             case 4:
                 System.out.print("Enter Month (MM-YYYY): ");
                 String monthYear = sc.nextLine();
                 manager.generateReport(monthYear);
                 break;


             case 5:
                 System.out.println("Exiting Expense Tracker...");
                 break;


             default:
                 System.out.println("Error: Invalid choice!");
         }


     } while (choice != 5);


     sc.close();
 }
}
