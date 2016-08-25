package br.com.PersistSpring.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@Table(name="PRODUTO")
@NamedQuery(name="Produto.findAll", query="SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PRODUTO")
	private int idProduto;

	private String descricao;

	private float valor;

	//uni-directional many-to-many association to Fornecedor
	@ManyToMany
	@JoinTable(
		name="FORNECEDOR_PRODUTO"
		, joinColumns={
			@JoinColumn(name="PRODUTO_ID_PRODUTO",referencedColumnName="ID_PRODUTO"),
			}
		, inverseJoinColumns={
			@JoinColumn(name="FORNECEDOR_ID_FORNECEDOR",referencedColumnName="ID_FORNECEDOR")
			}
		)
	private List<Fornecedor> fornecedor;

	//bi-directional many-to-many association to Pedido
	@ManyToMany
	@JoinTable(
		name="ITEM_PEDIDO"
		, joinColumns={
			@JoinColumn(name="PRODUTO_ID_PRODUTO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="PEDIDO_CLIENTE_ID_CLIENTE", referencedColumnName="CLIENTE_ID_CLIENTE"),
			@JoinColumn(name="PEDIDO_ID_PEDIDO", referencedColumnName="ID_PEDIDO")
			}
		)
	private List<Pedido> pedidos;

	public Produto() {
	}

	public int getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	

	

	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

}