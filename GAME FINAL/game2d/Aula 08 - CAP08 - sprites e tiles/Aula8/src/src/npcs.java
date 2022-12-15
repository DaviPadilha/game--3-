import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class npcs {


    private int posX, posY;
    private int largura = 48, altura = 48;
    private Image imagemNpc;
    String cenario;
    boolean visivel;
    ImageIcon icon;
    String caminho = "";
    Rectangle areaSolida;

    public npcs (int x, int y, String cena)//constructor
    {

        this.posX = x;
        this.posY = y;
        this.visivel = true;
        this.cenario = cena; 
        this.areaSolida = new Rectangle(); 
        this.areaSolida.x = this.posX + 10;
        this.areaSolida.y = this.posY + 12;
        this.areaSolida.width = this.largura - 17;
        this.areaSolida.height = this.altura - 25;

        icon = new ImageIcon ("res/npc/npc1.png");
        this.imagemNpc = icon.getImage();    
    }
    public void desenhar(Graphics2D desenho) 
    {
        if(this.visivel == true){
            //desenho.setColor(Color.black);
            //desenho.fillOval(this.areaSolida.x, this.areaSolida.y, this.areaSolida.width, this.areaSolida.height);
           // desenho.fillRect( this.areaSolida.x, 
            //this.areaSolida.y, 
            //this.areaSolida.width, 
            //this.areaSolida.height);
            desenho.drawImage(imagemNpc, this.posX, this.posY, this.largura, this.altura,null);  
        }
    }     
}

    

