/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprog2.logica;

import com.mycompany.finalprog2.persistencia.ControladoraPersistencia;
import java.util.ArrayList;

/**
 *
 * @author lpela
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearHospital(Hospital hos){
        controlPersis.crearHospital(hos);
    }
    
    public void eliminarHospital(int id){
        controlPersis.eliminarHospital(id);
        
    }
    
    public void editarHospital(Hospital hos){
        controlPersis.editarHospital(hos);
    }
    
    public Hospital traerHospital(int id){
       return controlPersis.traerHospital(id); 
    }
    /*
    public ArrayList<Alumno> traerListaAlumnos(){
        return controlPersis.traerListaAlumnos();
    }
*/
    
}
