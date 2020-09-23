/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrudJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Serpa
 */
public class JDBC {
    
    public Connection connection = null;
    public Statement smt;
    
    public JDBC()
    {
        // configurações do banco de dados
        
        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=Loja";

        try {
            Class.forName(DRIVER); // Carrega o Driver

            // Obtém a conexão com a base de dados
            connection = DriverManager.getConnection(DATABASE_URL, "serpa", "123");
            smt = connection.createStatement();
            System.out.println("Conectado ao banco");

        } catch (SQLException|ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }  
    }
    
    
    public void SalvarCliente(Cliente c)
    {
        try{
        //Statement smt = connection.createStatement();
        smt.executeUpdate("insert into cliente (NOME, CPF, CODIGO, DATA_NASC) values ('" +  c.NOME + "','" + c.CPF + "','"+c.CODIGO+"','"+c.DATA_NASC+"')");
        System.out.println("Inseriu um cliente");
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
        }
    }
    
    public void ExcluirCliente(Cliente c)
    {
        try{
        
        smt.executeUpdate("delete from cliente where nome = '" + c.NOME + "'");
        System.out.println("Excluiu um cliente");
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
        }
    }
    
    public List<Cliente> ListarCliente()
    {
        List<Cliente> resultado = new ArrayList<Cliente>();
        
        try{
        //Statement smt = connection.createStatement();
        ResultSet resultSet = smt.executeQuery("select * from cliente");
        
        while (resultSet.next()) {
           // System.out.println(resultSet.getString("NOME"));
            
            Cliente c = new Cliente();
            c.NOME = resultSet.getString("NOME");
            c.CODIGO = resultSet.getInt("CODIGO");
            c.CPF = resultSet.getString("CPF");
            c.DATA_NASC = resultSet.getString("DATA_NASC");
            
            
            resultado.add(c);
        }

        return resultado;
        
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
          return null;
        }
    }
    
}
