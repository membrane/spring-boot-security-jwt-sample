Voraussetzungen: Java 8, Maven

1. Konsole öffnen

> cd spring-boot-security-jwt-sample
> cd authorization_server
> mvnw spring-boot:run

(laufen lassen, währenddessen weitermachen)


2. Konsole öffnen

> cd spring-boot-security-jwt-sample
> cd resource_server
> mvnw spring-boot:run

3. Membrane starten

membrane-service-proxy-4.6.3-SNAPSHOT.zip entpacken (liegt hier im Git, oder irgendein Release >4.6.2)
proxies.xml im membrane-service-proxy-4.6.3-SNAPSHOT/conf/ Verzeichnis durch die ./proxies.xml (Hauptverzeichnis) ersetzen

> cd membrane-service-proxy-4.6.3-SNAPSHOT
> service-proxy.bat



4. Demo

Im Browser öffnen:
http://localhost:2000/user
oder
http://localhost:2000/admin

Einloggen mit
tobias / 123  (=USER)
till / 123    (=ADMIN)