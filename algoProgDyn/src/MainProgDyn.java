/************************************************************************************/
/*Dans ce code : 																    */
/*	Les tours ont la liste des voitures qui peuvent recevoir des informations	    */
/*	Les voitures ont : - la liste des tours candidates								*/
/*		-une seule tour, unique possibilité pour emettre			
 *      
 *      scenario 1 : 12 véhicules statiques dont 2 sources
 *      scenario 2 : 5 véhicules immobile avec une source et arrivée d'un sixieme véhicule source
 * 
 * 	Possibilité de générer aléatoirement la position des véhicules
 * 	Possibilité de charger la position des véhicules grâce à Input.txt
 * 
 * 	Sortie output.txt : temps des changements
 * 	Sortie total.txt : temps des changements classés																				*/
/************************************************************************************/



import java.util.Vector;

import jbotsim.Topology;
import jbotsimx.ui.JViewer;

public class MainProgDyn {
	public static int CHGMT=0;
	static Vector<TempsParPassage> vectPassageTemps = new Vector<TempsParPassage>();
	static Vector<DebitParTour> vectDebitTotal = new Vector<DebitParTour>();
	
	static int nbOptimum=0;

	public static String toStringvpt() {
		String str="";
		for (int i=0; i<vectPassageTemps.size(); i++)
		{
			str=str+vectPassageTemps.get(i).toString();
		}
		return str;
	}
	
	public static int getNbOptimum() {
		return nbOptimum;
	}

	public static void setNbOptimum(int nbOptimum) {
		MainProgDyn.nbOptimum = nbOptimum;
	}

	public static int tourUtilisee(Integer t)
	{
		for (int i=0; i<vectDebitTotal.size(); i++)
		{
			if (vectDebitTotal.get(i).getTourID()==t)
			{
				return i;
			}
		}
		return -1;
	}
	
	public static double debitTotal()
	{
		double debTot=0;
		for (int i=0; i< vectPassageTemps.size(); i++)
		{
			debTot+= vectPassageTemps.get(i).getDebit();
		}
		return debTot;
	}
	
	public static void main(String[] args) {
		
		
		Topology tp = new Topology();
		tp.setNodeModel("car", HighwayCar.class);
		tp.setNodeModel("tower", HighwayTower.class);

		/*cas de base
		*/
		/*
		HighwayCar c0 = new HighwayCar();
		tp.addNode(260, 100, c0);
		c0.setSource(1);

		HighwayCar c1 = new HighwayCar();
		tp.addNode(300, 140, c1);
		c1.setSource(2);
		
		HighwayCar c2 = new HighwayCar();
		tp.addNode(260, 180, c2);
		
		HighwayCar c3 = new HighwayCar();
		tp.addNode(260, 250, c3);
		
		HighwayCar c4 = new HighwayCar();
		tp.addNode(260, 300, c4);
		
		HighwayCar c5 = new HighwayCar();
		tp.addNode(220, 20, c5);
		
		HighwayTower t1 = new HighwayTower(8);
		tp.addNode(310, 200, t1);

		HighwayTower t0 = new HighwayTower(15);
		tp.addNode(210, 140, t0);
		
		HighwayTower t2 = new HighwayTower(12);
		tp.addNode(310, 80, t2);
		
		HighwayTower t3 = new HighwayTower(10);
		tp.addNode(340, 100, t3);
*/

		HighwayCar c0 = new HighwayCar();
		tp.addNode(260, 100,c0);
		c0.setSource(1);
		c0.setIntColor(1);

		HighwayCar c1 = new HighwayCar(0);
		tp.addNode(200, 140,c1);
		c1.setSource(2);
		c1.setIntColor(2);


		for (int i=0; i<10; i++)
		{
			tp.addNode(new HighwayCar(0));
		}
		
		
		HighwayTower t1 = new HighwayTower(3);
		tp.addNode(310, 200, t1);

		HighwayTower t0 = new HighwayTower(5);
		tp.addNode(210, 140, t0);
		
		HighwayTower t2 = new HighwayTower(7);
		tp.addNode(310, 40, t2);
		
		HighwayTower t3 = new HighwayTower(11);
		tp.addNode(340, 100, t3);

		HighwayTower t4 = new HighwayTower(13);
		tp.addNode(400, 180, t4);

		HighwayTower t5 = new HighwayTower(17);
		tp.addNode(440, 150, t5);

		new JViewer(tp);
		tp.start();
	}
}
