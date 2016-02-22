/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mangocannon;

import java.util.Vector;
/**
 *
 * @author Kutoma
 */
public class SetOfBooks extends Vector<Book> implements java.io.Serializable {


    public SetOfBooks() {

        super();
    }

    public void addBook(Book aBook) {

        if ((aBook.getTitle().equals("") || aBook.getAuthor().equals("") || aBook.getISBNNumber().equals(""))){
            System.out.println("Please enter a Title, Author and ISBN");
        }
        else {
            super.add(aBook);
        }
    }

    public SetOfBooks findBookByAuthor(String author) {

        SetOfBooks newSetOfBooks = new SetOfBooks();

    //'this' refers to a reference of the current class
        //'super' refers to the parent of the current class
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getAuthor().equals(author)) { //this.get(i) means the whole book
                newSetOfBooks.addBook(this.get(i));
            }
        }
        return newSetOfBooks;
    }

    public SetOfBooks findBookFromTitle(String title) {

        SetOfBooks newSetOfBooks = new SetOfBooks();

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getTitle().equals(title)) {
                newSetOfBooks.addBook(this.get(i));
            }
        }
        return newSetOfBooks;
    }

    public Book findBookFromAccNumber(int accNum) {
        //Returns book not setOfBooks
        Book newBook = null;

        for (int i = 0; i < this.size(); i++){
            if (this.get(i).getAccessionNumber() == accNum) {
                newBook = this.get(i);
            }
        }
        return newBook;
    }

    public SetOfBooks findBookFromISBN(String iSBN){
        SetOfBooks newSetOfBooks = new SetOfBooks();

        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getISBNNumber().equals(iSBN)) {
                newSetOfBooks.addBook(this.get(i));
            }
        }
        return newSetOfBooks;
    }

    public void removeBook(Book aBook) {
        super.remove(aBook); //Removes aBook from the SetOfBooks vector (of type Book)
    }

}
