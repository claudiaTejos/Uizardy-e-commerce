/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.bean;

import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoletoHTML;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import sp.senac.br.beans.CompraEJBLocal;
import sp.senac.br.uizardy.commons.Compra;
import sp.senac.br.uizardy.utils.GerarBoleto;

/**
 *
 * @author blanc
 */
@ManagedBean(name = "compraBean")
@SessionScoped
public class CompraBean {
    private Compra compra;
    
    @EJB
    private CompraEJBLocal compraEJB;
    
    @ManagedProperty(value = "#{carrinhoBean}")
    private CarrinhoBean carrinhoBean;
    
    @ManagedProperty(value = "#{usuarioClienteBean}")
    private UsuarioClienteBean usuarioClienteBean;

    public CompraBean() {
        this.novaCompra();
    }
    
    public void cadastrarCompra(){
        this.compra.setCarrinho(carrinhoBean.getCarrinho());
        this.compra.setCliente(usuarioClienteBean.getCliente());
        this.compra.setEndEntregaCliente(carrinhoBean.getCarrinho().getEnderecoEntrega());
        this.compra.setStatus("Aguardando confirmacao de pagamento");
        this.compra.setValorTotal(carrinhoBean.getCarrinho().getValorTotal());
        this.compraEJB.cadastrar(this.compra);
        this.carrinhoBean.novoCarrinho();
    }
    
    public void novaCompra(){
        this.compra = new Compra();
        this.compra.setTipoDePagamento("Cartão de Crédito");
    }

    public void pagarComBoleto (){
        this.compra.setTipoDePagamento("Boleto");
        GerarBoleto gerarBoleto = new GerarBoleto();
        GeradorDeBoletoHTML gerador = gerarBoleto.geraBoletoHTML(this.compra.getIdCompra());
        gerador.geraHTML(FacesContext.getCurrentInstance().getResponseWriter(), null);
        GeradorDeBoleto geradorDeBoleto = gerarBoleto.geradorDeBoleto(this.compra.getIdCompra());
        geradorDeBoleto.geraPDF("boleto.pdf");
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public void setCarrinhoBean(CarrinhoBean carrinhoBean) {
        this.carrinhoBean = carrinhoBean;
    }

    public void setUsuarioClienteBean(UsuarioClienteBean usuarioClienteBean) {
        this.usuarioClienteBean = usuarioClienteBean;
    }
    
}