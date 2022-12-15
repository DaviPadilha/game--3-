    
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;


import javax.swing.ImageIcon;

public class player {
	int posY;
    private int posX;
    private int largura;
    private int altura;
    private int espessuraBorda;
	private Color corDaBorda;
	escutadorTeclado escutaTecl;
	Image imagemD1,imagemR1,imagemL1,imagemU1,imagemD2,imagemR2,imagemL2,imagemU2,imagemD3,imagemR3,imagemL3,imagemU3;
	Image imagemPlayer;
	Rectangle areaSolida;
	int velocidade = 3; 
	inventario [] inventarioJogador;	
    
	player(int pX,int pY,int larg, int alt,Color CDB,int EDB){
		ImageIcon icon;

		this.posX = pX;
		this.posY = pY;
		this.largura = larg;
		this.altura = alt;
		this.corDaBorda = CDB;
		this.espessuraBorda = EDB;
		icon = new ImageIcon("res/down1.png");
		this.imagemPlayer = icon.getImage();
		icon = new ImageIcon("res/down1.png");
		this.imagemD1 = icon.getImage();
		icon = new ImageIcon("res/left1.png");
		this.imagemL1 = icon.getImage();
		icon = new ImageIcon("res/right1.png");
		this.imagemR1 = icon.getImage();
		icon = new ImageIcon("res/up1.png");
		this.imagemU1 = icon.getImage();
		icon = new ImageIcon("res/down2.png");
		this.imagemD2 = icon.getImage();
		icon = new ImageIcon("res/left2.png");
		this.imagemL2 = icon.getImage();
		icon = new ImageIcon("res/right2.png");
		this.imagemR2 = icon.getImage();
		icon = new ImageIcon("res/up2.png");
		this.imagemU2 = icon.getImage();
		icon = new ImageIcon("res/down3.png");
		this.imagemD3 = icon.getImage();
		icon = new ImageIcon("res/left3.png");
		this.imagemL3 = icon.getImage();
		icon = new ImageIcon("res/right3.png");
		this.imagemR3 = icon.getImage();
		icon = new ImageIcon("res/up3.png");
		this.imagemU3 = icon.getImage();	
		defineValoresAreaSolidaJogador();	
	}
	private void defineValoresAreaSolidaJogador(){

		this.areaSolida = new Rectangle();
		this.areaSolida.x = this.posX + 7;
		this.areaSolida.y = this.posY + this.altura / 2;
		this.areaSolida.width = this.largura - 20;
		this.areaSolida.height = this.altura /2;

		//inicia array de inventario com 2 posiçoes
		inventarioJogador = new inventario [2];
		//instancia a primeira posaicao como chave e o sgundo como moeda
		inventarioJogador[0] = new inventario("chave");
		inventarioJogador[1] = new inventario("moeda");
	}

	public void capturaObjeto (String nome)
	{
		for (int i = 0;i < inventarioJogador.length; i++)
		{
			if (this.inventarioJogador[i].nomeObjeto == nome)
			{
				this.inventarioJogador [i].qtdeObjeto++;
				break;
			}
		}
	}
	public void removeObjeto(String nome){
		for (int i = 0;i < inventarioJogador.length; i++)
		{
			if (this.inventarioJogador[i].nomeObjeto == nome)
			{
				this.inventarioJogador [i].qtdeObjeto--;
				break;
			}
		}
	}

	public void atualizaPosicao(boolean moveEsq,boolean moveCima,boolean moveDir,boolean moveBaixo) {
		if(moveEsq) {
			this.posX = this.posX - this.velocidade;
		}
		else if(moveDir) {
			this.posX = this.posX + this.velocidade;
		}
		else if(moveCima) {
			this.posY = this.posY - this.velocidade;
		}
		else if(moveBaixo) {
			this.posY = this.posY + this.velocidade;
		}
		this.areaSolida.x = this.posX + 7;
		this.areaSolida.y = this.posY + this.altura / 2;
		//System.out.println("posX = " +(int) this.posX/this.largura);
		//System.out.println("posY = " + this.posY/this.altura);
	}
	
	public void atualizaSprite(boolean moveEsq,boolean moveCima,boolean moveDir,boolean moveBaixo) {
		if(moveEsq) {
			if(this.imagemPlayer == this.imagemL1) {
				this.imagemPlayer = this.imagemL2;
			}else if(this.imagemPlayer == this.imagemL2) {
				this.imagemPlayer = this.imagemL3;
			}else {
				this.imagemPlayer=this.imagemL1;
			}
		}
	
		if(moveDir) {
			if(this.imagemPlayer == this.imagemR1) {
				this.imagemPlayer = this.imagemR2;
			}else if(this.imagemPlayer == this.imagemR2) {
				this.imagemPlayer = this.imagemR3;
			}else {
				this.imagemPlayer=this.imagemR1;
			}
		}
		if(moveCima) {
			if(this.imagemPlayer == this.imagemU1) {
				this.imagemPlayer = this.imagemU2;
			}else if(this.imagemPlayer == this.imagemU2) {
				this.imagemPlayer = this.imagemU3;
			}else {
				this.imagemPlayer=this.imagemU1;
			}
		}
		if(moveBaixo) {
			if(this.imagemPlayer == this.imagemD1) {
				this.imagemPlayer = this.imagemD2;
			}else if(this.imagemPlayer == this.imagemD2) {
				this.imagemPlayer = this.imagemD3;
			}else {
				this.imagemPlayer=this.imagemD1;
			}
		}
	}
	
	public void desenhar(Graphics2D desenho) {
		desenho.setColor(Color.black);
		desenho.fillOval(this.areaSolida.x, this.areaSolida.y, this.areaSolida.width, this.areaSolida.height);
		desenho.setStroke(new BasicStroke(this.espessuraBorda));
		desenho.setColor(this.corDaBorda);
		desenho.drawImage(imagemPlayer,this.posX, this.posY, this.largura, this.altura,null);
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getEspessuraBorda() {
		return espessuraBorda;
	}
	public void setEspessuraBorda(int espessuraBorda) {
		this.espessuraBorda = espessuraBorda;
	}
}
    
