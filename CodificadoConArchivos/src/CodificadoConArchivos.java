import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CodificadoConArchivos {

	public static void main(String[] args) throws IOException {
	
		/*  
		 * el programa recibe argumentos antes de ser ejecutado
		 *  el primer argumento puede ser 1 = se desea codificar
		 *  							  2 = se desea decodificar
		 *  el segundo argumento puede ser cualquier int
		 *  y funciona como offset a la hora de codificar o decodifcar
		 */
		
		String archivoPalabras = "C:\\Users\\fran4\\git\\repository\\CodificadoConArchivos\\src\\palabras.txt";
		String archivoCodificadas = "C:\\Users\\fran4\\git\\repository\\CodificadoConArchivos\\src\\codificadas.txt";
		char [] palabraSeparada;
		char abecedario [] = new char [] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'} ;

		
		//CODIFICACION SI ARGS==1 --- DECODIFICACION SI ARGS==2
		if (Integer.parseInt(args[0])==1) {		//CODIFICACION
			ArrayList <String> palabras = new ArrayList<String>();
			for (String linea : Files.readAllLines(Paths.get(archivoPalabras))) {
				palabras.add(linea);
			}
			for(int I = 0; I < palabras.size(); I++) {		//BUCLEA POR CADA palabra EN palabras
				palabraSeparada = (palabras.get(I)).toCharArray();		//SE SEPARA LA PALABRA
				char palabraCodificada [] = new char [palabraSeparada.length];		//SE INSTANCIA palabraCodificada
				for(int J = 0; J < (palabraSeparada.length); J++) {		//BUCLEA POR CADA LETRA DE palabraSeparada
					if(palabraSeparada[J] != ' ') {
						for(int H = 0; H < (abecedario.length); H++) {		//SELECCIONA Y POSICIONA letra SEGUN offset EN palabraCodificada
							if(palabraSeparada[I] == abecedario[H]) {
								if((Integer.parseInt(args[1])) > ((abecedario.length)-H)) {		//(Integer.parseInt(args[1])) == OFFSET
									palabraCodificada[I] = abecedario[(Integer.parseInt(args[1]))-(abecedario.length-H)];
									break;
								}else {
									palabraCodificada[I] = abecedario[H+(Integer.parseInt(args[1]))];
									break;
								}
							}
						}
					}
				}
				String palabra = new String(palabraCodificada);		//PSEUDO-CAST char array TO string
				Files.writeString(Paths.get(archivoCodificadas), palabra);		//GUARDADO DE palabra EN archivoCodificadas			
			}
		}else if(Integer.parseInt(args[0])==2) {		//DECODIFICACION
			ArrayList <String> palabras = new ArrayList<String>();
			for (String linea : Files.readAllLines(Paths.get(archivoCodificadas))) {
				palabras.add(linea);
			}
			for(int I = 0; I < palabras.size(); I++) {		//BUCLEA POR CADA palabra EN palabras
				palabraSeparada = (palabras.get(I)).toCharArray();		//SE SEPARA LA PALABRA
				char palabraDecodificada [] = new char [palabraSeparada.length];		//SE INSTANCIA palabraCodificada
				for(int J = 0; J < (palabraSeparada.length); J++) {		//BUCLEA POR CADA LETRA DE palabraSeparada
					if(palabraSeparada[J] != ' ') {
						for(int H = 0; H < (abecedario.length); H++) {		//SELECCIONA Y POSICIONA letra SEGUN offset EN palabraCodificada
							if(palabraSeparada[I] == abecedario[H]) {
								if((Integer.parseInt(args[1])) > ((abecedario.length)-H)) {		//(Integer.parseInt(args[1])) == OFFSET
									palabraDecodificada[I] = abecedario[(Integer.parseInt(args[1]))-(abecedario.length-H)];
									break;
								}else {
									palabraDecodificada[I] = abecedario[H+(Integer.parseInt(args[1]))];
									break;
								}
							}
						}
					}
				}
				String palabra = new String(palabraDecodificada);		//PSEUDO-CAST char array TO string
				Files.writeString(Paths.get(archivoPalabras), palabra);		//GUARDADO DE palabra EN archivoCodificadas	
			}
		}	
	}

}
