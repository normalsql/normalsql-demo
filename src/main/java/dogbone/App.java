package dogbone;

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
//        Class.forName( "org.h2.Driver" );
        Class.forName( "com.mysql.jdbc.Driver" );
//        Class.forName( "org.h2.Driver" );
    }
}
