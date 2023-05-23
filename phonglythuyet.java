/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication17;

/**
 *
 * @author thaih
 */
public class phonglythuyet extends phonghoc{
   private boolean comaychieu;
    
   public phonglythuyet(String maphong, String daynha,double dientich, int sobongden,boolean comaychieu){
       super(maphong, daynha, dientich,sobongden);
       this.comaychieu = comaychieu;
   }
   public boolean iscomaychieu(){
       return comaychieu;
   }

    @Override
    public String toString() {
        return "phonglythuyet{" + super.toString()+  "comaychieu=" + comaychieu + '}';
    }
   
}
