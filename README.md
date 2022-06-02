# SOA-ECB-SpringBoot-Consumer
#### Aplikacja SpringBoot mająca na celu nasłuchiwanie kafki i przy pojawieniu się nowych rekordów wpisanie ich do bazy danych SQLite

### Na chwilę obecną:
Aplikacja Spring Boot przy uruchomieniu pobiera dane na 90 dni wstecz z XML'a ECB oraz ma schedule pobierania daily danych od poniedziałku do piątku(poza świętami) o godz. 16:10(dane pojawiają się na ECB około 16), następnie wysyłe je do kafki

### Jak włączyć:  
1. Uruchomić Kafka Zookeeper  
2. Uruchomić Kafka Server  
3. Uruchomić aplikację  
4. Uruchomić [pierwszy mikroserwis](https://github.com/bchanowski/SOA-ECB-SpringBoot-Producer-With-Kafka)
5. Uruchomić [trzeci mikroserwis](https://github.com/Kacper-Pohl/SOA-ECB-SpringBoot-API) - Api
