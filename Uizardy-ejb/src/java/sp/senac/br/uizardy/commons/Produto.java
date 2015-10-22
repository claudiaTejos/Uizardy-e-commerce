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
public class Produto implements Serializable {
    @Id
    @GeneratedValue
    private int idProduto;
    
    @ManyToOne
    @JoinColumn(name="idFornecedor")
    private Fornecedor fornecedor;
    
    @ManyToOne
    @JoinColumn(name="idIdioma")
    private Idioma idioma;

    private String nomeProduto;
    private String descricaoProduto;
    private String edicaoProduto;
    private String nomeAutor;
    private String caminhoImagem;
    private double valorProduto;
    private int qntProduto;
    private boolean disponivel;

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getEdicaoProduto() {
        return edicaoProduto;
    }

    public void setEdicaoProduto(String edicaoProduto) {
        this.edicaoProduto = edicaoProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQntProduto() {
        return qntProduto;
    }

    public void setQntProduto(int qntProduto) {
        this.qntProduto = qntProduto;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idProduto;
        hash = 29 * hash + Objects.hashCode(this.fornecedor);
        hash = 29 * hash + Objects.hashCode(this.idioma);
        hash = 29 * hash + Objects.hashCode(this.nomeProduto);
        hash = 29 * hash + Objects.hashCode(this.descricaoProduto);
        hash = 29 * hash + Objects.hashCode(this.edicaoProduto);
        hash = 29 * hash + Objects.hashCode(this.nomeAutor);
        hash = 29 * hash + Objects.hashCode(this.caminhoImagem);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valorProduto) ^ (Double.doubleToLongBits(this.valorProduto) >>> 32));
        hash = 29 * hash + this.qntProduto;
        hash = 29 * hash + (this.disponivel ? 1 : 0);
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
        final Produto other = (Produto) obj;
        if (this.idProduto != other.idProduto) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.idioma, other.idioma)) {
            return false;
        }
        if (!Objects.equals(this.nomeProduto, other.nomeProduto)) {
            return false;
        }
        if (!Objects.equals(this.descricaoProduto, other.descricaoProduto)) {
            return false;
        }
        if (!Objects.equals(this.edicaoProduto, other.edicaoProduto)) {
            return false;
        }
        if (!Objects.equals(this.nomeAutor, other.nomeAutor)) {
            return false;
        }
        if (!Objects.equals(this.caminhoImagem, other.caminhoImagem)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorProduto) != Double.doubleToLongBits(other.valorProduto)) {
            return false;
        }
        if (this.qntProduto != other.qntProduto) {
            return false;
        }
        if (this.disponivel != other.disponivel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "idProduto=" + idProduto + ", fornecedor=" + fornecedor + ", idioma=" + idioma + ", nomeProduto=" + nomeProduto + ", descricaoProduto=" + descricaoProduto + ", edicaoProduto=" + edicaoProduto + ", nomeAutor=" + nomeAutor + ", caminhoImagem=" + caminhoImagem + ", valorProduto=" + valorProduto + ", qntProduto=" + qntProduto + ", disponivel=" + disponivel + '}';
    }
    
}
