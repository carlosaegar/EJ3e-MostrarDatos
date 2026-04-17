package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        try(Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = conn.createStatement()){

            String sql = "SELECT * FROM empleado WHERE MOD(ID,2) != 0 ";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id= resultSet.getInt("id");
                String nombre= resultSet.getString("nombre");
                double salario= resultSet.getDouble("salario");
                System.out.println("ID: " +id+ " Nombre: "+nombre+" Salario: "+salario);
            }


        }catch(SQLException e ){
            System.out.println("Error al crear la tabla" + e.getMessage());
        }

    }
}
