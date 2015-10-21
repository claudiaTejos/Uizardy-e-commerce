/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sp.senac.br.uizardy.commons.Produto;

/**
 *
 * @author blanco
 */
@Stateless
public class ProdutoEJB implements ProdutoEJBLocal {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void cadastrar(Produto produto) {
        em.persist(produto);
    }

    @Override
    public void alterar(Produto produto) {
        Produto temp = em.find(Produto.class, produto.getIdProduto());
        if (temp!=null) {
            temp.setAutores(produto.getAutores());
            temp.setDescricaoProduto(produto.getDescricaoProduto());
            temp.setDisponivel(produto.isDisponivel());
            temp.setEdicaoProduto(produto.getEdicaoProduto());
            temp.setFornecedor(produto.getFornecedor());
            temp.setIdioma(produto.getIdioma());
            temp.setNomeProduto(produto.getNomeProduto());
            temp.setQntProduto(produto.getQntProduto());
            temp.setValorProduto(produto.getValorProduto());
            temp.setCaminhoImagem(produto.getCaminhoImagem());
        }
    }

    @Override
    public List<Produto> pesquisar() {
        Query query = em.createQuery("Select p from Produto p inner join p.fornecedor f");
        List<Produto> produtos = (List<Produto>)query.getResultList();
        return produtos;
    }

    @Override
    public Produto pesquisar(int id) {
        return em.find(Produto.class, id);
    }
}
