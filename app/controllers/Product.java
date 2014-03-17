package controllers;

import java.util.ArrayList;
import java.util.List;

import model.ProductModel;
import play.mvc.*;
import views.html.product.*;

public class Product extends Controller
{
	
	public static Result showAllProducts()
	{
		List<ProductModel> list = getAllProducts();
		return ok(showAllProducts.render(list));
	}
	
	public static Result showProductById(int id)
	{
		ProductModel prod = getProduct(id);
		return ok(showOneProduct.render(prod));
	}
	
	public static Result editProduct()
	{
		return ok(editProducts.render(""));
	}
	
	public static Result showLowStock(int lowestStock)
	{
		List<ProductModel> list = getAllProducts();
		return ok(showLowStockProducts.render(list));
	}
	
	public static ProductModel getProduct(int id)
	{
		List<ProductModel> products = new ArrayList<ProductModel>();
		
		List<Integer> categories = new ArrayList<Integer>();
		categories.add(2);
		categories.add(1);
		products.add(ProductModel.builder("Apple", 2, 35).id(0)
				.description("Small round fruit, tasty. Both green and red in color.").cost(40)
				.rrp(20).categories(categories).build());
		categories.clear();
		categories.add(1);
		products.add(ProductModel
				.builder("Orange", 2, 0)
				.id(1)
				.description(
						"Small round fruit, tasty. Only comes in orange, as the name suggests...")
				.cost(22).rrp(20).categories(categories).build());
		products.add(ProductModel
				.builder("Pear", 2, 90)
				.id(2)
				.description(
						"Small pear-shaped fruit, tasty. Comes in many colors including red, black, yellow and cyan.")
				.cost(10).rrp(20).categories(categories).build());
		
		return products.get(id);
	}
	
	public static List<ProductModel> getAllProducts()
	{
		List<ProductModel> products = new ArrayList<ProductModel>();
		
		List<Integer> categories = new ArrayList<Integer>();
		categories.add(2);
		categories.add(1);
		products.add(ProductModel.builder("Apple", 2, 35).id(0)
				.description("Small round fruit, tasty. Both green and red in color.").cost(40)
				.rrp(20).categories(categories).build());
		categories.clear();
		categories.add(1);
		products.add(ProductModel
				.builder("Orange", 2, 0)
				.id(1)
				.description(
						"Small round fruit, tasty. Only comes in orange, as the name suggests...")
				.cost(22).rrp(20).categories(categories).build());
		products.add(ProductModel
				.builder("Pear", 2, 90)
				.id(2)
				.description(
						"Small pear-shaped fruit, tasty. Comes in many colors including red, black, yellow and cyan.")
				.cost(10).rrp(20).categories(categories).build());
		
		return products;
	}
	
}