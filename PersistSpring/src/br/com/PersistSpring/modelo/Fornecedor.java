package br.com.PersistSpring.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fornecedor database table.
 * 
 */
@Entity
@Table(name="FORNECEDOR")
@NamedQuery(name="Fornecedor.findAll", query="SELECT f FROM Fornecedor f")
public class Fornecedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String nome;

	//bi-directional many-to-many association to Produto
	@ManyToMany
	@JoinTable(
		name="FORNECEDOR_PRODUTO"
		, joinColumns={
			@JoinColumn(name="FORNECEDOR_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="PRODUTO_ID")
			}
		)
	private List<Produto> produtos;

	public Fornecedor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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