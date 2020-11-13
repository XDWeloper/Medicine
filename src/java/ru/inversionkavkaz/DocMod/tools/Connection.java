package ru.inversionkavkaz.DocMod.tools;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Connection {
    private static java.sql.Connection connection;
    public static java.sql.Connection  ConnectDB() throws SQLException {
        if(connection != null && !connection.isClosed()) return connection;
        DriverManager.registerDriver(new org.postgresql.Driver());
        connection = DriverManager.getConnection("jdbc:postgresql://inversion-kavkaz.ru/ikmed", "ikmed", "gfhjkmlkzikmed");
        return connection;
    }    
    
        public static int getSeq(String seqString) throws SQLException{
            if(connection == null) ConnectDB();
        ResultSet rs = connection.createStatement().executeQuery(seqString);
        rs.next();
        return rs.getInt(1);
    }
}
