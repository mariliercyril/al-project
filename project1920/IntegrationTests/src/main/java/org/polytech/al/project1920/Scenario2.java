package org.polytech.al.project1920;

import org.springframework.boot.web.client.RestTemplateBuilder;

import java.util.Scanner;

class Scenario2 {
    String REST_URI;

    Scenario2(String uri){
        REST_URI = uri;
    }

    /*
    * José et Killian possèdent tous deux un compte (“bank account”) dans notre banque.
    * José effectue un virement (“transfer”) à destination de Killian, d’une valeur de 10 000 euros.
    * Killian possède alors 12 300 euros sur son compte courant : dans les prochains jours, le système de recommandation (“recommandations”)
    * comparera le profil généré par le profileur (“profiling”) pour Killian avec le catalogue des produits (“catalog”),
    * et lui proposera de créer un compte (“bank account”) avec un taux plus avantageux.
    */
    void play(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Color.ANSI_CYAN+"--------------------------------------------------------------------");
        System.out.println("                             Scenario 2");
        System.out.println("--------------------------------------------------------------------"+Color.ANSI_RESET);
        //create account Marcel
        createAccount("pass","Jose",45);
        createBankAccount("Jose");
        addMoney("Jose",15000);
        createAccount("word","Killian",24);
        createBankAccount("Killian");
        addMoney("Killian",2300);
        //System.out.println(x);
        scanner.nextLine();
        System.out.println(Color.ANSI_GREEN+"Jose se connecte a son compte utilisateur."+Color.ANSI_RESET);
        //requete login
        //System.out.println("Requete blabla");
        String x = login("pass","Jose");
        System.out.println(x);
        scanner.nextLine();

        System.out.println(Color.ANSI_GREEN+"Jose effectue un virement de 10 000 euros sur le compte de Killian."+Color.ANSI_RESET);
        //requete login
        //System.out.println("Requete blabla");
        x = transfer("Jose","Killian",10000);
        System.out.println(x);
        scanner.nextLine();

        //profiling action
        System.out.println(Color.ANSI_GREEN+"Killian possède donc 12 300 euros.");
        System.out.println("Le profileur a genere un profil pour Killian a partir de ses donnees.");
        System.out.println("Le module de recommandations recupere le profil genere par le profileur."+Color.ANSI_RESET);
        //requete get profile
        System.out.println("Requete blabla");
        System.out.println("reponse blabla");
        scanner.nextLine();
        System.out.println(Color.ANSI_GREEN+"Le module de recommandations recupere les donnees du catalogue et le profil genere par le profileur."+Color.ANSI_RESET);
        //requete get catalog
        System.out.println("Requete blabla");
        System.out.println("reponse blabla");
        scanner.nextLine();
        //action recommendation
        System.out.println(Color.ANSI_GREEN+"Il remarque que Killian possède une somme importante sur son compte");
        System.out.println("Il lui propose donc un compte avec un taux plus avantageux."+Color.ANSI_RESET);
        System.out.println("Proposition blabla");
        System.out.println();
        scanner.nextLine();

    }

    private String createAccount(String pass, String id, int age){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        String result = builder.build().postForObject(REST_URI+":8081/createAccount?password="+pass+"&userId="+id+"&age="+age,null, String.class);
        return result;
    }

    private String createBankAccount(String id){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        String result = builder.build().postForObject(REST_URI+":8080/createBankAccount?userId="+id,null, String.class);
        return result;
    }

    private String login(String pass, String id){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        String result = builder.build().getForObject(REST_URI+":8081/login?password="+pass+"&userId="+id, String.class);
        return result;
    }

    private String addMoney(String id,int amount){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        String result = builder.build().postForObject(REST_URI+":8080/addMoney?userId="+id+"&amount="+amount,null, String.class);
        return result;
    }

    private String transfer(String senderId, String receiverId, int amount){
        RestTemplateBuilder builder = new RestTemplateBuilder();
        String result = builder.build().postForObject(REST_URI+":8080/requestTransfer?senderId="+senderId+"&receiverId="+receiverId+"&amount="+amount,null, String.class);
        return result;
    }
}
