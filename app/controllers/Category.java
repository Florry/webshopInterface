package controllers;

import model.CategoryModel;
import model.ProductModel;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.category.*;

public class Category extends Controller
{
	@Transactional
	public static Result showAllCategories()
	{
		return ok(showAllCategories.render(JPA.em()
				.createQuery("SELECT a FROM CategoryModel a", CategoryModel.class).getResultList()));
	}
	
	@Transactional
	public static Result showCategoryById(int id)
	{
		return ok(showOneCategory.render(getCategory(id)));
	}
	
	public static Result editCategory()
	{
		return ok(editCategories.render(""));
	}
	
	@Transactional
	public static CategoryModel getCategory(int id)
	{
		return JPA.em().find(CategoryModel.class, id);
	}
	
}