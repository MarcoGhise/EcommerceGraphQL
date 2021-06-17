package it.blog.graphql.ecommercegraphql.entity;

import java.util.Arrays;

public class Order {

	private String id;
	private float amount;
	private float tax;
	private Status status;
	private String createdAt;
	private String[] productsId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getTax() {
		return tax;
	}
	public void setTax(float tax) {
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
	public String[] getProductsId() {
		return productsId;
	}
	public void setProductsId(String[] productsId) {
		this.productsId = productsId;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", amount=" + amount + ", tax=" + tax + ", status=" + status + ", createdAt="
				+ createdAt + ", productsId=" + Arrays.toString(productsId) + "]";
	}
}
