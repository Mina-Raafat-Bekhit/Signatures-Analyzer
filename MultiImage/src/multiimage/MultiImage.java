/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiimage;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFileChooser;

/**
 *
 * @author Mega Store
 */
public class MultiImage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
      JFileChooser  f = new JFileChooser( );
        
          int c =  f.showOpenDialog(null);
        
       if( c == JFileChooser.APPROVE_OPTION){
          
            File image = f.getSelectedFile();
                checkfile(image);
       }
      }

   public static void checkfile(File file) {
        
              try (FileInputStream x = new FileInputStream(file)) {
                    
                    byte[] n = new byte[4];
                    
                        x.read(n) ;
                         
                          
                 String image = tohex(n);
                    
                    if (  image.startsWith ("424D") ){
                        System.out.println("BMP image");}else if (  image.startsWith ("474946") ) {
                        System.out.println("GIF file");}else{
                        System.out.println("another format");}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            
        
        }
      private static String tohex(byte[] z) {
           String y = "" ;
            
       for(int i = 0; i < z.length; i++)
       {
            byte k = z[i];
            
            y  += ( String.format ("%02X", k) ) ;
         }
        return  y;}}
    

