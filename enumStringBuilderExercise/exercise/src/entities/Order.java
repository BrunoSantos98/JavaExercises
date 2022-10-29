package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private LocalDateTime moment;
    private OrderStatus status;

    private List<OrderItem> listItems = new ArrayList<>();

    public Order() {
    }

    public Order(LocalDateTime moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double total(){
        double soma =0;

        for(OrderItem items : listItems){
            soma += items.subtotal();
        }

        return soma;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item){
        listItems.add(item);
    }

    public void removeItem(OrderItem item){
        listItems.remove(item);
    }
}
