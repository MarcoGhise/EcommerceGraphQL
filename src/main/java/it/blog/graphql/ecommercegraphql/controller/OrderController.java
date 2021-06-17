package it.blog.graphql.ecommercegraphql.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.blog.graphql.ecommercegraphql.dao.OrderDao;
import it.blog.graphql.ecommercegraphql.dao.ProductDao;
import it.blog.graphql.ecommercegraphql.entity.Order;
import it.blog.graphql.ecommercegraphql.entity.OrderRest;
import it.blog.graphql.ecommercegraphql.entity.Product;
import it.blog.graphql.ecommercegraphql.entity.Status;

@RestController
public class OrderController {

	@Autowired
	OrderDao orderDao;

	@Autowired
	ProductDao productDao;

	@GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderRest> getOrder(@RequestParam("status") String status, @RequestParam("count") int count)
			throws IOException {
		return orderDao.getOrders().stream().filter(o -> o.getStatus().equals(Status.valueOf(status)))
				.map(o -> this.fromOrderToRest(o, count)).collect(Collectors.toList());
	}

	private OrderRest fromOrderToRest(Order order, int count) {
		OrderRest or = new OrderRest();
		or.setId(order.getId());
		or.setStatus(order.getStatus());
		or.setCreatedAt(order.getCreatedAt());

		or.setProducts(productDao.getProducts().stream()
				.filter(p -> Arrays.stream(order.getProductsId()).anyMatch(o -> p.getProductId().equals(o)))
				.collect(Collectors.toList()));

		or.setMostexpensive(productDao.getProducts().stream()
				.filter(p -> Arrays.stream(order.getProductsId()).anyMatch(o -> p.getProductId().equals(o)))
				.sorted(Comparator.comparingDouble(Product::getPrice).reversed()).limit(count)
				.collect(Collectors.toList()));

		or.setAmount(productDao.getProducts().stream()
				.filter(p -> Arrays.stream(order.getProductsId()).anyMatch(o -> p.getProductId().equals(o)))
				.mapToDouble(p -> p.getPrice()).sum());

		or.setTax(or.getAmount() * 22 / 100);
		
		return or;
	}
}
