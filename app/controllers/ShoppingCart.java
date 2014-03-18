package controllers;

import java.util.ArrayList;
import java.util.List;
import com.avaje.ebean.Ebean;

import play.mvc.*;
import views.html.shoppingcart.*;
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
		List<Integer> categories = new ArrayList<Integer>();
		categories.add(2);
		categories.add(1);
		contents.add(ProductModel.builder(0, "Apple", 2, 35)
				.description("Small round fruit, tasty. Both green and red in color.").cost(40)
				.rrp(20).categories(categories).build());
		categories.clear();
		categories.add(1);
		contents.add(ProductModel
				.builder(1, "Orange", 2, 0)
				.description(
						"Small round fruit, tasty. Only comes in orange, as the name suggests...")
				.cost(22).rrp(20).categories(categories).build());
		contents.add(ProductModel
				.builder(2, "Pear", 2, 90)
				.description(
						"Small pear-shaped fruit, tasty. Comes in many colors including red, black, yellow and cyan.")
				.cost(10).rrp(20).categories(categories).build());
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