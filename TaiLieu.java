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

    public void Nhap(Scanner sc) {
        System.out.print("Nhap ten nha xuat ban: ");
        setTenNXB(sc.nextLine().trim());

        System.out.print("Nhap so ban phat hanh: ");
        setSoBanPhatHanh(Integer.parseInt(sc.nextLine().trim()));
    }

    public abstract String getLoai();

    public abstract String getChiTiet();

    /** Chuoi ghi vao file txt: LOAI|ma|nxb|soBan|...thuoc tinh rieng */
    public abstract String toFileString();

    public void Hien() {
        System.out.printf("| %-8s | %-6s | %-16s | %6d | %-26s |%n",
                getLoai(), getMaTaiLieu(), getTenNXB(), getSoBanPhatHanh(), getChiTiet());
    }
}