/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.commons;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author blanc
 */

@Entity
public class ItemDeCompra implements Serializable{
    
    @Id
    @GeneratedValue
    private int idItem;
    
    @ManyToOne
    @JoinColumn(name="idProduto")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name = "idCarrinho")
    private Carrinho carrinhoItem;
    
    private int quantidadeProduto;
    
    private double valorParcial;

    public Carrinho getCarrinhoItem() {
        return carrinhoItem;
    }

    public void setCarrinhoItem(Carrinho carrinhoItem) {
        this.carrinhoItem = carrinhoItem;
    }

    public double getValorParcial() {
        return valorParcial;
    }

    public void setValorParcial(double valorParcial) {
        this.valorParcial = this.produto.getValorProduto() * this.quantidadeProduto;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        this.setValorParcial(valorParcial);
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
        this.setValorParcial(valorParcial);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idItem;
        hash = 37 * hash + Objects.hashCode(this.produto);
        hash = 37 * hash + this.quantidadeProduto;
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
        final ItemDeCompra other = (ItemDeCompra) obj;
        if (this.idItem != other.idItem) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (this.quantidadeProduto != other.quantidadeProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemDeCompra{" + "idItem=" + idItem + ", produto=" + produto + ", quantidadeProduto=" + quantidadeProduto + '}';
    }
    
}
