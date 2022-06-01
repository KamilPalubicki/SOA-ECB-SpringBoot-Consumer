# SOA-ECB-SpringBoot-Consumer
#### Aplikacja SpringBoot mająca na celu nasłuchiwanie kafki i przy pojawieniu się nowych rekordów wpisanie ich do bazy danych SQLite

### Na chwilę obecną:  
Aplikacja Spring Boot nasłuchuje Kafkę i przy pojawianiu się nowych rekordów dodaje je do bazy danych, przy uruchomieniu baza się zeruje, aby pojawiły się w niej dane należy uruchomić następnie pierwszy mikroserwis.

### Jak włączyć:  
Uruchomić Kafka Zookeeper  
Uruchomić Kafka Server  
Uruchomić aplikację  
Uruchomić [pierwszy mikroserwis](https://github.com/bchanowski/SOA-ECB-SpringBoot-Producer-With-Kafka)
Uruchomić [trzeci mikroserwis](https://github.com/Kacper-Pohl/SOA-ECB-SpringBoot-API) - Api
