/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/**
 *
 * @author lukas
 */
public class FindKRS{
    public static String imga;
    public static String marka = "apple";
    public static String model = "iphone6s";
    
       // public FindKRS(){
           // AddOrder order = new AddOrder();
            //marka = order.mark;
           // model = order.mod;
        public static void main (String[] args){
        try {
            Document doc = Jsoup.connect("http://www.mgsm.pl/pl/katalog/"+marka+"/"+model+"/").userAgent("mozilla/17.0").get();
           Elements img = doc.select("#right-con > div:nth-child(4) > div.large-5.medium-12.small-12.columns.right-sheet-column > div:nth-child(1) > div.large-7.medium-7.columns.phone-thumb-large.text-center > a > img");
         for (Element el : img) {
                imga = el.absUrl("src");
                System.out.println(imga);
            }
           
        } catch (IOException ex) {
            Logger.getLogger(FindKRS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
} 
