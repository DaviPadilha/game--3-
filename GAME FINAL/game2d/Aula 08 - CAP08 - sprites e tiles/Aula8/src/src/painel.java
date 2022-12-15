import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class painel extends JPanel {

	private String Id_posicao;    
    player player1 = new player(100,100,50,50,Color.white,2);
    tiles tile;
    tileMap cenario;
	gameLoop loopDoJogo;
	escutadorTeclado escutaTecl; 
	spriteloop loopDoSprite; 
	objetos [] obj;
	npcs prisioneiro;
	porta porta;


	painel(String posicao){
		this.Id_posicao = posicao; 
		switch(Id_posicao) {
		case "centro":
			this.setBackground(Color.black);
			this.setPreferredSize(new Dimension(769,480));
			this.setFocusable(true);
			this.obj = new objetos [3];
			this.obj [0] = new objetos (500, 200, "chave", "TE");
			this.obj [1] = new objetos(670, 190, "moeda", "BD");
			this.obj [2] = new objetos(50, 235, "", "TD");
			this.prisioneiro = new npcs(100, 280, "BE");
			this.porta = new porta(720, 49, "TE");
			escutaTecl = new escutadorTeclado();
			this.addKeyListener(escutaTecl);
			this.setFocusable(true);
			this.cenario = new tileMap();
            loopDoJogo = new gameLoop(this,escutaTecl);
            loopDoJogo.start();
			loopDoSprite = new spriteloop(this, escutaTecl);
			loopDoSprite.start();
			break;
		}
	}
    public void paintComponent(Graphics desenho) {
		Graphics2D desenho2d = (Graphics2D) desenho; 		
		desenho.setColor(this.getBackground());
		desenho.fillRect(0, 0,this.getWidth(), this.getHeight());
		if(Id_posicao == "centro") {
			this.cenario.desenhar(desenho2d);//desenhar o cenario
			player1.desenhar(desenho2d);//player
			
			
			if (this.cenario.getcenaValida() == "TE")
			{	
				for (int i = 0; i < this.obj.length; i++)
				{
					if (obj[i].cenario == "TE")
						obj[i].desenhar(desenho2d);
					if(porta.cenario == "TE")
						porta.desenhar(desenho2d);
				}
			}
			else if (this.cenario.getcenaValida() == "BD")
			{	
				for (int i = 0; i < this.obj.length; i++)
				{
					if (obj[i].cenario == "BD")
						obj[i].desenhar(desenho2d);
				}
			}	
			else if (this.cenario.getcenaValida() == "TD")
			{	
				for (int i = 0; i < this.obj.length; i++)
				{
					if (obj[i].cenario == "TD")
						obj[i].desenhar(desenho2d);
				}
			}	
			else if (this.cenario.getcenaValida() == "BE")
			{	
				for (int i = 0; i < this.obj.length; i++)
				{
					if (obj[i].cenario == "BE")
						obj[i].desenhar(desenho2d);
					if(prisioneiro.cenario == "BE"){
						prisioneiro.desenhar(desenho2d);
					}
				}
			}		
		}
    }
}

