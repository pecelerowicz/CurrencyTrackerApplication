**Currency tracker application**</br>

The application runs on the default **port 8080**. It exposes one endpoint for all data bundled together (below):</br>

localhost:8080/pairs</br>

Additionally it exposes another endpoint for each individual pair of currencies</br>
(currency pair identificator is case insensitive):</br>

localhost:8080/pairs/btcusd</br>
localhost:8080/pairs/ethusd</br>
localhost:8080/pairs/btceur</br>
localhost:8080/pairs/etheur</br>

The application returns the newest data received from the websocket api.

