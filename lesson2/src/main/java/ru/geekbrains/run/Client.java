package ru.geekbrains.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.geekbrains.model.Cart;
import ru.geekbrains.model.Product;
import ru.geekbrains.repository.ProductRepository;

public class Client {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        ProductRepository productRepository = context.getBean("productRepository",ProductRepository.class);

        productRepository.create(new Product(1,"1",1));
        productRepository.create(new Product(2,"2",2));
        productRepository.create(new Product(3,"3",3));
        productRepository.create(new Product(4,"4",4));
        productRepository.create(new Product(5,"5",5));

        Cart cart = context.getBean("cart",Cart.class);
        cart.printCartList();

        cart.addProductToCart(productRepository.selectById(1));
        cart.printCartList();
        cart.addProductToCart(productRepository.selectById(2));
        cart.addProductToCart(productRepository.selectById(4));
        cart.printCartList();

        Cart cart2 = context.getBean("cart",Cart.class);
        System.out.println("Cart 2");
        cart2.printCartList();
        cart2.addProductToCart(productRepository.selectById(3));
        cart2.addProductToCart(productRepository.selectById(5));

        cart2.printCartList();

        cart.removeProductFromCart(2);
        cart.printCartList();
    }

}
