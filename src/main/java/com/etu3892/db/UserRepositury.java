package com.etu3892.db;


import com.etu3892.db.Entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositury {

    public static void createUser(User user) throws SQLException{
        String tryquery = "insert into users values (0,'"+user.getUsername()+"','"+user.getPassword()+"',"+user.getTeamId()+","+user.getCountryId()+",false,'"+user.getEmail()+"')";
        DBConnector.execute(tryquery);
    }

    public static String checkUser(String username, String password) throws SQLException{
        String query = "select * from users where username='"+username+"'";
        ResultSet set = DBConnector.getSet(query);
        set.next();
        if (set.wasNull()) return "Invalid username!";
        String pass = set.getString("password");
        if (!pass.equals(password)) return "Invalid password!";
        return "granted";
    }

    public static User findUserByUserName (String username) throws SQLException{
        String query = "select * from users where username='"+username+"'";
        ResultSet set = DBConnector.getSet(query);
        if (set.wasNull()) return null;
        set.next();
        return new User(set.getInt("userId"),set.getString("username"),set.getString("password"),set.getInt("teamId"),set.getInt("countryId"), set.getString("email"));
    }

    public static User findUserByEmail (String email) throws SQLException{
        String query = "select * from users where email='"+email+"'";
        ResultSet set = DBConnector.getSet(query);
        if (set.wasNull()) return null;
        set.next();
        return new User(set.getInt("userId"),set.getString("username"),set.getString("password"),set.getInt("teamId"),set.getInt("countryId"), set.getString("email"));
    }

    public static void updateUser (User user) throws SQLException{
        String query = "update users set username='"+user.getUsername()+"', password='"+user.getPassword()+"', teamId="+user.getTeamId()+", countryId="+user.getCountryId()+", email='"+user.getEmail()+"' where userId="+user.getUserId();
        DBConnector.execute(query);
    }

    public static boolean isAdmin (User user) throws SQLException{
        String query = "select * from users where username='"+user.getUsername()+"'";
        ResultSet set = DBConnector.getSet(query);
        set.next();

        return set.getBoolean("admin");
    }


}
