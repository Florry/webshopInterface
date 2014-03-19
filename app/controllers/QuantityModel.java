package controllers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuantityModel
{
	@Id
	@GeneratedValue
	private final int id;
	private final int quantity;
	
	public QuantityModel(int id, int quantity)
	{
		this.id = id;
		this.quantity = quantity;
	}
	
	public QuantityModel(int quantity)
	{
		this.quantity = quantity;
		this.id = -1;
	}
	
	public QuantityModel()
	{
		this(-1, -1);
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
}
