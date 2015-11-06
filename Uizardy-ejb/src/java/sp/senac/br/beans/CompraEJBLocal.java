/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.List;
import javax.ejb.Local;
import sp.senac.br.uizardy.commons.Compra;

/**
 *
 * @author blanc
 */
@Local
public interface CompraEJBLocal {
    public void cadastrar(Compra compra);
    public void alterar(Compra compra);
    public List<Compra> pesquisar();
    public Compra pesquisar (int id);
}
