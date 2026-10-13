import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLy {

    private static final String FILE_DATA = "Tailieu.txt";

    private final List<TaiLieu> dsTaiLieu = new ArrayList<>();

    // ====================== FILE ======================
    public void docFile() {
        File f = new File(FILE_DATA);
        if (!f.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
            String line;
            int soDong = 0;
            while ((line = br.readLine()) != null) {
                soDong++;
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                try {
                    TaiLieu tl = parse(line);
                    if (tl != null && timTheoMa(tl.getMaTaiLieu()) == null) {
                        dsTaiLieu.add(tl);
                    }
                } catch (Exception e) {
                    System.out.println("Bo qua dong loi " + soDong + ": " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    public void ghiFile() {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(
                new FileOutputStream(FILE_DATA), StandardCharsets.UTF_8))) {
            for (TaiLieu tl : dsTaiLieu) {
                pw.println(tl.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    private TaiLieu parse(String line) {
        String[] p = line.split("\\|", -1);
        switch (p[0].trim().toUpperCase()) {
            case "SACH":
                return new Sach(p[1], p[2], Integer.parseInt(p[3]), p[4], Integer.parseInt(p[5]));
            case "TAPCHI":
                return new TapChi(p[1], p[2], Integer.parseInt(p[3]),
                        Integer.parseInt(p[4]), Integer.parseInt(p[5]));
            case "BAO":
                return new Bao(p[1], p[2], Integer.parseInt(p[3]), p[4]);
            default:
                return null;
        }
    }

    // ====================== CHUC NANG ======================
    private TaiLieu timTheoMa(String ma) {
        for (TaiLieu tl : dsTaiLieu) {
            if (tl.getMaTaiLieu().equalsIgnoreCase(ma)) {
                return tl;
            }
        }
        return null;
    }

    public void them(Scanner sc) {
        System.out.println("1. Sach   2. Tap chi   3. Bao");
        System.out.print("Chon loai tai lieu: ");
        String chon = sc.nextLine().trim();

        TaiLieu tl;
        switch (chon) {
            case "1":
                tl = new Sach();
                break;
            case "2":
                tl = new TapChi();
                break;
            case "3":
                tl = new Bao();
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                return;
        }

        System.out.print("Nhap ma tai lieu: ");
        String ma = sc.nextLine().trim();
        if (ma.isEmpty()) {
            System.out.println("Ma tai lieu khong duoc de trong!");
            return;
        }
        if (timTheoMa(ma) != null) {
            System.out.println("Ma tai lieu da ton tai!");
            return;
        }
        tl.setMaTaiLieu(ma);

        try {
            tl.Nhap(sc);
        } catch (NumberFormatException e) {
            System.out.println("Du lieu so khong hop le, huy them moi!");
            return;
        }

        dsTaiLieu.add(tl);
        ghiFile();
        System.out.println("Them thanh cong!");
    }

    public void xoa(Scanner sc) {
        System.out.print("Nhap ma tai lieu can xoa: ");
        String ma = sc.nextLine().trim();
        TaiLieu tl = timTheoMa(ma);
        if (tl == null) {
            System.out.println("Khong tim thay tai lieu co ma " + ma);
            return;
        }
        dsTaiLieu.remove(tl);
        ghiFile();
        System.out.println("Da xoa tai lieu " + ma);
    }

        private static final String VIEN =
            "+----------+--------+------------------+--------+------------------------------+";

    private void inTieuDe() {
        System.out.println(VIEN);
        System.out.printf("| %-8s | %-6s | %-16s | %6s | %-28s |%n",
                "Loai", "Ma", "Nha xuat ban", "So ban", "Chi tiet");
        System.out.println(VIEN);
    }

    public void hienTatCa() {
        if (dsTaiLieu.isEmpty()) {
            System.out.println("Thu vien chua co tai lieu nao.");
            return;
        }
        inTieuDe();
        for (TaiLieu tl : dsTaiLieu) {
            tl.Hien();
        }
    }

    public void timTheoLoai(Scanner sc) {
        System.out.println("1. Sach   2. Tap chi   3. Bao");
        System.out.print("Chon loai can tim: ");
        String chon = sc.nextLine().trim();

        Class<? extends TaiLieu> loai;
        switch (chon) {
            case "1":
                loai = Sach.class;
                break;
            case "2":
                loai = TapChi.class;
                break;
            case "3":
                loai = Bao.class;
                break;
            default:
                System.out.println("Lua chon khong hop le!");
                return;
        }

        boolean coKetQua = false;
        for (TaiLieu tl : dsTaiLieu) {
            if (loai.isInstance(tl)) {
                if (!coKetQua) {
                    inTieuDe();
                    coKetQua = true;
                }
                tl.Hien();
            }
        }
        if (!coKetQua) {
            System.out.println("Khong co tai lieu thuoc loai nay.");
        }
    } 
}