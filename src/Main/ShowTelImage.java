/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.awt.Desktop;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/**
 *
 * @author lukas
 */
public class ShowTelImage{
    
    public static String imga;
    public static String data1;
    public static String data2;
    public  String data3;
    public static String data4;
    AddUser adduser = new AddUser();
    String nip2 = adduser.nipcampany;
    Desktop d = Desktop.getDesktop();
    public ShowTelImage(){
            takeData();
            //d.browse(URI.create("http://www.krs-online.com.pl"));
    }
private void takeData(){
         

             //System.out.print(mark);
              try {
                 Document doc = Jsoup.connect("http://www.krs-online.com.pl/?p=25&lookn="+nip2+"&sprawdz=Sprawd%BC").userAgent("mozilla/17.0").get();
                 Elements name1 = doc.select("#main > div:nth-child(7) > p > a");
                 for (Element el : name1) {
                     imga = el.absUrl("href");
                 }

             } catch (IOException ex) {
                 //Logger.getLogger(ShowTelImage.class.getName()).log(Level.SEVERE, null, ex);
                 //errorKrs();
                 JOptionPane.showMessageDialog(null, "Przejdz do strony http://www.krs-online.com.pl i wprowadź kod z obrazka");
             }
             try {
                 Document doc = Jsoup.connect(imga).userAgent("mozilla/17.0").get();
                 Elements name = doc.select("#main > div:nth-child(4) > table:nth-child(1) > tbody > tr:nth-child(1) > th > b");
                 for (Element el : name) {
                     data1= el.text();
                     //System.out.println(data1);
                 }
                 Elements street = doc.select("#main > table:nth-child(8) > tbody > tr:nth-child(8) > td");
                 for (Element el : street) {
                     data2= el.text();
                     //System.out.println(data2);
                 }
                 Elements city = doc.select("#main > table:nth-child(8) > tbody > tr:nth-child(6) > td");
                 for (Element el : city) {
                     data3 = el.text();
                     //System.out.println(data3);
                 }
                 Elements postocode = doc.select("#main > table:nth-child(8) > tbody > tr:nth-child(7) > td");
                 for (Element el : postocode) {
                     data4= el.text();
                     //System.out.println(data4);
                 }

             } catch (IOException ex) {
                 //Logger.getLogger(ShowTelImage.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Przejdz do strony http://www.krs-online.com.pl i wprowadź kod z obrazka");
             }
             //System.out.print(imga);

    }
     
}
