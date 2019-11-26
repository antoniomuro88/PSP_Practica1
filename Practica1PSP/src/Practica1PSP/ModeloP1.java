package Practica1PSP;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class ModeloP1 {

	Runtime rt;
	Process p;
	Process blocProc;
	Process paintProc;
	Process gameProc;
	Process gestionProc;

	public void ejecutarProceso(String n, JButton bt, DefaultListModel<String> dlm) {
		bt.setEnabled(false);
		rt = Runtime.getRuntime();

		try {
			p = rt.exec(n);
			dlm.addElement(n);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void finalizarProceso(JList<String> jl, Process p, JButton btNotepad, JButton btPaint, JButton btGestion,
			JButton btGame) {
		String n = jl.getSelectedValue();
		if (n == "notepad") {
			blocProc.destroy();
			btNotepad.setEnabled(true);
		} else if (n == "mspaint") {
			paintProc.destroy();
			btPaint.setEnabled(true);
		} else if (n == "java -jar SnakeGame.jar") {
			gameProc.destroy();
			btGame.setEnabled(true);
		} else if (n == "java -jar pGestion.jar") {
			gestionProc.destroy();
			btGestion.setEnabled(true);
		}
	}

	public void ejecutarCmd(String cmd, TextArea ta) {
		try {
			p = Runtime.getRuntime().exec("cmd /C" + cmd);
			BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String res = "";
			String read;
			while ((read = in.readLine()) != null) {
				res += read + "\n";
			}
			ta.setText(res);
			if (res == "") {
				ta.setText("Introduzca un comando válido");
			}
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}