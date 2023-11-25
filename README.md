# tp_JavaServer-Faces-JSF-
# Gestion des Employés 

Bienvenue dans l'application de gestion des employés. Cette application a été développée avec JSF et Hibernate pour permettre la gestion des services et des employés au sein d'une entreprise.

## Fonctionnalités

### 1. Gestion des Services

- Affichage de la liste des services.
- Ajout d'un nouveau service.
- Modification et Suppression d'un service.

### 2. Gestion des Employés

- Ajout d'un employé avec les informations telles que nom, prénom, date de naissance, le chef du service auquel l'employé est affecté, le service et une photo.
- Affichage des employés par chef de service et donc la liste des collaborateurs.
- Modification des informations d'un employé.
- Suppression d'un employé.

### 3. Statistiques

- Affichage d'un graphique montrant le nombre d'employés par service.

## Structure du Projet

- `entities`: Contient les entités Employe et Service.
- `services`: Contient les classes de service, dont AbstractFacade pour les opérations CRUD génériques.
- `pages`: Contient les pages web JSF, y compris celles pour la gestion des services et des employés graphe.

## Capture de la Base de donnée :

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/6f312e17-3dac-4f95-a9f6-c6b70584d0fd)

## Page d'authentification :

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/049e8d8b-ee4a-439f-b8a6-d70b04a4c12c)

## Les Differentes interfaces du projet :

1. Gestion des Services

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/67c9bcf4-84ce-424b-913d-5f99f819a231)

2. Gestion des Employés

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/d0572bda-e952-4345-ab2d-991e06d4de0f)

3. Statistiques
   
![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/c297ccc0-c49f-4be7-8ebf-797b489b89b2)

## CRUD TEST :

1. Gestion des Services

- Ajout d'un service :

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/509f573d-bec1-49a9-9254-2c42d6274e72)

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/a5f17c83-7eba-440e-ab6f-0bbd5c40e1d3)

- Modification des informations d'un service :

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/2c5e6a16-b60f-4b9d-a9b8-95409b47466c)

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/1998bcc0-17fc-46b4-9403-db83039b710a)

- Suppression d'un service :
  
![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/af965651-ee54-452c-aeaa-8128e3f5a9bb)

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/8b760183-a48e-4596-8346-8f27111696ad)


2. Gestion des Employés

- Ajout d'un employé :

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/a3a401c9-11b0-4e55-9c52-4e622112f2f5)

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/9d89bdb7-3c40-4616-a42e-1ec8dcae5c63)

- Affichage de la liste des collaborateurs :

   Exemple 1 filtrage par chef ' BAGHDAD GHITA ' :
  
![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/2ad3ff78-93ad-4c15-a787-18110112e2c6)

  Exemple 2 filtrage par chef ' CHOUFANI ZINEB ' :

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/047d1a45-7d64-419d-a79a-7f6542ad2193)
 
- Modification des informations d'un employé :

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/e282baea-c194-4849-b558-1daac5e1ebf5)

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/3db9e4b4-af59-4444-b1c9-851eb0efd877)

- Suppression d'un employé :
  
![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/89bf3399-3988-445d-99a9-845d8d0b696b)

![image](https://github.com/ghita-baghdad/tp_JavaServer-Faces-JSF-/assets/147449053/46089951-a85d-4b2e-9d69-ba341bee9669)

## Conclusion
Ce projet a été développé en tirant parti de la puissance de JavaServer Faces (JSF) pour fournir une application web de gestion des employés. 
JSF a permis de créer une interface utilisateur dynamique et réactive, PrimeFaces a été essentiel pour enrichir l'interface utilisateur facilitant 
l'interaction avec les fonctionnalités de gestion des services et des employés.



