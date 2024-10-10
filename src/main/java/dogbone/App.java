package dogbone;

import petclinic.PetsReport;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
        throws Exception
    {
        System.out.println( "Hello World!" );

        Connection conn = DriverManager.getConnection( "jdbc:h2:tcp://localhost/petclinic-jdbc", null, null );

        var report = new PetsReport( conn );
        report.setLast_Name( "%" );
        var reportRS = report.execute();
        while( reportRS.hasNext() )
        {
            System.out.println( reportRS.toString() );
        }
//        SelectOne selectOne = new SelectOne( conn );
//        SelectOneResultSet ugh = selectOne.execute();
//        while( ugh.hasNext() )
//        {
//            System.out.println(ugh.getONE());
//        }
    }
}
