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
public class SetOfMembers extends Vector<Member> implements java.io.Serializable {



    void addMember(Member aMember) {
        //this doesnt work lol VVVV
        if (aMember.getName().equals("")){
            System.out.println("Member name cannot be null!");
        }
        else {
            super.add(aMember);
        }
    }
    
    
    
    public Member getMemberFromName(String memberName) {
        
        Member newMember = null;//new Member(null);
        
        for (int i = 0; i < this.size(); i++){
            if (this.get(i).getName().equals(memberName)){
                newMember = this.get(i);
                }
        }
        
        return newMember;
    }
    
    
//    public Member getMemberFromName (String memberName){
//        SetOfMembers newSetOfMembers = new SetOfMembers();
//
//        //'this' refers to a reference of the current class
//        //'super' refers to the parent of the current class
//        for (int i = 0; i < this.size(); i++) {
//            if (this.get(i).getName().equals(memberName)) { //this.get(i) means the whole book
//                newSetOfMembers.addMember(this.get(i));
//            }
//        }
//        return newSetOfMembers;
//    }

    
    
    
    
    
    
        void removeMember(Member aMember){
            super.remove(aMember);
        }
}
