import javax.swing.JOptionPane;

public class Movimenta implements Runnable{

	private String[] rota = {"9","9","9","9","9","9","9"}; //CONTROLA O ANDAR DE DESTINO DO PASSAGEIRO (VALOR 9 COMO DEFAULT)

	private String[] andares = {"0","1","2","3","4","5","6"}; //TODOS OS ANDARES
	
	private ElevadorFactory elevador;
	
	private String[] passageiros = {"1","2","3","4","5","6","7","8"}; //A SER UTILIZADO PELO COMBOBOX DE SELEÇÃO DA QUANTIDADE DE PASSAGEIROS
	
	private int[] embarcados = {0, 0, 0, 0, 0, 0, 0, 0}; //MANTÉM A QUANTIDADE DE PASSAGEIROS EM DESTINO A DETERMINADO ANDAR
	
	View view;
	
	public void run()
	{
		elevador = new ElevadorFactory();
		
		view = new View();
		
		String pessoas = "0";
		
		while(true)
		{		
			//ELEVADOR SOBE
			
			for(int i=0; i<7;i++)
			{
				//SETA TODOS STATUS DO ELEVADOR
				elevador.setAndarAtual(i);
		
				elevador.setEstadoElevador(EstadoElevador.Subindo);
				elevador.setEstadoPorta(EstadoPorta.Fechada);
				view.setDados(elevador);
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				
				//SE O ANDAR ATUAL ESTIVER SIDO ACIONADO
				if(view.acionados[i].equals("x"))
				{
					//SETA TODOS STATUS DO ELEVADOR
					elevador.setEstadoElevador(EstadoElevador.Parado);
					elevador.setEstadoPorta(EstadoPorta.Aberta);
					view.setDados(elevador);
					
					rota[i] = JOptionPane.showInputDialog(null,"Passageiro entrou no elevador e escolherá o andar:", "Seleção do andar de destino", JOptionPane.PLAIN_MESSAGE, null, andares, "0").toString();
					view.acionados[i] = "";
					
					pessoas = JOptionPane.showInputDialog(null,"Quantidade de passageiros que entraram no elevador:", "Seleção da quantidade de pessoas embarcadas", JOptionPane.PLAIN_MESSAGE, null, passageiros, passageiros[0]).toString();
					elevador.sobePessoas(Integer.parseInt(pessoas));
					embarcados[Integer.parseInt(rota[i])] = Integer.parseInt(pessoas);
					
					controlePassageiros(elevador.getQtdePessoas());
					view.setDados(elevador);
					
					elevador.setEstadoElevador(EstadoElevador.Subindo);
					elevador.setEstadoPorta(EstadoPorta.Fechada);
					view.setDados(elevador);
				}
				
				for(int x=0; x<7; x++)
				{
					//SE O ANDAR ATUAL ESTIVER SIDO SELECIONADO PARA DESEMBARQUE
					if (i == Integer.parseInt(rota[x]))
					{
						elevador.setEstadoElevador(EstadoElevador.Parado);
						elevador.setEstadoPorta(EstadoPorta.Aberta);
						view.setDados(elevador);
						
						JOptionPane.showMessageDialog(null, "Porta abriu," + embarcados[i] + " passageiro(s) desceu/desceram no " + i + "º andar!");
						rota[x] = "9";
						
						elevador.descePessoas(embarcados[i]);
						embarcados[i] = 0;
						
						controlePassageiros(elevador.getQtdePessoas());
						
						elevador.setEstadoElevador(EstadoElevador.Subindo);
						elevador.setEstadoPorta(EstadoPorta.Fechada);
						view.setDados(elevador);
					}
				}
			}
			
			//ELEVADOR DESCE
			for(int i=5; i>=1;i--)
			{
				elevador.setAndarAtual(i);

				elevador.setEstadoElevador(EstadoElevador.Descendo);
				elevador.setEstadoPorta(EstadoPorta.Fechada);
				view.setDados(elevador);
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				
				if(view.acionados[i].equals("x"))
				{
					elevador.setEstadoElevador(EstadoElevador.Parado);
					elevador.setEstadoPorta(EstadoPorta.Aberta);
					view.setDados(elevador);
					
					rota[i] = JOptionPane.showInputDialog(null,"Passageiro entrou no elevador e escolherá o andar:", "Seleção", JOptionPane.PLAIN_MESSAGE, null, andares, "0").toString();
					view.acionados[i] = "";
					
					pessoas = JOptionPane.showInputDialog(null,"Quantidade de passageiros que entraram no elevador:", "Seleção da quantidade de pessoas embarcadas", JOptionPane.PLAIN_MESSAGE, null, passageiros, passageiros[0]).toString();
					elevador.sobePessoas(Integer.parseInt(pessoas));
					embarcados[Integer.parseInt(rota[i])] = Integer.parseInt(pessoas);
					
					controlePassageiros(elevador.getQtdePessoas());
					view.setDados(elevador);
					
					elevador.setEstadoElevador(EstadoElevador.Descendo);
					elevador.setEstadoPorta(EstadoPorta.Fechada);
					view.setDados(elevador);
				}
				
				for(int x=6; x>=0; x--)
				{
					if (i == Integer.parseInt(rota[x]))
					{
						
						elevador.setEstadoElevador(EstadoElevador.Parado);
						elevador.setEstadoPorta(EstadoPorta.Aberta);
						view.setDados(elevador);
						
						JOptionPane.showMessageDialog(null, "Porta abriu," + embarcados[i] + " passageiro(s) desceu/desceram no " + i + "º andar!");
						rota[x] = "9";
						
						elevador.descePessoas(embarcados[i]);
						embarcados[i] = 0;
						
						controlePassageiros(elevador.getQtdePessoas());
						
						elevador.setEstadoElevador(EstadoElevador.Descendo);
						elevador.setEstadoPorta(EstadoPorta.Fechada);
						view.setDados(elevador);
					}
				}
			}
		}
	}
	
	//CONTROLA O COMBOBOX PARA SELEÇÃO DA QUANTIDADE DE PASSAGEIROS A EMBARCAREM NO ELEVADOR
	public void controlePassageiros(int atual)
	{
		Integer valor = 1;
		int cheio = 7;
		int capacidadeRestante = cheio - atual;
		passageiros = new String[8];

		for(int i=0; i<=capacidadeRestante; i++)
		{
			passageiros[i] = valor.toString();
			valor++;
		}
	}
}
