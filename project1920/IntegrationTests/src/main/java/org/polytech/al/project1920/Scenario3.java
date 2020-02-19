package org.polytech.al.project1920;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.springframework.boot.web.client.RestTemplateBuilder;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

import java.util.*;

class Scenario3 {
    private String REST_URI;
    private RestTemplateBuilder builder;
    private HashMap<String,String> users;

    Scenario3(String uri) {
        REST_URI = uri;
        builder = new RestTemplateBuilder();
        users = new HashMap<>();
    }

    static Logger root = (Logger) LoggerFactory
            .getLogger(Logger.ROOT_LOGGER_NAME);

    static {
        root.setLevel(Level.ERROR);
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
        getUsers();
        System.out.println(Color.ANSI_CYAN + "--------------------------------------------------------------------");
        System.out.println("                             Scenario 3 : Simulation");
        System.out.println("--------------------------------------------------------------------" + Color.ANSI_RESET);
        scanner.nextLine();
        System.out.println("Noemie, la gestionnaire bancaire veut ajouter un nouveau produit au catalogue.");
        scanner.nextLine();
        System.out.println("Elle commence par regarder le catalogue deja existants pour verifier qu'un produit similaire n'existe pas.");
        scanner.nextLine();
        //getProducts
        String x = getProducts();
        System.out.println(x);
        scanner.nextLine();
        System.out.println("Elle rajoute le produit \"Compte platinium\" pour les personnes possedant plus de 50 000 euros.");
        System.out.println("Elle remplit un formulaire avec les informations suivantes");
        System.out.println(" produit : Compte platinium , condition : money > 50000");
        scanner.nextLine();
        //addProduct
        createProduct("create product Compte_platinium with condition money > 50000");
        scanner.nextLine();
        System.out.println("Elle verifie que le produit a bien ete ajoute.");
        scanner.nextLine();
        //getProduct
        x = getProducts();
        System.out.println(x);
        scanner.nextLine();
        System.out.println("Elle veut lancer une simulation pour voir si son produit est bien pris en compte.");
        scanner.nextLine();
        //lauchSimulation
        //x = reco();
        //System.out.println(x);
        scanner.nextLine();
        System.out.println("Elle veut comparer les resultats de cette simulation aux anciens resultats");
        System.out.println("Elle cherche l'historique des recommandations");
        //getHistory
        String[] res = getCollections();
        scanner.nextLine();
        System.out.println("Elle regarde les deux dernieres recommandations");
        scanner.nextLine();
        //getOldResults
        getDB(res[0]);
        getDB(res[1]);
        scanner.nextLine();
        //System.out.println("Elle voit bien que son produit a ete recommande a certaines personnes");
        //scanner.nextLine();
    }

    private String createProduct(String infos) {
        String fullUri = REST_URI + ":8082/saveProducts?request=" + infos;
        System.out.println(Color.ANSI_BLUE + "REST/POST : " + fullUri + Color.ANSI_RESET);
        return builder.build().postForObject(fullUri, null, String.class);
    }

    private String getProducts() {
        String fullUri = REST_URI + ":8082/getProducts";
        System.out.println(Color.ANSI_BLUE + "REST/GET : " + fullUri + Color.ANSI_RESET);
        return builder.build().getForObject(fullUri, String.class);
    }

    private void getDB(String collection) {
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://server_user:server_password@profiling-88zkw.mongodb.net/test?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        FindIterable<Document> x = database.getCollection(collection).find();
        System.out.println(collection);
        for (Document d: x) {
            String userID = d.get("userID").toString();
            System.out.print(users.get(userID));
            System.out.print(" : ");
            System.out.println(d.get("recommendation"));
        }
        System.out.println();
    }

    private String[] getCollections() {
        HashMap<Date,String> recos = new HashMap<>();
        MongoClientURI uri = new MongoClientURI("mongodb+srv://server_user:server_password@profiling-88zkw.mongodb.net/test?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoIterable<String> x = database.listCollectionNames();
        for (String s: x) {
            String[] splits = s.split(" ");
            if(splits[0].equals("Recomendation") && !splits[1].equals("testHour")){
                System.out.println(s);
                String[] day = splits[1].split("/");
                String[] hours = splits[2].split(":");
                Date date = new Date(Integer.parseInt(day[2]),Integer.parseInt(day[1]),Integer.parseInt(day[0]),Integer.parseInt(hours[0]),Integer.parseInt(hours[1]),Integer.parseInt(hours[2]));
                recos.put(date,s);
            }
        }
        SortedSet<Date> keys = new TreeSet<>(recos.keySet());
        String[] res = new String[2];
        for (Date key : keys) {
            String value = recos.get(key);
            res[1] = res[0];
            res[0] = value;
        }
        return res;
    }

    private void getUsers(){
        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://server_user:server_password@profiling-88zkw.mongodb.net/test?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("test");
        FindIterable<Document> x = database.getCollection("User").find();
        for (Document d: x) {
            users.put(d.get("_id").toString(),d.get("userId").toString());
        }
    }


    private String reco() {
        String fullUri = REST_URI + ":8000/triggerRecommendation";
        System.out.println(Color.ANSI_BLUE + "REST/GET : " + fullUri + Color.ANSI_RESET);
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
