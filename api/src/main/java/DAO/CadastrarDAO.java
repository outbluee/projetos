/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rafa
 */
public class CadastrarDAO {
        public static boolean excluir(String nome) {
        boolean retorno = false;
        Connection conexao = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/senac_4sem_pi", "root", "");
            
            PreparedStatement comando = conexao.prepareStatement("DELETE FROM Usuários WHERE nome = ?");
            
            comando.setString(1,nome);
         
        
        int gravacaoResult = comando.executeUpdate();
            
            if(gravacaoResult>0) {
                retorno = true;
            }
        
    } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar o driver");
        }
        catch (SQLException ex) {
            System.out.println("Erro ao conectar com o banco" + ex.getMessage());
        }
        return retorno;
    }
}
