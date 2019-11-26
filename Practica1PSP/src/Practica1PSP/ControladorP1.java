package Practica1PSP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JOptionPane;

public class ControladorP1 implements ActionListener, WindowListener {
	ModeloP1 modelo = null;
	VistaP1 vista = null;

	public ControladorP1(ModeloP1 modelo, VistaP1 vista) {
		this.vista = vista;
		this.modelo = modelo;
		this.vista.getBtNotepad().addActionListener(this);
		this.vista.getBtFinalizar().addActionListener(this);
		this.vista.getBtGame().addActionListener(this);
		this.vista.getBtPaint().addActionListener(this);
		this.vista.getBtGestion().addActionListener(this);
		this.vista.getBtExeCmd().addActionListener(this);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object a = e.getSource();

		if (a.equals(vista.getBtNotepad())) {
			modelo.ejecutarProceso("notepad", vista.getBtNotepad(), vista.getModeloLista());
			modelo.blocProc = modelo.p;
		} else if (a.equals(vista.getBtPaint())) {
			modelo.ejecutarProceso("mspaint", vista.getBtPaint(), vista.getModeloLista());
			modelo.paintProc = modelo.p;
		} else if (a.equals(vista.getBtGame())) {
			modelo.ejecutarProceso("java -jar SnakeGame.jar", vista.getBtGame(), vista.getModeloLista());
			modelo.gameProc = modelo.p;
		} else if (a.equals(vista.getBtGestion())) {
			modelo.ejecutarProceso("java -jar pGestion.jar", vista.getBtGestion(), vista.getModeloLista());
			modelo.gestionProc = modelo.p;
		} else if (a.equals(vista.getBtFinalizar())) {
			if (vista.getListProc().getSelectedValue() == null) {
				JOptionPane.showMessageDialog(vista, "Por favor, seleccione un proceso", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				modelo.finalizarProceso(vista.getListProc(), modelo.p, vista.getBtNotepad(), vista.getBtPaint(),
						vista.getBtGestion(), vista.getBtGame());
				vista.modeloLista.remove(vista.getListProc().getSelectedIndex());
			}
		} else if (a.equals(vista.getBtExeCmd())) {
			modelo.ejecutarCmd(vista.getTxtCmd().getText(), vista.getTxtAreaCmd());
			vista.getTxtCmd().setText("");
		}
	}
}