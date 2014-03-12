package controllers;

import play.mvc.Controller;
import play.mvc.*;
import views.html.category.*;

public class Category extends Controller
{
	public static Result showAllCategories()
	{
		return ok(showAllCategories.render("placeholder:  All products:"));
	}
	
	public static Result showCategoryById(int parameter)
	{
		return ok(showOneCategory.render("placeholder: Getting category " + parameter + ":"));
	}
	
	public static Result editCategory()
	{
		return ok(editCategories.render("placeholder: Edit products"));
	}
}