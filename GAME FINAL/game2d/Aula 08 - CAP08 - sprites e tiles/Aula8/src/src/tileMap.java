import java.awt.Graphics2D;

public class tileMap {
	tiles pecaDoCenario;
	int [][] cenarioValido;

	int[][] cenarioTopEsq = {
		{ 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
		{ 2 , 1 , 1 , 1 , 2 , 2 , 1 , 2 , 2 , 0 , 3 , 3 , 3 , 3 , 3 , 3 },
		{ 2 , 1 , 3 , 1 , 2 , 2 , 1 , 2 , 2 , 0 , 3 , 3 , 3 , 3 , 3 , 0 },
		{ 2 , 1 , 3 , 1 , 2 , 2 , 1 , 2 , 2 , 0 , 3 , 3 , 3 , 3 , 3 , 0 },
		{ 2 , 1 , 3 , 1 , 2 , 2 , 1 , 2 , 2 , 0 , 3 , 3 , 3 , 3 , 3 , 0 },
		{ 2 , 1 , 3 , 1 , 1 , 1 , 1 , 2 , 2 , 0 , 3 , 3 , 3 , 3 , 3 , 0 },
		{ 2 , 1 , 3 , 3 , 3 , 3 , 3 , 0 , 0 , 0 , 3 , 3 , 3 , 3 , 3 , 0 },
		{ 2 , 1 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 0 },
		{ 2 , 1 , 15, 15, 15, 15, 15, 0 , 0 , 0 , 0 , 0 , 3 , 0 , 0 , 0 },
		{ 2 , 14, 14, 14, 14, 14, 14, 13, 13, 13, 13, 0 , 3 , 0 , 0 , 0 }
	};
	int[][]  cenarioBasEsq = { 
			
		{ 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 9 , 3 , 12, 12, 12},
		{ 2 , 9 , 2 , 9 , 2 , 9 , 2 , 9 , 2 , 9 , 2 , 9 , 5 , 5 , 5 , 12},
		{ 9 , 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 5 , 5 , 5 , 5 , 12},
		{ 9 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 12, 12, 12, 12},
		{ 9 , 5 , 12, 5 , 5 , 5 , 12, 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 },
		{ 9 , 5 , 12, 12, 5 , 5 , 12, 5 , 5 , 12, 12, 12, 12, 12, 12, 12},
		{ 9 , 5 , 5 , 12, 5 , 5 , 12, 5 , 5 , 12, 5 , 5 , 5 , 12, 5 , 12},
		{ 9 , 5 , 5 , 12, 12, 12, 12, 12, 12, 12, 5 , 12, 5 , 12, 5 , 12},
		{ 9 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 12, 5 , 5 , 5 , 5 },
		{ 9 , 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12}
	};
	int[][] cenarioBasDir = { 
		{ 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16},
		{ 17, 18, 18, 17, 18, 18, 18, 17, 18, 18, 18, 17, 18, 18, 18, 17},
		{ 17, 18, 18, 18, 18, 17, 18, 18, 18, 17, 18, 17, 18, 18, 17, 17},
		{ 17, 18, 18, 17, 17, 17, 17, 17, 17, 17, 18, 17, 18, 18, 18, 17},
		{ 18, 18, 17, 17, 18, 18, 18, 18, 18, 17, 18, 17, 18, 18, 18, 17},
		{ 17, 18, 17, 17, 18, 17, 17, 17, 18, 17, 18, 17, 17, 17, 18, 17},
		{ 17, 17, 17, 17, 18, 17, 18, 17, 18, 4 , 18, 17, 17, 18, 18, 17},
		{ 17, 18, 17, 17, 18, 17, 18, 17, 18, 17, 17, 17, 17, 18, 17, 17},
		{ 18, 18, 18, 18, 18, 18, 18, 17, 18, 18, 18, 18, 18, 18, 18, 17},
		{ 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17}
	};
	int[][] cenarioTopDir = { 
		{ 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 },
		{ 3, 3, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7 },
		{ 7, 3, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 7 },
		{ 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 8, 8, 7 },
		{ 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 3, 8, 8, 7 },
		{ 7, 3, 7, 3, 3, 3, 3, 3, 3, 7, 3, 3, 3, 8, 8, 7 },
		{ 7, 3, 7, 3, 3, 7, 7, 7, 3, 7, 3, 7, 3, 8, 8, 7 },
		{ 7, 3, 7, 7, 3, 3, 3, 7, 3, 7, 3, 7, 3, 3, 3, 7 },
		{ 7, 3, 3, 3, 3, 3, 3, 7, 3, 3, 3, 7, 3, 8, 8, 7 },
		{ 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 }
	};	
	
	tileMap(){
		cenarioValido = cenarioTopEsq;
		this.cenaValida = "TE";
		this.pecaDoCenario = new tiles();
	}
	public void desenhar(Graphics2D g) {
		int pecaDaMatriz;
		for(int col = 0;col < cenarioValido[0].length;col++)
			for(int row = 0;row < cenarioValido.length;row++) {
				pecaDaMatriz = cenarioValido[row][col];
				this.pecaDoCenario.carregaPecaDaMatriz(pecaDaMatriz);
				this.pecaDoCenario.desenhar(g, row, col);
			}
	}
	private String cenaValida;
	public String cenaValida(){
		return cenaValida;
	}
	public void setcenaValida(String cenaValida)
	{
		this.cenaValida = cenaValida;
		switch (this.cenaValida)
		{
			case "TE":
				this.cenarioValido = this.cenarioTopEsq;
				break;
			case "BE":
				this.cenarioValido = this.cenarioBasEsq;
				break;
			case "TD":
				this.cenarioValido = this.cenarioTopDir;
				break;
			case "BD":
				this.cenarioValido = this.cenarioBasDir;
				break;
			}
	}
	public String getcenaValida() {
		return cenaValida;
	}
}
