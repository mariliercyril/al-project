package org.polytech.al.project1920;

import org.springframework.boot.web.client.RestTemplateBuilder;

public class Application {

    public static void main(String[] args) {
        RestTemplateBuilder builder = new RestTemplateBuilder();

        String uri = "http://192.168.99.100";
        Scenario1 scenario1 = new Scenario1(uri);
        scenario1.play();
        System.out.println();
        Scenario2 scenario2 = new Scenario2(uri);
        scenario2.play();

        /*System.out.println(Color.ANSI_CYAN+"--------------------------------------------------------------------");
        System.out.println("                             Pretty Dump");
        System.out.println("--------------------------------------------------------------------"+Color.ANSI_RESET);
        String result = builder.build().getForObject(uri+":8081/prettyDump", String.class);*/
    }

}