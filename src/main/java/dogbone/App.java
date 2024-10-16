package dogbone;

import petclinic.*;

import java.sql.*;
import java.time.Instant;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
        throws Exception
    {
        Connection conn = DriverManager.getConnection( "jdbc:h2:tcp://localhost/petclinic-jdbc", null, null );
//        TableIdentifierInspector.findTableIdentifier( "pets", conn );

        var report = new PetsReport( conn );
        report.setLast_Name( "Frank%" );
//
//        extracted( report );
//
//        var inserter = new InsertPet( conn );
//        inserter.setName( "Dolly" );
//        Date now = new Date( System.currentTimeMillis() );
//        inserter.setBirth_Date( now );
//        var insertRS = inserter.execute();
//        insertRS.next();
//        var petID = insertRS.getInt( 1 );
//
//        extracted( report );
//
//        var updater = new UpdatePet( conn );
//        updater.setID( petID );
//        var updateCount = updater.execute();
//        extracted( report );
//
//
//        var deleter = new DeletePet( conn );
//        deleter.setID( petID );
//        var deleteCount = deleter.execute();
//        extracted( report );

    }

    public static void extracted( PetsReport report ) throws SQLException
    {
        var reportRS = report.execute();
        while( reportRS.hasNext() )
        {
            System.out.println( reportRS );
        }
    }
}
