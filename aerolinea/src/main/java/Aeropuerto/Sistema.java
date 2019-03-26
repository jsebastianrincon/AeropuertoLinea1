package Aeropuerto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author Juan Sebastian Rincon
 * @author Edward Ramos
 */

/*Clase donde se hace el manejo de los mapas tanto para las personas como para los aviones*/
public class Sistema {
    private HashMap<String,Avion> aviones;
    private HashMap<String,Persona> personas;
    
    public Sistema(){
        aviones=new HashMap();
        personas=new HashMap();
    }
/*Metodo donde se hace el manejo del almacenamiento del archivo*/    
    public void guardarArchivo(HashMap<String, Avion> hmAviones){
        try{
            File fileOne=new File("Aerolinea");
            FileOutputStream fos=new FileOutputStream(fileOne);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            
            oos.writeObject(hmAviones);
            oos.flush();
            oos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    /*Metodo donde se hace el manejo de la lectura del archivo*/
    public HashMap leerArchivo(){
        try{
            File toRead=new File("Aerolinea");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            aviones=(HashMap<String,Avion>)ois.readObject();
            
            ois.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        } 
        return aviones;
    }
     /*Metodo donde se hace el manejo del almacenamiento del archivo*/
    public void guardarArchivoCliente(HashMap<String, Persona> hmPersonas){
        try{
            File fileOne=new File("Clientes");
            FileOutputStream fos=new FileOutputStream(fileOne);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            
            oos.writeObject(hmPersonas);
            oos.flush();
            oos.close();
            fos.close();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
     /*Metodo donde se hace el manejo de la lectura del archivo para la informacion del cliente*/
    public HashMap leerArchivoCliente(){
        try{
            File toRead=new File("Clientes");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            personas=(HashMap<String,Persona>)ois.readObject();
            
            ois.close();
            fis.close();
            
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        } 
        return personas;
    }
}
