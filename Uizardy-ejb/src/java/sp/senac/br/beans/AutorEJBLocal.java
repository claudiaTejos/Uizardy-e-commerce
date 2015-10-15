/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.List;
import javax.ejb.Local;
import sp.senac.br.uizardy.commons.Autor;

/**
 *
 * @author blanc
 */
@Local
public interface AutorEJBLocal {
    public void cadastrar(Autor autor);
    public void alterar(Autor autor);
    public List<Autor> pesquisar();
    public Autor pesquisar (int id);
}
