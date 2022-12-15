import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class gameLoop extends Thread implements Runnable, ActionListener {

    int FPS = 60;
    Timer controleDoTempoDoJogo;
    long contadorDeFPS;
    private escutadorTeclado escutaTecl;
    private painel cenaDoJogo;
    verificaColisao colisao = new verificaColisao();

    gameLoop(painel cenaDoJogo,escutadorTeclado eT){
       // System.out.println("Gameloop instanciado");
        this.escutaTecl = eT;
        this.cenaDoJogo = cenaDoJogo;
    }

    @Override
    public void run() {
        this.contadorDeFPS = 0;
        this.controleDoTempoDoJogo = new Timer(1000,this);
        this.controleDoTempoDoJogo.start();
            double frameRate = 1000000000/FPS;
            double tempoDecorrido = 0;
            long tempoUltimaMedidaDoLoop = System.nanoTime();
            long tempoAtualDoLoop;

        while(this.isAlive()){
            tempoAtualDoLoop = System.nanoTime();
            tempoDecorrido = tempoDecorrido + (tempoAtualDoLoop - tempoUltimaMedidaDoLoop)/frameRate;
            tempoUltimaMedidaDoLoop = tempoAtualDoLoop;
            if(tempoDecorrido >=1){
                String direcao = "cima";
                if(escutaTecl.movePraCima) direcao = "cima";
                if(escutaTecl.movePraBaixo) direcao = "baixo";
                if(escutaTecl.movePraDir) direcao = "direita";
                if(escutaTecl.movePraEsq) direcao = "esquerda";

                boolean bateu = colisao.verificaColisao(this.cenaDoJogo.cenario,this.cenaDoJogo.player1,direcao);
                boolean bateuPorta = colisao.verificaColisao(this.cenaDoJogo.porta.areaSolida,this.cenaDoJogo.player1.areaSolida);
                boolean visibilidadePorta = this.cenaDoJogo.porta.visivel;
                if(bateu == false){
                    if(bateuPorta == true && visibilidadePorta == true){
                        cenaDoJogo.player1.atualizaPosicao(escutaTecl.movePraEsq,escutaTecl.movePraCima,
                        false,escutaTecl.movePraBaixo);  
                    }else{
                        cenaDoJogo.player1.atualizaPosicao(escutaTecl.movePraEsq,escutaTecl.movePraCima,
                        escutaTecl.movePraDir,escutaTecl.movePraBaixo);  
                    }
                    for (int num_obj = 0; num_obj < this.cenaDoJogo.obj.length; num_obj++)

                {
                    if (this.cenaDoJogo.obj[num_obj].visivel)
                    {
                        if(this.cenaDoJogo.obj[num_obj].cenario == this.cenaDoJogo.cenario.getcenaValida())
                        {
                            boolean bateuEmObj = colisao.verificaColisao(this.cenaDoJogo.player1.areaSolida, this.cenaDoJogo.obj[num_obj].areaSolida);
                            if(bateuEmObj == true)
                            {
                                this.cenaDoJogo.obj[num_obj].visivel = false;
                                this.cenaDoJogo.player1.capturaObjeto(this.cenaDoJogo.obj[num_obj].nomeObj);
                                System.out.println("numero de chaves:" + this.cenaDoJogo.player1.inventarioJogador[0].qtdeObjeto);
                                System.out.println("numero de moedas:" + this.cenaDoJogo.player1.inventarioJogador[1].qtdeObjeto);
                                if(this.cenaDoJogo.obj[num_obj].nomeObj == ""){
                                    System.out.println("Fim do jogo, você está bebado!!");
                                    System.exit(0); 
                                }

                            }
                        }        
                    }
                    if(this.cenaDoJogo.prisioneiro.visivel){
                        if(this.cenaDoJogo.prisioneiro.cenario == this.cenaDoJogo.cenario.getcenaValida()){

                            boolean bateuNpc = colisao.verificaColisao(this.cenaDoJogo.player1.areaSolida, this.cenaDoJogo.prisioneiro.areaSolida);
                            if(bateuNpc== true)
                            {
                                if(this.cenaDoJogo.player1.inventarioJogador[1].qtdeObjeto == 0){
                                    System.out.println("Eu tenho uma chave, mas gostaria de dinheiro em troca dela!!");
                                    System.out.println("Retorne quando tiver dinheiro");
                                }else{
                                    System.out.println("Tome sua chave!!");
                                    System.out.println("Vou dar o fora daqui!! Adeus");
                                    this.cenaDoJogo.player1.removeObjeto(this.cenaDoJogo.obj[1].nomeObj);
                                    this.cenaDoJogo.player1.capturaObjeto(this.cenaDoJogo.obj[0].nomeObj);
                                    System.out.println("numero de chaves:" + this.cenaDoJogo.player1.inventarioJogador[0].qtdeObjeto);
                                    System.out.println("numero de moedas:" + this.cenaDoJogo.player1.inventarioJogador[1].qtdeObjeto);
                                    this.cenaDoJogo.prisioneiro.visivel = false;
                                }
                            }

                        }
                    }
                if(this.cenaDoJogo.porta.visivel){
                    if(this.cenaDoJogo.porta.cenario == this.cenaDoJogo.cenario.getcenaValida()){
                        boolean bateuNpc = colisao.verificaColisao(this.cenaDoJogo.player1.areaSolida, this.cenaDoJogo.porta.areaSolida);
                        if(bateuNpc== true){

                           if(this.cenaDoJogo.player1.inventarioJogador[0].qtdeObjeto != 2){
                                System.out.println("Tem duas entradas de chaves aqui!!");

                           }else{
                                System.out.println("A porta abriu!!");
                                    this.cenaDoJogo.porta.visivel = false;
                           }
                           

                        }
                    
                    
                    }

                }
                }  
                }
                this.cenaDoJogo.repaint();
                this.contadorDeFPS++;
                tempoDecorrido = 0;
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("FPS calculado:" + this.contadorDeFPS);
        this.contadorDeFPS = 0;
    }
}
