package it.blog.graphql.ecommercegraphql.resolver;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLResolver;
import it.blog.graphql.ecommercegraphql.dao.ProductDao;
import it.blog.graphql.ecommercegraphql.entity.Order;
import it.blog.graphql.ecommercegraphql.entity.Product;

@Component
public class OrderResolver implements GraphQLResolver<Order> {

	@Autowired
	ProductDao productDao;

	public List<Product> getProducts(Order order) throws IOException {
		return productDao.getProducts().stream()
				.filter(p -> Arrays.stream(order.getProductsId()).anyMatch(o -> p.getProductId().equals(o)))
				.collect(Collectors.toList());
	}

	public List<Product> mostexpensive(Order order, Integer count) throws IOException {
		return productDao.getProducts().stream()
				.filter(p -> Arrays.stream(order.getProductsId()).anyMatch(o -> p.getProductId().equals(o)))
				.sorted(Comparator.comparingDouble(Product::getPrice).reversed())
				.limit(count)
				.collect(Collectors.toList());
	}
	
	public double getAmount(Order order) {

		return productDao.getProducts().stream()
				.filter(p -> Arrays.stream(order.getProductsId()).anyMatch(o -> p.getProductId().equals(o)))
				.mapToDouble(p -> p.getPrice()).sum();
	}

	public double getTax(Order order) {

		return this.getAmount(order) * 22 / 100;
	}
}