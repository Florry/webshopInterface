package controllers;

import play.mvc.Controller;
import play.mvc.*;
import views.html.product.*;

public class Product extends Controller
{
	public static Result showAllProducts()
	{
		return ok(showAllProducts.render("placeholder:  All products:"));
	}
	
	public static Result showProductById(int parameter)
	{
		return ok(showOneProduct.render("placeholder: Product " + parameter + ": "));
	}
	
	public static Result editProduct()
	{
		return ok(editProducts.render("placeholder: Edit products"));
	}
	
	public static Result showLowStock(int lowestStock)
	{
		return ok(showLowStockProducts
				.render("These few products are low on stock! " + lowestStock));
	}
}