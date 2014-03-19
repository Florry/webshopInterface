package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public final class CategoryModel
{
	public static final int DEFAULT_ID = -1;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int staff_responsible;
	
	@ManyToMany(mappedBy = "categories")
	public List<ProductModel> products;
	
	public CategoryModel(String name, int staff_responsible)
	{
		this.name = name;
		this.staff_responsible = staff_responsible;
	}
	
	public CategoryModel(int id, CategoryModel other)
	{
		this(other.name, other.staff_responsible);
	}
	
	public CategoryModel()
	{
		this("Unkown category", -1);
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getStaff_responsible()
	{
		return staff_responsible;
	}
	
	@Override
	public int hashCode()
	{
		return 31 * id;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj instanceof CategoryModel)
		{
			CategoryModel other = (CategoryModel) obj;
			return id == other.id;
		}
		return false;
	}
	
	public String toString()
	{
		return String.format("Id: %s, Name: %s, Straff_responsible: %s", id, name,
				staff_responsible);
	}
	
}
