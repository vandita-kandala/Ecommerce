
package com.vandita.database;

import static com.vandita.database.DatabaseInfo.usersDb;
import com.vandita.pkg.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vandita
 */
public class UserDB {

    Connection connection;
    Statement statement;
            
    public UserDB() throws ClassNotFoundException, SQLException {

    Class.forName("com.mysql.cj.jdbc.Driver");
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nbad","root","");
    statement = connection.createStatement();
    }
    
    
    public boolean createUser(User user) throws SQLException {
        
        statement.executeUpdate("insert into user values ('"+user.getName()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getType()+"')");
        
        return true;
    }

    public User getUser(String email) throws SQLException {

       List<User> allUsers = new ArrayList<User>();
        
       allUsers = getUsers();
       
        for (User user : allUsers) {
            if (email.equals(user.getEmail())) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() throws SQLException {

        ResultSet rs = statement.executeQuery(
            "SELECT * FROM user");
          ResultSetMetaData metaData = rs.getMetaData();       
        int columnCount = metaData.getColumnCount();
        
        while(rs.next()) {
            
            
        String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String type = rs.getString("type");
            User user = new User(name, email, password, type);
            usersDb.add(user);
        }
       
        if (!usersDb.isEmpty() && usersDb != null) {
            return usersDb;
        }

        return null;
    }
    

    public boolean validateUser(String email, String password) throws SQLException {
        User user = getUser(email);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    
}
