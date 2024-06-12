/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprog2.logica;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private int id;
    private String nombre;
    
    @OneToMany
    private ArrayList<Doctor> doctores;
    private ArrayList<Paciente> pacientes;

    public Hospital() {
    }

    public Hospital(int id, String nombre, ArrayList<Doctor> doctores, ArrayList<Paciente> pacientes) {
        this.id = id;
        this.nombre = nombre;
        this.doctores = doctores;
        this.pacientes = pacientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(ArrayList<Doctor> doctores) {
        this.doctores = doctores;
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "Hospital{" + "id=" + id + ", nombre=" + nombre + ", doctores=" + doctores + ", pacientes=" + pacientes + '}';
    }
    
    
    
}
