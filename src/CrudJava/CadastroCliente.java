/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CrudJava;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import static java.time.Instant.now;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Serpa
 */
public class CadastroCliente {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        JDBC banco = new JDBC();
        
        Cliente c1 = new Cliente();
        
        c1.flag = true;
        
        c1.NOME = JOptionPane.showInputDialog("Entre com seu nome: ");
        
        c1.CODIGO = Integer.parseInt(JOptionPane.showInputDialog("Entre com seu ID: "));
        
        c1.CPF = JOptionPane.showInputDialog("Entre com seu CPF: ");
        
        c1.DATA_NASC = JOptionPane.showInputDialog("Entre com sua data de nascimento: ");
        
        if(c1.flag == true)
        {
          String ok = JOptionPane.showInputDialog("Voce deseja salvar este usuario na base de dados? sim / nao ");
          
          if(ok.contains("sim"))
          {
              banco.SalvarCliente(c1);
          } 
          else
          {
              System.out.println("Voce optou por nao salvar este usuario");
          }
        }
        
         //banco.ExcluirCliente(c1);
         
         //***Caso queira visualizar os usuarios cadastrados no banco de dados***
         
         //List<Cliente> clientes = banco.ListarCliente();
         
         //for (int i = 0; i <= clientes.size()-1; i++)
         //{
             //System.out.println(clientes.get(i).NOME);
             //System.out.println(clientes.get(i).CODIGO);
             //System.out.println(clientes.get(i).CPF);
         //}
    }
    
}
