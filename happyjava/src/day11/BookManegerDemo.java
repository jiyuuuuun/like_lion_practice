package day11;

public class BookManegerDemo {
    public static void main(String[] args) {
        Book book1=new Book("jun","abc",2001);
        Book book2=new Book("jun2","abc2",2001);
        Book book3=new Book("jun3","abc3",2002);
        Book book4=new Book("jun4","abc4",2004);
        Book book5=new Book("jun5","abc5",2005);
        Book book6=new Book("jun6","abc",2006);

        BookManeger bookManeger=new BookManeger();

        bookManeger.addBook(book1,book2,book3,book4,book5,book6);

        bookManeger.displayBooks();
        System.out.println("====================");
        bookManeger.deleteBook(book4);
        bookManeger.displayBooks();

        System.out.println("====================");
        bookManeger.searchBook(3,"abc");

    }
}
