/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;

import models.alumno;



public class alumnoDAOHIB implements AlumnoDAO {


    @Override
    public void insertarAlumno(alumno m) {
         var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();     
    }

    @Override
    public List<alumno> listarTodo() {
           List<alumno> salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<alumno> q = em.createQuery("select  from alumno ",alumno.class);
        salida = (List<alumno>) q.getResultList();
        em.close();
        return salida; 
    
    }

    @Override
    public List<alumno> listarSuspensos() {
       List<alumno> salida;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<alumno> q = em.createQuery("select from alumno where AD<5.0 or DI<5.0 ",alumno.class);
        salida = (List<alumno>) q.getResultList();
        em.close();
        return salida; 
    }

    @Override
    public void estadisticas() {
        double NotasSumadasAD = 0;
        double NotasSumadasDI = 0;
        List<alumno> salida;
        List<alumno> listaAprobados;
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<alumno> q = em.createQuery("select  from alumno ",alumno.class);
        salida = (List<alumno>) q.getResultList();
        em.close();
       for (int i = 0; i <= salida.size()-1; i++) {
         NotasSumadasAD+=salida.get(i).getAD();
      
    }
         for (int i = 0; i <= salida.size()-1; i++) {
         NotasSumadasDI+=salida.get(i).getDI();
      
    }
       double resultadoDI=NotasSumadasDI/salida.size();
       double resultadoAD=NotasSumadasAD/salida.size();
       System.out.println("Esta es la media de AD = "+resultadoAD);
       System.out.println("Esta es la media de DI = "+resultadoDI);
        
        var apr = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<alumno> x = apr.createQuery("select from alumno where AD>=5.0 and DI>=5.0 ",alumno.class);
        listaAprobados = (List<alumno>) x.getResultList();
        double NumeroAlumnosTotal = salida.size();  
        double NumeroAprobados = listaAprobados.size();  
        double ratio = NumeroAprobados/NumeroAlumnosTotal;
        System.out.println("Este es el ratio de aprobados = "+ratio);
        apr.close();
    }

  

   

    
    }
    
    
    
    
    
    

