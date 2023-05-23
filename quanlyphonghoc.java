/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication17;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author thaih
 */
public class quanlyphonghoc {
    private List<phonghoc> danhsachphonghoc;

    public quanlyphonghoc() {
        danhsachphonghoc = new ArrayList<>();
    }

    public boolean themphonghoc(phonghoc phongHoc) {
        if (!kiemTraTonTai(phongHoc.getMaphong())) {
            danhsachphonghoc.add(phongHoc);
            return true;
        }
        return false;
    }

    public phonghoc timphonghoctheoma(String maphong) {
        for (phonghoc phonghoc : danhsachphonghoc) {
            if (phonghoc.getMaphong().equals(maphong)) {
                return phonghoc;
            }
        }
        return null;
    }

    public void intoanbodanhsachphonghoc() {
        for (phonghoc phonghoc : danhsachphonghoc) {
            System.out.println(phonghoc);
        }
    }

    public void inDanhSachPhongHocDatChuan() {
        for (phonghoc phonghoc : danhsachphonghoc) {
            if (phonghoc instanceof phonglythuyet) {
                phonglythuyet phongLyThuyet = (phonglythuyet) phonghoc;
                if (phongLyThuyet.iscomaychieu() && phonghoc.getSobongden()>= phonghoc.getDientich()/ 10) {
                    System.out.println(phonghoc);
                }
            } else if (phonghoc instanceof phongmaytinh) {
                phongmaytinh phongmaytinh = (phongmaytinh) phonghoc;
                if (phongmaytinh.getSomaytinh() >= phonghoc.getDientich() / 1.5
                        && phonghoc.getSobongden() >= phonghoc.getDientich() / 10) {
                    System.out.println(phonghoc);
                }
            } else if (phonghoc instanceof phongthinghiem) {
                phongthinghiem phongThiNghiem = (phongthinghiem) phonghoc;
                if (phongThiNghiem.iscobonrua() && phonghoc.getSobongden() >= phonghoc.getDientich() / 10) {
                    System.out.println(phonghoc);
                }
            }
        }
    }

    public void sapXepTheoDayNhaTangDan() {
        danhsachphonghoc.sort(Comparator.comparing(phonghoc::getDaynha));
    }

    public void sapXepTheoDienTichGiamDan() {
        danhsachphonghoc.sort(Comparator.comparing(phonghoc::getDientich).reversed());
    }

    public void sapXepTheoSoBongDenTangDan() {
        danhsachphonghoc.sort(Comparator.comparing(phonghoc::getSobongden));
    }

    public void capNhatSoMayTinh(String maPhong, int soMayTinhMoi) {
        for (phonghoc phonghoc : danhsachphonghoc) {
            if (phonghoc instanceof phongmaytinh && phonghoc.getMaphong().equals(maPhong)) {
                phongmaytinh phongMayTinh = (phongmaytinh) phonghoc;
                phongMayTinh.setSomaytinh(soMayTinhMoi);
                break;
            }
        }
    }

    public boolean xoaPhongHoc(String maPhong) {
        for (phonghoc phonghoc : danhsachphonghoc) {
            if (phonghoc.getMaphong().equals(maPhong)) {
                danhsachphonghoc.remove(phonghoc);
                return true;
            }
        }
        return false;
    }

    public void inTongSoPhongHoc() {
        System.out.println("Tong so phong hoc: " + danhsachphonghoc.size());
    }

    public void inDanhSachPhongMayCoSoMayTinh(int soMayTinh) {
        for (phonghoc phongHoc : danhsachphonghoc) {
            if (phongHoc instanceof phongmaytinh) {
                phongmaytinh phongMayTinh = (phongmaytinh) phongHoc;
                if (phongMayTinh.getSomaytinh() == soMayTinh) {
                    System.out.println(phongHoc);
                }
            }
        }
    }

    private boolean kiemTraTonTai(String maPhong) {
        for (phonghoc phongHoc : danhsachphonghoc) {
            if (phongHoc.getMaphong().equals(maPhong)) {
                return true;
            }
        }
        return false;
    }

}
