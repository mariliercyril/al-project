package org.polytech.al.project1920;

import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.Scanner;

class Scenario2 {
    private String REST_URI;
    private RestTemplateBuilder builder;

    Scenario2(String uri) {
        REST_URI = uri;
        builder = new RestTemplateBuilder();
    }

    /*
     * José et Killian possèdent tous deux un compte (“bank account”) dans notre banque.
     * José effectue un virement (“transfer”) à destination de Killian, d’une valeur de 10 000 euros.
     * Killian possède alors 12 300 euros sur son compte courant : dans les prochains jours, le système de recommandation (“recommandations”)
     * comparera le profil généré par le profileur (“profiling”) pour Killian avec le catalogue des produits (“catalog”),
     * et lui proposera de créer un compte (“bank account”) avec un taux plus avantageux.
     */
    void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Color.ANSI_CYAN + "--------------------------------------------------------------------");
        System.out.println("                             Scenario 2");
        System.out.println("--------------------------------------------------------------------" + Color.ANSI_RESET);
        scanner.nextLine();
        //create account Marcel
        System.out.println(Color.ANSI_GREEN + "Initialisation Jose, 45 ans. Un compte avec 15 000 euros" + Color.ANSI_RESET);
        createAccount("pass", "Jose", 45);
        createBankAccount("Jose");
        addMoney("Jose", 15000);
        scanner.nextLine();
        System.out.println(Color.ANSI_GREEN + "Initialisation Killian, 24 ans. Un compte avec 2 300 euros" + Color.ANSI_RESET);
        createAccount("word", "Killian", 24);
        createBankAccount("Killian");
        addMoney("Killian", 2300);
        //System.out.println(x);
        scanner.nextLine();
        System.out.println(Color.ANSI_CYAN + "Pretty Dump" + Color.ANSI_RESET);
        prettyDump();
        scanner.nextLine();
        System.out.println(Color.ANSI_GREEN + "Jose se connecte a son compte utilisateur." + Color.ANSI_RESET);
        //requete login
        String x = login("pass", "Jose");
        System.out.println(Color.ANSI_YELLOW + x + Color.ANSI_RESET);
        scanner.nextLine();

        System.out.println(Color.ANSI_GREEN + "Jose effectue un virement de 10 000 euros sur le compte de Killian." + Color.ANSI_RESET);
        //requete login
        x = transfer("Jose", "Killian", 10000);
        System.out.println(Color.ANSI_YELLOW + x + Color.ANSI_RESET);
        scanner.nextLine();

        //profiling action
        System.out.println(Color.ANSI_GREEN + "Killian possede donc 12 300 euros.");
        System.out.println(Color.ANSI_GREEN + "Le profileur a genere un profil pour Killian a partir de ses donnees.");
        System.out.println("Le module de recommandations recupere le profil genere par le profileur et le compare au catalogue." + Color.ANSI_RESET);
        scanner.nextLine();

        System.out.println(Color.ANSI_GREEN + "Le module de recommandations remarque que Killian a une somme impotante sur son compte.");
        System.out.println("Il lui propose donc de creer un compte avec un taux plus avantageux." + Color.ANSI_RESET);
        //requete get profile
        String y = reco();
        System.out.println(Color.ANSI_YELLOW + y + Color.ANSI_RESET);
        scanner.nextLine();
        System.out.println(Color.ANSI_CYAN + "Pretty Dump" + Color.ANSI_RESET);
        prettyDump();
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

    private String addMoney(String id, int amount) {
        String fullUri = REST_URI + ":8080/addMoney?userId=" + id + "&amount=" + amount;
        System.out.println(Color.ANSI_YELLOW + "REST/POST : " + fullUri + Color.ANSI_RESET);
        return builder.build().postForObject(fullUri, null, String.class);
    }

    private String transfer(String senderId, String receiverId, int amount) {
        String fullUri = REST_URI + ":8080/requestTransfer?senderId=" + senderId + "&receiverId=" + receiverId + "&amount=" + amount;
        System.out.println(Color.ANSI_YELLOW + "REST/POST : " + fullUri + Color.ANSI_RESET);
        return builder.build().postForObject(fullUri, null, String.class);
    }

    private String prettyDump() {
        String fullUri = REST_URI + ":8081/prettyDump";
        System.out.println(Color.ANSI_YELLOW + "REST/GET : " + fullUri + Color.ANSI_RESET);
        return builder.build().getForObject(fullUri, String.class);
    }
}
