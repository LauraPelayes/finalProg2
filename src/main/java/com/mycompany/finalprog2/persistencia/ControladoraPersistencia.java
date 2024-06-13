/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalprog2.persistencia;

import com.mycompany.finalprog2.logica.Hospital;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lpela
 */
public class ControladoraPersistencia {

    HospitalJpaController hosJpa = new HospitalJpaController();
    
    
    public void crearHospital(Hospital hos) {

        hosJpa.create(hos);
        
    }

    public void eliminarHospital(int id) {

        try {
            hosJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarHospital(Hospital hos) {
        
        try {
            hosJpa.edit(hos);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Hospital traerHospital(int id) {

        return hosJpa.findHospital(id);
    }
    
}
