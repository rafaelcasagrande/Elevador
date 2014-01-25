
public class ElevadorFactory {

	private EstadoElevador estadoElevador;
	private EstadoPorta estadoPorta;
	private int qtdePessoas = 0;
	private int andarAtual = 0;
	
	public void setAndarAtual(int andarAtual)
	{
		this.andarAtual = andarAtual;
	}
	
	public int getAndarAtual()
	{
		return andarAtual;
	}
	
	public void setEstadoElevador(EstadoElevador estadoElevador)
	{
		this.estadoElevador = estadoElevador;
	}
	
	public EstadoElevador getEstadoElevador()
	{
		return estadoElevador;
	}
	
	public void setEstadoPorta (EstadoPorta estadoPorta)
	{
		this.estadoPorta = estadoPorta;
	}
	
	public EstadoPorta getEstadorPorta()
	{
		return estadoPorta;
	}
	
	public void sobePessoas(int qtdePessoas)
	{
		this.qtdePessoas = this.qtdePessoas + qtdePessoas;
	}
	
	public void descePessoas(int qtdePessoas)
	{
		this.qtdePessoas = this.qtdePessoas - qtdePessoas;
	}
	
	public int getQtdePessoas()
	{
		return qtdePessoas;
	}
	
	public void setQtdePessoas(int qtdePessoas)
	{
		this.qtdePessoas = qtdePessoas;
	}
}
