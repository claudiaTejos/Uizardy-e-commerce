/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sp.senac.br.beans.CarrinhoEJBLocal;
import sp.senac.br.beans.ProdutoEJBLocal;
import sp.senac.br.uizardy.commons.Carrinho;
import sp.senac.br.uizardy.commons.EnderecoEntrega;
import sp.senac.br.uizardy.commons.ItemDeCompra;

/**
 *
 * @author blanc
 */
@ManagedBean
@SessionScoped
public class CarrinhoBean {

    private Carrinho carrinho;
    
    @EJB
    private CarrinhoEJBLocal carrinhoEJB;

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void cadastrar(){
        carrinhoEJB.cadastrar(carrinho);
        carrinho = null;
    }
    
    public List<Carrinho> pesquisar(){
        return carrinhoEJB.pesquisar();
    }
    
    public Carrinho pesquisar (int id){
        return carrinhoEJB.pesquisar(id);
    }
    
    public void atualizar(){
        carrinhoEJB.alterar(carrinho);
    }

    @EJB
    ProdutoEJBLocal pro;
    
    public void addListaProduto(String idProduto){
        ItemDeCompra item = new ItemDeCompra();
        item.setProduto(pro.pesquisar(Integer.parseInt(idProduto)));
        item.setQuantidadeProduto(1);
        this.carrinho.getItensDoCarrinho().add(item);
    }
    public CarrinhoBean() {
        this.carrinho = new Carrinho();
        EnderecoEntrega end = new EnderecoEntrega();
        end.setValorEntrega(13.5);
        this.carrinho.setEnderecoEntrega(end);
        double valorParcial = this.carrinho.getValorParcial();
        double valorTotal = valorParcial + end.getValorEntrega();
        this.carrinho.setValorTotal(valorTotal);
    }
    
}