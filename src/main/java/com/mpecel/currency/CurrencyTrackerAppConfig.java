package com.mpecel.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mpecel.currency.constants.Constants;
import com.mpecel.currency.websocket.CurrencyWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@Configuration
public class CurrencyTrackerAppConfig {

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public StandardWebSocketClient getStandardWebSocketClient() {
        return new StandardWebSocketClient();
    }

    @Bean
    public WebSocketConnectionManager getWebSocketConnectionManager(CurrencyWebSocketHandler currencyWebSocketHandler,
                                                                    StandardWebSocketClient standardWebSocketClient) {
        return new WebSocketConnectionManager(standardWebSocketClient, currencyWebSocketHandler, Constants.URI);
    }
}
