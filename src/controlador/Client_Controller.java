package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import modelo.Client;
import modelo.Polissa;
import modelo.Vehicle;

public class Client_Controller {

    public void Insertar(Client p) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("persist");
        em.persist(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Modificar(Client p) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("merge");
        em.merge(p);

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public void Eliminar(Client p) {
        EM_Controller oem = new EM_Controller();
        EntityManager em = oem.getEntityManager();

        //em.getTransaction().begin();
        EntityTransaction etx = em.getTransaction();

        System.out.println("begin");
        etx.begin();

        System.out.println("remove");
        em.remove(em.contains(p) ? p : em.merge(p));

        System.out.println("commit");
        //em.getTransaction().commit();
        etx.commit();

        System.out.println("close");
        em.close();
    }

    public Client Buscar(Long id) {
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("busqueda");

        Client c = (Client) em.find(Client.class, id);

        System.out.println("close");
        em.close();

        return c;
    }

    public Client BuscarPerNom(String nom) {
        EntityManager em = new EM_Controller().getEntityManager();

        System.out.println("Busqueda per nom");
        Query query = em.createNamedQuery("cercaClientNom", Client.class);
        query.setParameter("nom", nom);
        Client c = (Client) query.getSingleResult();
        System.out.println("close");
        em.close();
        return c;
    }

    public void imprimirPersona(Client c) {
        System.out.println(c);
    }
    
    public List<Vehicle> obtenirVehiclesClient(long id){
        EntityManager  em = new EM_Controller().getEntityManager();
        System.out.println("Cerca de vehicles que te un client");
        Query query = em.createNamedQuery("cercaVehiclesClient", Vehicle.class);
        query.setParameter("id", id);
        List<Vehicle> lista = (List<Vehicle>) query.getResultList();
        System.out.println(lista);
        System.out.println("close");
        em.close();
        return lista;
    }

}