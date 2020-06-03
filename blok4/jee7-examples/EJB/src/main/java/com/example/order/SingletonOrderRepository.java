package com.example.order;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;

// @Singleton
// @Stateless         // alternatively, use this (in non CDI, EJB app)
@ApplicationScoped // alternatively, use this (in non EJB, CDI app)
public class SingletonOrderRepository extends OrderRepository {
}
