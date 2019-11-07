package org.polytech.al.project1920;

import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.Scanner;

class Scenario1 {
    String REST_URI;

    Scenario1(String uri){
        REST_URI = uri;
    }

    /*
    * Marcel se connecte à son compte utilisateur (user account) grâce au module d’authentification (authentication).
    * Le module de recommandations (recommandations) compare le profil généré par le profileur (profiling)
    * à partir des données recueillies sur Marcel avec les produits du catalogue (catalog).
    * Il remarque que Marcel aura bientôt 18 ans et ne possède pas de compte jeune.
    * Il lui affiche alors une proposition pour créer un compte jeune, adapté à sa situation.
    */
    void play(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Color.ANSI_CYAN+"--------------------------------------------------------------------");
        System.out.println("                             Scenario 1");
        System.out.println("--------------------------------------------------------------------"+Color.ANSI_RESET);
        //create account Marcel
        String x = createAccount("azerty","Marcel",18);
        //System.out.println(x);
        scanner.nextLine();
        System.out.println(Color.ANSI_GREEN+"Marcel se connecte a son compte utilisateur."+Color.ANSI_RESET);
        //requete login
        //System.out.println("Requete blabla");
        String y = login("azerty","Marcel");
        System.out.println(Color.ANSI_YELLOW+y+Color.ANSI_RESET);
        scanner.nextLine();
        //profiling action
        System.out.println(Color.ANSI_GREEN+"Le profileur a genere un profil pour Marcel a partir de ses donnees.");
        System.out.println("Le module de recommandations recupere le profil genere par le profileur et le compare au catalogue."+Color.ANSI_RESET);
        scanner.nextLine();

        System.out.println(Color.ANSI_GREEN+"Le module de recommandations remarque que Marcel aura bientot 18 ans.");
        System.out.println("Il lui propose donc de creer un compte jeune."+Color.ANSI_RESET);
        //requete get profile
        y = reco();
        //System.out.println("Requete blabla");
        System.out.println(Color.ANSI_YELLOW+y+Color.ANSI_RESET);
        scanner.nextLine();

    }

    private String createAccount(String pass, String id, int age){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        String result = builder.build().postForObject(REST_URI+":8081/createAccount?password="+pass+"&userId="+id+"&age="+age,null, String.class);
        return result;
    }

    private String login(String pass, String id){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        String result = builder.build().getForObject(REST_URI+":8081/login?password="+pass+"&userId="+id, String.class);
        return result;
    }

    private String reco(){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        String result = builder.build().getForObject(REST_URI+":8000/triggerRecommendation", String.class);
        return result;
    }
}
