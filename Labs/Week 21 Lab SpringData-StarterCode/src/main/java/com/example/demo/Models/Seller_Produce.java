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
@Table(name = "Seller_Produce")
@EntityListeners(AuditingEntityListener.class)
public class Seller_Produce implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="seller")
    private User seller;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="produce")
    private Produce produce;

    Long quantity;
    Float price;

    public Seller_Produce(){
        super();
    }

    public Seller_Produce(User seller, Produce produce){
        super();
        this.seller = seller;
        this.produce = produce;
    }

    public User getSeller(){
        return seller;
    }

    public void setSeller(User seller){
        this.seller = seller;
    }

    public Produce getProduce(){
        return produce;
    }

    public void setProduce(Produce produce){
        this.produce = produce;
    }

    public Long getQuantity(){
        return quantity;
    }

    public void setQuantity(Long quantity){
        this.quantity = quantity;
    }

    public Float getPrice(){
        return price;
    }

    public void setPrice(Float price){
        this.price = price;
    }
}