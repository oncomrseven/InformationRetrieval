/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import model.Document;
import model.Posting;

/**
 *
 * @author admin
 */
public class testDocument {
    public static void main(String[] args) {
        Document doc1= new Document(1, "computer information retrieval");
        Document doc2= new Document(2, "computer organization and architecture");
    
        
        String tokenDoc1[]=doc1.getListofTerm();
        String tokenDoc2[]=doc2.getListofTerm();
        
        ArrayList<Posting>list= new ArrayList<Posting>();
        
        for (int i = 0; i < tokenDoc1.length; i++) {
            Posting termPosting = new Posting(tokenDoc1[i],doc1);
            
            list.add(termPosting);
            
        }
        for (int i = 0; i < tokenDoc2.length; i++) {
            Posting termPosting = new Posting(tokenDoc2[i],doc2);
            
            list.add(termPosting);
            
        }
        System.out.println("Ukuran List = "+list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTerm()+","+list.get(i).getDocument().getId());
            
        }
        
    }
}