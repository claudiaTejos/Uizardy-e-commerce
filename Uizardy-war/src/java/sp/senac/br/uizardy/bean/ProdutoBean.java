/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sp.senac.br.beans.ProdutoEJBLocal;
import sp.senac.br.uizardy.commons.Produto;

/**
 *
 * @author blanc
 */
@ManagedBean
@RequestScoped
public class ProdutoBean {
    
    private Produto produto;
    
    @EJB
    private ProdutoEJBLocal produtoEJB;

    public ProdutoBean() {
        this.produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    //cadastra um novo produto
    public void cadastrar(){
        produtoEJB.cadastrar(this.produto);
    }
    
    //lista todos os produtos
    public List<Produto> pesquisar(){
        return produtoEJB.pesquisar();
    }
    
    //retorna um produto pelo ID
    public Produto pesquisar(int idProduto){
        return produtoEJB.pesquisar(idProduto);
    }
    
    //atualiza um produto
    public void atualizar(){
        produtoEJB.alterar(this.produto);
    }
    
}