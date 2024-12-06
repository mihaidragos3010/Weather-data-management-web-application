
Student: Mihai Dragos-Andrei
Grupa: 342C5

# Tema 2 SCD

# Introducere

In realizarea temei am folosit ca si tehnologie de backend un server de Spring Boot. Pe partea de 
baze de date am ales MS SQL (Microsoft Server SQL). 

### Inplementare Server
In cadrul proiectului am implementat un server de backend, utilizand tehologiile oferite de Spring Boot. Artitectura aplicatiei este
realizata peste arhitectura MVC. Sunt Definite clase de tip @Controller care au rolul de a defini endpoint-urile aplicatiei. Pentru 
procesare am folosit clasele de tip @Service. Comunicarea cu baza de date se realizeaza de clasele @Repository. Structurile de tip "*Dto"
au rolul de a defini structurile externe, cele care se folosesc in comunicarea cu clientul. Din cauza constrangerilor temei, am ales 
sa returnez, dupa caz, obiecte de tip @Entity. Am folosit un handler global pentru prinderea exceptiilor pentru intregul server, si pentru
intoarcerea catre client a unor raspunsuri valide si usor de inteles.

### Implementare Database
In cadrul bazei de date am folosit tehnologiile oferite de MS SQL. Tabelele bazei de date sunt contruide de server Spring la prima
conectare. Clasele @Entity au rolul de a defini structura tabelelor, constrangerile si relatiile dintre ele. Parola pentru user-ul
"sa" a fost definita la initializarea containerului de Docker.

### Definire Containere de Docker
In contructia aplicatiei am folosit un fisier de tip docker-compose. El are rolul de a initializa o baza de date, folosind o imagine 
predefinita din DockerHub. Persistenta datelor este garantata de definirea unui volum, gestionat de agentul de docker.
Pentru initializarea server de Spring am folosit un fisier Dokerfile, la baza are o imagine de maven cu java 17 la care am 
adaugat codul sursa ar server si pom.xml, folosit pentru a defini dependintele utilizate. Ambele containere au fost introduse intr-un
network, cu numele de "global".
# Executie

Pentru a initializa containerele de server si database
    
    docker-compose up

Pentru a opri containerele, sterge volumes si sterge reteaua folosita

    docker-compose down --volumes

    
