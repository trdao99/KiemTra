package ra.bussiness.implement;

import ra.bussiness.designe.P_Method;
import ra.bussiness.entity.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static ra.bussiness.implement.Cate_IPL.categoriesList;

public class Product_IPL implements P_Method {
    public static List<Product> productList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    boolean editOrno = true;

    @Override
    public Product inputData() {
        Product product = new Product();
        String regex = "^[CSA][A-Za-z0-9]{3}$";

        if (editOrno) {
            do {
                productList.add(product);
                System.out.println("nhập ID sản phẩm: ");
                String ID = sc.nextLine();
                if (ID.matches(regex)) {
                    boolean ID_correct = true;
                    for (int i = 0; i < productList.size() - 1; i++) {
                        if (productList.get(i).getProductid().equals(ID)) {
                            System.err.println("ID đã tồn tại");
                            ID_correct = false;
                        }
                    }
                    if (ID_correct) {
                        product.setProductid(ID);
                        break;
                    }
                } else {
                    System.err.println("ID không đúng định dạng(C/S/A + 3 kí tự)");
                }
            } while (true);

        }

        do {
            System.out.println("nhập tên sản phẩm : ");
            String NewName = sc.nextLine();
            boolean NameCorrect = true;
            if (!NewName.trim().isEmpty() && NewName.length() <= 50 && NewName.length() >= 10) {
                for (int i = 0; i < productList.size() - 1; i++) {
                    if (productList.get(i).getProductName().equals(NewName)) {
                        System.err.println("tên đã tồn tại");
                        NameCorrect = false;
                        break;
                    }
                }
                if (NameCorrect) {
                    product.setProductName(NewName);
                    break;
                }
            } else {
                System.err.println("tên không được để trống và phải [10-50]");
            }
        } while (true);
        System.out.println("nhập mô tả sản phẩm");
        product.setDescription(sc.nextLine());
        do {
            System.out.println("nhập giá sản phẩm: ");
            float NewPrice = Float.parseFloat(sc.nextLine());
            if (NewPrice <= 0) {
                System.err.println("giá phải lớn hơn 0");
            } else {
                product.setPrice(NewPrice);
                break;
            }
        } while (true);
        boolean validDate = false;
        do {
            System.out.println("Enter the production date (dd/MM/yyyy):");
            String date = sc.nextLine();

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                LocalDate productionDate = LocalDate.parse(date, dateFormatter);
                product.setCreated(productionDate);
                validDate = true;
            } catch (Exception e) {
                System.err.println("Invalid date format. Please enter the date in the format dd/MM/yyyy.");
            }
        } while (!validDate);

        categoriesList.forEach(v -> System.out.println(v.toString()));
        out:
        do {
            System.out.println("chọn ID danh mục muốn thêm:");
            int idCat = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < categoriesList.size(); i++) {
                if (idCat == categoriesList.get(i).getCatalogId()) {
                    product.setCatalogId(idCat);
                    break out;
                }
            }
            System.err.println("ID không tồn tại.");
        } while (true);

        out:
        do {
            System.out.println("nhập trạng thái(ACTIVE/BLOCK/INACTIVE): ");
            String status = sc.nextLine();
            switch (status) {
                case "ACTIVE":
                    product.setStatus(Product.ProductStatus.valueOf(status));
                    break out;
                case "BLOCK":
                    product.setStatus(Product.ProductStatus.valueOf(status));
                    break out;
                case "INACTIVE":
                    product.setStatus(Product.ProductStatus.valueOf(status));
                    break out;
                default:
                    System.err.println("nhập đúng định dạng");
                    break;
            }
        }
        while (true);
        return product;
    }

    @Override
    public void displayData() {
        productList.forEach(v -> System.out.println(v.toString()));
    }

    @Override
    public void add() {
        if (categoriesList.isEmpty()) {
            System.err.println("nhập danh mục trước");
        } else {
            System.out.println("nhập số sản phẩm muốn thêm:");
            int addNum = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < addNum; i++) {
                inputData();
            }
        }
    }

    @Override
    public void update() {
        out:
        do {
            System.out.println("nhập ID muốn sửa");
            String editID = sc.nextLine();

            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getProductid().equals(editID)) {
                    editOrno = false;
                    Product update = inputData();
                    update.setProductid(editID);
                    productList.set(i, update);
                    System.out.println("update thành công");
                    break out;
                }
            }
            System.err.println("ID không tồn tại");
        } while (true);
    }

    @Override
    public void switchStatus() {
        System.out.println("chọn ID sản phẩm muốn sửa trạng thái");
        String switchID = sc.nextLine();
        for (Product product : productList) {
            if (product.getProductid().equals(switchID)) {
                out:
                do {
                    System.out.println("nhập trạng thái(ACTIVE/BLOCK/INACTIVE):");
                    String status = sc.nextLine();
                    switch (status) {
                        case "ACTIVE":
                            product.setStatus(Product.ProductStatus.valueOf(status));
                            break out;
                        case "BLOCK":
                            product.setStatus(Product.ProductStatus.valueOf(status));
                            break out;
                        case "INACTIVE":
                            product.setStatus(Product.ProductStatus.valueOf(status));
                            break out;
                        default:
                            System.err.println("nhập đúng định dạng");
                            break;
                    }
                }
                while (true);
            }
        }
    }

    @Override
    public void sortByPrice() {
        Collections.sort(productList, Comparator.comparing(Product::getPrice));
    }

    @Override
    public void findByPrice() {
        System.out.println("nhập giá bắt đầu");
        float startPrice = Float.parseFloat(sc.nextLine());
        System.out.println("nhập giá kết thúc");
        float endPrice = Float.parseFloat(sc.nextLine());
        for (Product product : productList) {
            if (product.getPrice() <= endPrice && product.getPrice() >= startPrice) {
                System.out.println(product.toString());
            }
        }
    }

    @Override
    public void search() {
        System.out.println("nhập tên sản phẩm muốn tìm");
        String findName = sc.nextLine().toLowerCase();
        for (Product product : productList) {
            if (product.getProductName().toLowerCase().equals(findName)) {
                System.out.println(product.toString());
                break;
            }
        }
    }

    @Override
    public void delData() {
        System.out.println("chọn ID sản phẩm muốn xoa");
        String DelID = sc.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductid().equals(DelID)) {
                productList.remove(i);
                break;
            }
        }
        System.err.println("không tồn tại ID");
    }
}
