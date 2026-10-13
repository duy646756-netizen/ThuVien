import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Bao extends TaiLieu {

    private static final DateTimeFormatter DINH_DANG_NGAY = new DateTimeFormatterBuilder()
            .appendPattern("dd/MM/uuuu")
            .toFormatter()
            .withResolverStyle(ResolverStyle.STRICT);

    private String ngayPhatHanh;

    public Bao() {
    }

    public Bao(String maTaiLieu, String tenNXB, int soBanPhatHanh,
               String ngayPhatHanh) {
        super(maTaiLieu, tenNXB, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public String getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public void Nhap(Scanner sc) {
        super.Nhap(sc);
        int ngay = nhapSoNguyen(sc, "Nhap ngay phat hanh: ", 1, 31);
        int thang = nhapSoNguyen(sc, "Nhap thang phat hanh: ", 1, 12);
        int nam = nhapSoNguyen(sc, "Nhap nam phat hanh: ", 1, 9999);
        while (true) {
            try {
                LocalDate ngayPhatHanh = LocalDate.of(nam, thang, ngay);
                setNgayPhatHanh(DINH_DANG_NGAY.format(ngayPhatHanh));
                return;
            } catch (DateTimeException e) {
                System.out.println("Ngay khong hop le. Vui long nhap lai ngay.");
                ngay = nhapSoNguyen(sc, "Nhap ngay phat hanh: ", 1, 31);
            }
        }
    }

    @Override
    public String getLoai() {
        return "Bao";
    }

    @Override
    public String getChiTiet() {
                return "Ngay " + ngayPhatHanh;
    }

    @Override
    public String toFileString() {
        return "BAO|" + maTaiLieu + "|" + tenNXB + "|" + soBanPhatHanh
                + "|" + ngayPhatHanh;
    }
}
