package com.rahul;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class AlienRepository
{
   // List<Alien> aliens = new ArrayList<>();

    Connection con = null;

    public AlienRepository(){

        String url = "jdbc:postgresql://localhost:5432/restdb";
        String username = "postgres";
        String password = "";
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,username,password);


        }catch(Exception e){
            System.out.println(e);
        }

    }

    public List<Alien> getAliens(){

        List<Alien> aliens = new ArrayList<>();
        String sql = "select * from alien";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));

                aliens.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        return aliens;
    }
    public Alien getAlien(int id){
        String sql = "select * from alien where id="+id;
        Alien a = new Alien();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setPoints(rs.getInt(3));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

       return a;
    }

    public void create(Alien a1){
        String sql = "insert into alien values(?,?,?)";
        Alien a = new Alien();
        try {
            PreparedStatement st= con.prepareStatement(sql);
            st.setInt(1,a1.getId());
            st.setString(2,a1.getName());
            st.setInt(3,a1.getPoints());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void update(Alien a1){
        String sql = "update alien set name=?,point=? where id=?;";
        try {
            PreparedStatement st= con.prepareStatement(sql);

            st.setString(1,a1.getName());
            st.setInt(2,a1.getPoints());
            st.setInt(3,a1.getId());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void deleteAlien(int id) {
        String sql = "delete from alien where id=?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,id);
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
