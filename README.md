Sukurti API automobilių nuomos sistemai be autentifikacijos naudojant Java. API turi leisti valdyti automobilius ir klientus, taip pat registruoti nuomos operacijas.

Reikalavimai:

Automobiliai

  Modelis: Car
  
    id (unikalus identifikatorius)
    
    make (gamintojas)
    
    model (modelis)  
    
    year (metai)
    
    available (prieinamumas nuomai, boolean)
    
Klientai

  Modelis: Client
  
    id (unikalus identifikatorius)
    firstName (vardas)
    lastName (pavardė)
    email (el. paštas)
    phone (telefonas)
Nuomos operacijos
  Modelis: Rental
    id (unikalus identifikatorius)
    carId (automobilio id)
    clientId (kliento id)
    rentalDate (nuomos pradžios data)
    returnDate (grąžinimo data, nullable)
API Endpointai
  Automobiliai
    Gauti visus automobilius:
    GET /cars
    Gauti automobilį pagal ID:
    GET /cars/{id}
    Sukurti naują automobilį:
    POST /cars
    Request body: {"make": "...", "model": "...", "year": ..., "available": true}
    Atnaujinti automobilio informaciją:
    PUT /cars/{id}
    Request body: {"make": "...", "model": "...", "year": ..., "available": ...}
    Ištrinti automobilį:
    DELETE /cars/{id}
  Klientai
    Gauti visus klientus:
    GET /clients
    Gauti klientą pagal ID:
    GET /clients/{id}
    Sukurti naują klientą:
    POST /clients
    Request body: {"firstName": "...", "lastName": "...", "email": "...", "phone": "..."}
    Atnaujinti kliento informaciją:
    PUT /clients/{id}
    Request body: {"firstName": "...", "lastName": "...", "email": "...", "phone": "..."}
    Ištrinti klientą:
    DELETE /clients/{id}
  Nuomos operacijos
    Gauti visas nuomos operacijas:
    GET /rentals
    Gauti nuomos operaciją pagal ID:
    GET /rentals/{id}
    Sukurti naują nuomos operaciją:
    POST /rentals
    Request body: {"carId": ..., "clientId": ..., "rentalDate": "YYYY-MM-DD"}
    Atnaujinti nuomos operacijos informaciją (grąžinimo datą):
    PUT /rentals/{id}
    Request body: {"returnDate": "YYYY-MM-DD"}
    Ištrinti nuomos operaciją:
    DELETE /rentals/{id}
    Naudoti MySQL duomenų bazę (lokaliai)
    
