/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 *
 * @author bac
 */
public class BookList {

    NodeBook head, tail;

    BookList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    // add last
    void addLast( Book x) {

        NodeBook p =new NodeBook(x);

        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }
    //  input from file
     void loadFile(String fname) throws IOException {
        RandomAccessFile f = new RandomAccessFile(fname, "r");
        String s;
        String[] a;
        String Bcode, Tittle;
        int Quantity, Lended;
        double Price;
        Book x;
        while (true) {
            s = f.readLine();
            if (s == null || s.trim().equals("")) {
                break;
            }
            a = s.split("[|]");
            Bcode = a[0].trim();
            Tittle = a[1].trim();
            Quantity = Integer.parseInt(a[2].trim());
            Lended = Integer.parseInt(a[3].trim());
            Price = Double.parseDouble(a[4].trim());
            x = new Book(Bcode, Tittle, Quantity, Lended, Price);
            addLast(x);
        }
        f.close();
    }
     
    // 1.2  add the end
    // input node
    Book input() {
        Validate v = new Validate();
        String bcode;
        String title;
        int quantity;
        int lended;
        double price;
        Scanner in = new Scanner(System.in);
        NodeBook p;
        
        while(true){
          bcode=v.checkString("enter bcode: ");
            title=v.checkString("enterTitle: ");
            
            quantity = v.checkInt("enterQuanlity: ");
            lended = v.checkInt("enter lended: ");
            price = v.checkDouble("enter price: ");
            p = searchByBcode(bcode);
           
                
            if(p != null || lended > quantity ){
                System.out.println("  enter again: ");
               
            }
            else{
                break;
        }
    }
        Book x = new Book(bcode, title, quantity, lended, price);
       
        return x;
    }
// 1.2 add to end
    void addEnd(){
        Book p = input();
        addLast(p);
    }
    

    // display data
    void visit(NodeBook p) {
        if (p != null) {
            System.out.println(p.info);

        }
    }

    void traversal() {
        NodeBook p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println("");
    }
    // 1.5 save file
    void saveFile(String fname) throws IOException {
        File f = new File(fname);
        if (!f.exists()) {
            f.delete();
        }
        RandomAccessFile raf = new RandomAccessFile(fname, "rw");

        NodeBook p = head;
        while (p != null) {
            raf.writeBytes(p.info.bcode + "|" + p.info.title + "|" + p.info.quantity + "|"+p.info.lended+ "|" + p.info.price + "\r\n");
            p = p.next;
        }
        raf.close();
    }
    //1.5 search by bcode
    NodeBook searchByBcode(String bcode) {
        NodeBook p = head;
        while (p != null) {
            if (p.info.bcode.equals(bcode)) {
                return p;
            }
            p = p.next;
        } 
        return null;
    }
    
    //1.6
    // delete fist
    void deleFist() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
                System.out.println("dele sucess");

    }

    // dele node q
    void dele(NodeBook q) {
        if (isEmpty() || q == null) {
            return;
        }
        if (q == head) {
            deleFist();

        } else {
            NodeBook p = head;
            while (p != null && p.next != q) {
                p = p.next;
            }
            if (p == null) {
                return;
            }
            p.next = q.next;
            if (p.next == null) {
                tail = p;
            }
            System.out.println("dele sucess");
        }
    }

    // dele by bcode
    void deleByBcode(String Bcode) {
        NodeBook q = searchByBcode(Bcode);
       
        dele(q);
       
    }

    //1.7 sort by bcode
    void sortByBcode() {
        NodeBook pi, pj;
        Book x;
        pi = head;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.info.bcode.compareTo(pj.info.bcode) > 1) {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;

            }
            pi = pi.next;
        }
    }

    //1.8 addfirst
    void addFirst() {
        Book x =input();
        NodeBook p = new NodeBook(x);
       p.next = head;
       head = p;
        if (tail == null) {
            tail = head;
        }
    }
    // insert after
    void insertAfter(NodeBook q, Book x) {
        if (q == null) {
            return;
        }
        NodeBook p = new NodeBook(x, q.next);
        q.next = p;
        if (p.next == null) {
            tail = p;
        }
    }

    //1.9 insert after k
    void insertAfterPos(int k, Book x) {
        NodeBook q = new NodeBook(x);
        int count = 0;
        NodeBook p = head;
        while (p != null) {
            if (count++ == k) {
                insertAfter(p, x);
                break;
            }
            p = p.next;
        }
    }

    //1.10 dele st pos k
    void delePos(int k) {
        NodeBook p = head;
        int count = 0;
        while (p != null) {
            if (count++ == k) {
                dele(p);
                break;
            }
            p = p.next;
            
        }
        
    }
}

    