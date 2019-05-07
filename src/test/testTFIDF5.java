package test;

import java.util.ArrayList;
import java.util.List;
import model.Document;
import model.InvertedIndex;
import model.Posting;
import model.Term;

/**
 *
 * @author admin
 */
public class testTFIDF5 {

    public static void main(String[] args) {
        // seting dokumen
        Document doc1 = new Document(1, "Shipment of gold damaged in a fire");
        Document doc2 = new Document(2, "delivery of silver arrived in a silver truck");
        Document doc3 = new Document(3, "shipment of gold arrived in a truck");

        // buat object invertedIndex
        InvertedIndex index = new InvertedIndex();
        // tmbahkan document ke index
        index.addNewDocument(doc1);
        index.addNewDocument(doc2);
        index.addNewDocument(doc3);

        // panggil fungsi search
        index.makeDictionaryWithTermNumber();
        ArrayList<Term> result = index.getDictionary();
        // tampilkan isi document dan id-nya
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Term = " + result.get(i).getTerm() + ", numberOfDocument = " + result.get(i).getNumberOfDocument());
            ArrayList<Posting> tempPosting = result.get(i).getPostingList();
            for (int j = 0; j < tempPosting.size(); j++) {
                System.out.println("id_Document = " + tempPosting.get(j).getDocument().getId()
                        + ", numberOfTerm = " + tempPosting.get(j).getNumberOfTerm());

            }
        }
        //number of Document
        String tempString = "silver";
        int result2 = index.getDocumentFrequency("silver");
        System.out.println("Number of Document with " + tempString + " is = " + result2);

        //idf
        String tempString1 = "silver";
        int result3 = index.getDocumentFrequency(tempString1);
        System.out.println("IDF of  " + tempString1 + " is = " + result3);

    }
}
