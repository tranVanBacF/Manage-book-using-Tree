/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author bac
 */
public class NodeBook {
    Book info;
    NodeBook next;
    NodeBook(){
        info =null;
        next =null;
    }
    
    NodeBook ( Book info , NodeBook next){
        this.info = info;
        this.next = next;
       // this(info,next);
    }
    NodeBook(Book info){
        this(info,null);
    }
    
}
