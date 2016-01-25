/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

/**
 *
 * @author Kutoma
 */
public class Member implements java.io.Serializable {
    private String name;
    private int memberNumber;
    private SetOfBooks currentLoans = new SetOfBooks();
    private static int memberCount = 0;
    
    //Constructor
    public Member(String aName){
     name = aName;
     memberNumber = memberCount++;
     currentLoans = new SetOfBooks();
    }

    //Gets 'nd sets
    public String getName(){
        return name;
    } 
    
    public void setName (String theName){
        this.name = theName;
    }
    
    public int getMemberNumber(){
        return memberNumber;
    }
    
    public void setMemberNumber(int theMemberNumber){
        this.memberNumber = theMemberNumber;
    }
    
    public SetOfBooks getCurrentLoans() {
        return currentLoans;
    }
    
    public int getMemberCount() {
        return memberCount;
    }
    
    
    public String toString(){
        return Integer.toString(memberNumber) + ": " + name;
    }

    public void borrowBook(Book aBook){
        currentLoans.addBook(aBook);
        aBook.setCurrentBorrower(this);
    }
    
    public void returnBook(Book aBook){
        currentLoans.removeBook(aBook);
        aBook.setCurrentBorrower(null);
    }

}

