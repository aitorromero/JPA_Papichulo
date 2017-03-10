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
//@NamedQueries({
//@NamedQuery(name=Usuari.CONSULTA, query="SELECT u FROM Usuari u WHERE u.nom=:usuariNom")})
@Table(name = "USUARI")
public class Usuari implements Serializable {
    
    private static final long serialVersionUID = 1L;
    //public static final String CONSULTA = "UsuariId";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long usuariId;
        
    @Column(name = "usuariNom", length = 30)
    private String nom;

    
    @Column(name = "usuariPass", length = 30)
    private String pass;

    public Usuari() {
    }

    public Usuari(long usuariId, String nom, String pass) {
        this.usuariId = usuariId;
        this.nom = nom;
        this.pass = pass;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUsuariId() {
        return usuariId;
    }

    public String getNom() {
        return nom;
    }

    public String getPass() {
        return pass;
    }
    
    public void setUsuariId(Long usuariId) {
        this.usuariId = usuariId;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.usuariId);
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
        if (!Objects.equals(this.usuariId, other.usuariId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuari{" + "usuariId=" + usuariId + ", nom=" + nom + ", pass=" + pass + '}';
    }
    
    
    
}
