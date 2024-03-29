package ra.present;

import java.util.Scanner;

public class Shop_Manager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P_maneger pManeger = new P_maneger();
        C_manager cManager = new C_manager();
        out:
        do {
            System.out.println("******************SHOP MENU*******************\n" +
                    "1. Quản lý danh mục sản phẩm\n" +
                    "2. Quản lý sản phẩm\n" +
                    "3. Thoát\n");
            System.out.println("chọn chức năng");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    cManager.manager();
                    break;
                case 2:
                    pManeger.manager();
                    break;
                case 3:
                    break out;
            }
        } while (true);
    }
}
