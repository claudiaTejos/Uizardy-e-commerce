/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.bean;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import sp.senac.br.beans.IdiomaEJBLocal;
import sp.senac.br.uizardy.commons.Idioma;

/**
 *
 * @author blanc
 */
@ManagedBean
@RequestScoped
public class IdiomaBean {
    
    private Idioma idioma;
    
    @EJB
    private IdiomaEJBLocal idiomaEJB;

    public IdiomaBean() {
        this.idioma = new Idioma();
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
    
    //cadastra um novo idioma
    public void cadastrar(){
        idiomaEJB.cadastrar(this.idioma);
    }
    
    //lista todos os idioma
    public List<Idioma> pesquisar(){
        return idiomaEJB.pesquisar();
    }
    
    //retorna um idioma pelo ID
    public Idioma pesquisar(int idIdioma){
        return idiomaEJB.pesquisar(idIdioma);
    }
    
    //atualiza um idioma
    public void atualizar(){
        idiomaEJB.alterar(this.idioma);
    }
    
}