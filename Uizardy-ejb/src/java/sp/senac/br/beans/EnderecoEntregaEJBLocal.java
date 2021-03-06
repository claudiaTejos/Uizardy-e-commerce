/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import br.com.correios.bsb.sigep.master.bean.cliente.SQLException_Exception;
import br.com.correios.bsb.sigep.master.bean.cliente.SigepClienteException;
import java.util.List;
import javax.ejb.Local;
import sp.senac.br.uizardy.commons.EnderecoEntrega;

/**
 *
 * @author blanc
 */
@Local
public interface EnderecoEntregaEJBLocal {
    public void cadastrar(EnderecoEntrega endereco);
    public void alterar(EnderecoEntrega endereco);
    public List<EnderecoEntrega> pesquisar();
    public EnderecoEntrega pesquisar(int id);
    public EnderecoEntrega pesquisar(String cep) throws SQLException_Exception, SigepClienteException;
}
