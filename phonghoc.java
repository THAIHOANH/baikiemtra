/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication17;

/**
 *
 * @author thaih
 */
public class phonghoc {
      private String maphong;
      private String daynha;
      private double dientich;
      private int sobongden;

    public phonghoc(String maphong, String daynha, double dientich, int sobongden) {
        this.maphong = maphong;
        this.daynha = daynha;
        this.dientich = dientich;
        this.sobongden = sobongden;
    }

    public String getMaphong() {
        return maphong;
    }

    public String getDaynha() {
        return daynha;
    }

    public double getDientich() {
        return dientich;
    }

    public int getSobongden() {
        return sobongden;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public void setDaynha(String daynha) {
        this.daynha = daynha;
    }

    public void setDientich(double dientich) {
        this.dientich = dientich;
    }

    public void setSobongden(int sobongden) {
        this.sobongden = sobongden;
    }

    @Override
    public String toString() {
        return "phonghoc{" + "maphong=" + maphong + ", daynha=" + daynha + ", dientich=" + dientich + ", sobongden=" + sobongden + '}';
    }
}

   
   

          
   
