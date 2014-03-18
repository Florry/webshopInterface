package controllers;

import java.util.List;

import model.OrderModel;
import play.mvc.*;
import views.html.order.*;

public class Order extends Controller
{
	public static Result showContents(int id)
	{
		OrderModel order = getOrder(id);
		return ok(showOrderContents.render(order, User.getUser(order.getUser())));
	}
	
	public static Result showAllOrders()
	{
		return ok(showAllOrders.render(getAllOrders()));
	}
	
	public static OrderModel getOrder(int id)
	{
		return Ebean.find(OrderModel.class, id);
	}
	
	public static List<OrderModel> getAllOrders()
	{
		return Ebean.find(OrderModel.class).findList();
	}
	
	// public static OrderModel getOrder(int id)
	// {
	// List<OrderModel> orders = new ArrayList<OrderModel>();
	// Map<Integer, Integer> products = new LinkedHashMap<Integer, Integer>();
	// products.put(2, 2);
	// products.put(1, 2);
	// orders.add(new OrderModel("Persson@Persson.se", products, "2014-08-28",
	// 1));
	// orders.add(new OrderModel("leif@1337.se", products, "2013-01-05", 2));
	// orders.add(new OrderModel("cmon@letsgo.com", products, "2011-12-12", 3));
	// return orders.get(id);
	// }
	//
	// public static List<OrderModel> getAllOrders()
	// {
	// List<OrderModel> orders = new ArrayList<OrderModel>();
	// Map<Integer, Integer> products = new LinkedHashMap<Integer, Integer>();
	// products.put(2, 2);
	// products.put(1, 2);
	// orders.add(new OrderModel("Persson@Persson.se", products, "2014-08-28",
	// 1));
	// orders.add(new OrderModel("leif@1337.se", products, "2013-01-05", 2));
	// orders.add(new OrderModel("cmon@letsgo.com", products, "2011-12-12", 3));
	// return orders;
	// }
	
	public static Result editContents()
	{
		return ok(editOrder.render(""));
	}
	
}