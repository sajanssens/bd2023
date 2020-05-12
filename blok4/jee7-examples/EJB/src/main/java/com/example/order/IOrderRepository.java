package com.example.order;

import javax.ejb.Local;
import java.util.List;

@Local
public interface IOrderRepository {
    void addOrder(List<String> order);

    List<List<String>> getOrders();

    int getOrderCount();
}
