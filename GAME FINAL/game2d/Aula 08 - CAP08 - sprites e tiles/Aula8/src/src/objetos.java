import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;


import javax.swing.ImageIcon;

public class objetos
    {
    private int posX, posY;
    private int largura = 48, altura = 48;
    private Image imagemObjeto;
    public String nomeObj;
    String cenario;
    boolean visivel;
    ImageIcon icon;
    String caminho = "";
    Rectangle areaSolida;
    
    

    public objetos (int x, int y, String nome, String cena)//constructor
    {

        this.posX = x;
        this.posY = y;
        this.nomeObj = nome;
        this.visivel = true;
        this.cenario = cena; 
        this.areaSolida = new Rectangle(); 
        this.areaSolida.x = this.posX + 10;
        this.areaSolida.y = this.posY + 12;
        this.areaSolida.width = this.largura - 17;
        this.areaSolida.height = this.altura - 25;

        if (this.nomeObj == "chave")
            caminho = "res/objetos/" + this.nomeObj + ".png";
        else if (this.nomeObj == "moeda")
            caminho = "res/objetos/" + this.nomeObj + ".png";
        else {
            caminho = "res/objetos/beer.png";
        }
        icon = new ImageIcon (caminho);
        this.imagemObjeto = icon.getImage();    
    }
    public void desenhar(Graphics2D desenho) 
    {
        if(this.visivel == true){
           // desenho.fillRect( this.areaSolida.x, 
            //this.areaSolida.y, 
            //this.areaSolida.width, 
            //this.areaSolida.height);
            desenho.drawImage(imagemObjeto, this.posX, this.posY, this.largura, this.altura,null);  
        }
    }     
}
