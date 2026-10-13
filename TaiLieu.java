import java.util.Scanner;

public abstract class TaiLieu {

    protected String maTaiLieu;
    protected String tenNXB;
    protected int soBanPhatHanh;

    public TaiLieu() {
    }

    public TaiLieu(String maTaiLieu, String tenNXB, int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.tenNXB = tenNXB;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    protected static int nhapSoNguyen(Scanner sc, String loiNhap,
                                      int giaTriNhoNhat, int giaTriLonNhat) {
        while (true) {
            System.out.print(loiNhap);
            try {
                int giaTri = Integer.parseInt(sc.nextLine().trim());
                if (giaTri >= giaTriNhoNhat && giaTri <= giaTriLonNhat) {
                    return giaTri;
                }
            } catch (NumberFormatException e) {
                // Yeu cau nhap lai neu gia tri khong phai so nguyen.
            }
            System.out.println("Gia tri khong hop le. Vui long nhap lai.");
        }
    }

    public void Nhap(Scanner sc) {
        System.out.print("Nhap ten nha xuat ban: ");
        setTenNXB(sc.nextLine().trim());

        setSoBanPhatHanh(nhapSoNguyen(sc, "Nhap so ban phat hanh: ", 1, Integer.MAX_VALUE));
    }

    public abstract String getLoai();

    public abstract String getChiTiet();

    /** Chuoi ghi vao file txt: LOAI|ma|nxb|soBan|...thuoc tinh rieng */
    public abstract String toFileString();

    public void Hien() {
            System.out.printf("| %-8s | %-6s | %-16s | %6d | %-28s |%n",
            getLoai(), getMaTaiLieu(), getTenNXB(), getSoBanPhatHanh(), getChiTiet());
    }
}