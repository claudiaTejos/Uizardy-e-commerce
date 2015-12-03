/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.commons;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compra implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCompra;
    
    @ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;
    
    @OneToOne
    @JoinColumn(name="idCarrinho")
    private Carrinho carrinho;
    
    @ManyToOne
    @JoinColumn(name="idEnderecoEntrega")
    private EnderecoEntrega endEntregaCliente;
    
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date dataHoraCompra = new Date();
    
    private double valorTotal;
    private String tipoDePagamento;
    private String status;
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EnderecoEntrega getEndEntregaCliente() {
        return endEntregaCliente;
    }

    public void setEndEntregaCliente(EnderecoEntrega endEntregaCliente) {
        this.endEntregaCliente = endEntregaCliente;
    }

    public String getTipoDePagamento() {
        return tipoDePagamento;
    }

    public void setTipoDePagamento(String tipoDePagamento) {
        this.tipoDePagamento = tipoDePagamento;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Date getDataHoraCompra() {
        return dataHoraCompra;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.idCompra;
        hash = 71 * hash + Objects.hashCode(this.carrinho);
        hash = 71 * hash + Objects.hashCode(this.dataHoraCompra);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compra other = (Compra) obj;
        if (this.idCompra != other.idCompra) {
            return false;
        }
        if (!Objects.equals(this.carrinho, other.carrinho)) {
            return false;
        }
        if (!Objects.equals(this.dataHoraCompra, other.dataHoraCompra)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "idCompra=" + idCompra + ", carrinho=" + carrinho + ", dataHoraCompra=" + dataHoraCompra + ", valorTotal=" + valorTotal + ", status=" + status + '}';
    }
    
}
