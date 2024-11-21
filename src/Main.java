import java.util.ArrayList;
import java.util.List;

class Book {
    String title;
    String author;
    String isbn;
    String status; // "доступна" or "взята"

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = "доступна";
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Название: " + title + ", Автор: " + author + ", ISBN: " + isbn + ", Статус: " + status;
    }
}

class Reader {
    String name;
    List<Book> borrowedBooks;
    final int MAX_BORROWED_BOOKS = 3;

    public Reader(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() < MAX_BORROWED_BOOKS && book.status.equals("доступна")) {
            borrowedBooks.add(book);
            book.setStatus("взята");
            System.out.println(name + " взял(а) книгу: " + book.title);
        } else {
            System.out.println("Невозможно взять книгу. Достигнут лимит или книга недоступна.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setStatus("доступна");
            System.out.println(name + " вернул(а) книгу: " + book.title);
        } else {
            System.out.println(name + " не брал(а) книгу: " + book.title);
        }
    }
}

class Librarian {
    String name;

    public Librarian(String name) {
        this.name = name;
    }

    public void manageBooks(Library library) {
        // Добавление, удаление, изменение информации о книгах и т.д. (Реализация опущена для краткости)
    }
}

class Library {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> searchBook(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.title.toLowerCase().contains(query.toLowerCase()) ||
                    book.author.toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.status.equals("доступна")) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}


public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("1984", "Джордж Оруэлл", "978-0451524935"));
        library.addBook(new Book("Гордость и предубеждение", "Джейн Остин", "978-0141439518"));
        library.addBook(new Book("Властелин колец", "Дж.Р.Р. Толкин", "978-0618002255"));

        Reader reader1 = new Reader("Алиса");
        Librarian librarian1 = new Librarian("Боб");


        System.out.println("Доступные книги:");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
        }

        reader1.borrowBook(library.searchBook("1984").get(0));
        reader1.borrowBook(library.searchBook("Гордость").get(0));


        System.out.println("\nДоступные книги после взятия:");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
        }

        reader1.returnBook(library.searchBook("1984").get(0));

        System.out.println("\nДоступные книги после возврата:");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
        }

        System.out.println("\nВсе книги в библиотеке:");
        for (Book book : library.getAllBooks()) {
            System.out.println(book);
        }

        System.out.println("\nРезультаты поиска по запросу 'колец':");
        for (Book book : library.searchBook("колец")) {
            System.out.println(book);
        }
    }
}