package com.core.webserviceSpring.entities;

import com.core.webserviceSpring.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant dateMoment;
    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order() {}

    public Order(Long id, Instant dateMoment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.dateMoment = dateMoment;
        this.client = client;
        setOrderStatus(orderStatus);
    }

    // Getters
    public Long getId() {return id;}

    public Instant getDateMoment() {return dateMoment;}

    public User getClient() {return client;}

    public OrderStatus getOrderStatus() {return OrderStatus.getOrderStatus(orderStatus);}

    //Setters
    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }

    public void setId(Long id) {this.id = id;}

    public void setDateMoment(Instant dateMoment) {this.dateMoment = dateMoment;
    }

    public void setClient(User client) {this.client = client;}

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id) && Objects.equals(dateMoment, order.dateMoment) && Objects.equals(client, order.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateMoment, client);
    }


}
