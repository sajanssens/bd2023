package com.example.order;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

// @Singleton
@Lock(LockType.READ)
public class OrderRepository implements IOrderRepository {
    private List<List<String>> orders;

    @Override
    @Lock(LockType.WRITE)
    public void addOrder(List<String> order) {
        orders.add(order);
    }

    @Override
    public List<List<String>> getOrders() {
        return unmodifiableList(orders);
    }

    @Override
    public int getOrderCount() { return orders.size(); }

    @PostConstruct
    void initialize() {
        orders = new ArrayList<>();
    }
}
