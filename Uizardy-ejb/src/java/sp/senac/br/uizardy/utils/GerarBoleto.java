/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.utils;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoletoHTML;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import sp.senac.br.beans.CompraEJBLocal;
import sp.senac.br.uizardy.commons.Compra;

/**
 *
 * @author blanc
 */
public class GerarBoleto {
    
    @EJB
    CompraEJBLocal compraEJB;
    
    public Boleto GeraBoleto (int idCompra){
        Compra compra = compraEJB.pesquisar(idCompra);
        
        // Gera as datas do boleto
        int dia, mes, ano;
        Date data = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/YYYY");
        String dataFormatada = formataData.format(data);
        dia = Integer.parseInt(dataFormatada.substring(0, 1));
        mes = Integer.parseInt(dataFormatada.substring(3, 4));
        ano = Integer.parseInt(dataFormatada.substring(6, 9));
        
        Datas dataBoleto = Datas.novasDatas()
                .comDocumento(dia, mes, ano)
                .comProcessamento(dia, mes, ano)
                .comVencimento(dia+1, mes, ano);
        
        // Configura o endereco da empresa
        Endereco enderecoEmpresa = Endereco.novoEndereco()
                .comLogradouro("Avenida Engenheiro Eusébio Stevaux, 823")
                .comBairro("Santo Amaro")
                .comCep("04696-000")
                .comCidade("São Paulo")
                .comUf("SP");
        
        // Dados da empresa (banco)
        Beneficiario beneficiario = Beneficiario.novoBeneficiario()
                .comNomeBeneficiario("Uyzardi")
                .comAgencia("0123").comDigitoAgencia("1")
                .comCodigoBeneficiario("76000")
                .comDigitoCodigoBeneficiario("5")
                .comNumeroConvenio("1207113")
                .comCarteira("18")
                .comEndereco(enderecoEmpresa)
                .comNossoNumero("9000206");
        
        // Endereco do cliente
        Endereco enderecoCliente = Endereco.novoEndereco()
                .comLogradouro(compra.getEndEntregaCliente().getEndereco()
                        +", "
                        +compra.getEndEntregaCliente().getNumero()
                        +"-"
                        +compra.getEndEntregaCliente().getComplemento())
                .comBairro(compra.getEndEntregaCliente().getBairro())
                .comCep(compra.getEndEntregaCliente().getCep())
                .comCidade(compra.getEndEntregaCliente().getCidade())
                .comUf(compra.getEndEntregaCliente().getEstado());
        
        Pagador clienteBoleto = Pagador.novoPagador()
                .comNome(compra.getCliente().getNomeCliente())
                .comDocumento(compra.getCliente().getCpfCliente())
                .comEndereco(enderecoCliente);
        
        Banco banco = new BancoDoBrasil();
        
        Boleto boleto = Boleto.novoBoleto()
                .comBanco(banco)
                .comDatas(dataBoleto)
                .comBeneficiario(beneficiario)
                .comPagador(clienteBoleto)
                .comValorBoleto(compra.getCarrinho().getValorTotal())
                .comNumeroDoDocumento("1234")
                .comInstrucoes("Instruções")
                .comLocaisDePagamento("local 1");
        
        return boleto;
    }
    
    public GeradorDeBoleto geradorDeBoleto(int idCompra){
        GeradorDeBoleto geraBoleto = new GeradorDeBoleto(this.GeraBoleto(idCompra));
        
        return geraBoleto;
    }
    
    public GeradorDeBoletoHTML geraBoletoHTML(int idCompra){
        GeradorDeBoletoHTML geradorHTML = new GeradorDeBoletoHTML(this.GeraBoleto(idCompra));
        
        return geradorHTML;
    }
}
