package com.example.demo.Models;

import java.io.Serializable;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ordered_Items")
@EntityListeners(AuditingEntityListener.class)
public class Ordered_Items implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order")
    private Order order;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="seller_produce")
    private Seller_Produce seller_produce;

    Long quantity;
    Float price_at_order;

    public Ordered_Items(){
        super();
    }

    public Ordered_Items(Order order, Seller_Produce seller_produce){
        super();
        this.order = order;
        this.seller_produce = seller_produce;
    }


    public Order getOrder(){
        return order;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public Seller_Produce getSeller_Produce(){
        return seller_produce;
    }

    public void setSeller_Produce(Seller_Produce seller_produce){
        this.seller_produce = seller_produce;
    }

    public Long getQuantity(){
        return quantity;
    }

    public void setQuantity(Long quantity){
        this.quantity = quantity;
    }

    public Float getPrice_At_Order(){
        return price_at_order;
    }

    public void setPrice_At_Order(Float price_at_order){
        this.price_at_order = price_at_order;
    }
}