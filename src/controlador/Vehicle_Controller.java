package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Adreca;
import modelo.Client;
import modelo.Persona;
import modelo.Usuari;
import modelo.Vehicle;

public class Vehicle_Controller {

    public void Insertar(Vehicle p) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(p);

        System.out.println("commit");
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Modificar(Vehicle v) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(v);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Eliminar(Vehicle v) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(v) ? v : em.merge(v));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public Vehicle Buscar(long id) {
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Vehicle c = (Vehicle) em.find(Vehicle.class, id);

        System.out.println("close");
        em.close();

        return c;
    }

    public Client BuscarClient(long id) {
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Cerca de client per id per asignar-lo a la un vehicle: ");
        Client c = (Client) em.find(Client.class, id);
        System.out.println(c);
        System.out.println("close");
        em.close();
        return c;
    }

    public Vehicle cercaVehicleMatricula(String matricula) {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();
        System.out.println("Busqueda per matricula");
        //Query query = em.createNamedQuery("PersonaNom",Persona.class);
        Query query = em.createNamedQuery("cercaVehicleMatricula", Vehicle.class);
        query.setParameter("matricula", matricula);
        Vehicle v = (Vehicle) query.getSingleResult();
        System.out.println("close");
        em.close();
        return v;
    }

    public List<Vehicle> ConsultaTots() {
        // Recupera el entity manager
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Consulta");
//        List<Persona> lista = (List<Persona>) em.createQuery("FROM Persona").getResultList();
        Query q = em.createQuery("FROM Vehicle");
        List<Vehicle> lista = (List<Vehicle>) q.getResultList();
        System.out.println(lista);
        System.out.println("close");
        em.close();
        return lista;
    }

}