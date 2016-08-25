package br.com.PersistSpring.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.PersistSpring.conexao.Conexao;
import br.com.PersistSpring.modelo.Cliente;
import br.com.PersistSpring.modelo.Fornecedor;


@Repository
public class FornecedorDao {
	
	
	@PersistenceContext(unitName ="JPA")
	protected EntityManager entityManager;
	
	 @Transactional
	  public void salvar(Fornecedor fornecedor) throws Exception {
		 entityManager.persist(fornecedor);
		
	     
	  }
	 
	 public List<Fornecedor> buscar(){
		return entityManager.createNamedQuery("Fornecedor.findAll", Fornecedor.class).getResultList();
		
		 
	 }
	 public List<Fornecedor> buscar(Fornecedor fornecedor){
			return entityManager.createNamedQuery("Fornecedor.buscaNome", Fornecedor.class).setParameter(1,fornecedor.getNome()+"%").getResultList();
			
			 
		 }
		 
	 
	 
	 
	
	
	
	/*public String salvar(Cliente cliente){
		Conexao con = new Conexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String msg ="Cadastro Efetuado com Sucesso";
		try {
		stmt = con.abreConexao().prepareStatement("insert into CLIENTE values (?,?,?,?,?)");
			stmt.setInt(1,buscaIdCliente() );
			stmt.setString(2,cliente.getNome());
			stmt.setString(3,cliente.getCpf());
			stmt.setString(4,cliente.getCnpj());
			stmt.setString(5,cliente.getTipoCliente());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "Não foi possivel ";
		}finally {
			con.closeConnection(stmt, rs);
		}
		return msg;
			
	}*/
	
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
	
	public LinkedList<Cliente> pesquisarCliente(Cliente cliente){
		Conexao con = new Conexao();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		LinkedList<Cliente> lista = new LinkedList<Cliente>();

		try {
		stmt = con.abreConexao().prepareStatement("select * from CLIENTE where NOME like ?");
			stmt.setString(1,cliente.getNome());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente clienteRetorno = new Cliente();
				clienteRetorno.setNome(rs.getString("nome"));
				clienteRetorno.setCpf(rs.getString("cpf"));
				lista.add(clienteRetorno);
					
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			con.closeConnection(stmt, rs);
		}
	
		return lista;	
	}
	
	
	
}
