package list;

import models.Category;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class CrudProduct {
    public List<Product> productList = new ArrayList<>();

    CrudCategory crudCategory = new CrudCategory();

    public CrudProduct() {
        productList.add(new Product(1,"Tho Katty",20000000,"https://image-us.24h.com.vn/upload/1-2022/images/2022-03-18/Co-gai-Viet-noi-bat-tren-pho-voi-kieu-vay-anh-15-1633753877-839-width650height867-1647574774-446-width650height867.jpeg",crudCategory.categoryList.get(0),true));
        productList.add(new Product(2,"Thao Mai",5000000,"https://we25.vn/media2018/Img_News/2019/10/05/hotgirl-cuu-sinh-vien-dh-su-pham_20191005090410.jpg",crudCategory.categoryList.get(1),false));
    }

    public void create(Product product){
        productList.add(product);
    }
    public void edit(Product product,int index){
        productList.set(index,product);
    }
    public void delete(int index){
        productList.remove(index);
    }
}
