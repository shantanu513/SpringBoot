//package com.springboot.service;
//
//import org.springframework.stereotype.Service;
//
//import lombok.RequiredArgsConstructor;
//import com.springboot.repository.ProductRepository;
//import com.springboot.schema.Product;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ProductService {
//
//    private final ProductRepository productRepository;
//
//    public List<Product> findAll() {
//        return (List<Product>) productRepository.findAll();
//    }
//
//    public Product findById(Long id) {
//        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
//    }
//
//    public Product save(Product product) {
//        return productRepository.save(product);
//    }
//
//    public void deleteById(Long id) {
//        productRepository.deleteById(id);
//    }
//
//    public void deleteAll() {
//        productRepository.deleteAll();
//    }
//}
