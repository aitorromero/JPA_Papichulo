package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name=Persona.CONSULTA, query="SELECT u FROM Usuari u WHERE u.usuariNom=:usuariNom")})
@Table(name = "USUARIS")
public class Usuari implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "usuariNom", length = 30, nullable = false)
    private String nom;
    
    public static final String CONSULTA = "UsuariId";
    
    @Column(name = "usuariPass", length = 30, nullable = false)
    private String pass;

    public Usuari(String nom, String pass) {
        this.nom=nom;
        this.pass=pass;
    }
    
    public Usuari(){}
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPass(){
        return pass;
    }
    
    public void setPas(String nom){
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuari other = (Usuari) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Usuari{" + "nom=" + nom + ", pass=" + pass + '}';
    }
    
    
}
