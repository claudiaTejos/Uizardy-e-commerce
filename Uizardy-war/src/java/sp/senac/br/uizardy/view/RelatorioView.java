package org.primefaces.showcase.view.data.datatable;
 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import sp.senac.br.beans.CompraEJBLocal;
import sp.senac.br.uizardy.commons.Compra;
 
@ManagedBean(name="relatorioView")
@ViewScoped
public class RelatorioView implements Serializable {
     
    private List<Compra> compras;
     
    @EJB
    private CompraEJBLocal compraEJB;
 
    @PostConstruct
    public void init() {
        compras = compraEJB.pesquisar();
    }

    public List<Compra> getCompras() {
        return compras;
    }

}