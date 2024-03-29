package ra.bussiness.implement;

import ra.bussiness.designe.C_Method;
import ra.bussiness.entity.Categories;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ra.bussiness.implement.Product_IPL.productList;

public class Cate_IPL implements C_Method {
    public static List<Categories> categoriesList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    boolean editOrno = true;

    @Override
    public Categories inputData() {
        Categories categories = new Categories();

        if (editOrno) {
            categoriesList.add(categories);
            categories.setCatalogId(categoriesList.indexOf(categories) + 1);
        }
        do {
            System.out.println("nhập tên danh muc : ");
            String NewName = sc.nextLine();
            boolean NameCorrect = true;
            if (!NewName.trim().isEmpty() && NewName.length() < 50) {
                for (int i = 0; i < categoriesList.size() - 1; i++) {
                    if (categoriesList.get(i).getCatalogName().equals(NewName)) {
                        System.err.println("tên đã tồn tại");
                        NameCorrect = false;
                        break;
                    }
                }
                if (NameCorrect) {
                    categories.setCatalogName(NewName);
                    break;
                }
            } else {
                System.err.println("tên không được để trống");
            }
        } while (true);
        System.out.println("nhập mô tả danh mục:");
        categories.setDescriptions(sc.nextLine());
        out:
        do {
            System.out.println("nhập trạng thái:");
            String status = sc.nextLine();
            switch (status) {
                case "true":
                    categories.setCatalogStatus(true);
                    break out;
                case "false":
                    categories.setCatalogStatus(false);
                    break out;
                default:
                    System.err.println("chỉ nhập true/false ");
                    break;
            }
        } while (true);

        return categories;
    }

    @Override
    public void displayData() {
        categoriesList.forEach(v -> System.out.println(v.toString()));
    }

    @Override
    public void add() {
        System.out.println("nhập số lượng danh mục muốn thêm: ");
        int addNum = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < addNum; i++) {
            inputData();
        }
    }

    @Override
    public void update() {
        out:
        do {
            System.out.println("nhập ID muốn sửa");
            int editID = Integer.parseInt(sc.nextLine());
            if (editID > 0) {
                for (int i = 0; i < categoriesList.size(); i++) {
                    if (categoriesList.get(i).getCatalogId() == editID) {
                        editOrno = false;
                        Categories update = inputData();
                        update.setCatalogId(editID);
                        categoriesList.set(i, update);
                        System.out.println("update thành công");
                        break out;
                    }
                }
                System.err.println("ID không tồn tại");
            } else {
                System.err.println("ID lớn hơn 0");
            }
        } while (true);
    }

    @Override
    public void switchStatus() {
        out:
        do {
            System.out.println("nhập ID muốn sửa");
            int SwitchID = Integer.parseInt(sc.nextLine());
            if (SwitchID > 0) {
                for (int i = 0; i < categoriesList.size(); i++) {
                    if (categoriesList.get(i).getCatalogId() == SwitchID) {
                        categoriesList.get(i).setCatalogStatus(!categoriesList.get(i).isCatalogStatus());
                        System.out.println("update thành công");
                        break out;
                    }
                }
                System.err.println("ID không tồn tại");
            } else {
                System.err.println("ID lớn hơn 0");
            }
        } while (true);
    }

    @Override
    public void delData() {
        out:
        do {
            System.out.println("Nhập ID danh muc muốn xóa:");
            int delID = Integer.parseInt(sc.nextLine());
            if (delID > 0) {
                for (int i = 0; i < categoriesList.size(); i++) {
                    if (categoriesList.get(i).getCatalogId() == delID) {
                        for (int j = 0; j < productList.size(); j++) {
                            if (productList.get(j).getCatalogId() == delID) {
                                System.err.println("danh mục tồn tại sản phẩm không thể xóa.");
                                break out;
                            }
                        }
                        categoriesList.remove(i);
                        break out;
                    }
                    System.err.println("ID không tồn tại");
                }
            } else {
                System.err.println("ID phải lớn hơn 0");
            }
        } while (true);
    }
}

