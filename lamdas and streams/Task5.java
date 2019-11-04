package lamdas;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {

        Author authorOne =  new Author("Kunal", (short) 25);
        Author authorTwo = new Author("Bala", (short) 24);
        Author authorThree = new Author("Srinivas", (short) 24);

        Book bookOne = new Book("Book1", 100);
        Book bookTwo = new Book("Book2", 200);
        Book bookThree = new Book("Book3", 300);
        Book bookFour = new Book("Book4", 400);
        Book bookFive = new Book("Book5", 500);
        Book bookSix = new Book("Book6", 600);
        Book bookSeven = new Book("Book7", 200);


        // Book1 Authors

        bookOne.setAuthors(Arrays.asList(authorOne,authorTwo));


        // Book2 Authors

        bookTwo.setAuthors(Arrays.asList(authorOne,authorThree));


        // Book3 Authors

        bookThree.setAuthors(Arrays.asList(authorTwo,authorThree));

        // Book4 Authors

        bookFour.setAuthors(Arrays.asList(authorOne,authorTwo,authorThree));

        // Book 5 Authors

        bookFive.setAuthors(Arrays.asList(authorOne));


        // Book 6  Authors

        bookSix.setAuthors(Arrays.asList(authorTwo));


        // Book 7 Authors

        bookSeven.setAuthors(Arrays.asList(authorThree));

        // Author 1 Books

        authorOne.setBooks(Arrays.asList(bookOne,bookTwo,bookFour,bookFive));

        // Author 2 Books

        authorTwo.setBooks(Arrays.asList(bookOne,bookThree,bookFour,bookSix));

        // Author 3 Books

        authorThree.setBooks(Arrays.asList(bookTwo,bookThree,bookFour,bookSeven));


        Book[] books = {bookOne, bookTwo, bookThree, bookFour, bookFive, bookSix, bookSeven};
        Author[] authors = {authorOne,authorTwo,authorThree};


        Comparator<Book> numberOfPages = Comparator.comparing(Book::getNumberOfPages);

        Comparator<Book> title = Comparator.comparing(Book::getTitle);

        Comparator<Book> numberOfPagesAndThenTitle = numberOfPages.thenComparing(title);


        //Tasks
        //3
        //I check if some/all book(s) have more than 200 pages;

        boolean allBooksHaveMoreThan200Pages = Stream.of(books).allMatch(book -> book.getNumberOfPages() > 200);
        boolean someBooksHaveMoreThan200Pages = Stream.of(books).anyMatch(book -> book.getNumberOfPages() > 200);

        //II. find the books with max and min number of pages;

        Book bookWithMinimumNumberOfPages = Stream.of(books).min(numberOfPages).get();
        Book bookWithMaximumNumberOfPages = Stream.of(books).max(numberOfPages).get();

        //III. filter books with only single author;

        Set<Book> booksWithOnlySingleAuthor = Stream.of(books).filter(book -> book.getAuthors().size() == 1).collect(Collectors.toSet());

        //IV. sort the books by number of pages/title;

        List<Book> booksSortByPagesTitle = Stream.of(books).sorted(numberOfPagesAndThenTitle).collect(Collectors.toList());

        // V. get list of all titles;
        // VI. print them using forEach method;
        List<String> allBooksTitles = Stream.of(books).map(Book::getTitle).collect(Collectors.toList());
        allBooksTitles.stream().forEach(System.out::println);

        // VII. get distinct list of all authors

        List<Author> distinctAuthors = Stream.of(books).map(book -> book.getAuthors()).flatMap(authorList -> authorList.stream()).distinct().collect(Collectors.toList());


        // 4. Use peek method for debugging intermediate streams during execution the previous task.

        List<Author> distinctAuthorsPeekDemo = Stream.of(books).map(book -> book.getAuthors()).peek(System.out::println).flatMap(authorList -> authorList.stream()).peek(System.out::println).collect(Collectors.toList());

        // 5. Use parallel stream with subtask #3.

        //I check if some/all book(s) have more than 200 pages;

        boolean allBooksHaveMoreThan200PagesParallelStreams = Stream.of(books).parallel().allMatch(book -> book.getNumberOfPages() > 200);
        boolean someBooksHaveMoreThan200PagesParallelStreams = Stream.of(books).parallel().anyMatch(book -> book.getNumberOfPages() > 200);

        //II. find the books with max and min number of pages;

        Book bookWithMinNumOfPagesUsingParallelStreams = Stream.of(books).parallel().min(numberOfPages).get();
        Book bookWithMaxNumOfPagesUsingParallelStreams = Stream.of(books).parallel().max(numberOfPages).get();

        //III. filter books with only single author;

        Set<Book> booksWithOnlySingleAuthorUsingParallelStreams = Stream.of(books).parallel().filter(book -> book.getAuthors().size() == 1).collect(Collectors.toSet());

        //IV. sort the books by number of pages/title;

        List<Book> booksSortByPagesTitleUsingParallelStream = Stream.of(books).parallel().sorted(numberOfPagesAndThenTitle).collect(Collectors.toList());

        // V. get list of all titles;
        // VI. print them using forEach method;
        List<String> allBooksTitlesUsingParallelStream = Stream.of(books).parallel().map(Book::getTitle).collect(Collectors.toList());
        allBooksTitles.stream().forEach(System.out::println);

        // VII. get distinct list of all authors

        List<Author> distinctAuthorsUsingParallelStreams = Stream.of(books).parallel().map(book -> book.getAuthors()).flatMap(authorList -> authorList.parallelStream()).distinct().collect(Collectors.toList());


        // 7. Use the Optional type for determining the title of the biggest book of some author.
        Optional<Book> srinivasBiggestBook = Stream.of(books)
                .map(book -> book.getAuthors()).peek(System.out::println)
                .flatMap(authorList -> authorList.stream()).peek(System.out::println)
                .filter(author -> author.getName().equals("Srinivas")).peek(System.out::println)
                .map(author -> author.getBooks())
                .flatMap(listOfBooks -> listOfBooks.stream())
                .max(numberOfPages);

    }
}

class Author {
    private String name;
    private short age;
    private List<Book> books;

    public Author(String name, short age) {
        this.name = name;
        this.age = age;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

class Book {
    private String title;
    private List<Author> authors;
    private int numberOfPages;

    public Book(String title, int numberOfPages) {
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + ", numberOfPages=" + numberOfPages + '}';
    }
}
