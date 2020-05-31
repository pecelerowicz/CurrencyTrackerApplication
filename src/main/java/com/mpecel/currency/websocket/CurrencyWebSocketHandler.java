package com.mpecel.currency.websocket;

import com.mpecel.currency.services.CurrencyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

import static com.mpecel.currency.constants.Constants.*;

@Log4j2
@Service
public class CurrencyWebSocketHandler extends TextWebSocketHandler {

    private CurrencyService currencyService;

    @Autowired
    public CurrencyWebSocketHandler(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        log.info("Received message: " +  message.getPayload());
        currencyService.createOutput(message.getPayload());
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        log.info("Connection established");
        session.sendMessage(new TextMessage(SUBSCRIPTION_PAYLOAD));
        log.info("Subscription payload sent: " + SUBSCRIPTION_PAYLOAD);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        log.error("Transport error");
        exception.printStackTrace();
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
        log.info("Closed connection: " + status.getReason());
    }

}
