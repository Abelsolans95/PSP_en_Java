package Procesos2;

	public class ejemplo3 {

		public static void main(String[] args) {
			if (args.length != 1){
				System.out.print("demasiados argumentos o ninguno");
			}else{
			System.out.println("cmd /c ping "+args[0]);
			}
		}
	}

	
