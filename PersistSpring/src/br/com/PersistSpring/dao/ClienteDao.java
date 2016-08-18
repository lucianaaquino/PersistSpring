package br.com.PersistSpring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.PersistSpring.conexao.Conexao;



public class ClienteDao {
	
	
	
	public String salvar(String nomeCliente,String cpfCliente,String cnpjCliente,String tipoCliente){
		Conexao con = new Conexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String msg ="Cadastro Efetuado com Sucesso";
		try {
		stmt = con.abreConexao().prepareStatement("insert into CLIENTE values (?,?,?,?,?)");
			stmt.setInt(1,buscaIdCliente() );
			stmt.setString(2,nomeCliente);
			stmt.setString(3,cpfCliente);
			stmt.setString(4,cnpjCliente);
			stmt.setString(5,tipoCliente);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "Não foi possivel ";
		}finally {
			con.closeConnection(stmt, rs);
		}
		return msg;
			
	}
	
	public int buscaIdCliente(){
		int id=0;
		Conexao con = new Conexao();
		PreparedStatement stmt =  null;
		ResultSet rs = null;
		try {
			stmt = con.abreConexao().prepareStatement("select count(*) id FROM CLIENTE");
			rs = stmt.executeQuery();
			if(rs.next()){
				id=rs.getInt("id");
			}
			
		System.out.println(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			con.fechaConexao();
		}
		
		
		
		return id;
		
	}
	
	
	
}
