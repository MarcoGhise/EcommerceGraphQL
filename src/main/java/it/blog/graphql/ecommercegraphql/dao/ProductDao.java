package it.blog.graphql.ecommercegraphql.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.blog.graphql.ecommercegraphql.entity.Product;

@Component
public class ProductDao {

	private List<Product> products;

	public ProductDao() {
		Product p1 = new Product();
		p1.setName("Horn Speaker Voice Annunciator with Rotating Light");
		p1.setPrice(120);
		p1.setProductId("RT-24VF-R/Y/G/B");
		p1.setQty(1);

		Product p2 = new Product();
		p2.setName("LED Work Light");
		p2.setPrice(90);
		p2.setProductId("CWK-3S-24-CD");
		p2.setQty(1);

		Product p3 = new Product();
		p3.setName("Interface Converter");
		p3.setPrice(300);
		p3.setProductId("NBM-D88NN");
		p3.setQty(1);

		Product p4 = new Product();
		p4.setName("Wireless Data Acquisition System");
		p4.setPrice(285);
		p4.setProductId("WDR-LE-Z2-PRO");
		p4.setQty(1);

		Product p5 = new Product();
		p5.setName("Audible Alarm");
		p5.setPrice(40);
		p5.setProductId("BK-24-J");
		p5.setQty(1);

		Product p6 = new Product();
		p6.setName("LED Work Light");
		p6.setPrice(115);
		p6.setProductId("CLE-24N");
		p6.setQty(1);

		Product p7 = new Product();
		p7.setName("Modular Signal Tower");
		p7.setPrice(80);
		p7.setProductId("KUS-24C");
		p7.setQty(1);

		products = new ArrayList<>() {
			{
				add(p1);
				add(p2);
				add(p3);
				add(p4);
				add(p5);
				add(p6);
				add(p7);
			}
		};

	}

	public List<Product> getProducts() {
		return products;
	}

}
