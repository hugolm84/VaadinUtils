package au.com.vaadinutils.crud;

import javax.persistence.metamodel.SingularAttribute;

import com.google.gwt.thirdparty.guava.common.base.Preconditions;
import com.vaadin.ui.Table.ColumnGenerator;

public class HeadingToPropertyId<E>
{
	private final String heading;
	private final String propertyId;
	private final ColumnGenerator columnGenerator;
	private final SingularAttribute<E, ?> attribute;

	/**
	 * 
	 * @param heading
	 * @param propertyId
	 *            - the real field name
	 * @param columnGenerator2 
	 */
	public <M extends Object> HeadingToPropertyId(String heading, SingularAttribute<E, M> attribute, ColumnGenerator columnGenerator2)
	{
		Preconditions.checkNotNull(attribute);
		this.heading = heading;
		this.propertyId = null;
		this.attribute = attribute;
		this.columnGenerator = columnGenerator2;
	}
	
	/**
	 * 
	 * @param heading
	 * @param propertyId
	 *            - the real field name
	 * @param columnGenerator2 
	 */
	public HeadingToPropertyId(String heading, String propertyId, ColumnGenerator columnGenerator2)
	{
		Preconditions.checkNotNull(propertyId);
		this.heading = heading;
		this.propertyId = propertyId;
		this.attribute = null;
		this.columnGenerator = columnGenerator2;
	}


	public String getPropertyId()
	{
		return (propertyId == null ? this.attribute.getName() : this.propertyId);
	}

	public String getHeader()
	{
		return heading;
	}

	public ColumnGenerator getColumnGenerator()
	{

		return columnGenerator;
	}

	public boolean isGenerated()
	{
		return columnGenerator != null;
	}

}
