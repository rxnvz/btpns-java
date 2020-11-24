package com.codeflex.springboot.service;

import com.codeflex.springboot.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service("productService")
public class ProductServiceImpl implements ProductService {


    //  Using two hashmaps in order to provide performance of O(1) while fetching products
    private static HashMap<Long, Product> products = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();


    public List<Product> findAllProducts() {
        // Pagination should be added...
        return new ArrayList<>(products.values());
    }

    public Product findById(long id) {
            return products.get(id);
    }

    public Product findByName(String name) {

        if (idNameHashMap.get(name) != null){
            return products.get(idNameHashMap.get(name));
        }

        return null;
    }

    public void saveProduct(Product product) {
        synchronized (this) {    //  Critical section synchronized
            products.put(product.getId(), product);
            idNameHashMap.put(product.getName(), product.getId());
        }
    }

    public void updateProduct(Product product) {
        synchronized (this) {    //  Critical section synchronized
            products.put(product.getId(), product);
            idNameHashMap.put(product.getName(), product.getId());
        }
    }

    public void deleteProductById(long id) {
        synchronized (this) {    //  Critical section synchronized
            idNameHashMap.remove(products.get(id).getName());
            products.remove(id);
        }
    }

    public boolean isProductExist(Product product) {
        return findByName(product.getName()) != null;
    }

    public void deleteAllProducts() {
        products.clear();
    }

}
