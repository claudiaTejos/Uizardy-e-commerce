/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
@SessionScoped
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
        return "detalheDeProduto?faces-redirect=true";
    }
    
    //cadastra um novo produto
    public void cadastrar(){
        Fornecedor fornecedor = fornecedorEJB.pesquisar(Integer.parseInt(idFornecedor));
        Idioma idioma = idiomaEJB.pesquisar(Integer.parseInt(idIdioma));
        this.produto.setFornecedor(fornecedor);
        this.produto.setIdioma(idioma);
        produtoEJB.cadastrar(this.produto);
        this.produto = null;
    }
    
    //lista todos os produtos
    public List<Produto> pesquisar(){
        return produtoEJB.pesquisar();
    }
    
    //retorna um produto pelo ID
    public Produto pesquisar(int idProduto){
        return produtoEJB.pesquisar(idProduto);
    }
    
    // lista de produtos de acordo com o idioma
    public String pesquisarIdioma(String nomeIdioma){
        resultBusca = produtoEJB.pesquisarPorIdioma(nomeIdioma);
        return "listagemDeProduto?faces-redirect=true";
    }
    
    // lista novos produtos
    public List<Produto> pesquisarNovos(){
        return produtoEJB.pesquisarNovos();
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
         return "listagemDeProduto?faces-redirect=true";        
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