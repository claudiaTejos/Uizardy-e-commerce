/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Carrinho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCarrinho;
    
    private double valorParcial;
    private double valorTotal;
    
    @OneToOne
    @JoinColumn(name="idEnderecoEntrega")
    private EnderecoEntrega enderecoEntrega;
    
    @OneToMany(mappedBy = "carrinhoItem", cascade = CascadeType.ALL)
    private List<ItemDeCompra> itensDoCarrinho;

    public Carrinho() {
        this.itensDoCarrinho = new ArrayList<>();
    }

    public EnderecoEntrega getCEP() {
        this.atualizaValorTotal();
        return enderecoEntrega;
    }

    public void setCEP(EnderecoEntrega CEP) {
        this.enderecoEntrega = CEP;
        this.atualizaValorTotal();
    }

    public double getValorParcial() {
        this.atualizaValorParcial();
        return valorParcial;
    }

    public void setValorParcial(double valorParcial) {
        this.valorParcial = valorParcial;
    }
    
    public void atualizaValorParcial(){
        this.valorParcial = 0;
        for (ItemDeCompra item : itensDoCarrinho) {
            this.valorParcial += item.getValorParcial();
        }
    }

    public EnderecoEntrega getEnderecoEntrega() {
        this.atualizaValorTotal();
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
        this.atualizaValorTotal();
    }

    public void atualizaValorTotal(){
        this.valorTotal = this.valorParcial + this.enderecoEntrega.getValorEntrega();
    }
    
    public double getValorTotal() {
        this.atualizaValorTotal();
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemDeCompra> getItensDoCarrinho() {
        return itensDoCarrinho;
    }

    public void setItensDoCarrinho(List<ItemDeCompra> itensDoCarrinho) {
        this.itensDoCarrinho = itensDoCarrinho;
        this.atualizaValorParcial();
    }

    public int getIdCarrinho() {
        return idCarrinho;
    }

    public void setIdCarrinho(int idCarrinho) {
        this.idCarrinho = idCarrinho;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.idCarrinho);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
        hash = 23 * hash + Objects.hashCode(this.itensDoCarrinho);
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
        final Carrinho other = (Carrinho) obj;
        if (!Objects.equals(this.idCarrinho, other.idCarrinho)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.itensDoCarrinho, other.itensDoCarrinho)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carrinho{" + "idCarrinho=" + idCarrinho + ", valorParcial=" + valorTotal + ", produto=" + itensDoCarrinho + '}';
    }
    
}
