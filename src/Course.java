import java.util.Random;

public class Course {
	SuperPlateau plateau;
	Random r = new Random();
	int taille;
	int[][] positions;
	int[] x = {0,0};
	int[] y = {0,1};
	
	Course(String[] gifs, int taille){
		plateau = new SuperPlateau(gifs, taille);
		positions = new int[taille][taille];
		this.taille = taille;
		// on initialise le tableau position avec que des 0
		for (int i=0;i<taille;i++)
			for (int j=0;j<taille;j++)
			positions[i][j]=0;
		// on place les smileys
		positions[x[0]][y[0]] = 1;
		positions[x[1]][y[1]] = 2;
	}
	
	void deplacerAlea(int joueur){
		int choix = r.nextInt(3);
		if(choix==0){
			if(plateau.deplacer(x[joueur], y[joueur], x[joueur]+1, y[joueur])){
				x[joueur]++;
			}
		}else if(choix==1){
			if(plateau.deplacer(x[joueur], y[joueur], x[joueur], y[joueur]+1)){
				y[joueur]++;
			}
		}else if(choix==2){
			if(plateau.deplacer(x[joueur], y[joueur], x[joueur]+1, y[joueur]+1)){
				x[joueur]++;
				y[joueur]++;
			}
		}
	}
	public static void main(String[] args) {
		String[] gifs={"images/un.gif", "images/deux.gif", "images/trois.gif", "images/quatre.gif"};
		Course course = new Course(gifs, 10);

		course.plateau.setJeu(course.positions);
		course.plateau.affichage();
		
		while(course.positions[course.taille-1][course.taille-1] == 0){
			try{Thread.sleep(500);}catch(Exception ie){}
			course.deplacerAlea(0);
			course.plateau.affichage();
			try{Thread.sleep(500);}catch(Exception ie){}
			course.deplacerAlea(1);
			course.plateau.affichage();
			System.out.println("yo");
		}
		System.out.println("Bravo!");
	}

}
