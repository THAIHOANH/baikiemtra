/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication17;

/**
 *
 * @author thaih
 */
public class phongmaytinh extends phonghoc {
    private int somaytinh;
    
    public phongmaytinh(String maphong, String daynha, double dientich, int sobongden, int somaytinh) {
        super(maphong, daynha, dientich, sobongden);
        this.somaytinh = somaytinh;
    }

    public int getSomaytinh() {
        return somaytinh;
    }

    public void setSomaytinh(int somaytinh) {
        this.somaytinh = somaytinh;
    }

    @Override
    public String toString() {
        return "phongmaytinh{" + super.toString()+"somaytinh=" + somaytinh + '}';
    }
    
    
    
}
