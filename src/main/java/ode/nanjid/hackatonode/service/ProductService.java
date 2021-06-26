package ode.nanjid.hackatonode.service;

import ode.nanjid.hackatonode.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public abstract List<Product> getAllProducts();
    public abstract Page<Product> getAllProductsPaged(int pageNo);
    public abstract Product saveProduct(Product product);
    public abstract Product getProductById(Long productId);

}
