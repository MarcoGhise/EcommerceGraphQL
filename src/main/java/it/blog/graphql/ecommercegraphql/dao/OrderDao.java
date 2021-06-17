package it.blog.graphql.ecommercegraphql.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.blog.graphql.ecommercegraphql.entity.Order;
import it.blog.graphql.ecommercegraphql.entity.Status;

@Component
public class OrderDao {

	private List<Order> orders;

	public OrderDao() {
		Order o1 = new Order();
		o1.setId("e6f1d9fe-d063-48db-a382-e19dfc0df098");
		o1.setStatus(Status.CONFIRMED);
		o1.setCreatedAt("2020-03-02 11:02:02");
		o1.setProductsId(new String[] { "RT-24VF-R/Y/G/B", "CWK-3S-24-CD", "NBM-D88NN" });

		Order o2 = new Order();
		o2.setId("6c89dd58-7cb7-455a-9d0d-a32a43dc1bfa");
		o2.setStatus(Status.CONFIRMED);
		o2.setCreatedAt("2021-03-01 14:12:02");
		o2.setProductsId(new String[] { "WDR-LE-Z2-PRO" });

		Order o3 = new Order();
		o3.setId("80bb23f0-e4f8-4246-9c86-5ad1789ceb0c");
		o3.setStatus(Status.CANCELED);
		o3.setCreatedAt("2019-04-10 16:02:02");
		o3.setProductsId(new String[] { "RT-24VF-R/Y/G/B", "WDR-LE-Z2-PRO" });

		Order o4 = new Order();
		o4.setId("3e07aee3-ec1c-4c3d-b08c-d3473b37b343");
		o4.setStatus(Status.PENDING);
		o4.setCreatedAt("2018-07-22 09:01:01");
		o4.setProductsId(new String[] { "BK-24-J", "CLE-24N", "KUS-24C" });

		orders = new ArrayList<>() {
			{
				add(o1);
				add(o2);
				add(o3);
				add(o4);
			}
		};

	}

	public List<Order> getOrders() {
		return orders;
	}
	
	public void saveOrder(Order o) {
		orders.add(o);
	}
}
