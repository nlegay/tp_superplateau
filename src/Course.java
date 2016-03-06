import java.util.Random;

public class Course {
	
	public static void main(String[] args) {
		Random r = new Random();
		int choix;
		int[] x = {0,0};
		int[] y = {0,1};
		String[] gifs={"images/un.gif", "images/deux.gif", "images/trois.gif", "images/quatre.gif"};
		int taille = 10;
		int[][] positions = new int[taille][taille];
		SuperPlateau plateau = new SuperPlateau(gifs, taille);
		
		for (int i=0;i<taille;i++)
			for (int j=0;j<taille;j++)
			positions[i][j]=0;
		positions[x[0]][y[0]] = 1;
		positions[x[1]][y[1]] = 2;
		plateau.setJeu(positions);
		plateau.affichage();
		
		while(positions[taille-1][taille-1] == 0){
			try{Thread.sleep(500);}catch(Exception ie){}
			choix = r.nextInt(3);
			if(choix==0){
				if(plateau.deplacer(x[0], y[0], x[0]+1, y[0])){
					x[0]++;
				}
			}else if(choix==1){
				if(plateau.deplacer(x[0], y[0], x[0], y[0]+1)){
					y[0]++;
				}
			}else if(choix==2){
				if(plateau.deplacer(x[0], y[0], x[0]+1, y[0]+1)){
					x[0]++;
					y[0]++;
				}
			}
			try{Thread.sleep(500);}catch(Exception ie){}
			choix = r.nextInt(3);
			if(choix==0){
				if(plateau.deplacer(x[1], y[1], x[1]+1, y[1])){
					x[1]++;
				}
			}else if(choix==1){
				if(plateau.deplacer(x[1], y[1], x[1], y[1]+1)){
					y[1]++;
				}
			}else if(choix==2){
				if(plateau.deplacer(x[1], y[1], x[1]+1, y[1]+1)){
					x[1]++;
					y[1]++;
				}
			}
			plateau.affichage();
		}
		System.out.println("Bravo!");
	}

}
