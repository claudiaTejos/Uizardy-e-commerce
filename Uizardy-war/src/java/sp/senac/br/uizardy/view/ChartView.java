package org.primefaces.examples;
 
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import sp.senac.br.beans.CompraEJBLocal;
import sp.senac.br.uizardy.commons.Compra;
import sp.senac.br.uizardy.commons.ItemDeCompra;
 
@ManagedBean
public class ChartView implements Serializable {
    private BarChartModel animatedModel;
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
    }
 
    public BarChartModel getAnimatedModel() {
        return animatedModel;
    }
 
    private void createAnimatedModels() {
        animatedModel = initBarModel();
        animatedModel.setTitle("Total de Venda");
        animatedModel.setAnimate(true);
        animatedModel.setLegendPosition("ne");
        Axis yAxis = animatedModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
    }
     
    @EJB
    private CompraEJBLocal compraEJB;
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        List<Compra> listaCompra = compraEJB.pesquisar();
        
        ChartSeries vendaTotal = new ChartSeries();
        ChartSeries qntItensTotal = new ChartSeries();
        vendaTotal.setLabel("Valor");
        qntItensTotal.setLabel("Itens");
        double valorTotalVendas = 0;
        int qntItens = 0;
        for (Compra listaCompra1 : listaCompra) {
            valorTotalVendas += listaCompra1.getValorTotal();
            for (ItemDeCompra listaItens : listaCompra1.getCarrinho().getItensDoCarrinho()) {
                qntItens += listaItens.getQuantidadeProduto();
            }
        }
        vendaTotal.set(this, valorTotalVendas);
        qntItensTotal.set(this, qntItens);
        
        model.addSeries(vendaTotal);
        model.addSeries(qntItensTotal);
        
        return model;
    }
     
}