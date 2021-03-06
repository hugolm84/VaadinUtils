package au.com.vaadinutils.fields;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.vaadin.data.Property;
import com.vaadin.data.Validator;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.ui.Button;
import com.vaadin.ui.Field;

public class DataBoundButton<T> extends Button implements Field<T>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2137449474336770169L;
	private Property<T> dataSource;
	private boolean required = false;
	private String requiredMessage = "";
	private T value;

	final Class<T> type;
	private boolean invalidCommitted = false;
	private boolean buffered = false;

	Set<Validator> validators = new HashSet<Validator>();
	private boolean invalidAllowed = true;

	Set<ValueChangeListener> listeners = new HashSet<ValueChangeListener>();

	DataBoundButton(Class<T> type)
	{
		super();
		this.type = type;
	}

	public DataBoundButton(String fieldLabel, Class<T> type2)
	{
		super(fieldLabel);
		type = type2;
	}

	@Override
	public boolean isInvalidCommitted()
	{
		return invalidCommitted;
	}

	@Override
	public void setInvalidCommitted(boolean isCommitted)
	{
		invalidCommitted = isCommitted;

	}

	@Override
	public void commit() throws SourceException, InvalidValueException
	{
		dataSource.setValue(value);

	}

	@Override
	public void discard() throws SourceException
	{
		
		value = dataSource.getValue();

	}

	@Override
	public void setBuffered(boolean buffered)
	{
		this.buffered = buffered;

	}

	@Override
	public boolean isBuffered()
	{

		return buffered;
	}

	@Override
	public boolean isModified()
	{
		return false;
	}

	@Override
	public void addValidator(Validator validator)
	{
		validators.add(validator);

	}

	@Override
	public void removeValidator(Validator validator)
	{
		validators.remove(validator);

	}

	@Override
	public void removeAllValidators()
	{
		validators.clear();

	}

	@Override
	public Collection<Validator> getValidators()
	{
		return validators;
	}

	@Override
	public boolean isValid()
	{
		return true;
	}

	@Override
	public void validate() throws InvalidValueException
	{

	}

	@Override
	public boolean isInvalidAllowed()
	{
		return invalidAllowed;
	}

	@Override
	public void setInvalidAllowed(boolean invalidValueAllowed) throws UnsupportedOperationException
	{
		invalidAllowed = invalidValueAllowed;
	}

	@Override
	public T getValue()
	{
		System.out.println(value);
		return value;
	}

	@Override
	public void setValue(T newValue) throws ReadOnlyException
	{
		System.out.println(value);
		value = newValue;

	}

	@Override
	public Class<T> getType()
	{
		return type;
	}

	@Override
	public void addValueChangeListener(ValueChangeListener listener)
	{
		listeners.add(listener);

	}

	@Override
	public void addListener(ValueChangeListener listener)
	{
		listeners.add(listener);

	}

	@Override
	public void removeValueChangeListener(ValueChangeListener listener)
	{
		listeners.remove(listener);

	}

	@Override
	public void removeListener(ValueChangeListener listener)
	{
		listeners.remove(listener);

	}

	@Override
	public void valueChange(com.vaadin.data.Property.ValueChangeEvent event)
	{
		System.out.println("Value changed");

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setPropertyDataSource(Property newDataSource)
	{
		System.out.println("data source set");
		this.dataSource = newDataSource;
		value = dataSource.getValue();

	}

	@Override
	public Property<T> getPropertyDataSource()
	{
		return dataSource;
	}

	@Override
	public boolean isRequired()
	{
		return required;
	}

	@Override
	public void setRequired(boolean required)
	{
		this.required = required;

	}

	@Override
	public void setRequiredError(String requiredMessage)
	{
		this.requiredMessage = requiredMessage;

	}

	@Override
	public String getRequiredError()
	{
		return requiredMessage;
	}

}
