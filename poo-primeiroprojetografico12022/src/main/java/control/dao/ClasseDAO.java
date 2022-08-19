package control.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import control.conectionjdbc.SingleConnection;


public class ClasseDAO {
	
	private Connection connection;

	public ClasseDAO() {
		connection = SingleConnection.getConnetion();
	}

	public boolean buscar(String nome, String senha) throws Exception {
		
		String sql = "SELECT acesso, senha FROM login l WHERE l.acesso = ? AND l.senha = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, nome);	
		statement.setString(2, senha);

		ResultSet resultado = statement.executeQuery();
		
		String loginBanco = "";
		String senhaBanco ="";
		while (resultado.next()) {
			loginBanco = resultado.getString("acesso");
			senhaBanco = resultado.getString("senha");

		}
		if(loginBanco.equals(nome) && senhaBanco.equals(senha)) {
			return true;
		}else {
			return false;
		}
	}	

}
