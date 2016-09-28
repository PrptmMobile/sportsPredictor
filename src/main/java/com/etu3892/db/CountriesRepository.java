package com.etu3892.db;


import com.etu3892.db.DBConnector;
import com.etu3892.db.Entities.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountriesRepository {
    public List getCountries() throws SQLException {
        List countriesList = new ArrayList<Country>();
        String tryquery = "select * from countries where country <> 'None'";
        ResultSet rs1 = DBConnector.getSet(tryquery);
        while (rs1.next()) {
            Country country = new Country(rs1.getInt("countryId"),rs1.getString("country"));
            countriesList.add(country);
        }

        return countriesList;
    }

    public static List getStCountries() throws SQLException {
        List countriesList = new ArrayList<Country>();
        String tryquery = "select * from countries where country <> 'None'";
        ResultSet rs1 = DBConnector.getSet(tryquery);
        while (rs1.next()) {
            Country country = new Country(rs1.getInt("countryId"),rs1.getString("country"));
            countriesList.add(country);
        }

        return countriesList;
    }

    public static Country getCountryById(int id) throws SQLException {
        String tryquery = "select * from countries where countryId="+id;
        ResultSet rs1 = DBConnector.getSet(tryquery);
        rs1.next();
        return new Country(rs1.getInt("countryId"),rs1.getString("country"));
    }

    public static void addCountry (Country country) throws SQLException {
        String tryquery = "insert into countries values ("+country.getCountryId()+",'"+country.getCountry()+"')";
        DBConnector.execute(tryquery);
    }

    public static void updateCountry (Country country) throws SQLException {
        String tryquery = "update countries set country='"+country.getCountry()+"' where countryId="+country.getCountryId();
        DBConnector.execute(tryquery);
    }

    public static void removeCountry (Country country) throws SQLException {
        String tryquery = "delete from countries where countryId="+country.getCountryId();
        DBConnector.execute(tryquery);
    }

}
