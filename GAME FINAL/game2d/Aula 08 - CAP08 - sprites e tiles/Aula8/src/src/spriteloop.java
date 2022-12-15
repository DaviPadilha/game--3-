
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class spriteloop extends Thread implements Runnable, ActionListener {

    
	int FPS = 10;
	Timer ControleDoTempoDoJogo;
	long contadorDeFPS;
	private painel cenaDoJogo;
	escutadorTeclado escutaTecl;
	
	spriteloop(painel P,escutadorTeclado eT){
		
		System.out.println("Sprite instanciado");
		this.cenaDoJogo = P;
		this.escutaTecl = eT;
		
	}
	
	@Override
	public void run() {
		
		this.contadorDeFPS = 0;
		this.ControleDoTempoDoJogo = new Timer(1000,this);
		this.ControleDoTempoDoJogo.start();
		
		double frameRate = 1000000000/this.FPS;
		double tempoDecorrido = 0;
		long tempoUltimaMedidaDoLoop = System.nanoTime();
		long tempoAtualDoLoop;
		
		while (this.isAlive()) {
			tempoAtualDoLoop = System.nanoTime();
			tempoDecorrido = tempoDecorrido + (tempoAtualDoLoop - tempoUltimaMedidaDoLoop)/frameRate;
			tempoUltimaMedidaDoLoop = tempoAtualDoLoop;
			
			if(tempoDecorrido >=1) {
				
				cenaDoJogo.player1.atualizaSprite(escutaTecl.movePraEsq,escutaTecl.movePraCima,
												escutaTecl.movePraDir,escutaTecl.movePraBaixo);
				//System.out.println("o loop est� ativo!!");
				this.contadorDeFPS++;
				tempoDecorrido = 0;
				
			}
			
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("FPS Sprite calculado: " + this.contadorDeFPS);
		this.contadorDeFPS = 0;
		
	}

}
