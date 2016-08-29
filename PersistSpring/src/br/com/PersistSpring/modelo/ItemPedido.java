package br.com.PersistSpring.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the ITEM_PEDIDO database table.
 * 
 */
@Entity
@Table(name="ITEM_PEDIDO")
@NamedQuery(name="ItemPedido.findAll", query="SELECT i FROM ItemPedido i")
public class ItemPedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PK pk;

	@Column(name="QUANTIDADE")
	private int quantidade;

	@Column(name="VALOR")
	private float valor;

	//bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name = "PEDIDO_ID",referencedColumnName="ID", insertable=false, updatable=false, nullable=false)
	private Pedido pedido;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID",referencedColumnName="ID", insertable=false, updatable=false, nullable=false)
	private Produto produto;

	public ItemPedido() {
		super();
	
	}

	
	public PK getPk() {
		return pk;
	}



	public void setPk(PK pk) {
		this.pk = pk;
	}



	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@Embeddable
	public static class PK implements Serializable {
		//default serial version id, required for serializable classes.
		private static final long serialVersionUID = 1L;

		@Column(name="PEDIDO_ID", insertable=false, updatable=false)
		private int pedidoId;

		@Column(name="PRODUTO_ID", insertable=false, updatable=false)
		private int produtoId;

		public PK() {
			super();
			
		}
		public PK(int idPedido,int idProduto) {
			this.setPedidoId(idPedido);
			this.setProdutoId(idProduto);
		}
		public int getPedidoId() {
			return this.pedidoId;
		}
		public void setPedidoId(int pedidoId) {
			this.pedidoId = pedidoId;
		}
		public int getProdutoId() {
			return this.produtoId;
		}
		public void setProdutoId(int produtoId) {
			this.produtoId = produtoId;
		}

		public boolean equals(Object other) {
			if (this == other) {
				return true;
			}
			if (!(other instanceof PK)) {
				return false;
			}
			PK castOther = (PK)other;
			return 
				(this.pedidoId == castOther.pedidoId)
				&& (this.produtoId == castOther.produtoId);
		}

		public int hashCode() {
			final int prime = 31;
			int hash = 17;
			hash = hash * prime + this.pedidoId;
			hash = hash * prime + this.produtoId;
			
			return hash;
		}
	}

}