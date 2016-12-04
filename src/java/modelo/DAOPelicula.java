/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author campitos
 */
public class DAOPelicula {
    
    
    public static String guardarPelicula(String titulo, String sinopsis) throws Exception{
       Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call guardar_pelicula(?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,titulo);
        callate.setString(3,sinopsis);
      
        callate.execute();
        int pk=callate.getInt(1);
        return "SE guardo la pelicula con id:"+pk; 
    }
    
    
    public static  String buscarTodasPeliculas(){
        //primero nos conectamos a Oracle
      String json="no tiene nada";
      try{
           //A. Hacer la conexion
          Connection con=  Conexion.conectarse(); 
           //B. Hacer un cueris 
          Statement st= con.createStatement ();
          
          ResultSet res=st.executeQuery("select * from pelicula");
          ArrayList<Pelicula> peliculas=new ArrayList<>();
          //C. iterar el resultado y llenar el arraylist del select
          while(res.next()){
              Pelicula p=new Pelicula();
              p.setId(res.getInt(1));
              p.setTitulo(res.getString(2));
              p.setSinopsis(res.getString(3));
              peliculas.add(p);
          }
          //preparamos la informacion de sql para que salga
          //a traves de http hacia el cliente(web) usando
          //el formato de informacion JSON
          ObjectMapper maper=new ObjectMapper(); 
          json=maper.writeValueAsString(peliculas);//hace que un  arreglo pasan a ser de tipo JSON
          
          
      }catch(Exception e){
         
       
         
          
      }
      return json;
    }
    

    
}
