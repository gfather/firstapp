package ru.geekbrains.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.repository.ProductRepository;

import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private ProductRepository pr = new ProductRepository();

    public Cart() {
    }


    public void addProductToCart(Product product){
        this.pr.create(product);

    }
   public void printCartList(){
       System.out.println("Begin Cart List");
        if(!this.pr.selectAll().isEmpty()) {
            for (Product product : this.pr.selectAll()) {
                System.out.println(product);
            }
        }else{
            System.out.println("...Cart is Empty");
        }
       System.out.println("End Cart List");
   }

    public void removeProductFromCart(int productId){
        this.pr.delete(productId);

    }

    public List<Product> getAllProducts(){
        return this.pr.selectAll();
    }

    public Product getProductById(int id){
        return pr.selectById(id);
    }

}
