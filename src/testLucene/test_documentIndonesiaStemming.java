/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testLucene;

import model.Document;


public class test_documentIndonesiaStemming {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Document doc = new Document(1, "She is looking on my eyes");
Document doc  = new Document(1, "Dia ingin berbelanja kepusat perbelanjaan "
        + " namun ibu melarangnya karena dia belum makan nasi ");

//        doc.stemming();
        doc.IndonesiaStemming();
        System.out.println("Real Content: " + doc.getRealContent());
        System.out.println("Content Stemming: " + doc.getContent());
    }
    
}