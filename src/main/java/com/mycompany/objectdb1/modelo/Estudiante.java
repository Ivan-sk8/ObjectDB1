/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objectdb1.modelo;

import javax.persistence.*;
import java.io.Serializable;
/**
 *
 * @author ivan_
 */
@Entity
public class Estudiante implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    
    @Column (nullable = false)
    private String apellido;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    private int edad;
    
    //Constructor vacio
    public Estudiante() {}
    
    //Constructor con parametros
    public Estudiante(String nombre, String apellido, String email, int edad)
    {
    this.nombre = nombre;
    this.apellido = apellido;
    this.email = email;
    this.edad = edad;
    }
    
    //getter and setters
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override
    public String toString(){
        return nombre + " " + apellido + "(" + email + ")";
    }
}
