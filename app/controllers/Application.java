package controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
		users.add(new UserModel.Builder("Persson@Persson.se", "bullshit", "perssons", "persson",
				"strandvägen 2", "stockholm", "14463").dob("1943-08-12").address2("")
				.telephone("9090987543").build());
		users.add(new UserModel.Builder("leif@1337.se", "Test", "Leifodor", "1337son",
				"Bergvägen 4", "stockholm", "14463").dob("1991-02-01").address2("")
				.telephone("0708574937").build());
		users.add(new UserModel.Builder("cmon@letsgo.com", "password", "Comon", "Letsgo",
				"TORSGATAN 2", "stockholm", "14463").telephone("0703487264").dob("1980-02-24")
				.address2("").build());
		
		// ORDER
		List<OrderModel> orders = new ArrayList<OrderModel>();
		Map<Integer, Integer> orderProducts = new LinkedHashMap<Integer, Integer>();
		orderProducts.put(2, 2);
		orderProducts.put(2, 2);
		orderProducts.put(1, 2);
		orders.add(new OrderModel("Persson@Persson.se", orderProducts, "2014-08-28", 1));
		orders.add(new OrderModel("leif@1337.se", orderProducts, "2013-01-05", 2));
		orders.add(new OrderModel("cmon@letsgo.com", orderProducts, "2011-12-12", 3));
		
		// CATEGORY
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		categories.add(new CategoryModel(1, "Fruit", 2));
		categories.add(new CategoryModel(2, "Books", 2));
		categories.add(new CategoryModel(3, "Films", 2));
		categories.add(new CategoryModel(4, "CD-ROMs", 2));
		categories.add(new CategoryModel(5, "Headsets", 2));
		
		// PRODUCT
		List<ProductModel> products = new ArrayList<ProductModel>();
		products.add(ProductModel.builder(1, "Apple", 2, 35)
				.description("Small round fruit, tasty. Both green and red in color.").cost(40)
				.rrp(20).build());
		products.add(ProductModel
				.builder(2, "Orange", 2, 0)
				.description(
						"Small round fruit, tasty. Only comes in orange, as the name suggests...")
				.cost(22).rrp(20).build());
		products.add(ProductModel
				.builder(3, "Pear", 2, 90)
				.description(
						"Small pear-shaped fruit, tasty. Comes in many colors including red, black, yellow and cyan.")
				.cost(10).rrp(20).build());
		
		// private final List<Integer> categories;
		//
		// if (Ebean.find(UserModel.class).findSet().size() > 0)
		// {
		// Ebean.delete(Ebean.find(UserModel.class).findList());
		// }
		// if (Ebean.find(OrderModel.class).findSet().size() > 0)
		// {
		// Ebean.delete(Ebean.find(OrderModel.class).findList());
		// }
		// if (Ebean.find(CategoryModel.class).findSet().size() > 0)
		// {
		// Ebean.delete(Ebean.find(CategoryModel.class).findList());
		// }
		// if (Ebean.find(ProductModel.class).findSet().size() > 0)
		// {
		// Ebean.delete(Ebean.find(ProductModel.class).findList());
		// }
		
		JPA.em().persist(users);
		JPA.em().persist(orders);
		JPA.em().persist(categories);
		JPA.em().persist(products);
		
		List<UserModel> getUsers = JPA.em()
				.createQuery("SELECT a FROM UserModel a", UserModel.class).getResultList();
		List<ProductModel> getProducts = JPA.em()
				.createQuery("SELECT a FROM ProductModel a", ProductModel.class).getResultList();
		List<OrderModel> getOrders = JPA.em()
				.createQuery("SELECT a FROM OrderModel a", OrderModel.class).getResultList();
		List<CategoryModel> getCategories = JPA.em()
				.createQuery("SELECT a FROM CategoryModel a", CategoryModel.class).getResultList();
		
		return ok("ok \n " + getUsers + " \n " + getProducts + " \n " + getOrders + " \n "
				+ getCategories);
	}
}
