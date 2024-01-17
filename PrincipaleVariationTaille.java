public class PrincipaleVariationTaille {

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


    /**
     * calcule le temps nécessaire à 10 opérations d'ajout sur une liste
     * @param typeListe le type d'implementation a utiliser (ListeChainee, ListeContigue, ListeChaineePlacesLibres)
     * @param chaine les chaines a inserer dans la liste
     * @param operation l'operation a effectuer (1 pour un ajout, -1 pour une suppression)
     * @param nbNoms le combre de chaînes à ajouter à la liste
     * @return le temps nécessaire pour effectuer les 10 opérations
     */
    public static long calculerTemps(String typeListe, String[] chaines, int operation, int nbNoms){

      long total = 0;
      ListeTriee l = null;

      for (int j=0; j<100; j++){  // Modifié à la question 13

        switch(typeListe){
          case "ListeChainee":
            l = new ListeTriee(new ListeChainee((nbNoms*2)+10));
            break;
          case "ListeContigue":
            l = new ListeTriee(new ListeContigue((nbNoms*2)+10));
            break;
          case "ListeChaineePlacesLibres":
            l = new ListeTriee(new ListeChaineePlacesLibres((nbNoms*2)+10));
            break;
          default:
            l = new ListeTriee(new ListeChainee((nbNoms*2)+10));
            break;
        }

        switch(nbNoms){ // Modifié à la question 14
          case 100:
            remplir_liste(l,"noms100.txt");
            break;
          case 1000:
            remplir_liste(l,"noms1000.txt");
            break;
          case 10000:
            remplir_liste(l,"noms10000.txt");
            break;
          case 100000:
            remplir_liste(l,"noms100000.txt");
            break;
          default:
            remplir_liste(l,"noms1000.txt");
            break;
        }

        long date_debut = System.nanoTime();
        if (operation == 1){
          for(int i=0; i<10;i++){
              l.adjlisT(chaines[i]);
          }
        }
        else {
          for(int i=0; i<10;i++){
            l.suplisT(chaines[i]);
          }
        }
        long date_fin = System.nanoTime();
        long duree = date_fin - date_debut;
        total += duree;

      }
      return total/100;
    }

    /**
     * affiche les mesures des temps d'execution
     * @param typeListe le type d'implementation a utiliser (ListeChainee, ListeContigue, ListeChaineePlacesLibres)
     * @param operation l'operation a effectuer (1 pour un ajout, -1 pour une suppression)
     * @param chaine l'emplacement des chaines a inserer dans la liste
     * @param nbNoms le combre de chaînes à ajouter à la liste
     * @return un affichage des résultats de la mesure (liste;operation;emplacement;duree(ns))
     */
    public static String mesurer(String typeListe, int operation, String chaines, int nbNoms){
      String ope = "ajout";
      String[] ch = ELEMENTS_DE_DEBUT;
      if (chaines == "fin") ch = ELEMENTS_DE_FIN;
      if (operation == -1) ope = "suppression";
      return (typeListe+";"+ope+";"+chaines+";"+calculerTemps(typeListe, ch, operation, nbNoms));
    }


    public static void main(String [] args){

    // ListeChainee LCH=new ListeChainee(10000);
    // ListeContigue LC=new ListeContigue(10000);
    // ListeChaineePlacesLibres LCPL=new ListeChaineePlacesLibres(20010);

    // // QUESTION 6
    // ListeTriee L1=new ListeTriee(LCPL);
    // remplir_liste(L1,"noms10000.txt");

    // // QUESTION 7
    // mesurer("ListeChainee", 1, "debut");
    // mesurer("ListeContigue", 1, "debut");
    // mesurer("ListeChaineePlacesLibres", 1, "debut");

    // // QUESTION 8
    // mesurer("ListeChainee", 1, "fin");
    // mesurer("ListeContigue", 1, "fin");
    // mesurer("ListeChaineePlacesLibres", 1, "fin");

    // // QUESTION 10
    // mesurer("ListeChainee", -1, "debut");
    // mesurer("ListeContigue", -1, "debut");
    // mesurer("ListeChaineePlacesLibres", -1, "debut");

    // // QUESTION 11
    // mesurer("ListeChainee", -1, "fin");
    // mesurer("ListeContigue", -1, "fin");
    // mesurer("ListeChaineePlacesLibres", -1, "fin");


    // QUESTION 12 (modification QUESTION 14)
    EcritureFichier fichier = new EcritureFichier("resultats.csv");
    fichier.ouvrirFichier();
    fichier.ecrireLigne("liste;operation;emplacement;duree");
    for (int i=100; i<=10000; i=i*10){
      fichier.ecrireLigne(mesurer("ListeChainee", 1, "debut", i));
      fichier.ecrireLigne(mesurer("ListeContigue", 1, "debut", i));
      fichier.ecrireLigne(mesurer("ListeChaineePlacesLibres", 1, "debut", i));
      fichier.ecrireLigne(mesurer("ListeChainee", 1, "fin", i));
      fichier.ecrireLigne(mesurer("ListeContigue", 1, "fin", i));
      fichier.ecrireLigne(mesurer("ListeChaineePlacesLibres", 1, "fin", i));
      fichier.ecrireLigne(mesurer("ListeChainee", -1, "debut", i));
      fichier.ecrireLigne(mesurer("ListeContigue", -1, "debut", i));
      fichier.ecrireLigne(mesurer("ListeChaineePlacesLibres", -1, "debut", i));
      fichier.ecrireLigne(mesurer("ListeChainee", -1, "fin", i));
      fichier.ecrireLigne(mesurer("ListeContigue", -1, "fin", i));
      fichier.ecrireLigne(mesurer("ListeChaineePlacesLibres", -1, "fin", i));
    }
    fichier.fermerFichier();
}

}
