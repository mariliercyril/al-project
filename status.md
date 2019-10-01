#V5: MARKETING WEBSITE



####Plan proposé pour définir le périmètre de notre projet :

1. Présentation de l’architecture globale du système (avec la situation de chaque V)
2. Description du périmètre de notre V, en commençant par définir l’idée générale (en ayant à l’esprit que la notion centrale est la recommandation, sur du profilage), avec quelques “use case” (chaque “use case” appartenant à un groupe de “produits/services” bancaires différent) présenté comme des “user story” (donc sans rentrer dans des choses techniques)
3. Liste (sans doute non exhaustive) des produits/services (bancaires) auxquels nous avons déjà pensé (répartis selon plusieurs grands groupes) en commençant peut-être par préciser que chaque “user story” précédemment formulée appartient à l’un de ces groupes
4. Donner quelques pistes à propos des techniques de profilage (faire quelques recherches à ce sujet)


####1.	Architecture et périmètre globaux du système (avec la situation de chaque variante)

![alt text](https://github.com/FrereB/AL1920/blob/master/Architecture.pdf "architecture")

Nous avons choisi d’afficher sur notre schéma d’architecture les endroits où les différentes variantes peuvent entrer en effet. Cela nous permet d’avoir une vision plus globale du projet et de comprendre du mieux possible les différents aspects du système à développer.

Voici le scope choisi pour le projet sous forme d’user story, nous détaillerons le périmètre choisi pour la variante 5 ensuite :

* En tant que client, je souhaite créer un compte et renseigner mes détails. (US1)  
* En tant que client, je souhaite pouvoir résilier mon compte. (US2)  
* En tant que client, je souhaite pouvoir ajouter de l’argent sur mon compte. (US3)  
* En tant que client, je souhaite pouvoir utiliser mon compte afin de payer. (US4)  
* En tant que client, je souhaite avoir une carte bancaire. (US5)  
* En tant que client, je souhaite pouvoir annuler ma carte bancaire. (US6)  
* En tant que client, je souhaite pouvoir me connecter à mon compte. (US7)  
* En tant que client, je souhaite pouvoir effectuer un virement. (US8)  
* En tant que client, je souhaite avoir accès à l’ensemble des produits et services proposés par la banque. (US9)  
* En tant que client, je souhaite pouvoir choisir un produit ou un service proposé par la banque. (US10)  
* En tant que client, je souhaite pouvoir contacter mon conseiller bancaire. (US11)  
* En tant que conseiller, je souhaite pouvoir créer un compte pour un client. (US12)  
* En tant que conseiller, je souhaite pouvoir clôturer le compte d’un client. (US13)  
* En tant que conseiller, je souhaite pouvoir ajouter et supprimer une carte bancaire au compte d’un client. (US14)  
* En tant que conseiller, je souhaite pouvoir surveiller le compte d’un client. (US15)  
* En tant que conseiller, je souhaite pouvoir bloquer un compte (par exemple retirer l’accès à la carte bancaire) d’un client. (US16)  
* En tant que conseiller, je souhaite pouvoir accéder à la liste des clients dont je gère le compte. (US17)  
* En tant que conseiller, je souhaite pouvoir contacter un client dont je gère le compte. (US18)  

Concernant la création de compte, un utilisateur possédera un profil sur l’application, où il pourra avoir accès à un ou plusieurs comptes bancaires.

####2.	Périmètre de notre variante

Notre variante consiste à intégrer un aspect webmarketing au projet à travers la conception, la mise en œuvre et la maintenance d’un système de recommandation de produits ou services de la banque, en se basant sur le profil des clients. Il peut être intéressant de nous tenir informés de ce que font les autres équipes, car elles proposeront peut-être des produits ou services pouvant être recommandés dans notre projet.

#####2.1	Nos utilisateurs

Le système sera utilisé par les personnes suivantes :
* Un client de la banque (professionnel comme particulier)
* Un conseiller bancaire

#####2.2	Ce que nous avons l’intention de couvrir d'un point de vue fonctionnel

Dans le cadre de notre variante (variante 5), nous voulons mettre en place les user story suivantes :

* En tant que client déménageant dans un autre pays, je souhaite qu’on me propose une solution adaptée au pays dans lequel je vais vivre. (USV1)  
* En tant que client bientôt majeur, je souhaite recevoir une offre qui m’aide à m’engager. (USV2)  
* En tant que client venant de perdre son emploi, je souhaite recevoir une proposition de formule adaptée à mes revenus diminués. (USV3)  
* En tant que client achetant fréquemment sur Internet, je souhaiterais qu’on me recommande un produit qui facilite les achats en ligne. (USV4)  
* En tant que client économe, je souhaite recevoir une notification lorsqu’une activité suspecte a lieu sur mon compte. (USV5)  

*USV = user story pour notre variante

Quelle que soit la fonction, la recommandation doit être appropriée.

#####2.3	Ce qui est en dehors du périmètre

Les produits proposés à la suite d’une demande d’un client ou directement par le conseiller sont en dehors du périmètre. En effet, il faut toujours avoir à l’esprit le terme principal du sujet de notre variante, qui est la “recommandation”, et qui se fera de façon automatique.

La gestion complète des produits n’entre pas dans le périmètre de notre projet car nous nous concentrerons sur la partie bancaire principalement. Nous implémenterons donc seulement une gestion simplifiée des produits afin de démontrer l’aspect principal de recommandation.


####3.	Liste des types de produit et service auxquels nous avons déjà pensé

Chaque “USV” précédemment formulée appartient à l’un de ces types :

* Produits recommandés en fonction du pays dans lequel le client est localisé
* Produits recommandés en fonction de l’âge du client (livret jeune, livret A, compte d’épargne, PEL…)
* Produits recommandés en fonction de la situation professionnelle du client (crédit, prêt, carte…)
* Produits recommandés en fonction de certains comportements du client (service de facilitation des paiements en ligne…)
* Services de notification (en cas d’opération suspecte sur un compte, en cas de comportement à risque…)


####4.	Quelques pistes à propos des méthodes de profilage

Les algorithmes de profilage que nous mettrons en œuvre prendront en compte des données “statiques”, telles que les noms, âges ou encore les localisations, et des données “dynamiques”, telles que les historiques des clients (afin de dégager des habitudes de consommation).

Après quelques premières recherches sur les méthodes de profilage, nous avons trouvé certaines méthodes de filtrage collaboratif (“collaborative filtering”) intéressantes, telles que la méthode du “filtrage collaboratif passif”, par exemple, qui, consistant à analyser les comportements en “arrière-plan”, pourraient nous permettre de satisfaire à la “USV” 4 – au moins, partiellement.
