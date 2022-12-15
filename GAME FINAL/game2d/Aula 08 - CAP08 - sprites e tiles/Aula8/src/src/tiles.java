import java.awt.Image;

import javax.swing.ImageIcon;

import java.awt.Graphics2D;

public class tiles {

	private final int largura = 48,altura = 48;
    private int posX,posY;
    private Image imgAtual;
    private Image imgGrass, imgSand, imgWall, imgWater, imgBeer, 
	imgMuroVerde, imgFire,imgCastle1,imgCastle2,imgCastle3,imgCastle4,imgWater2,
	imgWater3,imgSand2,imgSnow1,imgSnow2,imgSnow3;
    private Image imgWhite, imgGray;
	private boolean colisao;

    tiles(){
        this.carregarImagensTiles();

    }        

    public void desenhar(Graphics2D desenho, int linha, int coluna){
       this.posX = coluna * this.largura;
       this.posY = linha * this.altura;
    desenho.drawImage(this.imgAtual, this.posX, this.posY, this.largura, this.altura, null);
    }
    private void carregarImagensTiles() {
    	ImageIcon Icon;
    	Icon = new ImageIcon ("res/tiles/grass1.png");
    	this.imgGrass = Icon.getImage();
    	Icon = new ImageIcon ("res/tiles/sand1.png");
    	this.imgSand = Icon.getImage();
    	Icon = new ImageIcon ("res/tiles/water1.png");
    	this.imgWater = Icon.getImage();
    	Icon = new ImageIcon ("res/tiles/wall1.png");
    	this.imgWall = Icon.getImage();
    	Icon = new ImageIcon ("res/tiles/white.png");
    	this.imgWhite = Icon.getImage();
    	Icon = new ImageIcon ("res/tiles/gray.png");
    	this.imgGray = Icon.getImage();
		Icon = new ImageIcon("res/tiles/beer.png");
		this.imgBeer = Icon.getImage();
		Icon = new ImageIcon("res/tiles/muro_verde.png");
		this.imgMuroVerde = Icon.getImage();
		Icon = new ImageIcon("res/tiles/fire.png");
		this.imgFire = Icon.getImage();

		Icon = new ImageIcon("res/tiles/castle1.png");
		this.imgCastle1 = Icon.getImage();
		Icon = new ImageIcon("res/tiles/castle2.png");
		this.imgCastle2 = Icon.getImage();
		Icon = new ImageIcon("res/tiles/castle3.png");
		this.imgCastle3 = Icon.getImage();
		Icon = new ImageIcon("res/tiles/castle4.png");
		this.imgCastle4 = Icon.getImage();
		Icon = new ImageIcon("res/tiles/water2.png");
		this.imgWater2 = Icon.getImage();
		Icon = new ImageIcon("res/tiles/water3.png");
		this.imgWater3 = Icon.getImage();
		Icon = new ImageIcon("res/tiles/sand2.png");
		this.imgSand2 = Icon.getImage();
		Icon = new ImageIcon("res/tiles/snow1.png");
		this.imgSnow1 = Icon.getImage();
		Icon = new ImageIcon("res/tiles/snow2.png");
		this.imgSnow2 = Icon.getImage();
		Icon = new ImageIcon("res/tiles/snow3.png");
		this.imgSnow3 = Icon.getImage();
    }
    public void carregaPecaDaMatriz(int valorDaPeca) {
    	if(valorDaPeca == 0){ 
			this.imgAtual = this.imgWall;
			this.colisao = true;
		}
    	if(valorDaPeca == 1){
			this.imgAtual = this.imgSand;
			this.colisao = false;
		}
		if(valorDaPeca == 2){ 
			this.imgAtual = this.imgWater;
			this.colisao = true;
		}
    	if(valorDaPeca == 3){
			this.imgAtual = this.imgGrass;
			this.colisao = false;
		}
    	
		if(valorDaPeca == 4){ 
			this.imgAtual = this.imgWhite;
			this.colisao = true;
		}
		if(valorDaPeca == 5){ 
			this.imgAtual = this.imgGray;
			this.colisao = false;
		}
		if (valorDaPeca == 6){
			this.imgAtual = this.imgBeer;
			this.colisao = false;
		}

		if (valorDaPeca == 7){
			this.imgAtual = this.imgMuroVerde;
			this.colisao = true;
		}

		if (valorDaPeca == 8){
			this.imgAtual = this.imgFire;
			this.colisao = true;
		}
		if (valorDaPeca == 9){
			this.imgAtual = this.imgCastle1;
			this.colisao = true;
		}
		if (valorDaPeca == 10){
			this.imgAtual = this.imgCastle2;
			this.colisao = true;
		}
		if (valorDaPeca == 11){
			this.imgAtual = this.imgCastle3;
			this.colisao = true;
		}
		if (valorDaPeca == 12){
			this.imgAtual = this.imgCastle4;
			this.colisao = true;
		}
		if (valorDaPeca == 13){
			this.imgAtual = this.imgWater2;
			this.colisao = true;
		}
		if (valorDaPeca == 14){
			this.imgAtual = this.imgWater3;
			this.colisao = true;
		}
		if (valorDaPeca == 15){
			this.imgAtual = this.imgSand2;
			this.colisao = false;
		}
		if (valorDaPeca == 16){
			this.imgAtual = this.imgSnow1;
			this.colisao = true;
		}
		if (valorDaPeca == 17){
			this.imgAtual = this.imgSnow2;
			this.colisao = true;
		}
		if (valorDaPeca == 18){
			this.imgAtual = this.imgSnow3;
			this.colisao = false;
		}
	
    }
	public boolean isColisao(){
		return colisao;
	}
	public void serColisao(boolean colisao){
		this.colisao = colisao;
	}

    
}
