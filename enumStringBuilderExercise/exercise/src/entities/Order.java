package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Date moment;
    private OrderStatus status;
    private Client cliente;
    private List<OrderItem> listItems = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client cliente) {
        this.moment = moment;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }


    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
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

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("ORDER SUMMARY: \n");
        sb.append("Order Moment: " + sdf.format(moment) + "\n" + "Order Status: " + status + "\n");
        sb.append("Cliente: " + cliente + "\n");
        sb.append("order items: \n");
        for(OrderItem OI : listItems){
            sb.append(OI.getProduct().getName() + ", $" + OI.getProduct().getPrice() + ",");
            sb.append(" Quantity: " + OI.getQuantity() + ", subtotal: $" + OI.subtotal() + "\n");
        }

        sb.append("Total price: $" + total() + "\n");

        return sb.toString();
    }

}
