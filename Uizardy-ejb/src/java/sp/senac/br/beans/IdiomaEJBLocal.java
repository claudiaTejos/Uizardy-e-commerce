/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.beans;

import java.util.List;
import javax.ejb.Local;
import sp.senac.br.uizardy.commons.Idioma;

/**
 *
 * @author blanc
 */
@Local
public interface IdiomaEJBLocal {
    public void cadastrar(Idioma idioma);
    public void alterar(Idioma idioma);
    public List<Idioma> pesquisar();
    public Idioma pesquisar (int id);
}
