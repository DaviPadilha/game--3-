import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Color;
public class porta {

    private int posX, posY;
    private int largura = 48, altura = 48;
    private Image imagemNpc;
    String cenario;
    boolean visivel;
    ImageIcon icon;
    String caminho = "";
    Rectangle areaSolida;

    public porta (int x, int y, String cena)//constructor
    {
        this.posX = x;
        this.posY = y;
        this.visivel = true;
        this.cenario = cena; 
        this.areaSolida = new Rectangle(); 
        this.areaSolida.x = this.posX + 0;
        this.areaSolida.y = this.posY + 0;
        this.areaSolida.width = this.largura - 0;
        this.areaSolida.height = this.altura - 0;
        icon = new ImageIcon ("res/porta/porta.png");
        this.imagemNpc = icon.getImage();    
    }
    public void desenhar(Graphics2D desenho) 
    {
        if(this.visivel == true){
            desenho.setColor(Color.black);
            desenho.fillRect( this.areaSolida.x, 
            this.areaSolida.y, 
            this.areaSolida.width, 
            this.areaSolida.height);
            desenho.drawImage(imagemNpc, this.posX, this.posY, this.largura, this.altura,null);  
        }
    }     
}
