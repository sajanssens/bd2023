package com.example.order;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class Basket implements Serializable {

    @EJB // local interfaced session bean
    private SingletonOrderRepository repo;

    @EJB // no-interface session bean
    private PaymentService paymentService;

    private List<String> items;

    @PostConstruct void initialize() { items = new ArrayList<>(); }

    public void addItem(String item) {
        items.add(item);
    }

    public IOrderRepository getRepo() { return repo; }

    public int getItemCount() { return items.size(); }

    public int pay() { return paymentService.pay(this); }

    public void placeOrder() {
        repo.addOrder(items);
        items.clear();
    }

}
