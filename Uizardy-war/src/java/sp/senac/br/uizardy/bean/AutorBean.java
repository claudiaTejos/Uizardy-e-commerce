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
import sp.senac.br.beans.AutorEJBLocal;
import sp.senac.br.uizardy.commons.Autor;

/**
 *
 * @author blanc
 */
@ManagedBean
@RequestScoped
public class AutorBean {
    
    private Autor autor;
    
    @EJB
    private AutorEJBLocal autorEJB;

    public AutorBean() {
        this.autor = new Autor();
    }

    public Autor getIdioma() {
        return autor;
    }

    public void setIdioma(Autor autor) {
        this.autor = autor;
    }
    
    //cadastra um novo autor
    public void cadastrar(){
        autorEJB.cadastrar(this.autor);
    }
    
    //lista todos os autor
    public List<Autor> pesquisar(){
        return autorEJB.pesquisar();
    }
    
    //retorna um autor pelo ID
    public Autor pesquisar(int idAutor){
        return autorEJB.pesquisar(idAutor);
    }
    
    //atualiza um autor
    public void atualizar(){
        autorEJB.alterar(this.autor);
    }
    
}
