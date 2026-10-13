import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLy ql = new QuanLy();

        ql.docFile();

        int chon;
        do {
            System.out.println();
            System.out.println("========== QUAN LY THU VIEN ==========");
            System.out.println("1. Them moi tai lieu (Sach/Tap chi/Bao)");
            System.out.println("2. Xoa tai lieu theo ma");
            System.out.println("3. Hien thi thong tin tai lieu");
            System.out.println("4. Tim kiem tai lieu theo loai");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            try {
                chon = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                chon = -1;
            }

            switch (chon) {
                case 1:
                    ql.them(sc);
                    break;
                case 2:
                    ql.xoa(sc);
                    break;
                case 3:
                    ql.hienTatCa();
                    break;
                case 4:
                    ql.timTheoLoai(sc);
                    break;
                case 0:
                    ql.ghiFile();
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);

        sc.close();
    }
}