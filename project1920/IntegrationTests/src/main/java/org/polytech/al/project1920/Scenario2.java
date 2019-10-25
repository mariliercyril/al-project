package org.polytech.al.project1920;

class Scenario2 {

    Scenario2(){ }

    /*
    * José et Killian possèdent tous deux un compte (“bank account”) dans notre banque.
    * José effectue un virement (“transfer”) à destination de Killian, d’une valeur de 10 000 euros.
    * Killian possède alors 12 300 euros sur son compte courant : dans les prochains jours, le système de recommandation (“recommandations”)
    * comparera le profil généré par le profileur (“profiling”) pour Killian avec le catalogue des produits (“catalog”),
    * et lui proposera de créer un compte (“bank account”) avec un taux plus avantageux.
    */
    void play(){
        System.out.println(Color.ANSI_CYAN+"--------------------------------------------------------------------");
        System.out.println("                             Scenario 2");
        System.out.println("--------------------------------------------------------------------"+Color.ANSI_RESET);
        //create account Jose + Killian
        //mock add money
        System.out.println();
        System.out.println("Marcel se connecte a son compte utilisateur.");
        System.out.println("Requete blabla");
        System.out.println("reponse blabla");
        System.out.println();
        System.out.println("Le profileur à généré un profil pour Marcel a partir de ses données.");
        System.out.println("Requete blabla");
        System.out.println("reponse blabla");
        System.out.println();
        System.out.println("Le module de recommandations récupère les données du catalogue et le profil généré par le profileur.");
        System.out.println("Requete blabla");
        System.out.println("reponse blabla");
        System.out.println();
        System.out.println("Il remarque que Marcel aura bientot 18 ans et ne possède pas de compte jeune.");
        System.out.println("Il lui affiche alors une proposition pour créer un compte jeune.");
        System.out.println("Proposition blabla");

    }
}
