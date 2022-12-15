import javax.swing.JFrame;

import java.awt.BorderLayout;

public class moldura extends JFrame{
    moldura(){
        this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setTitle("Aula 07 - Cap08 - Sprites e tiles - parte 1");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		painel p = new painel("centro");
		this.add(p);
		this.pack();// moldura n�o precisa ter seu tamanho definido, pois s�o os pain�is que far�o esta defini��o.
		this.setLocationRelativeTo(null);
		this.setVisible(true);
    }
}
