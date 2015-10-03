package net.runelite.deob.pool;

import net.runelite.deob.ConstantPool;
import net.runelite.deob.execution.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Integer extends PoolEntry
{
	private int value;

	public Integer(ConstantPool pool, DataInputStream is) throws IOException
	{
		super(ConstantType.INTEGER);

		value = is.readInt();
	}
	
	public Integer(int i)
	{
		super(ConstantType.INTEGER);
		
		value = i;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Integer))
			return false;
		
		Integer i = (Integer) other;
		return value == i.value;
	}
	
	@Override
	public java.lang.String toString()
	{
		return "" + value;
	}

	@Override
	public Type getTypeClass()
	{
		return new Type(int.class.getCanonicalName());
	}

	@Override
	public void write(DataOutputStream out) throws IOException
	{
		out.writeInt(value);
	}
	
	@Override
	public Object getObject()
	{
		return value;
	}
}
