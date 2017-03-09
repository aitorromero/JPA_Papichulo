package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity 
@NamedQueries({
    @NamedQuery(name=Asseguradora.CONSULTA, query="SELECT a FROM Asseguradora a WHERE a.asseguradoraId=:id")})
@Table(name = "ASSEGURADORA")

public class Asseguradora implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "asseguradoraId")
    private Long asseguradoraId;
    
    public static final String CONSULTA = "AsseguradoraId";
    
    @Column(name = "nomAsseguradora", length = 100, unique = true)
    private String nomAsseguradora;

    @Column(name = "nifPolissa")
    private int nifPolissa;

    public Asseguradora(Long id, String nomAsseguradora, int nifPolissa) {
        this.asseguradoraId = id;
        this.nomAsseguradora = nomAsseguradora;
        this.nifPolissa = nifPolissa;
    }

    public Asseguradora() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAsseguradoraId() {
        return asseguradoraId;
    }

    public String getNomAsseguradora() {
        return nomAsseguradora;
    }

    public int getNifPolissa() {
        return nifPolissa;
    }

    public void setAsseguradoraId(Long asseguradoraId) {
        this.asseguradoraId = asseguradoraId;
    }

    public void setNomAsseguradora(String nomAsseguradora) {
        this.nomAsseguradora = nomAsseguradora;
    }

    public void setNifPolissa(int nifPolissa) {
        this.nifPolissa = nifPolissa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.asseguradoraId);
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
        final Asseguradora other = (Asseguradora) obj;
        if (!Objects.equals(this.asseguradoraId, other.asseguradoraId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Asseguradora{" + "id=" + asseguradoraId + ", nomAsseguradora=" + nomAsseguradora + ", nifPolissa=" + nifPolissa + '}';
    }
    
    

}
