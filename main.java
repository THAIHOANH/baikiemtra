/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication17;

import java.util.Scanner;

/**
 *
 * @author thaih
 */
public class main {
    public static void main(String[]args){
               quanlyphonghoc quanLyPhongHoc = new quanlyphonghoc();
 Scanner scanner = new Scanner(System.in);
       int luaChon;
        do {
            System.out.println("1. Thêm phòng học");
            System.out.println("2. Tìm kiếm phòng học theo mã");
            System.out.println("3. In toàn bộ danh sách phòng học");
            System.out.println("4. In danh sách phòng học đạt chuẩn");
            System.out.println("5. Sắp xếp danh sách tăng dần theo dãy nhà");
            System.out.println("6. Sắp xếp danh sách giảm dần theo diện tích");
            System.out.println("7. Sắp xếp danh sách tăng dần theo số bóng đèn");
            System.out.println("8. Cập nhật số máy tính cho một phòng máy tính");
            System.out.println("9. Xóa một phòng học");
            System.out.println("10. In tổng số phòng học");
            System.out.println("11. In danh sách phòng máy có số máy tính");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập mã phòng: ");
                    String maPhong = scanner.next();
                    System.out.print("Nhập dãy nhà: ");
                    String dayNha = scanner.next();
                    System.out.print("Nhập diện tích: ");
                    double dienTich = scanner.nextDouble();
                    System.out.print("Nhập số bóng đèn: ");
                    int soBongDen = scanner.nextInt();

                    System.out.println("Loại phòng học:");
                    System.out.println("1. Phòng lý thuyết");
                    System.out.println("2. Phòng máy tính");
                    System.out.println("3. Phòng thí nghiệm");
                    System.out.print("Nhập lựa chọn của bạn: ");
                    int loaiPhong = scanner.nextInt();

                    switch (loaiPhong) {
                        case 1:
                            System.out.print("Có máy chiếu ? (true/false): ");
                            boolean coMayChieu = scanner.nextBoolean();
                            phonglythuyet phongLyThuyet = new phonglythuyet(maPhong, dayNha, dienTich, soBongDen,
                                    coMayChieu);
                            if (quanLyPhongHoc.themphonghoc(phongLyThuyet)) {
                                System.out.println("Thêm phòng học thành công!");
                            } else {
                                System.out.println("Mã phòng đã tồn tại!");
                            }
                            break;
                        case 2:
                            System.out.print("Nhấp số máy tính: ");
                            int soMayTinh = scanner.nextInt();
                            phongmaytinh phongMayTinh = new phongmaytinh(maPhong, dayNha, dienTich, soBongDen,
                                    soMayTinh);
                            if (quanLyPhongHoc.themphonghoc(phongMayTinh)) {
                                System.out.println("Thêm phòng học thành công!");
                            } else {
                                System.out.println("Mã phòng đã tồn tại!");
                            }
                            break;
                        case 3:
                            System.out.print("Nhập chuyên ngành: ");
                            String chuyenNganh = scanner.next();
                            System.out.print("Nhập sức chứa: ");
                            int sucChua = scanner.nextInt();
                            System.out.print("Có bồn rửa? (true/false): ");
                            boolean coBonRua = scanner.nextBoolean();
                            phongthinghiem phongThiNghiem = new phongthinghiem(maPhong, dayNha, dienTich, soBongDen,
                                    chuyenNganh, sucChua, coBonRua);
                            if (quanLyPhongHoc.themphonghoc(phongThiNghiem)) {
                                System.out.println("Thêm phòng học thành công!");
                            } else {
                                System.out.println("Mã phòng đã tồn tại!");
                            }
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Nhập mã phòng cần tìm: ");
                    String maPhongTimKiem = scanner.next();
                    phonghoc phongHocTimKiem = quanLyPhongHoc.timphonghoctheoma(maPhongTimKiem);
                    if (phongHocTimKiem != null) {
                        System.out.println(phongHocTimKiem);
                    } else {
                        System.out.println("Không tìm thấy phòng học!");
                    }
                    break;
                case 3:
                    quanLyPhongHoc.intoanbodanhsachphonghoc();
                    break;
                case 4:
                    quanLyPhongHoc.inDanhSachPhongHocDatChuan();
                    break;
                case 5:
                    quanLyPhongHoc.sapXepTheoDayNhaTangDan();
                    System.out.println("Đã sắp xếp danh sách tăng dần theo dãy nhà!");
                    break;
                case 6:
                    quanLyPhongHoc.sapXepTheoDienTichGiamDan();
                    System.out.println("Đã sắp xếp danh sách giảm dần theo diện tích!");
                    break;
                case 7:
                    quanLyPhongHoc.sapXepTheoSoBongDenTangDan();
                    System.out.println("Đã sắp xếp danh sách tăng dần theo số bóng đèn!");
                    break;
                case 8:
                    System.out.print("Nhập mã phòng máy tính cần cập nhật: ");
                    String maPhongCapNhat = scanner.next();
                    System.out.print("Nhập số máy tính mới: ");
                    int soMayTinhMoi = scanner.nextInt();
                    quanLyPhongHoc.capNhatSoMayTinh(maPhongCapNhat, soMayTinhMoi);
                    System.out.println("Đã cập nhật số máy tính cho phòng học!");
                    break;
                case 9:
                    System.out.print("Nhập mã phòng học cần xóa: ");
                    String maPhongXoa = scanner.next();
                    if (quanLyPhongHoc.xoaPhongHoc(maPhongXoa)) {
                        System.out.println("Đã xóa phòng học!");
                    } else {
                        System.out.println("Không tìm thấy phòng học!");
                    }
                    break;
                case 10:
                   quanLyPhongHoc.inTongSoPhongHoc();
                    break;
                case 11:
                    quanLyPhongHoc.inDanhSachPhongMayCoSoMayTinh(60);
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (luaChon != 0);

        scanner.close();
    }
}
