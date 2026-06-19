/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiaudio;

import java.io.File;
import java.io.FileInputStream;
import javax.swing.JFileChooser;

/**
 *
 * @author Mina Raafat
 */
public class MultiAudio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFileChooser  f = new JFileChooser( );
        
          int c =  f.showOpenDialog(null);
        
       if( c == JFileChooser.APPROVE_OPTION){
          
            File audio = f.getSelectedFile();
                checkfile(audio);
       }
      }

   public static void checkfile(File file) {
        
              try (FileInputStream x = new FileInputStream(file)) {
                    
                    byte[] m = new byte[4];
                    byte[] n = new byte[4];
                    
                        x.read(n) ;
                         x.skip(4) ;
                          x.read(m) ;
                         
                          
                 String wav = tohex(m);
                 String flac = tohex(n);
                    
                    if (  wav.startsWith ("57415645") ){
                        System.out.println("WAVE file");}else if (  flac.startsWith ("664C6143") ) {
                        System.out.println("FLAC file");}else{
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
    

