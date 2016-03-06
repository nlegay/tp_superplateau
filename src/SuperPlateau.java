import java.util.Random;

public class SuperPlateau {
	private Plateau plateau;
	
	SuperPlateau(String[] gifs, int taille){
		plateau = new Plateau(gifs, taille);
	}
	public void affichage(){
		plateau.affichage();
	}
	public void setJeu(int[][] positions){
		plateau.setJeu(positions);
	}
	public int[][] getJeu(){
		return plateau.getJeu();
	}
	boolean deplacer(int x, int y, int a, int b){
		int taille = this.getJeu().length;
		int[][] pos = this.getJeu();
		if(a<taille && b<taille && a>=0 && b>=0 && x<taille && y<taille && x>=0 && y>=0 && pos[x][y] > 0 && pos[a][b] == 0){
			pos[a][b] = pos[x][y];
			pos[x][y] = 0;
			this.setJeu(pos);
			return true;
		}else{
			return false;
		}
	}
	
	static public void main(String[] args){
		Random r = new Random();
		String[] gifs={"images/un.gif", "images/deux.gif", "images/trois.gif", "images/quatre.gif"};
		int taille = 10;
		int[][] positions = new int[taille][taille];
		SuperPlateau plateau = new SuperPlateau(gifs, taille);
		for (int i=0;i<taille;i++)
			for (int j=0;j<taille;j++)
			positions[i][j]=r.nextInt(gifs.length+1);
		positions[0][0] = 1;
		positions[1][0] = 0;

		plateau.setJeu(positions);
		plateau.affichage();
		try{Thread.sleep(1000);}catch(Exception ie){}
		plateau.deplacer(0, 0, 1, 0);
		plateau.affichage();
	}
}
