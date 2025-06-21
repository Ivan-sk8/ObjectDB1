/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.objectdb1.modelo.vista;

import com.mycompany.objectdb1.modelo.Estudiante;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ivan_
 */
public class EstudianteTableModel extends AbstractTableModel
{
    private final String[] columnNames = {"ID", "Name", "Lastname", "Email", "Age"};
    private List<Estudiante> estudiantes;
    
    public EstudianteTableModel(){
        this.estudiantes = new ArrayList<>();
    }
    
    public EstudianteTableModel(List<Estudiante> estudiantes){
        this.estudiantes = estudiantes != null ? estudiantes : new ArrayList<>();
    }
    
    @Override
    public int getRowCount(){
        return estudiantes.size();
    }
    
    @Override
    public int getColumnCount(){
        return columnNames.length;
    }
    
    @Override
    public String getColumnName(int Column){
        return columnNames[Column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Estudiante estudiante = estudiantes.get(rowIndex);
        
        switch(columnIndex){
            case 0: return estudiante.getId();
            case 1: return estudiante.getNombre();
            case 2: return estudiante.getApellido();
            case 3: return estudiante.getEmail();
            case 4: return estudiante.getEdad();
            default: return null;
        }
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Long.class;
            case 1: return Integer.class;
            default: return String.class;
        }
    }
    
    @Override
    public boolean isCellEditable (int rowIndex, int ColumnIndex){
        return false;
    }
    
    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes != null ? estudiantes: new ArrayList<>();
        fireTableDataChanged();
    }
    
    public Estudiante getEstudianteAt(int rowIndex){
        if(rowIndex >= 0 && rowIndex < estudiantes.size()){
            return estudiantes.get(rowIndex);
        }
        return null;
    }
    
    public void addEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        fireTableRowsInserted(estudiantes.size() -1, estudiantes.size() -1);
    }
    
    public void removeEstudiante(int rowIndex) {
        if(rowIndex >= 0 && rowIndex < estudiantes.size()) {
            estudiantes.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }
}
