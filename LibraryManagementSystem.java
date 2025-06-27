import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    // Book class
    static class Book {
        int id;
        String title;
        boolean isIssued;

        Book(int id, String title) {
            this.id = id;
            this.title = title;
            this.isIssued = false;
        }

        void display() {
            System.out.println("Book ID: " + id + ", Title: " + title + ", Issued: " + (isIssued ? "Yes" : "No"));
        }
    }

    // User class (for future use or extension)
    static class User {
        int userId;
        String name;

        User(int userId, String name) {
            this.userId = userId;
            this.name = name;
        }
    }

    // Library class
    static class Library {
        ArrayList<Book> books = new ArrayList<>();

        void addBook(Book b) {
            books.add(b);
        }

        void showAllBooks() {
            if (books.isEmpty()) {
                System.out.println("No books available.");
            } else {
                for (Book b : books) {
                    b.display();
                }
            }
        }

        void issueBook(int bookId) {
            for (Book b : books) {
                if (b.id == bookId && !b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book issued successfully.");
                    return;
                }
            }
            System.out.println("Book not available for issuing.");
        }

        void returnBook(int bookId) {
            for (Book b : books) {
                if (b.id == bookId && b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book returned successfully.");
                    return;
                }
            }
            System.out.println(" Book was not issued or doesn't exist.");
        }
    }

    // Main method
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    lib.addBook(new Book(id, title));
                    System.out.println(" Book added.");
                    break;
                case 2:
                    lib.showAllBooks();
                    break;
                case 3:
                    System.out.print("Enter book ID to issue: ");
                    int issueId = sc.nextInt();
                    lib.issueBook(issueId);
                    break;
                case 4:
                    System.out.print("Enter book ID to return: ");
                    int returnId = sc.nextInt();
                    lib.returnBook(returnId);
                    break;
                case 5:
                    running = false;
                    System.out.println(" Exiting Library System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
