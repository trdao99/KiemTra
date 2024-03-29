package ra.present;


import ra.bussiness.designe.P_Method;
import ra.bussiness.implement.Product_IPL;

import java.util.Scanner;

public class P_maneger {
    P_Method pMethod = new Product_IPL();
    Scanner sc = new Scanner(System.in);

    public void manager() {
        out:
        do {
            System.out.println("*******************PRODUCT MANAGEMENT*****************\n" +
                    "1. Nhập thông tin các sản phẩm\n" +
                    "2. Hiển thị thông tin các sản phẩm\n" +
                    "3. Sắp xếp các sản phẩm theo giá\n" +
                    "4. Cập nhật thông tin sản phẩm theo mã sản phẩm\n" +
                    "5. Xóa sản phẩm theo mã sản phẩm\n" +
                    "6. Tìm kiếm các sản phẩm theo tên sản phẩm\n" +
                    "7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn\n" +
                    "phím)\n" +
                    "8. Quay lại\n");
            System.out.println("chọn chức năng");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    pMethod.add();
                    break;
                case 2:
                    pMethod.displayData();
                    break;
                case 3:
                    pMethod.sortByPrice();
                    break;
                case 4:
                    pMethod.update();
                    break;
                case 5:
                    pMethod.delData();
                    break;
                case 6:
                    pMethod.search();
                    break;
                case 7:
                    pMethod.findByPrice();
                    break;
                case 8:
                    break out;
            }
        }
        while (true);

    }
}

