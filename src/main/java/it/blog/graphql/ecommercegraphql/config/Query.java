package it.blog.graphql.ecommercegraphql.config;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;
import it.blog.graphql.ecommercegraphql.dao.OrderDao;
import it.blog.graphql.ecommercegraphql.dao.ProductDao;
import it.blog.graphql.ecommercegraphql.entity.Order;
import it.blog.graphql.ecommercegraphql.entity.Product;
import it.blog.graphql.ecommercegraphql.entity.Status;

@Component
public class Query implements GraphQLQueryResolver {

	@Autowired
	OrderDao orderDao;

	@Autowired
	ProductDao productDao;

	public List<Order> ordersByStatus(Status status) throws IOException {
		return orderDao.getOrders().stream().filter(o -> o.getStatus().equals(status)).collect(Collectors.toList());
	}

	public List<Product> productsByCount(int count) throws IOException {
		return productDao.getProducts();
	}
}
