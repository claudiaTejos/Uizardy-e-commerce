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
import sp.senac.br.beans.FornecedorEJBLocal;
import sp.senac.br.beans.IdiomaEJBLocal;
import sp.senac.br.beans.ProdutoEJBLocal;
import sp.senac.br.uizardy.commons.Fornecedor;
import sp.senac.br.uizardy.commons.Idioma;
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
    
    @EJB
    private IdiomaEJBLocal idiomaEJB;
    
    @EJB
    private FornecedorEJBLocal fornecedorEJB;
    
    private String idIdioma;
    private String idFornecedor;
    
    private String buscaProduto;
    private List<Produto> resultBusca;

    public String getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(String idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(String idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public ProdutoBean() {
        this.produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public String setProdutoPaginaDetalhes(Produto produto) {
        this.produto = produto;
        return "detalheDeProduto";
    }
    
    //cadastra um novo produto
    public void cadastrar(){
        Fornecedor fornecedor = fornecedorEJB.pesquisar(Integer.parseInt(idFornecedor));
        Idioma idioma = idiomaEJB.pesquisar(Integer.parseInt(idIdioma));
        this.produto.setFornecedor(fornecedor);
        this.produto.setIdioma(idioma);
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
        Fornecedor fornecedor = fornecedorEJB.pesquisar(Integer.parseInt(idFornecedor));
        Idioma idioma = idiomaEJB.pesquisar(Integer.parseInt(idIdioma));
        this.produto.setFornecedor(fornecedor);
        this.produto.setIdioma(idioma);
        produtoEJB.alterar(this.produto);
    }
    
    public String pesquisarProduto(){
        resultBusca = produtoEJB.pesquisar(buscaProduto);
        return "listagemDeProduto";
        
    }

    public List<Produto> getResultBusca() {
        return resultBusca;
    }

    public void setResultBusca(List<Produto> resultBusca) {
        this.resultBusca = resultBusca;
    }

    
    public String getBuscaProduto() {
        return buscaProduto;
    }

    public void setBuscaProduto(String buscaProduto) {
        this.buscaProduto = buscaProduto;
    }
    
    
    
}