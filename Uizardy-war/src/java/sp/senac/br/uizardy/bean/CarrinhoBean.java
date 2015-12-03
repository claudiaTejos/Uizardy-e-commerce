/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.bean;

import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sp.senac.br.beans.CarrinhoEJBLocal;
import sp.senac.br.beans.EnderecoEntregaEJBLocal;
import sp.senac.br.beans.ItemDeCompraEJBLocal;
import sp.senac.br.beans.ProdutoEJBLocal;
import sp.senac.br.uizardy.commons.Carrinho;
import sp.senac.br.uizardy.commons.EnderecoEntrega;
import sp.senac.br.uizardy.commons.ItemDeCompra;

/**
 *
 * @author blanc
 */
@ManagedBean(name = "carrinhoBean")
@SessionScoped
public class CarrinhoBean {

    private Carrinho carrinho;
    private String cep;
    
    @EJB
    private CarrinhoEJBLocal carrinhoEJB;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    @EJB
    private ItemDeCompraEJBLocal itemDeCompraEJB;
    
    public void cadastrar(){
        this.endEJB.cadastrar(this.carrinho.getEnderecoEntrega());
        this.carrinhoEJB.cadastrar(this.carrinho);
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
        item.setCarrinhoItem(this.carrinho);
        for (ItemDeCompra itemDaLista : this.carrinho.getItensDoCarrinho()) {
            if (itemDaLista.getProduto().getIdProduto() == item.getProduto().getIdProduto()) {
                return;
            }
        }
        this.carrinho.getItensDoCarrinho().add(item);
    }
    
    public void removeItemLista(ItemDeCompra item){
        this.carrinho.getItensDoCarrinho().remove(item);
    }
    
    public CarrinhoBean() {
        this.novoCarrinho();
    }
    
    @EJB
    EnderecoEntregaEJBLocal endEJB;
    
    public void alteraCepEntrega() throws SQLException_Exception, SigepClienteException{
        this.carrinho.setEnderecoEntrega(endEJB.pesquisar(this.cep));
    }

    public void novoCarrinho() {
        this.cep = "";
        this.carrinho = new Carrinho();
        EnderecoEntrega end = new EnderecoEntrega();
        this.carrinho.setEnderecoEntrega(end);
        double valorParcial = this.carrinho.getValorParcial();
        double valorTotal = valorParcial + end.getValorEntrega();
        this.carrinho.setValorTotal(valorTotal);
    }
    
}