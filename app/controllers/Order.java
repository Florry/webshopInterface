package controllers;

import play.mvc.*;
import views.html.order.*;

public class Order extends Controller
{
	public static Result showContents()
	{
		return ok(showOrderContents.render("This a order from user X"));
	}
	
	public static Result editContents()
	{
		return ok(editOrder.render("This is the page for editing contents of the order"));
	}
	
	public static Result showUser()
	{
		return ok(showOrderUser.render("This is the user of the order"));
	}
}