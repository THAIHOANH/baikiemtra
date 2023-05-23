/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication17;

/**
 *
 * @author thaih
 */
public class phongthinghiem extends phonghoc {
    private String chuyennganh;
    private int succhua;
    private boolean cobonrua;
    
    public phongthinghiem(String maphong, String daynha, double dientich, int sobongden,String chuyennganh,int succhua,boolean cobonrua) {
        super(maphong, daynha, dientich, sobongden);
        this.chuyennganh = chuyennganh;
        this.succhua = succhua;
        this.cobonrua = cobonrua;
    }
    public boolean iscobonrua(){
        return cobonrua;
    }

    public String getChuyennganh() {
        return chuyennganh;
    }

    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }

    public int getSucchua() {
        return succhua;
    }

    public void setSucchua(int succhua) {
        this.succhua = succhua;
    }

    public boolean isCobonrua() {
        return cobonrua;
    }

    public void setCobonrua(boolean cobonrua) {
        this.cobonrua = cobonrua;
    }

    @Override
    public String toString() {
        return "phongthinghiem{" + super.toString()+ "chuyennganh=" + chuyennganh + ", succhua=" + succhua + ", cobonrua=" + cobonrua + '}';
    }
    
    
}
