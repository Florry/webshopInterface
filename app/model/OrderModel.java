package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class OrderModel
{
	private final Map<Integer, Integer> products;
	private final String user;
	private final String date;
	private final String id;
	private final static String DEFAULT_ID = "-1";
	
	public OrderModel(String user, Map<Integer, Integer> products, String date, String id)
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
	
	public String getId()
	{
		return id;
	}
	
	@Override
	public String toString()
	{
		
		return String.format("Order %s: %s - %s - %s", getId(), getUser(), getDate(), getContents()
				.toString());
	}
	
	@Override
	public int hashCode()
	{
		int result = 1;
		result += 37 * this.user.hashCode();
		result += 37 * this.id.hashCode();
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
			
			return (user.equals(otherUser.getUser())) && id.equals(otherUser.getId())
					&& isSameClass;
		}
		
		return false;
	}
	
}
