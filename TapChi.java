import java.util.Scanner;

public class TapChi extends TaiLieu {

    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChi() {
    }

    public TapChi(String maTaiLieu, String tenNXB, int soBanPhatHanh,
                  int soPhatHanh, int thangPhatHanh) {
        super(maTaiLieu, tenNXB, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    public int getSoPhatHanh() {
        return soPhatHanh;
    }

    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }

    public int getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public void Nhap(Scanner sc) {
        super.Nhap(sc);
        setSoPhatHanh(nhapSoNguyen(sc, "Nhap so phat hanh: ", 1, Integer.MAX_VALUE));
        setThangPhatHanh(nhapSoNguyen(sc, "Nhap thang phat hanh: ", 1, 12));
    }

    @Override
    public String getLoai() {
        return "Tap chi";
    }

    @Override
    public String getChiTiet() {
                return "So " + soPhatHanh + " - thang " + thangPhatHanh;
    }

    @Override
    public String toFileString() {
        return "TAPCHI|" + maTaiLieu + "|" + tenNXB + "|" + soBanPhatHanh
                + "|" + soPhatHanh + "|" + thangPhatHanh;
    }
}
