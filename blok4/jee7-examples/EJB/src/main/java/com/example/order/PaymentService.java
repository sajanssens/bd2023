package com.example.order;

import javax.ejb.Stateless;

@Stateless
public class PaymentService {

    public int pay(Basket b) { return b.getItemCount() * 2; }

}
