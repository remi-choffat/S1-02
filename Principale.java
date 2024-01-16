/**
 * Classe principale de la SAÉ
 * @author Étienne André Sergueï Lenglet
 * @since 2021-11-04
 *
 */


public class Principale{

    private static final String[] ELEMENTS_DE_DEBUT
	= {"ABITEBOUL", "ADLEMAN", "AL-KINDI", "ALUR", "BERNERS-LEE",
	"BOOLE", "BUCHI", "BUTLER", "CLARKE", "CURRY"};
    private static final String[] ELEMENTS_DE_FIN
	= {"RABIN", "RIVEST", "SHAMIR", "SIFAKIS", "TORVALDS",
	"TURING", "ULLMAN", "VALIANT", "WIRTH", "YAO"};
    
    // NOTE: pour fichier 10 000
    // private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABBADI", "ABERGEL", "ALIAS", "ALIOUI", "AKKUS", "ALAZARD",
    // "ALLA", "AIDARA", "ABRANTES", "AARAB"};
    // //NOTE: pour fichier 1 000
    // private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABADIE", "ABDALLAH", "ABRAHAM", "ADAM", "AFONSO",
    // "ALBERT", "ALEXANDRE", "ALI", "ALIX", "ALLAIN"};
    // //NOTE: pour fichier 10 000
    // private static final String[] ELEMENTS_DE_FIN_SUPPR
    // = {"WEIS", "ZANIN", "WERQUIN", "YAGOUBI", "WERNERT",
    // "WAWRZYNIAK", "ZULIANI", "ZAIRE", "WAVRANT", "VILLAR"}; 
    // //NOTE: pour fichier 1 000
    // private static final String[] ELEMENTS_DE_FIN_SUPPR
    // = {"WEBER", "WEISS", "WINTERSTEIN", "WOLFF", "YANG",
    // "YILDIRIM", "YILDIZ", "YILMAZ", "ZIEGLER", "ZIMMERMANN"}; 
	
    // Type des listes, peut etre utile pour factoriser les tests
    private static final int CONTIGUE	       = 1;
    private static final int CHAINEE	       = 2;
    private static final int CHAINEE_PLIBRES   = 3;
	
    // Exemple d'utilisation de LectureFichier et remplissage d'une liste
    public static void remplir_liste(ListeTriee liste, String nom_fichier){
	LectureFichier lf = new LectureFichier(nom_fichier);
	// 		
	String[] liste_noms = lf.lireFichier();
	for (int i = 0; i < liste_noms.length; i++) {
	    liste.adjlisT(liste_noms[i]);
	}
    }
		
    public static void main(String [] args){
	// System.out.println("Bienvenue !");

	// //Exemple d'utilisation de la classe EcritureFichier
	// EcritureFichier fichier = new EcritureFichier("resultats.csv");
	// fichier.ouvrirFichier();
	// fichier.ecrireLigne("liste;operation;emplacement;duree");
	// fichier.fermerFichier();
    // }
    
    ListeChainee LCH=new ListeChainee(10000);
    ListeContigue LC=new ListeContigue(10000);
    ListeChaineePlacesLibres LCPL=new ListeChaineePlacesLibres(20010);
    // ListeTriee LT=new ListeTriee(LC);
    // ListeTriee LT2=new ListeTriee(LCH);
    // ListeTriee LT3=new ListeTriee(LCPL);

    ListeTriee L1=new ListeTriee(LCPL);
    remplir_liste(L1,"noms10000.txt");


    //QUESTION 7
    ListeTriee ListeTrieeLCPL = new ListeTriee(LCPL);
    remplir_liste(ListeTrieeLCPL,"noms10000.txt");
    long date_debut = System.nanoTime();
    for(int i=0; i<10;i++){
        ListeTrieeLCPL.adjlisT(ELEMENTS_DE_DEBUT[i]);
    }
    long date_fin = System.nanoTime();
    long duree = date_fin - date_debut ;
    System.out.println(duree);
}

}