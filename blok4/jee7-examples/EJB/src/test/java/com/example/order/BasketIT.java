package com.example.order;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
public class BasketIT {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
                .addPackage(Basket.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    Basket basket;

    @Inject
    SingletonOrderRepository repo;

    @Test
    @InSequence(1)
    public void place_order_should_add_order() {
        basket.addItem("sunglasses");
        basket.addItem("suit");
        basket.placeOrder();
        assertEquals(1, basket.getRepo().getOrderCount());
        assertEquals(1, repo.getOrderCount()); // When changing from Singleton to Stateful, this will fail.
        assertEquals(0, basket.getItemCount());

        basket.addItem("raygun");
        basket.addItem("spaceship");
        basket.placeOrder();
        assertEquals(2, repo.getOrderCount());
        assertEquals(0, basket.getItemCount());
    }

    @Test
    @InSequence(2)
    public void order_should_be_persistent() {
        assertEquals(2, repo.getOrderCount());
    }

    @Test
    @InSequence(3)
    public void payShouldReturnCorrectAmount() {
        // example of using no-interface view (since basket has a no-interface view on paymentservice)
        basket.addItem("raygun");
        basket.addItem("spaceship");
        basket.addItem("cardset");

        int amount = basket.pay();
        basket.placeOrder();

        assertThat(amount, is(6)); // 3 items, 2 euro's each
    }
}
