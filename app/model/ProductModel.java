package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ProductModel
{
	public static final int DEFAULT_PRODUCT_ID = -1;
	
	@Id
	@GeneratedValue
	private int id;
	private final String name;
	private final String description;
	private final double cost;
	private final double rrp;
	
	@ManyToMany
	private final List<CategoryModel> categories;
	private final int productType;
	private final int stock;
	
	public ProductModel()
	{
		this("Unkown name", "no description", 0, 0, null, 0, 0);
	}
	
	public ProductModel(String name, String description, double cost, double rrp,
			List<CategoryModel> categories, int productType, int stock)
	{
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.rrp = rrp;
		this.categories = categories;
		this.productType = productType;
		this.stock = stock;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public double getCost()
	{
		return this.cost;
	}
	
	public double getRrp()
	{
		return this.rrp;
	}
	
	public List<CategoryModel> getCategories()
	{
		return categories;
	}
	
	public int getProductType()
	{
		return productType;
	}
	
	public int getStock()
	{
		return stock;
	}
	
	@Override
	public int hashCode()
	{
		if (id != DEFAULT_PRODUCT_ID)
		{
			return 37 * id;
		}
		
		int hash = 37;
		hash *= name.hashCode();
		hash *= description.hashCode();
		hash += cost;
		hash += rrp;
		hash *= categories.hashCode();
		hash *= productType;
		
		return hash;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (obj instanceof ProductModel)
		{
			ProductModel other = (ProductModel) obj;
			
			if ((other.id != DEFAULT_PRODUCT_ID) || (this.id != DEFAULT_PRODUCT_ID))
			{
				return (other.id == this.id);
			}
			
			boolean isEqual = true;
			isEqual = isEqual && other.name.equals(this.name);
			isEqual = isEqual && other.description.equals(this.description);
			isEqual = isEqual && other.cost == this.cost;
			isEqual = isEqual && other.rrp == this.rrp;
			isEqual = isEqual && other.categories.equals(this.categories);
			isEqual = isEqual && other.productType == this.productType;
			
			return isEqual;
			
		}
		return false;
	}
	
	@Override
	public String toString()
	{
		
		return "ID: " + this.id + ", Stock: " + this.stock + ", Name: " + this.name
				+ ", Description: " + this.description + ", Cost: " + this.cost + ", RRP: "
				+ this.rrp + ", Product Type; " + this.productType
				+ ", categories: categories goes here";
	}
}
