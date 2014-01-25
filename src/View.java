

import java.awt.*;
import java.awt.List;

import javax.swing.*;

import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.*;


public class View extends JFrame implements ActionListener{

	//DECLARAÇÃO DAS VARIÁVEIS
	public String[] acionados = {"","","","","","",""};
	
	private int andarAtual = 0;
	private int qtdePassageiros = 0;
	private EstadoPorta estadoPorta = EstadoPorta.Fechada;
	private EstadoElevador estadoElevador = EstadoElevador.Parado;
	
	Movimenta movimenta;
	
	//DECLARAÇÃO DOS COMPONENTES
	
	JLabel lblAndarAtual, lblAndar0, lblAndar1, lblAndar2, lblAndar3, lblAndar4, lblAndar5, lblAndar6, lblQtdePassageiros, lblStatusPorta, lblStatusElevador, lblQtdePassageirosFixo, lblStatusPortaFixo, lblStatusElevadorFixo, lblAndarAtualFixo;
	
	JPanel pnlButtons, pnlEsquerdo, pnlDireito, pnlStatus, pnlAndar0, pnlAndar1, pnlAndar2, pnlAndar3, pnlAndar4, pnlAndar5, pnlAndar6, pnlQtdePessoas, pnlStatusPorta, pnlStatusElevador, pnlAndarAtual;
	
	JButton btnSair, btnAndar0, btnAndar1, btnAndar2, btnAndar3, btnAndar4, btnAndar5, btnAndar6;
	
	Container container;

	public View()
	{
		super("Controle de Elevador");
		
		movimenta = new Movimenta();
		
		//INICIALIZAÇÃO DOS COMPONENTES

		lblAndarAtualFixo = new JLabel();
		lblStatusElevadorFixo = new JLabel();
		lblStatusPortaFixo = new JLabel();
		lblQtdePassageirosFixo = new JLabel();
		lblAndar0 = new JLabel();
		lblAndar1 = new JLabel();
		lblAndar2 = new JLabel();
		lblAndar3 = new JLabel();
		lblAndar4 = new JLabel();
		lblAndar5 = new JLabel();
		lblAndar6 = new JLabel();
		lblAndarAtual = new JLabel();
		lblQtdePassageiros = new JLabel();
		lblStatusElevador = new JLabel();
		lblStatusPorta = new JLabel();
		
		btnAndar0 = new JButton();
		btnAndar1 = new JButton();
		btnAndar2 = new JButton();
		btnAndar3 = new JButton(); 
		btnAndar4 = new JButton();
		btnAndar5 = new JButton();
		btnAndar6 = new JButton();
		btnSair = new JButton();
		
		pnlStatus = new JPanel();
		pnlDireito = new JPanel();
		pnlButtons = new JPanel();
		pnlEsquerdo = new JPanel();
		pnlAndar0 = new JPanel();
		pnlAndar1 = new JPanel();
		pnlAndar2 = new JPanel();
		pnlAndar3 = new JPanel();
		pnlAndar4 = new JPanel();
		pnlAndar5 = new JPanel();
		pnlAndar6 = new JPanel();
		
		pnlStatusElevador = new JPanel();
		pnlStatusPorta = new JPanel();
		pnlQtdePessoas = new JPanel();
		pnlAndarAtual = new JPanel();
		
		//FORMATAÇÃO DOS COMPONENTES
		
		lblStatusPorta.setText("Fechada");
		lblStatusElevador.setText("Parado");
		lblQtdePassageiros.setText("0");
		lblAndarAtual.setText("0");
		lblQtdePassageirosFixo.setText("Passageiros no elevador:");
		lblStatusElevadorFixo.setText("Status do elevador:");
		lblStatusPortaFixo.setText("Status da porta:");
		lblAndarAtualFixo.setText("Andar atual:");
		
		lblStatusPorta.setFont(new Font("Arial", 0, 30));
		lblStatusElevador.setFont(new Font("Arial", 0, 30));
		lblQtdePassageiros.setFont(new Font("Arial", 0, 50));
		lblAndarAtual.setFont(new Font("Arial", 0, 50));
		
		lblAndar0.setText("Andar Térreo");
		lblAndar1.setText("1º Andar");
		lblAndar2.setText("2º Andar");
		lblAndar3.setText("3º Andar");
		lblAndar4.setText("4º Andar");
		lblAndar5.setText("5º Andar");
		lblAndar6.setText("6º Andar");
		
		lblAndar0.setFont(new Font("Arial", 0, 30));
		lblAndar1.setFont(new Font("Arial", 0, 30));
		lblAndar2.setFont(new Font("Arial", 0, 30));
		lblAndar3.setFont(new Font("Arial", 0, 30));
		lblAndar4.setFont(new Font("Arial", 0, 30));
		lblAndar5.setFont(new Font("Arial", 0, 30));
		lblAndar6.setFont(new Font("Arial", 0, 30));
		
		btnAndar0.addActionListener(this);
		btnAndar1.addActionListener(this);
		btnAndar2.addActionListener(this);
		btnAndar3.addActionListener(this);
		btnAndar4.addActionListener(this);
		btnAndar5.addActionListener(this);
		btnAndar6.addActionListener(this);
		btnSair.addActionListener(this);
		
		btnAndar0.setText("T");
		btnAndar1.setText("1");
		btnAndar2.setText("2");
		btnAndar3.setText("3");
		btnAndar4.setText("4");
		btnAndar5.setText("5");
		btnAndar6.setText("6");
		btnSair.setText("Sair");
		
		btnAndar0.setFont(new Font("Arial", 0, 30));
		btnAndar1.setFont(new Font("Arial", 0, 30));
		btnAndar2.setFont(new Font("Arial", 0, 30));
		btnAndar3.setFont(new Font("Arial", 0, 30));
		btnAndar4.setFont(new Font("Arial", 0, 30));
		btnAndar5.setFont(new Font("Arial", 0, 30));
		btnAndar6.setFont(new Font("Arial", 0, 30));
		btnSair.setFont(new Font("Arial", 0, 30));
		
		btnAndar0.setBackground(Color.LIGHT_GRAY);
		btnAndar1.setBackground(Color.LIGHT_GRAY);
		btnAndar2.setBackground(Color.LIGHT_GRAY);
		btnAndar3.setBackground(Color.LIGHT_GRAY);
		btnAndar4.setBackground(Color.LIGHT_GRAY);
		btnAndar5.setBackground(Color.LIGHT_GRAY);
		btnAndar6.setBackground(Color.LIGHT_GRAY);
		
		pnlEsquerdo.setLayout(new GridLayout(7,1));
		pnlEsquerdo.add(pnlAndar6);
		pnlEsquerdo.add(pnlAndar5);
		pnlEsquerdo.add(pnlAndar4);
		pnlEsquerdo.add(pnlAndar3);
		pnlEsquerdo.add(pnlAndar2);
		pnlEsquerdo.add(pnlAndar1);
		pnlEsquerdo.add(pnlAndar0);
		    		
		pnlAndar0.setBackground(new Color(22222));
		pnlAndar1.setBackground(new Color(50500));
		pnlAndar2.setBackground(new Color(50500));
		pnlAndar3.setBackground(new Color(50500));
		pnlAndar4.setBackground(new Color(50500));
		pnlAndar5.setBackground(new Color(50500));
		pnlAndar6.setBackground(new Color(50500));
		
		pnlAndar0.add(lblAndar0);
		pnlAndar1.add(lblAndar1);
		pnlAndar2.add(lblAndar2);
		pnlAndar3.add(lblAndar3);
		pnlAndar4.add(lblAndar4);
		pnlAndar5.add(lblAndar5);
		pnlAndar6.add(lblAndar6);		
		
		pnlAndarAtual.add("North",lblAndarAtualFixo);
		pnlAndarAtual.add("Center", lblAndarAtual);

		pnlQtdePessoas.add("North", lblQtdePassageirosFixo);
		pnlQtdePessoas.add("Center", lblQtdePassageiros);
		
		pnlStatusElevador.add("North", lblStatusElevadorFixo);
		pnlStatusElevador.add("Center", lblStatusElevador);
		
		pnlStatusPorta.add("North", lblStatusPortaFixo);
		pnlStatusPorta.add("Center", lblStatusPorta);
		
		pnlStatus.add(pnlAndarAtual);
		pnlStatus.add(pnlQtdePessoas);
		pnlStatus.add(pnlStatusElevador);
		pnlStatus.add(pnlStatusPorta);
		pnlStatus.setLayout(new GridLayout(2,2));
		
		pnlDireito.add(pnlStatus);
		pnlDireito.setLayout(new GridLayout(1,1));
		
		pnlButtons.setLayout(new GridLayout(4,4));
		pnlButtons.add(btnAndar0);
		pnlButtons.add(btnAndar1);
		pnlButtons.add(btnAndar2);
		pnlButtons.add(btnAndar3);
		pnlButtons.add(btnAndar4);
		pnlButtons.add(btnAndar5);
		pnlButtons.add(btnAndar6);
		pnlButtons.add(btnSair);
	
		container = getContentPane();
		
		container.setLayout(new GridLayout(1,3));
		container.add(pnlEsquerdo);
		container.add(pnlButtons);
		container.add(pnlDireito);
		
		setSize(1200,600);
		setVisible(true);
	}
		
	
	public void verificaAndar()
	{
		if (andarAtual == 0)
		{
			pnlAndar6.setBackground(new Color(50500));
			pnlAndar0.setBackground(new Color(22222));
			pnlAndar1.setBackground(new Color(50500));
			
			btnAndar0.setBackground(Color.LIGHT_GRAY);
			btnAndar0.setEnabled(true);
		}
		
		else if (andarAtual == 1)
		{
			pnlAndar0.setBackground(new Color(50500));
			pnlAndar1.setBackground(new Color(22222));
			pnlAndar2.setBackground(new Color(50500));
			
			btnAndar1.setBackground(Color.LIGHT_GRAY);
			btnAndar1.setEnabled(true);
		}
		
		else if (andarAtual == 2)
		{
			pnlAndar1.setBackground(new Color(50500));
			pnlAndar2.setBackground(new Color(22222));
			pnlAndar3.setBackground(new Color(50500));
			
			btnAndar2.setBackground(Color.LIGHT_GRAY);
			btnAndar2.setEnabled(true);
		}
		
		else if (andarAtual == 3)
		{
			pnlAndar2.setBackground(new Color(50500));
			pnlAndar3.setBackground(new Color(22222));
			pnlAndar4.setBackground(new Color(50500));
			
			btnAndar3.setBackground(Color.LIGHT_GRAY);
			btnAndar3.setEnabled(true);
		}
		
		else if (andarAtual == 4)
		{
			pnlAndar3.setBackground(new Color(50500));
			pnlAndar4.setBackground(new Color(22222));
			pnlAndar5.setBackground(new Color(50500));
			
			btnAndar4.setBackground(Color.LIGHT_GRAY);
			btnAndar4.setEnabled(true);
		}
		
		else if (andarAtual == 5)
		{
			pnlAndar4.setBackground(new Color(50500));
			pnlAndar5.setBackground(new Color(22222));
			pnlAndar6.setBackground(new Color(50500));
			
			btnAndar5.setBackground(Color.LIGHT_GRAY);
			btnAndar5.setEnabled(true);
		}
		
		else if (andarAtual == 6)
		{
			pnlAndar5.setBackground(new Color(50500));
			pnlAndar6.setBackground(new Color(22222));
			pnlAndar0.setBackground(new Color(50500));
			
			btnAndar6.setBackground(Color.LIGHT_GRAY);
			btnAndar6.setEnabled(true);
		}
	}
	
	public void setLabels()
	{
		lblAndarAtual.setText(andarAtual + "");
		lblQtdePassageiros.setText(qtdePassageiros + "");
		lblStatusElevador.setText(estadoElevador + "");
		lblStatusPorta.setText(estadoPorta + "");
	}
	
	public void setDados(ElevadorFactory elevador)
	{
		this.andarAtual = elevador.getAndarAtual();
		this.qtdePassageiros = elevador.getQtdePessoas();
		this.estadoElevador = elevador.getEstadoElevador();
		this.estadoPorta = elevador.getEstadorPorta();
		
		setLabels();
				
		verificaAndar();
	}
	

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnSair)
		{
			System.exit(0);
		}
		
		else if(e.getSource() == btnAndar0)
		{
			acionados[0] = "x";
			btnAndar0.setBackground(Color.orange);
			btnAndar0.setEnabled(false);
		}
		
		else if(e.getSource() == btnAndar1)
		{
			acionados[1] = "x";
			btnAndar1.setBackground(Color.orange);
			btnAndar1.setEnabled(false);
		}
		
		else if(e.getSource() == btnAndar2)
		{
			acionados[2] = "x";
			btnAndar2.setBackground(Color.orange);
			btnAndar2.setEnabled(false);
		}
		
		else if(e.getSource() == btnAndar3)
		{
			acionados[3] = "x";
			btnAndar3.setBackground(Color.orange);
			btnAndar3.setEnabled(false);
		}
		
		else if(e.getSource() == btnAndar4)
		{
			acionados[4] = "x";
			btnAndar4.setBackground(Color.orange);
			btnAndar4.setEnabled(false);
		}
		
		else if(e.getSource() == btnAndar5)
		{
			acionados[5] = "x";
			btnAndar5.setBackground(Color.orange);
			btnAndar5.setEnabled(false);
		}
		
		else if(e.getSource() == btnAndar6)
		{
			acionados[6] = "x";
			btnAndar6.setBackground(Color.orange);
			btnAndar6.setEnabled(false);
		}
	}
}
