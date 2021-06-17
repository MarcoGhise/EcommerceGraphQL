package it.blog.graphql.ecommercegraphql.entity;

import java.util.List;

public class OrderRest {

	private String id;
	private double amount;
	private double tax;
	private Status status;
	private String createdAt;
	private List<Product> products;
	private List<Product> mostexpensive;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public List<Product> getMostexpensive() {
		return mostexpensive;
	}
	public void setMostexpensive(List<Product> mostexpensive) {
		this.mostexpensive = mostexpensive;
	}
	@Override
	public String toString() {
		return "OrderRest [id=" + id + ", amount=" + amount + ", tax=" + tax + ", status=" + status + ", createdAt="
				+ createdAt + ", products=" + products + ", mostexpensive=" + mostexpensive + "]";
	}
	
}
