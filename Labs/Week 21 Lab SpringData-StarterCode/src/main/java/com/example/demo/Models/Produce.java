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
@Table(name = "Produce")
@EntityListeners(AuditingEntityListener.class)
public class Produce implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@NotBlank
	String name;

    public Produce(){
        super();
    }

    public Produce(String name){
        super();
        this.name = name;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
