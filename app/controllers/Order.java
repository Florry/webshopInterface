package controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import model.OrderModel;
import model.ProductModel;
import play.mvc.*;
import views.html.order.*;

public class Order extends Controller
{
	public static Result showContents(int id)
	{
		return ok(showOrderContents.render(getOrder(id)));
	}
	
	public static Result showAllOrders()
	{
		List<OrderModel> orders = getAllOrders();
		return ok(showAllOrders.render(orders));
	}
	
	public static OrderModel getOrder(int id)
	{
		List<OrderModel> orders = new ArrayList<OrderModel>();
		Map<Integer, Integer> products = new LinkedHashMap<Integer, Integer>();
		products.put(2, 2);
		products.put(1, 2);
		orders.add(new OrderModel("Persson@Persson.se", products, "2014-08-28", "0"));
		orders.add(new OrderModel("leif@1337.se", products, "2013-01-05", "1"));
		orders.add(new OrderModel("cmon@letsgo.com", products, "2011-12-12", "2"));
		return orders.get(id);
	}
	
	public static List<OrderModel> getAllOrders()
	{
		List<OrderModel> orders = new ArrayList<OrderModel>();
		Map<Integer, Integer> products = new LinkedHashMap<Integer, Integer>();
		products.put(2, 2);
		products.put(1, 2);
		orders.add(new OrderModel("Persson@Persson.se", products, "2014-08-28", "0"));
		orders.add(new OrderModel("leif@1337.se", products, "2013-01-05", "1"));
		orders.add(new OrderModel("cmon@letsgo.com", products, "2011-12-12", "2"));
		return orders;
	}
	
	public static Result editContents()
	{
		return ok(editOrder.render(""));
	}
	
}