/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication19;

/**
 *
 * @author thaih
 */
import java.util.*;
import java.io.*;

class KhachHang {
    private String soCMND;
    private String ten;
    private String gaDen;
    private double giaTien;

    public KhachHang(String soCMND, String ten, String gaDen, double giaTien) {
        this.soCMND = soCMND;
        this.ten = ten;
        this.gaDen = gaDen;
        this.giaTien = giaTien;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public String getTen() {
        return ten;
    }

    public String getGaDen() {
        return gaDen;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGaDen(String gaDen) {
        this.gaDen = gaDen;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    
}

public class QuanLyVeTau {
    private List<KhachHang> danhSachChoMuaVe;
    private List<KhachHang> danhSachDaMuaVe;

    public QuanLyVeTau() {
        danhSachChoMuaVe = new ArrayList<>();
        danhSachDaMuaVe = new ArrayList<>();
    }

    public void themKhachHangChoMuaVe(String soCMND, String ten, String gaDen, double giaTien) {
        KhachHang khachHang = timKhachHangTheoSoCMND(soCMND);
        if (khachHang != null) {
            khachHang = new KhachHang(soCMND, ten, gaDen, giaTien);
            danhSachChoMuaVe.add(khachHang);
            System.out.println("Thêm khách hàng vào danh sách chờ mua vé thành công.");
        } else {
            System.out.println("Khách hàng đã tồn tại. Chỉ cập nhật ga đến và giá tiền.");
            khachHang.setGaDen(gaDen);
            khachHang.setGiaTien(giaTien);
        }
    }

    public void banVeChoKhachHang() {
        if (danhSachChoMuaVe.isEmpty()) {
            System.out.println("Không có khách hàng nào trong danh sách chờ mua vé.");
        } else {
            KhachHang khachHang = danhSachChoMuaVe.remove(0);
            danhSachDaMuaVe.add(khachHang);
            System.out.println("Đã bán vé cho khách hàng: " + khachHang.getTen());
        }
    }

    public void hienThiDanhSachKhachHang() {
        if (danhSachChoMuaVe.isEmpty()) {
            System.out.println("Không có khách hàng nào trong danh sách chờ mua vé.");
        } else {
            System.out.println("Danh sách khách hàng chờ mua vé:");
            for (KhachHang khachHang : danhSachChoMuaVe) {
                System.out.println("Số CMND: " + khachHang.getSoCMND());
                System.out.println("Tên: " + khachHang.getTen());
                System.out.println("Ga đến: " + khachHang.getGaDen());
                System.out.println("Giá tiền: " + khachHang.getGiaTien());
                System.out.println("------------------------");
            }
        }
    }

    public void huyKhachHang(String soCMND) {
        KhachHang khachHang = timKhachHangTheoSoCMND(soCMND);
        if (khachHang != null) {
            danhSachChoMuaVe.remove(khachHang);
            System.out.println("Đã hủy khách hàng: " + khachHang.getTen());
        } else {
            System.out.println("Không tìm thấy khách hàng có số CMND: " + soCMND);
        }
    }

    public void thongKeTinhHinhBanVe() {
        int soKhachHangCho = danhSachChoMuaVe.size();
        int soKhachHangDaMua = danhSachDaMuaVe.size();
        double tongTienThuVe = 0;

        for (KhachHang khachHang : danhSachDaMuaVe) {
            tongTienThuVe += khachHang.getGiaTien();
        }

        System.out.println("Số khách hàng chờ nhận vé: " + soKhachHangCho);
        System.out.println("Số khách hàng đã nhận vé: " + soKhachHangDaMua);
        System.out.println("Tổng số tiền đã thu về: " + tongTienThuVe);
    }

    public void luuDanhSachVaoFile(String tenFile) {
        try {
            FileWriter writer = new FileWriter(tenFile);
            for (KhachHang khachHang : danhSachChoMuaVe) {
                writer.write(khachHang.getSoCMND() + "," + khachHang.getTen() + "," +
                        khachHang.getGaDen() + "," + khachHang.getGiaTien() + "\n");
            }
            writer.close();
            System.out.println("Danh sách khách hàng đã được lưu vào file: " + tenFile);
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể lưu danh sách vào file.");
        }
    }

    public void taiDanhSachTuFile(String tenFile) {
        danhSachChoMuaVe.clear();

        try {
            FileReader reader = new FileReader(tenFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] khachHangData = line.split(",");
                if (khachHangData.length == 4) {
                    String soCMND = khachHangData[0];
                    String ten = khachHangData[1];
                    String gaDen = khachHangData[2];
                    double giaTien = Double.parseDouble(khachHangData[3]);
                    KhachHang khachHang = new KhachHang(soCMND, ten, gaDen, giaTien);
                    danhSachChoMuaVe.add(khachHang);
                }
            }
            bufferedReader.close();
            System.out.println("Danh sách khách hàng đã được tải từ file: " + tenFile);
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi: File không tồn tại.");
        } catch (IOException e) {
            System.out.println("Lỗi: Không thể tải danh sách từ file.");
        }
    }

    public void hienThiDanhSachGaChuaMuaVe() {
        Set<String> dsGaDen = new HashSet<>();

        for (KhachHang khachHang : danhSachChoMuaVe) {
            dsGaDen.add(khachHang.getGaDen());
        }

        System.out.println("Danh sách các ga đang chờ mua vé:");
        for (String gaDen : dsGaDen) {
            System.out.println(gaDen);
        }
    }

    public void hienThiDanhSachGaVaSoVeTuongUng() {
        Map<String, Integer> dsGaDenSoVe = new HashMap<>();

        for (KhachHang khachHang : danhSachChoMuaVe) {
            String gaDen = khachHang.getGaDen();
            if (dsGaDenSoVe.containsKey(gaDen)) {
                int soVe = dsGaDenSoVe.get(gaDen);
                dsGaDenSoVe.put(gaDen, soVe + 1);
            } else {
                dsGaDenSoVe.put(gaDen, 1);
            }
        }

        System.out.println("Danh sách các ga đang chờ mua vé và số vé tương ứng:");
        for (Map.Entry<String, Integer> entry : dsGaDenSoVe.entrySet()) {
            System.out.println("Ga đến: " + entry.getKey() + ", Số vé: " + entry.getValue());
        }
    }

    private KhachHang timKhachHangTheoSoCMND(String soCMND) {
        for (KhachHang khachHang : danhSachChoMuaVe) {
            if (khachHang.getSoCMND().equals(soCMND)) {
                return khachHang;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyVeTau quanLyVeTau = new QuanLyVeTau();
        quanLyVeTau.taiDanhSachTuFile("danh_sach_khach_hang.txt");

        while (true) {
            System.out.println("----- QUẢN LÝ VÉ TÀU -----");
            System.out.println("1. Thêm một khách hàng mới vào hàng đợi mua vé");
            System.out.println("2. Bán một vé cho khách hàng");
            System.out.println("3. Hiển thị danh sách khách hàng");
            System.out.println("4. Hủy một khách hàng ra khỏi danh sách");
            System.out.println("5. Thống kê tình hình bán vé");
            System.out.println("6. Lưu danh sách vào file");
            System.out.println("7. Hiển thị danh sách các ga đang chờ mua vé");
            System.out.println("8. Hiển thị danh sách các ga đang chờ mua vé và số vé tương ứng cho ga");
            System.out.println("0. Thoát chương trình");

            System.out.print("Vui lòng chọn một mục: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line

            switch (choice) {
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    System.exit(0);
                case 1:
                    System.out.print("Nhập số CMND khách hàng: ");
                    String soCMND = scanner.nextLine();
                    System.out.print("Nhập tên khách hàng: ");
                    String ten = scanner.nextLine();
                    System.out.print("Nhập ga đến: ");
                    String gaDen = scanner.nextLine();
                    System.out.print("Nhập giá tiền: ");
                    double giaTien = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ dòng new line
                    quanLyVeTau.themKhachHangChoMuaVe(soCMND, ten, gaDen, giaTien);
                    break;
                case 2:
                    quanLyVeTau.banVeChoKhachHang();
                    break;
                case 3:
                    quanLyVeTau.hienThiDanhSachKhachHang();
                    break;
                case 4:
                    System.out.print("Nhập số CMND khách hàng cần hủy: ");
                    String cmndHuy = scanner.nextLine();
                    quanLyVeTau.huyKhachHang(cmndHuy);
                    break;
                case 5:
                    quanLyVeTau.thongKeTinhHinhBanVe();
                    break;
                case 6:
                    quanLyVeTau.luuDanhSachVaoFile("danh_sach_khach_hang.txt");
                    break;
                case 7:
                    quanLyVeTau.hienThiDanhSachGaChuaMuaVe();
                    break;
                case 8:
                    quanLyVeTau.hienThiDanhSachGaVaSoVeTuongUng();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}

