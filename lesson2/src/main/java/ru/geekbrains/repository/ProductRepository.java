package ru.geekbrains.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProductRepository  implements Repository{

    private List<Product> productList = new ArrayList<Product>();


    public ProductRepository(){

    }

    @Override
    public void create(Object obj) {
        productList.add((Product)obj);
    }

    @Override
    public Product selectById(int id) {
        return  productList.stream().filter( (product -> product.getId() == id) ).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Product> selectAll() {
        return productList;
    }

    @Override
    public int delete(int id) {
        productList.remove((Product) productList.stream().filter( (product -> product.getId() == id) ).collect(Collectors.toList()).get(0) );
        return 0;
    }
}
