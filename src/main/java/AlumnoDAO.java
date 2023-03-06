/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import java.util.ArrayList;
import java.util.List;
import models.alumno;


public interface AlumnoDAO {
    
    public void insertarAlumno(alumno m);
    public List<alumno> listarTodo();
    public List<alumno> listarSuspensos();
    public void estadisticas();
  
  

}
