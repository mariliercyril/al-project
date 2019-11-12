package org.polytech.al.project1920;

import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.Scanner;

class Scenario1 {
    private String REST_URI;
    private RestTemplateBuilder builder;

    Scenario1(String uri) {
        REST_URI = uri;
        builder = new RestTemplateBuilder();
    }

    /*
     * Marcel se connecte à son compte utilisateur (user account) grâce au module d’authentification (authentication).
     * Le module de recommandations (recommandations) compare le profil généré par le profileur (profiling)
     * à partir des données recueillies sur Marcel avec les produits du catalogue (catalog).
     * Il remarque que Marcel aura bientôt 18 ans et ne possède pas de compte jeune.
     * Il lui affiche alors une proposition pour créer un compte jeune, adapté à sa situation.
     */
    void play() {


        Scanner scanner = new Scanner(System.in);
        System.out.println(Color.ANSI_CYAN + "--------------------------------------------------------------------");
        System.out.println("                             Scenario 1");
        System.out.println("--------------------------------------------------------------------" + Color.ANSI_RESET);
        scanner.nextLine();
        //create account Marcel
        System.out.println(Color.ANSI_GREEN + "Initialisation Marcel, 18 ans." + Color.ANSI_RESET);
        String x = createAccount("azerty", "Marcel", 18);
        createBankAccount("Marcel");
        //System.out.println(x);
        scanner.nextLine();
        System.out.println(Color.ANSI_GREEN + "Marcel se connecte a son compte utilisateur." + Color.ANSI_RESET);
        //requete login
        String y = login("azerty", "Marcel");
        System.out.println(Color.ANSI_YELLOW + y + Color.ANSI_RESET);
        scanner.nextLine();
        //profiling action
        System.out.println(Color.ANSI_GREEN + "Le profileur a genere un profil pour Marcel a partir de ses donnees.");
        System.out.println("Le module de recommandations recupere le profil genere par le profileur et le compare au catalogue." + Color.ANSI_RESET);
        scanner.nextLine();

        System.out.println(Color.ANSI_GREEN + "Le module de recommandations remarque que Marcel aura bientot 18 ans.");
        System.out.println("Il lui propose donc de creer un compte jeune." + Color.ANSI_RESET);
        //requete get profile
        y = reco();
        System.out.println(Color.ANSI_YELLOW + y + Color.ANSI_RESET);
        scanner.nextLine();

    }

    private String createAccount(String pass, String id, int age) {
        String fullUri = REST_URI + ":8081/createAccount?password=" + pass + "&userId=" + id + "&age=" + age;
        System.out.println(Color.ANSI_YELLOW + "REST/POST : " + fullUri + Color.ANSI_RESET);
        return builder.build().postForObject(fullUri, null, String.class);
    }

    private String login(String pass, String id) {
        String fullUri = REST_URI + ":8081/login?password=" + pass + "&userId=" + id;
        System.out.println(Color.ANSI_YELLOW + "REST/GET : " + fullUri + Color.ANSI_RESET);
        return builder.build().getForObject(fullUri, String.class);
    }

    private String reco() {
        String fullUri = REST_URI + ":8000/triggerRecommendation";
        System.out.println(Color.ANSI_YELLOW + "REST/GET : " + fullUri + Color.ANSI_RESET);
        return builder.build().getForObject(fullUri, String.class);
    }

    private String createBankAccount(String id) {
        String fullUri = REST_URI + ":8080/createBankAccount?userId=" + id;
        System.out.println(Color.ANSI_YELLOW + "REST/POST : " + fullUri + Color.ANSI_RESET);
        return builder.build().postForObject(fullUri, null, String.class);
    }
}
