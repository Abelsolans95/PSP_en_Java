package Procesos2;


import java.io.*;



public class Ejemplo1{
	public static void main(String[] args){
		Runtime r = Runtime.getRuntime();
		String comando = "cmd /k ping "+args[0];
		Process p=null;
		try {
			p = r.exec( comando );
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader (is));
			
			String linea;
			while ((linea = br.readLine() ) != null){
				System.out.println(linea);
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