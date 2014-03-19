package controllers;

import java.util.List;

import model.OrderModel;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.order.*;

public class Order extends Controller
{
	@Transactional
	public static Result showContents(int id)
	{
		OrderModel order = getOrder(id);
		return ok(showOrderContents.render(order, User.getUser(order.getUser())));
	}
	
	@Transactional
	public static Result showAllOrders()
	{
		return ok(showAllOrders.render(getAllOrders()));
	}
	
	@Transactional
	public static OrderModel getOrder(int id)
	{
		return JPA.em().find(OrderModel.class, id);
	}
	
	@Transactional
	public static List<OrderModel> getAllOrders()
	{
		return JPA.em().createQuery("SELECT a FROM OrderModel a", OrderModel.class).getResultList();
	}
	
	@Transactional
	public static Result editContents()
	{
		return ok(editOrder.render(""));
	}
	
}