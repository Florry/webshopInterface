package model;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderModel
{
	private final Map<Integer, Integer> products;
	private final String user;
	private final String date;
	@Id
	private final int id;
	private final static int DEFAULT_ID = -1;
	
	public OrderModel(String user, Map<Integer, Integer> products, String date, int id)
	{
		this.id = id;
		this.date = date;
		this.user = user;
		this.products = new LinkedHashMap<>(products);
	}
	
	public OrderModel(String user, Map<Integer, Integer> products, String date)
	{
		this(user, products, date, DEFAULT_ID);
	}
	
	public String getUser()
	{
		return user;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public Map<Integer, Integer> getContents()
	{
		return products;
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
