import java.util.Random;

public class Traversee {
	static public void main(String[] args){
		int x=0, y=0;
		Random r = new Random();
		String[] gifs={"images/un.gif", "images/deux.gif", "images/trois.gif", "images/quatre.gif"};
		int taille = 10;
		int[][] positions = new int[taille][taille];
		SuperPlateau plateau = new SuperPlateau(gifs, taille);
		
		for (int i=0;i<taille;i++)
			for (int j=0;j<taille;j++)
			positions[i][j]=0;
		positions[x][y] = 1;
		plateau.setJeu(positions);
		plateau.affichage();
		
		while(positions[taille-1][taille-1] != 1){
			int choix = r.nextInt(3);
			if(choix==0){
				if(plateau.deplacer(x, y, x+1, y)){
					x++;
				}
			}else if(choix==1){
				if(plateau.deplacer(x, y, x, y+1)){
					y++;
				}
			}else if(choix==2){
				if(plateau.deplacer(x, y, x+1, y+1)){
					x++;
					y++;
				}
			}
			try{Thread.sleep(1000);}catch(Exception ie){}
			plateau.affichage();
		}
		System.out.println("Bravo!");
	}
}
