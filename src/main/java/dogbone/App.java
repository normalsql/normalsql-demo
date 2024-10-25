package dogbone;

import petclinic.*;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
        throws Exception
    {
        try
        (
            Connection conn = DriverManager.getConnection( "jdbc:h2:tcp://localhost/petclinic-jdbc", null, null );
            SelectPetsByOwner pets = new SelectPetsByOwner( conn );
        )
        {
            pets.setLast_Name( "D%" );

//            System.out.println( "same original: " + pets.toString().equals( pets.__originalSQL ));

            extracted( pets );

            var inserter = new InsertPet( conn );
            inserter.setName( "Dolly" );
            Date now = new Date( System.currentTimeMillis() );
            inserter.setBirth_Date( now );
            var petID = inserter.execute();

            extracted( pets );

            var updater = new UpdatePet( conn );
            updater.setID( petID );
            var updateCount = updater.execute();

            extracted( pets );

            var deleter = new DeletePet( conn );
            deleter.setID( petID );
            var deleteCount = deleter.execute();
            extracted( pets );


        }
    }

    public static void extracted( SelectPetsByOwner pets )
        throws SQLException
    {
//        pets.setLast_Name( "Frank%" );
        var reportRS = pets.execute();
        while( reportRS.hasNext() )
        {
            System.out.println( reportRS );
        }
    }
}
