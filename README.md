**Currency tracker application**</br>

The application runs on the default **port 8080**. It exposes one endpoint and **accetpts 4 values** (currency pair identificator is case insensitive):</br>

localhost:8080/currency/btcusd</br>
localhost:8080/currency/ethusd</br>
localhost:8080/currency/btceur</br>
localhost:8080/currency/etheur</br>

The application returns the newest data received from the websocket api, for each selected pair of currencies.

