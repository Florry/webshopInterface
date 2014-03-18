package controllers;

import com.avaje.ebean.Ebean;

import model.CategoryModel;
import model.ProductModel;
import play.mvc.*;
import views.html.category.*;

public class Category extends Controller
{
	
	public static Result showAllCategories()
	{
		return ok(showAllCategories.render(Ebean.find(CategoryModel.class).findList()));
	}
	
	public static Result showCategoryById(int id)
	{
		return ok(showOneCategory
				.render(getCategory(id), Ebean.find(ProductModel.class).findList()));
	}
	
	public static Result editCategory()
	{
		return ok(editCategories.render(""));
	}
	
	public static CategoryModel getCategory(int id)
	{
		return Ebean.find(CategoryModel.class, id);
	}
	
}