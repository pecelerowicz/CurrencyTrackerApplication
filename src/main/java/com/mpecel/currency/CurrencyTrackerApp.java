package com.mpecel.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.client.WebSocketConnectionManager;

@SpringBootApplication
public class CurrencyTrackerApp implements CommandLineRunner {

    private WebSocketConnectionManager webSocketConnectionManager;

    @Autowired
    public CurrencyTrackerApp(WebSocketConnectionManager webSocketConnectionManager) {
        this.webSocketConnectionManager = webSocketConnectionManager;
    }

    @Override
    public void run(String... args) throws Exception {
        webSocketConnectionManager.start();
    }

    public static void main(String[] args) {
        SpringApplication.run(CurrencyTrackerApp.class, args);
    }

}