# Enterprise Applications

## Progetto formativo 2022/2023

Realizzare un’applicazione enterprise sulla base di vinted (https://www.vinted.it/). Ogni utente deve poter inserire dei
post pubblici/privati con immagini, foto, ecc. La scelta degli elementi di stile dell’interfaccia grafica (colori, font,
logo, ecc.) è libera.

### Requisiti comuni a tutti i gruppi:

- [X] Uso di Spring per la creazione di API REST
- [X] Uso di JPA per la gestione del mapping su database
- [ ] Meccanismi di autenticazione/autorizzazione:
    - [ ] JWT (In che senso???)
    - [X] OpenID Connect/OAuth2 
- [ ] Implementazione di un client mobile usando Android
- [ ] Implementazione di un sito web per la connessione all’applicazione
- [ ] Implementazione di capabilities per consentire l’accesso ai prodotti nascosti degli utenti

### Bonus

- ~~Uso di un’architettura a microservizi.~~
- [X] Audit logging per le API REST
- [X] Rate limiting per le API REST (es. utilizzando Resilience4J)
  - [ ] Check perche' non logga ????
- [X] Uso di HTTPS per le API REST
- [X] Creare la documentazione delle API REST (es. utilizzando Swagger)
- ~~Testing per le API REST.~~
- [X] Implementazione di un custom authorization server


porte

keycloack 8443
spring 8081
angular 8082

# TODO

- [ ] verifica permessi differenti path con auth server
- [ ] verifica permessi differenti utenti con auth server
- [ ] decidere come rappresentare l'utente nella base di dati, cosa salvarsi dell'utente
- [X] generatore di dati
- [ ] chiedere al prof se va bene keycloak o intende una cosa con auth server (il pacchetto deprecato)
- [X] repositories
- [X] controller
- [ ] service
- [ ] api.rest file completo
- [ ] mutual-TLS
- [ ] accessi basati suoi ruoli
- [ ] sistemare la storia del refresh token in angular

# User story

## Guest

- come guest posso registrarmi usando username/password
- come guest posso registrarmi usando google
- come guest nella home vedo una lista di prodotti pubblici
- come guest posso utilizzare la funzione di ricerca cerca

## Utente registrato

- come utente posso loggarmi alla piattaforma usando username e password
- come utente posso loggarmi alla piattaforma usando il mio account di goole
- come utente nella home vedo una lista di prodotti basata sulle mie preferenze (impostate da me)
- come utente posso mettere un articolo in vendita
- come utente posso modificare i miei articoli in vendita
- come utente posso settare come privato un articolo in vendita (non lo vedono gli altri ma resta nel mio guardaroba)
- come utente posso inserire un articolo (non mio) nella mia lista dei preferiti
- come utente posso modificare la mia lista dei preferiti
- come utente posso condividere i miei prodotti privati (usando il link - capabilities)

## Amministratore (non so se inserirlo)

# Permessi

guest:

- lista prodotti pubblici
- prodotto singolo (se pubblico)

user:

- lista prodotti pubblici
- prodotto singolo (se pubblico o e' owner)
- lista ordini (di cui e' owner o se e' coinvolto un prodotto di cui e' owner)
- ordine singolo (di cui e' owner o se e' coinvolto un prodotto di cui e' owner)
- lista preferiti (ogni utente ha la propria, puo' inserire qualunque oggetto dentro)



# Note

## Capability
Una capability è un riferimento non falsificabile a un oggetto o a un risorsa insieme a un insieme di permessi per accedere a questa risorsa.
Nel caso di API REST le capability sono spesso URI, visto che questo è il formato standard per identificare le risorse. 
Le capability permettono di evitare attacchi di tipo confused deputy, cioè un attacco di questo tipo avviene quando un componente di un sistema con privilegi elevati può essere ingannato da un attaccante per fargli compiere operazioni che l’attaccante non potrebbe compiere. CSRF è un esempio di questo tipo di attacco. 

## Audit

- Creare una tabella sul database per il logging (senza vincoli con altre tabelle).
- La tabella deve contenere almeno un id del log, il metodo chiamato, il percorso dell’API, l’id dell’utente, lo status della request e il timestamp (eventuali altri dati possono essere aggiunti in base alle esigenze).
- Si può creare una pagina riservata agli amministratori per navigare i log.
