package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "prize")
	private int price;
	
	
	public product() {
		
	}
	public product(int id, String name, int prize) {
		super();
		this.id = id;
		this.name = name;
		this.price = prize;
	}
	public int getId() {
		System.out.println(id);
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		System.out.println(name);
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		System.out.println(price);
		return price;
	}
	public void setPrize(int price) {
		this.price = price;
	}
	
	
	
}
