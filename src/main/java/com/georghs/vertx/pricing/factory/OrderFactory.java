package com.georghs.vertx.pricing.factory;

import com.georghs.vertx.pricing.components.Currency;
import com.georghs.vertx.pricing.components.Order;
import com.georghs.vertx.pricing.components.OrderType;
import com.georghs.vertx.pricing.components.Stock;
import com.georghs.vertx.pricing.customer.Customer;

public class OrderFactory {

    private int id;
    private Stock stock;
    private int volume_in_amount;
    private int price;
    private OrderType ordertype;
    private Customer customer;


    //Fluent API
    public OrderFactory() {
        new OrderFactory().withStock().withStock().build();
    }

    public OrderFactory withRandomId() {
        return withId((int) Math.floor(Math.random() * 8999) + 1000);
    }

    public OrderFactory withId(int id) {
        this.id = id;
        return this;
    }

    public OrderFactory withStock() {
        this.stock = new Stock("DAI.DE", "Daimler", Currency.AUD);
        return this;
    }

    public OrderFactory withVolume_In_Amount(int amount) {
        this.volume_in_amount = amount;
        return this;
    }

    public OrderFactory withPrice(int price) {
        this.price = price;
        return this;
    }

    public OrderFactory withOrderType(OrderType ordertype) {
        this.ordertype = ordertype;
        return this;
    }

    public OrderFactory withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Order build() {
        return new Order(id, stock, volume_in_amount, price, ordertype, customer);
    }
}
