package com.manish.gaming_backend.Service;

import com.manish.gaming_backend.Request.UpdateProduct;
import com.manish.gaming_backend.Model.Product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public boolean saveProduct(Product product);
    public Product getProductByName(String name);
    public Product getProductForUpdate(String name , Long adminId);
    public int updateProduct(UpdateProduct updateProduct , Long adminId);
    public String extractPublicId(String secureUrl);
    public boolean deleteProductByName(String name , Long adminId) throws Exception;

    public List<Product> getAllProductOfAdmin(Long adminId);

    public List<Product> getAllProduct();

    public Product getProductById(Long productId);

}
