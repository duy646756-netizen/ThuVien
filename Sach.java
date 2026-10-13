import java.util.Scanner;

public class Sach extends TaiLieu {

    private String tenTacGia;
    private int soTrang;

    public Sach() {
    }

    public Sach(String maTaiLieu, String tenNXB, int soBanPhatHanh,
                String tenTacGia, int soTrang) {
        super(maTaiLieu, tenNXB, soBanPhatHanh);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    @Override
    public void Nhap(Scanner sc) {
        super.Nhap(sc);
        System.out.print("Nhap ten tac gia: ");
        setTenTacGia(sc.nextLine().trim());

        setSoTrang(nhapSoNguyen(sc, "Nhap so trang: ", 1, Integer.MAX_VALUE));
    }

    @Override
    public String getLoai() {
        return "Sach";
    }

    @Override
    public String getChiTiet() {
                return tenTacGia + " - " + soTrang + " trang";
    }

    @Override
    public String toFileString() {
        return "SACH|" + maTaiLieu + "|" + tenNXB + "|" + soBanPhatHanh
                + "|" + tenTacGia + "|" + soTrang;
    }
}
