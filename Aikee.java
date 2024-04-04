import java.util.ArrayList;
import java.util.List;

interface LibraryItem {
    void borrowItem();
    void returnItem();
    boolean isBorrowed();
}

class Book implements LibraryItem {
    private String title;
    private String author;
    private int publicationYear;
    private boolean borrowed;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("Book '" + title + "' is borrowed.");
        } else {
            System.out.println("Book '" + title + "' is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("Book '" + title + "' is returned.");
        } else {
            System.out.println("Book '" + title + "' was not borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }
}

class DVD implements LibraryItem {
    private String title;
    private String director;
    private int runningTime;
    private boolean borrowed;

    public DVD(String title, String director, int runningTime) {
        this.title = title;
        this.director = director;
        this.runningTime = runningTime;
        this.borrowed = false;
    }

    @Override
    public void borrowItem() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("DVD '" + title + "' is borrowed.");
        } else {
            System.out.println("DVD '" + title + "' is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        if (borrowed) {
            borrowed = false;
            System.out.println("DVD '" + title + "' is returned.");
        } else {
            System.out.println("DVD '" + title + "' was not borrowed.");
        }
    }

    @Override
    public boolean isBorrowed() {
        return borrowed;
    }
}

abstract class LibraryUser {
    List<LibraryItem> borrowedItems;

    public LibraryUser() {
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowItem(LibraryItem item) {
        item.borrowItem();
        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        item.returnItem();
        borrowedItems.remove(item);
    }

    public abstract void printItemsBorrowed();
}

class Student extends LibraryUser {
    @Override
    public void printItemsBorrowed() {
        System.out.println("Items borrowed by student:");
        for (LibraryItem item : borrowedItems) {
            System.out.println("- " + item.toString());
        }
    }
}

class Teacher extends LibraryUser {
    @Override
    public void printItemsBorrowed() {
        System.out.println("Items borrowed by teacher:");
        for (LibraryItem item : borrowedItems) {
            System.out.println("- " + item.toString());
        }
    }
}

public class Aikee {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Doe", 2020);
        DVD dvd1 = new DVD("Inception", "Christopher Nolan", 148);

        Student student = new Student();
        Teacher teacher = new Teacher();

        student.borrowItem(book1);
        teacher.borrowItem(dvd1);

        student.printItemsBorrowed();
        teacher.printItemsBorrowed();

        student.returnItem(book1);
        teacher.returnItem(dvd1);

        student.printItemsBorrowed();
        teacher.printItemsBorrowed();
    }
}
