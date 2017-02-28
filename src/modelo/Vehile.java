package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQueries({
//@NamedQuery(name="PersonaNom", query="SELECT p FROM Persona p WHERE p.nombre=:nombre")})
@NamedQuery(name = Persona.CONSULTA, query = "SELECT p FROM Persona p WHERE p.nombre=:nombre")})
//@NamedQuery(name=Persona.CONSULTA, query="SELECT p FROM Persona p WHERE p.nombre=:nombre"),
//segunda query, tercera...})
@Table(name = "VEHICLES")
public class Vehile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleId")
    private Long id;
    
    public static final String CONSULTA = "VehicleId";
    
    @Column(name = "matricula", length = 7, unique = true, nullable = false)
    private String matricula;

    @Column(name = "marcamodel", length = 50, nullable = false)
    private String marcaModel;

    @Column(name = "anyFabricacio")
    private int anyFabricacio;

    @Column(name = "propietari")
    @Basic(fetch = FetchType.LAZY)
    private Client propietari;

    public Vehile(Long id, String matricula, String marcaModel, int anyFabricacio, Client propietari) {
        this.id = id;
        this.matricula = matricula;
        this.marcaModel = marcaModel;
        this.anyFabricacio = anyFabricacio;
        this.propietari = propietari;
    }     
    
    public Vehile(){
        
    }
    
    

}
