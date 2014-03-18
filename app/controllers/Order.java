package controllers;

import java.util.List;
import com.avaje.ebean.Ebean;

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
	
	public static Result editContents()
	{
		return ok(editOrder.render(""));
	}
	
}