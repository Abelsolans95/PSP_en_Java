package Procesos2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

public class logConexion {

	public static void main(String[] args){
		Runtime r = Runtime.getRuntime();
		
		PrintWriter file = null;
	
		String comando = new String("cmd /c ping 8.8.8.8");
		Process p=null;
		try {
			p = r.exec( comando );
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader (is));
			
			String linea;
			while ((linea = br.readLine() ) != null){
				if(linea.length()>5){
				if( linea.substring(0, 6) == "Tiempo"){
					Date fecha = new Date();
					file.println(fecha.toString() + "error en la transmision");
				}
				System.out.println(linea);
					}
				}
		}catch (Exception e){
			System.out.println("Error en : "+comando);
			e.printStackTrace();
		}
		
		int salida;
		try{
			salida = p.waitFor();
			System.out.println("Valor devuelto "+ salida);
			}catch(InterruptedException e){
				System.out.println("el comando termino bruscamente");
				e.printStackTrace();
			
		}
		try{
			InputStream er = p.getErrorStream();
			BufferedReader errorBufferR = new BufferedReader(new InputStreamReader(er));
			
			String lineaError;
			while ((lineaError = errorBufferR.readLine())!= null){
				System.out.println("Error: " +lineaError);
			}
		}catch (IOException ioe){
			ioe.printStackTrace();
		}
	}
}