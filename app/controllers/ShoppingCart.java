package controllers;

import play.mvc.Controller;
import play.mvc.*;
import views.html.shoppingcart.*;

public class ShoppingCart extends Controller
{
	public static Result editContents()
	{
		return ok(editShoppingCartContents
				.render("This is the page for editing the contents of the shopping cart "));
	}
	
	public static Result showContents()
	{
		return ok(showShoppingCartContents.render("This is the shopping cart of user X"));
	}
}