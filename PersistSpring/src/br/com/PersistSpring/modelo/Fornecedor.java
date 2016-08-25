package br.com.PersistSpring.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




/**
 * The persistent class for the fornecedor database table.
 * 
 */
@Entity
@Table(name="FORNECEDOR")
@NamedQueries({
	@NamedQuery(name="Fornecedor.findAll", query="SELECT f FROM Fornecedor f"),
	@NamedQuery(name="Fornecedor.buscaNome", query="SELECT c FROM Fornecedor c WHERE c.nome like ?1 ")
})

public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_FORNECEDOR")
	private int idFornecedor;

	@Column(name="NOME")
	private String nome;

	//bi-directional many-to-many association to Produto
	@ManyToMany
	@JoinTable(
		name="FORNECEDOR_PRODUTO"
		, joinColumns={
			@JoinColumn(name="FORNECEDOR_ID_FORNECEDOR")
			}
		, inverseJoinColumns={
			@JoinColumn(name="PRODUTO_ID_PRODUTO")
			}
		)
	private List<Produto> produtos;

	public Fornecedor() {
	}

	public int getIdFornecedor() {
		return this.idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}