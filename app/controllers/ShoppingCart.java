package controllers;

import java.util.ArrayList;
import java.util.List;

import play.mvc.*;
import views.html.shoppingcart.*;
import model.CategoryModel;
import model.ProductModel;

public class ShoppingCart extends Controller
{
	public static Result editContents()
	{
		return ok(editShoppingCartContents.render(""));
	}
	
	public static Result showContents()
	{
		List<ProductModel> contents = getContents();
		return ok(showShoppingCartContents.render(contents, getPrice(getContents())));
	}
	
	private static List<ProductModel> getContents()
	{
		List<ProductModel> contents = new ArrayList<ProductModel>();
		
		List<CategoryModel> productCategories = new ArrayList<CategoryModel>();
		
		productCategories.add(controllers.Category.getCategory(1));
		productCategories.add(controllers.Category.getCategory(2));
		
		productCategories.clear();
		
		productCategories.add(controllers.Category.getCategory(1));
		productCategories.add(controllers.Category.getCategory(2));
		contents.add(new ProductModel("Apple",
				"Small round fruit, tasty. Both green and red in color.", 40, 20,
				productCategories, 2, 35));
		
		productCategories.add(controllers.Category.getCategory(3));
		contents.add(new ProductModel("Orange",
				"Small round fruit, tasty. Only comes in orange, as the name suggests", 22, 20,
				productCategories, 2, 0));
		
		return contents;
	}
	
	private static int getPrice(List<ProductModel> contents)
	{
		int price = 0;
		for (ProductModel product : contents)
		{
			price += product.getCost();
		}
		return price;
	}
}