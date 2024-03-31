package com.example.ap2;

import com.example.ap2.entities.Product;
import com.example.ap2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Ap2Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {

        SpringApplication.run(Ap2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product(null,"Yassine",8000,2));
        productRepository.save(new Product(null,"Computer",4000,5));
        productRepository.save(new Product(null,"Printer",2000,3));
        List<Product> products= productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("***********");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("***********");
        System.out.println("---------");
        List<Product> productList = productRepository.findByNameContains("Y");
        productList.forEach(p->{
            System.out.println(p);
        });
         System.out.println("---------");
     List<Product> productList1=productRepository.search("%C");
    productList1.forEach(p->{
     System.out.println(p);
});
        System.out.println("---------");
        List<Product> productList2=productRepository.searchByPrice(3000);
        productList2.forEach(p->{
            System.out.println(p);
        });
    }
}
