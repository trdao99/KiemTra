package ra.bussiness.designe;

import ra.bussiness.entity.Product;

public interface P_Method extends Method {
    Product inputData();

    void sortByPrice();

    void findByPrice();

    void search();

}
