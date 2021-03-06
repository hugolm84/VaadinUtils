package au.com.vaadinutils.crud;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import com.vaadin.ui.Table.ColumnGenerator;

public class HeadingPropertySet<E>
{
	private List<HeadingToPropertyId<E>> cols = new LinkedList<HeadingToPropertyId<E>>();
	
	private HeadingPropertySet()
	{
		// use the builder!
	}
	
	public static class Builder<E>
	{
		List<HeadingToPropertyId<E>> cols = new LinkedList<HeadingToPropertyId<E>>();
		
		public HeadingPropertySet<E> build()
		{
			HeadingPropertySet<E> tmp = new HeadingPropertySet<E>();
			tmp.cols = this.cols;
			return tmp;
		}

			
		public  Builder<E> addGeneratedColumn(String heading, String headingPropertyId,ColumnGenerator columnGenerator)
		{
			cols.add(new HeadingToPropertyId<E>(heading,headingPropertyId,columnGenerator));
			return this;
			
		}
		public  Builder<E> addColumn(String heading, String headingPropertyId)
		{
			cols.add(new HeadingToPropertyId<E>(heading,headingPropertyId,null));
			return this;
			
		}
		
		public <T extends Object> Builder<E> addColumn(String heading, SingularAttribute<E, T> headingPropertyId)
		{
			cols.add(new HeadingToPropertyId<E>(heading,headingPropertyId.getName(),null));
			return this;
			
		}
		public <T extends Object> Builder<E> addGeneratedColumn(String heading, SingularAttribute<E, T> headingPropertyId,ColumnGenerator columnGenerator)
		{
			cols.add(new HeadingToPropertyId<E>(heading,headingPropertyId.getName(),columnGenerator));
			return this;
			
		}

	}
	public List<HeadingToPropertyId<E>> getColumns()
	{
		
		return cols;
	}
	
	public String toString()
	{
		return Arrays.toString(cols.toArray());
	}
}
