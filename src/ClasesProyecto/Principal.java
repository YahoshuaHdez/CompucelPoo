package ClasesProyecto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Declaracion de variables

		Scanner lectura = null;
		String clave, marca, modelo;
		int existencia, menuPrin, subMenu, indice;
		float precio;

		// variable de tipo objeto
		Computadoras computadora = null;

		// Declaracion de lista
		List<Computadoras> lista = new ArrayList<Computadoras>();

		do {
			System.out.println("BIENVENIDO AL SISTEMA");
			System.out.println("1 ALTA");
			System.out.println("2 MOSTRAR");
			System.out.println("3 BUSCAR POR INDICE");
			System.out.println("4 EDITAR");
			System.out.println("5 ELIMINAR POR INDICE");
			System.out.println("6 BUSCAR POR MODELO"); //SOLO SE MOSTRARA 1 REGISTRO
			System.out.println("7 BUSCAR POR MARCA"); //SE MOSTRARAN VARIOS REGISTROS
			System.out.println("8 CALCULAR DINERO INVERTIDO");
			System.out.println("9 ELIMINAR POR MODELO"); //SOLO SE ELIMINARA 1 REGISTRO
			System.out.println("10 SALIR");

			lectura = new Scanner(System.in);
			menuPrin = lectura.nextInt();

			switch (menuPrin) {
			case 1:
				try {
					System.out.println("Ingresa la clave: ");
					lectura = new Scanner(System.in);
					clave = lectura.nextLine();

					System.out.println("Ingresa la marca: ");
					lectura = new Scanner(System.in);
					marca = lectura.nextLine();

					System.out.println("Ingresa el modelo: ");
					lectura = new Scanner(System.in);
					modelo = lectura.nextLine();

					System.out.println("Ingresa la existencia: ");
					lectura = new Scanner(System.in);
					existencia = lectura.nextInt();

					System.out.println("Ingresa el precio: ");
					lectura = new Scanner(System.in);
					precio = lectura.nextFloat();
					
					

					// Crear objeto
					computadora = new Computadoras(clave, marca, modelo, existencia, precio);

					// Agregar el onjeto a la lista
					lista.add(computadora);
					System.out.println("Se agrego nuevo registro");

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("ERROR AL GUARDAR" + e.getMessage());
				}

				break;

			case 2:
				System.out.println(lista);
				break;

			case 3:
				//
				System.out.println("Registros por indice en la lista");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + i + "]" + lista.get(i).getMarca());
				}

				try {
					System.out.println("Ingresa el indice a buscar: ");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// Busqueda
					computadora = lista.get(indice);
					System.out.println("Se encontro" + computadora);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al Buscar" + e.getMessage());
				}
				break;

			case 4:
				System.out.println("Registros por indice en la lista");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + i + "]" + lista.get(i).getMarca());
				}

				try {
					System.out.println("Ingresa el indice a buscar: ");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();

					// Busqueda
					computadora = lista.get(indice);
					System.out.println("Se encontro" + computadora.getMarca());

					// Editarmos Precio y Modelo
					do {
						System.out.println("SUBMENU PARA EDITAR");
						System.out.println("1 MODELO");
						System.out.println("2 PRECIO");
						System.out.println("3 REGRESAR A MENU PRINCIPAL");
						lectura = new Scanner(System.in);
						subMenu = lectura.nextInt();

						switch (subMenu) {
						case 1:
							System.out.println("Ingresa el nuevo modelo: ");
							lectura = new Scanner(System.in);
							modelo = lectura.nextLine();

							// Actualizacion de dato
							computadora.setModelo(modelo);
							System.out.println("Se edito con exito");

							break;

						case 2:
							System.out.println("Ingresa el nuevo modelo: ");
							lectura = new Scanner(System.in);
							precio = lectura.nextFloat();

							// Actualizacion de dato
							computadora.setPrecio(precio);
							System.out.println("Se edito con exito");
							break;

						case 3:
							break;
						}
					} while (subMenu < 3);

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al Buscar o editar" + e.getMessage());
				}

				break;

			case 5:
				System.out.println("Registros por indice en la lista");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + i + "]" + lista.get(i).getMarca());
				}
				
				try {
					System.out.println("ingresa el numero a eliminar: ");
					lectura = new Scanner(System.in);
					indice = lectura.nextInt();
					
					//Eliminacion
					lista.remove(indice);
					System.out.println("Se elimino con exito");
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("ERROR AL ELIMINAR");
				}
				break;

			case 6: //Busqueda por modelo
				
				System.out.println("Registros por indice en la lista");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + lista.get(i).getModelo()+"]");
				}
				
				try {
					System.out.println("ingresa el Modelo a buscar: ");
					lectura = new Scanner(System.in);
					modelo = lectura.nextLine();
					for(Computadoras comp : lista) {
						if(comp.getModelo().equalsIgnoreCase(modelo)) {
							System.out.println("Se encontro: "+comp);
							break;
						}
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("ERROR AL BUSCAR"+e.getMessage());
				}
				
				break;
				
			case 7:  //Busqueda por Marca

				System.out.println("Registros por marcas en la lista");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + lista.get(i).getMarca()+"]");
				}
				
				try {
					System.out.println("ingresa la marca a buscar: ");
					lectura = new Scanner(System.in);
					marca = lectura.nextLine();
					for(Computadoras mark : lista) {
						if(mark.getModelo().equalsIgnoreCase(marca)) {
							System.out.println("Se encontro: "+mark);
						}
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("ERROR AL BUSCAR"+e.getMessage());
				}
				
				break;
				
			case 8:

				float resultado = 0;
				System.out.println("Dinero Invertido: ");
				for (int i = 0; i < lista.size(); i++) {
					resultado += lista.get(i).getExistencia() * lista.get(i).getPrecio();
				}System.out.println("Total de dinero invertido: "+resultado);
				
				break;
				
			case 9:

				System.out.println("Registros por modelo en la lista");
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("[" + lista.get(i).getModelo()+"]");
				}
				
				try {
					System.out.println("ingresa el modelo a eliminar: ");
					lectura = new Scanner(System.in);
					modelo = lectura.nextLine();
					//Eliminar
					for(int i = 0; i < lista.size(); i++) {
						if(lista.get(i).getModelo().equalsIgnoreCase(modelo)) {
							lista.remove(i);
							System.out.println("Se elimino con exito");
							break;
						}
					}
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("ERROR AL BUSCAR"+e.getMessage());
				}
				break;
				
			case 10:

				break;

			}

		} while (menuPrin < 10);

	}

}
