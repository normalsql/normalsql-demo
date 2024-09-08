
/**
* SelectOneResultSet.java Tue Sep 03 13:24:43 PDT 2024
*
* Generated using NormalSQL's ResultSet.vm template.
*
* @see /Users/jasonosgood/Projects/normalsql/demo/dogbone/SelectOne.sql
*
**/

package dogbone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;

public class 
	SelectOneResultSet
{
	public SelectOneResultSet( ResultSet resultSet )
	{
		__resultSet = resultSet;
	}

	private ResultSet __resultSet;

	public final ResultSet getResultSet()
	{
		return __resultSet;
	}

	public boolean hasResultSet()
	{
		return __resultSet != null;
	}

	private Connection __connection = null;

	public void setConnection( Connection connection )
	{
		__connection = connection;
	}

	public Connection getConnection()
	{
		return __connection;
	}

	/**
		Closes the contained ResultSet instance. Also closes contained Connection instance
		created via a DataSource connection factory.
	**/
	public void close()
		throws SQLException
	{
		if( __resultSet != null && !__resultSet.isClosed() )
		{
			__resultSet.close();
			__resultSet = null;
		}
		if( __connection != null && !__connection.isClosed() )
		{
			__connection.close();
			__connection = null;
		}
	}

	private int __row = 0;

	public int getRow() { return __row; }

	public final boolean hasNext()
		throws SQLException
	{
		ResultSet rs = getResultSet();
		if( rs == null ) return false;
		boolean	success = rs.next();
		if( success )
		{
			__row = rs.getRow();
			_1 = rs.getInt( 1 );
		}
		return success;
	}

	/**
     *  Attempt to count this ResultSet's number of rows.
     *  @return number of rows. Or -1 if ResultSet's scroll type is TYPE_FORWARD_ONLY
     *  or if any exception occurs.
     */
	public int countRows()
	{
		int result = -1;
		try
		{
			ResultSet rs = getResultSet();
			if( rs.getType() != ResultSet.TYPE_FORWARD_ONLY )
			{
				int current = rs.getRow();
				if( rs.last() )
				{
					result = rs.getRow();
					if( current == 0 )
					{
						rs.beforeFirst();
					}
					else
					{
						rs.absolute( current );
					}
				}
			}
		}
		catch( SQLException e )
		{
			e.printStackTrace();
		}
		return result;
	}

	private Integer _1 = 0;
	/** column "1" **/
	public Integer get1() { return _1; }


	// TODO switch from StringBuilder to printf
	public String toString()
	{
		if( getResultSet() == null )
		{
			return "No results";
		}
		if( getRow() == 0 )
		{
			return "No current row";
		}
		StringBuilder sb = new StringBuilder();
		sb.append( "#row: " );
		sb.append( getRow() );
		sb.append( ", " );
		sb.append( "1: " );
		sb.append( get1() );
		return sb.toString();
	}

}
