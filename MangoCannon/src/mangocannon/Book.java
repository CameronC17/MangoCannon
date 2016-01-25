
package mangocannon;

public class Book implements java.io.Serializable {

    private String title;
    private Member borrower = null;
    private static int bookCount = 0;
    private int accessionNumber;
    private String author;
    private String iSBNNumber;

    public Book(String bookTitle, String bookAuthor, String ISBNNum){
        title = bookTitle;
        accessionNumber = bookCount++;
        author = bookAuthor;
        iSBNNumber = ISBNNum;
    }
    
    void setTitle(String theTitle){
        this.title = theTitle;
    }
    
    String getTitle(){
        return title;
    }

    void setCurrentBorrower(Member theBorrower) {
        this.borrower = theBorrower;
    }

    Member getBorrower() {
        return borrower;
    }
    
    int getBookCount() {
        return bookCount;
    }
    
    int getAccessionNumber() {
        return accessionNumber;
    }
      
    void setAuthor(String theAuthor){
        this.author = theAuthor;
    }
    
    String getAuthor(){
        return author;
    }
    
    void setISBNNumber (String theISBNNumber) {
        this.iSBNNumber = theISBNNumber;
    }
    
    String getISBNNumber() {
        return iSBNNumber;
    }
    
    //Methods
    
    @Override
    public String toString(){
        return  ("Title: " + this.title + " Author: " +this.author + " ISBN Number: " + this.iSBNNumber);
    }
    
    //boolean isOnLoan(){
        
    //}
    
    
}
