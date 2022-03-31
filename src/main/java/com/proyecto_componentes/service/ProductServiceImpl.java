package com.proyecto_componentes.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.proyecto_componentes.domain.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import com.proyecto_componentes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    
    @Override
    public void registerProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findAllByUserId(String userId) {
        return productRepository.findAllByUserId(userId);
    }

    @Override
    public Product updateByUuid(String uuid, Product product) {
        Product existing = productRepository.findByUuid(uuid).get(0);
        Product productDataFrom = new Product(product.getName(), product.getDescription(), product.getPrice());
        copyNonNullProperties(productDataFrom, existing);
        return this.productRepository.save(existing);
    }

    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
                emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    @Override
    public void deleteByUuid(String uuid) {
        productRepository.deleteTaskByUuid(uuid);
    }
    
}
