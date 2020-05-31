**Currency tracker application**</br>

The application runs on the default **port 8080**. It exposes one endpoint (below):</br>

localhost:8080/pairs</br>

Additionally it exposes another endpoint for each individual pair of currencies</br>
(currency pair identificator is case insensitive):</br>

localhost:8080/pair/btcusd</br>
localhost:8080/pair/ethusd</br>
localhost:8080/pair/btceur</br>
localhost:8080/pair/etheur</br>

The application returns the newest data received from the websocket api.

