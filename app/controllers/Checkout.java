package controllers;

import play.mvc.Controller;
import play.mvc.*;
import views.html.checkout.*;

public class Checkout extends Controller
{
	public static Result doCheckout()
	{
		return ok(checkout.render("Checkout was done!"));
	}
}