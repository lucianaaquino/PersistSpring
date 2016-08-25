package br.com.PersistSpring.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the pedido database table.
 * 
 */
@Entity
@Table(name="PEDIDO")
@NamedQuery(name="Pedido.findAll", query="SELECT p FROM Pedido p")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PK pk;

	@Temporal(TemporalType.DATE)
	private Date data;

	//bi-directional many-to-many association to Produto
	@ManyToMany(mappedBy="pedidos")
	private List<Produto> produtos;

	//bi-directional many-to-one association to Cliente
	@ManyToOne()
	@JoinColumn(name = "CLIENTE_ID_CLIENTE",referencedColumnName="ID_CLIENTE", insertable=false, updatable=false, nullable=false)
	private Cliente cliente;

	public Pedido() {
		this.setPk(new Pedido.PK());
	
	}
	
	



	public PK getPk() {
		return pk;
	}





	public void setPk(PK pk) {
		this.pk = pk;
	}





	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Embeddable
	public class PK implements Serializable {
		//default serial version id, required for serializable classes.
		private static final long serialVersionUID = 1L;

		@Column(name="ID_PEDIDO")
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int idPedido;

		@Column(name="CLIENTE_ID_CLIENTE", insertable=false, updatable=false)
		private int clienteIdCliente;

		public PK() {
			super();
		}
		public PK(final int idPedido, final int idCliente) {
		      this.setIdPedido(idPedido);
		      this.setClienteIdCliente(idCliente);
		}
		public int getIdPedido() {
			return this.idPedido;
		}
		public void setIdPedido(int idPedido) {
			this.idPedido = idPedido;
		}
		public int getClienteIdCliente() {
			return this.clienteIdCliente;
		}
		public void setClienteIdCliente(int clienteIdCliente) {
			this.clienteIdCliente = clienteIdCliente;
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
				(this.idPedido == castOther.idPedido)
				&& (this.clienteIdCliente == castOther.clienteIdCliente);
		}

		public int hashCode() {
			final int prime = 31;
			int hash = 17;
			hash = hash * prime + this.idPedido;
			hash = hash * prime + this.clienteIdCliente;
			
			return hash;
		}
	}

}