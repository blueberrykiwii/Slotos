package com.example.shop.component.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.example.article.component.structure.Article;
import com.example.customer.component.structure.Cart;
import com.example.customer.component.structure.CartItem;
import com.example.customer.component.structure.Customer;
import com.example.order.component.structure.Order;
import com.example.order.component.structure.OrderPosition;

import component.structure.Catalog;

public class Shop {
	private Catalog catalog;
	private Map<Integer, Customer> customers;

	public Shop() {
		customers = new HashMap<Integer, Customer>();
		catalog = new Catalog();
	}

	public Integer createCustomerWithCart() {
		Cart cart = new Cart();

		Customer customer = new Customer(cart);

		customers.put(customer.getCustomerId(), customer);

		return customer.getCustomerId();
	}

	public Article getArticle(int articleId) {
		// Delegation
		return catalog.getArticle(articleId);
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void removeArticleFromCart(Integer customerId, int articleId) {
		// Delegation
		Cart cart = customers.get(customerId).getCart();

		cart.deleteCartItem(articleId);
	}

	public void addArticleToCart(Integer customerId, Integer articleId) {
		Article foundArticle = getArticle(articleId);

		Cart cart = customers.get(customerId).getCart();

		cart.addCartItem(foundArticle);
	}

	public void decrementArticleQuantityInCart(Integer customerId,
			Integer articleId) {
		Cart cart = customers.get(customerId).getCart();

		cart.decrementArticleQuantity(articleId);
	}

	public Order checkOutCart(int customerId) {

		Customer customer = customers.get(customerId);
		Cart cart = customer.getCart();

		Order order = new Order(1);

		int i = 1;

		for (CartItem cartItem : cart.getCartItems()) {
			OrderPosition orderPosition = new OrderPosition(i++);
			orderPosition.setArticle(cartItem.getArticle());
			orderPosition.setArticleQuantity(cartItem.getQuantity());
			order.addOrderPosition(orderPosition);
		}

		customer.addOrder(order);

		return order;
	}

	public Cart getCartForCustomer(Integer customerId) {
		return customers.get(customerId).getCart();
	}

}