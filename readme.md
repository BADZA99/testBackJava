# Transaction Management API

## Description

Ce projet est une API de gestion des transactions, permettant de créer, lire, mettre à jour et supprimer des transactions. L'API est construite en utilisant Spring Boot et JPA pour la gestion des données.

## Prérequis

- Java 11 ou supérieur
- Maven ou Gradle
- Un IDE comme IntelliJ IDEA ou Visual Studio Code

## Installation

1. Clonez le dépôt :
    ```sh
    git clone https://github.com/votre-utilisateur/votre-repo.git
    cd votre-repo
    ```

2. Importez le projet dans votre IDE préféré.

3. Assurez-vous que vous avez les dépendances nécessaires dans votre fichier `pom.xml` (pour Maven) ou `build.gradle` (pour Gradle).

## Configuration

Assurez-vous de configurer votre base de données dans le fichier `application.properties` :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/votre_base_de_donnees
spring.datasource.username=votre_nom_utilisateur    
spring.datasource.password=votre_mot_de_passe
spring.jpa.hibernate.ddl-auto=update

## run the application

mvn spring-boot:run

## test the application

mvn test

## build the application

mvn package

##endpoints API

http://localhost:8080/transactions

Method: GET

Returns a list of all transactions.

Method: POST

Creates a new transaction.

Request Body:

{
    "description": "Achat de fournitures",
    "type": "dépense",
    "amount": 150.75,
    "date": "2023-08-01T10:00:00.000Z"
}

Method: PUT /{id}

Updates an existing transaction.

Request Body:

{
    "id": 1,
    "description": "Achat de fournitures",
    "type": "dépense",
    "amount": 150.75,
    "date": "2023-08-01T10:00:00.000Z"
}

Method: DELETE /{id}

Deletes an existing transaction.

Request Body:
{
    "id": 1
}

##fichier sql de la base de donnee : transactionsdb.sql a la racine du projet


