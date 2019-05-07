/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testLucene;

import java.io.StringReader;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.en.EnglishAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

/**
 *
 * @author admin
 */
public class Test_StopWordToken {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text = ": me and my girlfriend watching a sex movie together ";
        System.out.println("Text"+ text);
        Version matchVersion = Version.LUCENE_7_7_0;
        Analyzer analyzer = new StandardAnalyzer();
        analyzer.setVersion(matchVersion);
        
        CharArraySet stopWords = EnglishAnalyzer.getDefaultStopSet();
        
        TokenStream tokenStream = analyzer.tokenStream("myField",
                new StringReader(text.trim()));
        
        tokenStream = new StopFilter(tokenStream, stopWords);
        StringBuilder sb = new StringBuilder();
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        try {
            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                String term = charTermAttribute.toString();
                sb.append(term + " ");
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
        String newText = sb.toString();
        System.out.println("New Text = "+newText);
    }
        
    }
    

