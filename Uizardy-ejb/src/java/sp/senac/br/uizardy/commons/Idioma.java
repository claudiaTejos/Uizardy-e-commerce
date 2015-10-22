/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.commons;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author blanc
 */
@Entity
public class Idioma implements Serializable {
    
    @Id
    @GeneratedValue
    private int idIdioma;
    
    private String nomeIdioma;

    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNomeIdioma() {
        return nomeIdioma;
    }

    public void setNomeIdioma(String nomeIdioma) {
        this.nomeIdioma = nomeIdioma;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.idIdioma;
        hash = 59 * hash + Objects.hashCode(this.nomeIdioma);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Idioma other = (Idioma) obj;
        if (this.idIdioma != other.idIdioma) {
            return false;
        }
        if (!Objects.equals(this.nomeIdioma, other.nomeIdioma)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Idioma{" + "idIdioma=" + idIdioma + ", nomeIdioma=" + nomeIdioma + '}';
    }
    
}