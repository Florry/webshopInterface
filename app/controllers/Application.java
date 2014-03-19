package controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.CategoryModel;
import model.OrderModel;
import model.ProductModel;
import model.UserModel;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;

public class Application extends Controller
{
	public static Result home()
	{
		return ok(index.render("Welcome", null));
	}
	
	@Transactional
	public static Result populateDatabase()
	{
		
		// USER
		List<UserModel> users = new ArrayList<UserModel>();
		users.add(new UserModel("Persson@persson.se", "bullshit", "perssons", "persson",
				"1943-08-12", "0703487564", "Strandvägen 2", "", "Stockholm", "14462"));
		users.add(new UserModel("lefi@1337.se", "Test", "Lefidor", "1337son", "Bergvägen 4",
				"0704596049", "Bergvägen 4", "C/O ", "Stockholm", "14462"));
		users.add(new UserModel("cmon@letsgo.com", "password", "Comon", "Letsgo", "2012-02-01",
				"0704596049", "TORSGATAN 44", "C/O Nonsense", "Stockholm", "14462"));
		
		for (UserModel user : users)
		{
			JPA.em().persist(user);
		}
		
		// CATEGORY
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		categories.add(new CategoryModel("Fruit", 2));
		categories.add(new CategoryModel("Books", 2));
		categories.add(new CategoryModel("Films", 2));
		categories.add(new CategoryModel("CD-ROMs", 2));
		categories.add(new CategoryModel("Headsets", 2));
		
		for (CategoryModel category : categories)
		{
			JPA.em().persist(category);
		}
		
		// PRODUCT
		List<ProductModel> products = new ArrayList<ProductModel>();
		List<CategoryModel> productCategories = new ArrayList<CategoryModel>();
		List<CategoryModel> productCategories2 = new ArrayList<CategoryModel>();
		List<CategoryModel> productCategories3 = new ArrayList<CategoryModel>();
		
		productCategories.add(categories.get(1));
		productCategories.add(categories.get(2));
		products.add(new ProductModel("Apple",
				"Small round fruit, tasty. Both green and red in color.", 40, 20,
				productCategories, 2, 35));
		
		productCategories2.add(categories.get(3));
		productCategories2.add(categories.get(4));
		products.add(new ProductModel("Orange",
				"Small round fruit, tasty. Only comes in orange, as the name suggests", 22, 20,
				productCategories2, 2, 0));
		
		productCategories3.add(categories.get(3));
		productCategories3.add(categories.get(1));
		products.add(new ProductModel(
				"Pear",
				"Small pear-shaped fruit, tasty. Comes in many colors including red, black, yellow and cyan.",
				10, 20, productCategories3, 2, 90));
		
		for (ProductModel product : products)
		{
			JPA.em().persist(product);
		}
		
		// ORDER
		List<OrderModel> orders = new ArrayList<OrderModel>();
		
		Map<ProductModel, QuantityModel> orderProductsMap1 = new LinkedHashMap<ProductModel, QuantityModel>();
		Map<ProductModel, QuantityModel> orderProductsMap2 = new LinkedHashMap<ProductModel, QuantityModel>();
		Map<ProductModel, QuantityModel> orderProductsMap3 = new LinkedHashMap<ProductModel, QuantityModel>();
		
		QuantityModel quantity1 = new QuantityModel(2);
		QuantityModel quantity2 = new QuantityModel(3);
		QuantityModel quantity3 = new QuantityModel(5);
		
		orderProductsMap1.put(products.get(1), quantity1);
		orderProductsMap1.put(products.get(2), quantity2);
		orderProductsMap1.put(products.get(1), quantity3);
		
		orderProductsMap2.put(products.get(1), quantity2);
		orderProductsMap2.put(products.get(2), quantity2);
		orderProductsMap2.put(products.get(1), quantity3);
		
		orderProductsMap2.put(products.get(1), quantity1);
		orderProductsMap2.put(products.get(2), quantity2);
		orderProductsMap2.put(products.get(1), quantity3);
		
		OrderModel order1 = new OrderModel(users.get(0).getEmail(), orderProductsMap1, "2014-08-28");
		OrderModel order2 = new OrderModel(users.get(1).getEmail(), orderProductsMap2, "1947-02-12");
		OrderModel order3 = new OrderModel(users.get(2).getEmail(), orderProductsMap3, "2011-12-12");
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
		for (OrderModel order : orders)
		{
			// JPA.em().persist(order);
		}
		
		List<UserModel> getUsers = JPA.em()
				.createQuery("SELECT a FROM UserModel a", UserModel.class).getResultList();
		List<ProductModel> getProducts = JPA.em()
				.createQuery("SELECT a FROM ProductModel a", ProductModel.class).getResultList();
		List<OrderModel> getOrders = JPA.em()
				.createQuery("SELECT a FROM OrderModel a", OrderModel.class).getResultList();
		List<CategoryModel> getCategories = JPA.em()
				.createQuery("SELECT a FROM CategoryModel a", CategoryModel.class).getResultList();
		
		return ok(populate.render(getUsers, getProducts, order1, getCategories));
	}
}
