package model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import controllers.QuantityModel;

@Entity
public class OrderModel
{
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToMany
	private final List<ProductModel> products;
	@ManyToMany
	private final List<QuantityModel> quantities;
	private final String user;
	private final String date;
	
	public OrderModel(String user, Map<ProductModel, QuantityModel> products, String date)
	{
		this.date = date;
		this.user = user;
		this.products = new LinkedList<ProductModel>();
		this.products.addAll(products.keySet());
		this.quantities = new LinkedList<QuantityModel>();
		this.quantities.addAll(products.values());
	}
	
	public OrderModel()
	{
		this("no@email.com", new LinkedHashMap<ProductModel, QuantityModel>(), "1970-01-01");
	}
	
	public String getUser()
	{
		return user;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public List<ProductModel> getProducts()
	{
		return products;
	}
	
	public List<QuantityModel> getQuantities()
	{
		return quantities;
	}
	
	public LinkedHashMap<ProductModel, QuantityModel> getContents()
	{
		LinkedHashMap<ProductModel, QuantityModel> map = new LinkedHashMap<ProductModel, QuantityModel>();
		LinkedList<ProductModel> product = new LinkedList<ProductModel>();
		LinkedList<QuantityModel> quantity = new LinkedList<QuantityModel>();
		for (int i = 0; i < product.size(); i++)
		{
			map.put(product.get(i), quantity.get(i));
		}
		return map;
	}
	
	public int getId()
	{
		return id;
	}
	
	@Override
	public String toString()
	{
		return "Order " + this.getId() + ": " + this.getUser() + " - " + getDate() + " - "
				+ getContents();
	}
	
	@Override
	public int hashCode()
	{
		int result = 1;
		result += 37 * this.user.hashCode();
		result += 37 * this.id;
		result += 37 * this.getClass().hashCode();
		
		return result;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (other == this)
		{
			return true;
		}
		
		if (other instanceof OrderModel)
		{
			OrderModel otherUser = (OrderModel) other;
			boolean isSameClass = this.getClass().equals(otherUser.getClass());
			
			return (user.equals(otherUser.getUser())) && id == otherUser.getId() && isSameClass;
		}
		
		return false;
	}
}
