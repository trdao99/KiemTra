package ra.present;

import ra.bussiness.designe.C_Method;
import ra.bussiness.implement.Cate_IPL;

import java.util.Scanner;

public class C_manager {
    C_Method cMethod = new Cate_IPL();
    Scanner sc = new Scanner(System.in);

    public void manager() {
        out:
        do {
            System.out.println("********************CATEGORIES MENU***********\n" +
                    "1. Nhập thông tin các danh mục\n" +
                    "2. Hiển thị thông tin các danh mục\n" +
                    "3. Cập nhật thông tin danh mục\n" +
                    "4. Xóa danh mục\n" +
                    "5. Cập nhật trạng thái danh mục\n" +
                    "6. Quay lại\n");
            System.out.println("chọn chức năng");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    cMethod.add();
                    break;
                case 2:
                    cMethod.displayData();
                    break;
                case 3:
                    cMethod.update();
                    break;
                case 4:
                    cMethod.delData();
                    break;
                case 5:
                    cMethod.switchStatus();
                    break;
                case 6:
                    break out;
            }
        }
        while (true);

    }
}
