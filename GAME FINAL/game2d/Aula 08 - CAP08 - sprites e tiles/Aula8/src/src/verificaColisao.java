import java.awt.Rectangle;

public class verificaColisao {

    int colEsqX, colDirX,rowTopoY,rowBaseY;
    boolean colisaoOcorreu;
    
    public boolean verificaColisao(tileMap cenaDoJogo,player jogador,String direcao){
        colisaoOcorreu = false;

        int bordaEsqX = jogador.areaSolida.x;
        int bordaDirX = jogador.areaSolida.x + (int)jogador.areaSolida.getWidth();
        int bordaTopoY = jogador.areaSolida.y;
        int bordaBaseY = jogador.areaSolida.y + (int)jogador.areaSolida.getWidth();

        this.colEsqX = bordaEsqX/48;
        this.colDirX =bordaDirX/48;
        this.rowTopoY = bordaTopoY/48;
        this.rowBaseY = bordaBaseY/48;

        if(direcao == "cima"){ // mudança de cenario ok
            int prox_rowTopoY = (bordaTopoY - jogador.velocidade)/48;
            if(jogador.areaSolida.y < 0){
                if (cenaDoJogo.getcenaValida() == "BE")
                    cenaDoJogo.setcenaValida("TE");
                else
                    cenaDoJogo.setcenaValida("BE");
                int altura = cenaDoJogo.cenarioValido.length *48;
                jogador.posY = altura -(int)jogador.areaSolida.getHeight();     
            }else{
                cenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(cenaDoJogo.cenarioValido[prox_rowTopoY][colEsqX]);
                if(cenaDoJogo.pecaDoCenario.isColisao()){
                    this.colisaoOcorreu = true;
                }
                cenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(cenaDoJogo.cenarioValido[prox_rowTopoY][colDirX]);
                if(cenaDoJogo.pecaDoCenario.isColisao()){
                    this.colisaoOcorreu = true;
                }
            }
        }else if(direcao == "direita"){// mudança de cenario ok
            int prox_colDirX = (bordaDirX - jogador.velocidade)/48;
            //System.out.println((jogador.areaSolida.x)/48);
            //System.out.println(cenaDoJogo.cenarioValido[0].length);
            if((jogador.areaSolida.x / 48) >= (cenaDoJogo.cenarioValido[0].length-1)){
                if(cenaDoJogo.getcenaValida() == "TE"){
                    cenaDoJogo.setcenaValida("TD");
                }else{
                    cenaDoJogo.setcenaValida("BD");
                }
                jogador.setPosX((int)jogador.areaSolida.getWidth()); 
            }else{
                cenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(cenaDoJogo.cenarioValido[rowBaseY][prox_colDirX]);
                if(cenaDoJogo.pecaDoCenario.isColisao()){
                    this.colisaoOcorreu = true;
                }
                cenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(cenaDoJogo.cenarioValido[rowTopoY][prox_colDirX]);
                if(cenaDoJogo.pecaDoCenario.isColisao()){
                    this.colisaoOcorreu = true;
                }
            }
            
        }else if(direcao == "baixo"){ // mudança de cenario ok
            int prox_rowBaseY = (bordaBaseY - jogador.velocidade)/48;
            if(prox_rowBaseY < cenaDoJogo.cenarioValido.length){
                cenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(cenaDoJogo.cenarioValido[prox_rowBaseY][colEsqX]);
                if(cenaDoJogo.pecaDoCenario.isColisao()){
                    this.colisaoOcorreu = true;
                }
                cenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(cenaDoJogo.cenarioValido[prox_rowBaseY][colDirX]);
                if(cenaDoJogo.pecaDoCenario.isColisao()){
                    this.colisaoOcorreu = true;
                }
            }else
            {
                if(cenaDoJogo.getcenaValida() == "TE"){
                    cenaDoJogo.setcenaValida("BE");
                    jogador.setPosY(-(int)jogador.areaSolida.getHeight()); 
                }          
            }

        }else if(direcao == "esquerda"){ // mudança de cenario ok
            int prox_cowEsqX = (bordaEsqX - jogador.velocidade)/48;
            if(jogador.areaSolida.x < 0){
                if(cenaDoJogo.getcenaValida() == "TD"){
                    cenaDoJogo.setcenaValida("TE");
                }else{
                    cenaDoJogo.setcenaValida("BE");
                }
                int largDoCenario = cenaDoJogo.cenarioValido.length * 75; 
                jogador.setPosX(largDoCenario); 
            }else{
                cenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(cenaDoJogo.cenarioValido[rowBaseY][prox_cowEsqX]);
                if(cenaDoJogo.pecaDoCenario.isColisao()){
                    this.colisaoOcorreu = true;
                }
                cenaDoJogo.pecaDoCenario.carregaPecaDaMatriz(cenaDoJogo.cenarioValido[rowTopoY][prox_cowEsqX]);
                if(cenaDoJogo.pecaDoCenario.isColisao()){
                    this.colisaoOcorreu = true;
                }
            }
        }
        //System.out.println("colEsqx: "+ colEsqX);
        //System.out.println("colDirX: "+ colDirX);
        //System.out.println("rowTopoY: "+ rowTopoY);
        //System.out.println("rowBasY: "+ rowBaseY);
        //System.out.println("=======================" );
        return colisaoOcorreu;


    }


    public boolean verificaColisao(Rectangle Sprite1, Rectangle Sprite2){
        
        if(Sprite1.intersects(Sprite2)){
            return true;
        }else{
            return false;
        }
    }

}