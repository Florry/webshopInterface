package controllers;

import java.util.List;

import model.ProductModel;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.product.*;

public class Product extends Controller
{
	@Transactional
	public static Result showAllProducts()
	{
		List<ProductModel> list = getAllProducts();
		return ok(showAllProducts.render(list));
	}
	
	@Transactional
	public static Result showProductById(int id)
	{
		return ok(showOneProduct.render(getProduct(id)));
	}
	
	public static Result editProduct()
	{
		return ok(editProducts.render(""));
	}
	
	@Transactional
	public static Result showLowStock(int lowestStock)
	{
		return ok(showLowStockProducts.render(getAllProducts()));
	}
	
	@Transactional
	public static ProductModel getProduct(int id)
	{
		return JPA.em().find(ProductModel.class, id);
	}
	
	@Transactional
	public static List<ProductModel> getAllProducts()
	{
		return JPA.em().createQuery("SELECT a FROM ProductModel a", ProductModel.class)
				.getResultList();
	}
	
}