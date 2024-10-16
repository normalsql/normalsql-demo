package dogbone;

import java.sql.*;

public class TableIdentifierInspector {

    public static void findTableIdentifier(String tableName, Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        String schema = connection.getSchema(); // Adjust as needed to handle schemas
//        ResultSet rsPrimaryKeys = metaData.getPrimaryKeys(null, schema, tableName);
        ResultSet rsPrimaryKeys = metaData.getPrimaryKeys(null, null, "PETS");
        var digger = metaData.getColumns( null, null, "TEST", "ID" );

        // Collect all primary key columns
        String primaryKeyColumn = null;
        while (rsPrimaryKeys.next()) {
            String columnName = rsPrimaryKeys.getString("COLUMN_NAME");
            if (primaryKeyColumn == null) {
                primaryKeyColumn = columnName; // Single column PK
            } else {
                primaryKeyColumn += ", " + columnName; // Composite PK
            }
        }

        if (primaryKeyColumn != null) {
            System.out.println("Primary Key: " + primaryKeyColumn);
        } else {
            System.out.println("No primary key found. Searching for unique constraints...");

            // Fallback to unique constraint if no primary key is defined
            ResultSet rsUniqueColumns = metaData.getIndexInfo(null, schema, tableName, true, true);

            String uniqueColumns = null;
            while (rsUniqueColumns.next()) {
                if (!rsUniqueColumns.getBoolean("NON_UNIQUE")) {
                    String uniqueColumn = rsUniqueColumns.getString("COLUMN_NAME");
                    if (uniqueColumns == null) {
                        uniqueColumns = uniqueColumn;
                    } else {
                        uniqueColumns += ", " + uniqueColumn; // Composite unique key
                    }
                }
            }

            if (uniqueColumns != null) {
                System.out.println("Unique Constraint: " + uniqueColumns);
            } else {
                System.out.println("No primary key or unique constraint found.");
            }
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:your_database_url"; // Example: jdbc:postgresql://localhost/testdb
        String user = "your_db_user";
        String password = "your_db_password";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            findTableIdentifier("your_table_name", connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
