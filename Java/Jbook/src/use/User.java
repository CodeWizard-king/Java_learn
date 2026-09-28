package use;

import Ioperations.IOPeration;
import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: wzs
 * Date: 2026-04-19
 * Time: 20:32
 */
public abstract class User {
    protected String name;

    public User(String name){
        this.name=name;
    }

    public IOPeration[] ioPerations;
    public abstract int menu();

   public void doIoperation(int choice, BookList bookList){
       ioPerations[choice].work(bookList);
   }
}
