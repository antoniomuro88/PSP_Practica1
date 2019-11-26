package Practica1PSP;

import Practica1PSP.ModeloP1;
import Practica1PSP.VistaP1;
import Practica1PSP.ControladorP1;

public class Main {

	public static void main(String[] args) {
		
		ModeloP1 modelo = new ModeloP1();
		VistaP1 vista = new VistaP1();
		new ControladorP1(modelo, vista);

	}

}