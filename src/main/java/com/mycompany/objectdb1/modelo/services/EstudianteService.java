/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objectdb1.modelo.services;
import com.mycompany.objectdb1.modelo.Estudiante;
import javax.persistence.*;
import java.util.List;

/**
 *
 * @author ivan_
 */
public class EstudianteService {
    private EntityManagerFactory emf;
    
    public EstudianteService(){
        emf = Persistence.createEntityManagerFactory("Estudiantes");
        
    }
    
    public void guardarEstudiante(Estudiante estudiante) {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException("Error al guardar al estudiante: " + e.getMessage());
        } finally{
            em.close();
        }
    }

    public List<Estudiante> obtenerTodosLosEstudiantes(){
        EntityManager em = emf.createEntityManager();
        
        try{
            TypedQuery<Estudiante> query = em.createQuery("SELECT e From Estudiante e", Estudiante.class);
            return query.getResultList();
        }finally{
            em.close();
        }
    }
    public Estudiante buscarPorId(Long Id){
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Estudiante.class, Id);
        }finally{
            em.close();
        }
    }
    public void actualizarEstudiante(Estudiante estudiante){
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(estudiante);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException("Error al actualizar al estudiante: " + e.getMessage());
        }finally{
            em.close();
        }
    }
    
// Este código debe estar en EstudianteService.java
public void eliminarEstudiante (Long id){
    EntityManager em = emf.createEntityManager();
    try{
        em.getTransaction().begin();
        Estudiante estudiante = em.find(Estudiante.class, id);
        if(estudiante != null){
            em.remove(estudiante);
            em.getTransaction().commit();
        } else {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new EntityNotFoundException("Estudiante con ID " + id + " no encontrado para eliminar.");
        }
    }catch(Exception e){
        if(em.getTransaction().isActive()){
            em.getTransaction().rollback();
        }
        throw new RuntimeException("Error al eliminar al estudiante: " + e.getMessage(), e);
    } finally{
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}
    
    public void cerrar(){
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }
}
