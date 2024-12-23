package day11;

import java.util.ArrayList;
import java.util.List;

public class BookManeger {

    public static final int SEARCH_TITLE=1;
    public static final int SEARCH_YEAR=2;
    public static final int SEARCH_AUTHOR=3;

    List<Book> bookList=new ArrayList<>();

    public void addBook(Book...books){
        for(int i=0;i<books.length;i++) {
            bookList.add(books[i]);
        }
    }

    public void deleteBook(Book book){
        for(int i=0;i<bookList.size();i++){
            Book b= bookList.get(i);
            if(b.title.equals(book.title)){
                bookList.remove(i);
                break;
            }
        }
    }
    public void displayBooks(){
        for(Book b:bookList){
            System.out.println(b);
        }
    }

    public void searchBook(int num,String text){
        List<Book>list=new ArrayList<>();
        switch (num){
            case 1:
                for(Book b:bookList){
                    if(b.title.equals(text)){
                        list.add(b);
                    }
                }
                for(Book b:list){
                    System.out.println(b);
                }
                break;
            case 2:
                for(Book b:bookList){
                    int textToInt = Integer.parseInt(text);
                    if(b.year==textToInt){
                        list.add(b);
                    }
                }
                for(Book b:list){
                    System.out.println(b);
                }
                break;
            case 3:
                for(Book b:bookList){
                    if(b.author.equals(text)){
                        list.add(b);
                    }
                }
                for(Book b:list){
                    System.out.println(b);
                }
                break;
        }

    }
}
