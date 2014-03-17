package controllers;

import java.util.ArrayList;
import java.util.List;

import model.CategoryModel;
import model.ProductModel;
import play.mvc.*;
import views.html.category.*;

public class Category extends Controller
{
	public static Result showAllCategories()
	{
		List<CategoryModel> category = getAllCategories();
		return ok(showAllCategories.render(category));
	}
	
	public static Result showCategoryById(int id)
	{
		CategoryModel category = getCategory(id);
		List<ProductModel> products = Product.getAllProducts();
		return ok(showOneCategory.render(category, products));
	}
	
	public static Result editCategory()
	{
		return ok(editCategories.render(""));
	}
	
	public static List<CategoryModel> getAllCategories()
	{
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		categories.add(new CategoryModel(0, "Fruit", 2));
		categories.add(new CategoryModel(1, "Books", 2));
		categories.add(new CategoryModel(2, "Films", 2));
		categories.add(new CategoryModel(3, "CD-ROMs", 2));
		categories.add(new CategoryModel(4, "Headsets", 2));
		
		return categories;
	}
	
	public static CategoryModel getCategory(int id)
	{
		List<CategoryModel> categories = new ArrayList<CategoryModel>();
		categories.add(new CategoryModel(0, "Fruit", 2));
		categories.add(new CategoryModel(1, "Books", 2));
		categories.add(new CategoryModel(2, "Films", 2));
		categories.add(new CategoryModel(3, "CD-ROMs", 2));
		categories.add(new CategoryModel(4, "Headsets", 2));
		
		return categories.get(id);
	}
}