package controllers;

import java.util.List;
import com.avaje.ebean.Ebean;

import model.ProductModel;
import play.mvc.*;
import views.html.product.*;

public class Product extends Controller
{
	
	public static Result showAllProducts()
	{
		List<ProductModel> list = getAllProducts();
		return ok(showAllProducts.render(list));
	}
	
	public static Result showProductById(int id)
	{
		return ok(showOneProduct.render(getProduct(id)));
	}
	
	public static Result editProduct()
	{
		return ok(editProducts.render(""));
	}
	
	public static Result showLowStock(int lowestStock)
	{
		return ok(showLowStockProducts.render(getAllProducts()));
	}
	
	public static ProductModel getProduct(int id)
	{
		return Ebean.find(ProductModel.class, id);
	}
	
	public static List<ProductModel> getAllProducts()
	{
		return Ebean.find(ProductModel.class).findList();
	}
	
}