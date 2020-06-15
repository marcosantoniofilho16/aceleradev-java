package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items.stream().mapToDouble(item -> {
			Optional<Product> product = productRepository.findById(item.getProductId());
			Double total = 0D;

			if (product.isPresent()) {
				Double value = product.get().getIsSale() ? product.get().getValue() * 0.8 : product.get().getValue();

				total = item.getQuantity() * value;
			}

			return total;
		}).reduce(0, (total, totalOrder) -> total + totalOrder);
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream().map(productRepository::findById).filter(p -> p.isPresent()).map(p -> p.get())
				.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream().mapToDouble(this::calculateOrderValue).reduce(0,
				(total, totalOrders) -> total + totalOrders);
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return this.findProductsById(productIds).stream().collect(Collectors.groupingBy(Product::getIsSale));
	}

}