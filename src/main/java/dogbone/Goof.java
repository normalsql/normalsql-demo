package dogbone;

import java.io.IOException;

public class Goof
    implements
        AutoCloseable
{
    public Goof()
    {

    }

    public static void main( String[] args )
    {
        try( Goof goof = new Goof(); )
        {
            goof.doobie();
        }
        catch( Exception exception )
        {
            System.out.println( "caught" );
        }
    }

    public void doobie() throws IOException
    {
        System.out.println( "doobie" );
        throw new IOException( "ball" );
    }

    @Override
    public void close() throws IOException
    {
        System.out.println( "auto closed - dang it" );
    }
}
