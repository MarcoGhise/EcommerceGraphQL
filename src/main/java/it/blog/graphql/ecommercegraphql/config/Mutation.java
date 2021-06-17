package it.blog.graphql.ecommercegraphql.config;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;
import it.blog.graphql.ecommercegraphql.dao.OrderDao;
import it.blog.graphql.ecommercegraphql.entity.Order;
import it.blog.graphql.ecommercegraphql.entity.Status;

@Component
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	OrderDao orderDao;

	public Order createOrder(String status, String createdAt, String[] productsId)
	{
		Order o = new Order();
		o.setStatus(Status.valueOf(status));
		o.setCreatedAt(createdAt);
		o.setId(UUID.randomUUID().toString());
		
		o.setProductsId(productsId);
		
		orderDao.saveOrder(o);
		
		return o;
	}
	
}