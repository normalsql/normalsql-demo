
/**
* SelectOne.java Tue Sep 03 13:24:43 PDT 2024
*
* Generated using NormalSQL's Select.vm template.
*
* Original SQL:
*
* <pre>
* {@code
* SELECT 1;
* }
* </pre>
*
* @see /Users/jasonosgood/Projects/normalsql/demo/dogbone/SelectOne.sql
*
**/

package dogbone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import java.math.BigDecimal;

public class
	SelectOne
{
	private final PreparedStatement __ps;

	public final String __preparedSQL =
		"SELECT 1;"; 

	public final String __printfSQL =
		"SELECT 1;"; 

	/**
		Pass a Connection. You are responsible for closing that Connection.
		SelectOne is a wrapper for a PreparedStatement, not a Connection.
	**/
	public SelectOne( Connection connection, int resultSetType, int resultSetConcurrency )
		throws SQLException
	{
		__ps = connection.prepareStatement( __preparedSQL, resultSetType, resultSetConcurrency );
	}

	public SelectOne( Connection connection )
		throws SQLException
	{
		this( connection, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
	}

	/**
		Pass a DataSource. You are responsible for closing that DataSource.
		SelectOne is a wrapper for a PreparedStatement, not a Connection.
	**/
	public SelectOne( DataSource dataSource, int resultSetType, int resultSetConcurrency )
		throws SQLException
	{
		this( dataSource.getConnection(), resultSetType, resultSetConcurrency );
	}

	public SelectOne( DataSource dataSource )
		throws SQLException
	{
		this( dataSource, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
	}

	public final SelectOneResultSet execute()
		throws SQLException
	{

        if( __ps.execute() )
        {
	        ResultSet rs = __ps.getResultSet();
			return new SelectOneResultSet( rs );
        }

        return null;
    }

	// TODO add null check to setters (when !isnullable)

	public String toString()
	{
		return String.format( __printfSQL
		);
	}
}