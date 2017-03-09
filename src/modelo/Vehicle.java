package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQueries({
   @NamedQuery(name=Vehicle.CONSULTA, query="SELECT v FROM Vehicle v WHERE v.vehicleId=:vehicleId")})
@Table(name = "VEHICLE")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleId")
    private Long vehicleId;
    
    public static final String CONSULTA = "VehicleId";
    
    @Column(name = "matricula", length = 7, unique = true, nullable = false)
    private String matricula;

    @Column(name = "marcamodel", length = 40, nullable = false)
    private String marcaModel;

    @Column(name = "anyFabricacio", length = 30)
    private int anyFabricacio;
    
    //@OneToOne//(fetch = FetchType.LAZY)
    //@Column(name = "propietari")
    @ManyToOne
    @JoinColumn(name="vehiclePropietari")
    private Client propietari;

    public Vehicle(Long vehicleId, String matricula, String marcaModel, int anyFabricacio, Client propietari) {
        this.vehicleId = vehicleId;
        this.matricula = matricula;
        this.marcaModel = marcaModel;
        this.anyFabricacio = anyFabricacio;
        this.propietari = propietari;
    }     
    
    public Vehicle(){
        
    }

    public Long getId() {
        return vehicleId;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarcaModel() {
        return marcaModel;
    }

    public int getAnyFabricacio() {
        return anyFabricacio;
    }

    public Client getPropietari() {
        return propietari;
    }

    public void setId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarcaModel(String marcaModel) {
        this.marcaModel = marcaModel;
    }

    public void setAnyFabricacio(int anyFabricacio) {
        this.anyFabricacio = anyFabricacio;
    }

    public void setPropietari(Client propietari) {
        this.propietari = propietari;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.vehicleId);
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
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.vehicleId, other.vehicleId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "vehicleId=" + vehicleId + ", matricula=" + matricula + ", marcaModel=" + marcaModel + ", anyFabricacio=" + anyFabricacio + ", propietari=" + propietari + '}';
    }
    
    

}
