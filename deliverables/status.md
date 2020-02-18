# V5 : MARKETING WEBSITE

Week 08 ![flag](https://placehold.it/15/00ff00/000000?text=+)
-

* Cette semaine, nous avons finalisé le code. A cause de difficultés techniques (version étudiante d'AWS empêchant d'entraîner un modèle), le modèle de recommandation est mocké, mais la façon de s'y connecter correspond à celle d'un vrai modèle.
* Objectifs pour la semaine 9 : corriger les derniers petits bugs, prendre des mesures de temps complémentaires et continuer à préparer la démonstration.
* Nous ne rencontrons pas de difficultés techniques pour le travail de cette semaine.

Week 07 ![flag](https://placehold.it/15/ffff00/000000?text=+)
-

* Cette semaine, nous avons fait des avancées concernant les fonctions AWS (nous pouvons lire les données que nous générons pour entraîner un modèle)
* Objectifs pour la semaine 8 : finaliser le code afin de préparer la démonstration.
* Nous rencontrons des difficultés techniques avec AWS puisque notre offre ne permet pas d'entraîner un modèle. Nous cherchons donc une solution pour contourner ce problème (utiliser un modèle déjà entraîné par exemple).

Week 06 ![flag](https://placehold.it/15/00ff00/000000?text=+)
-

* Cette semaine, nous avons fait des avancées dans le code. Nous avons terminé la mise en place du DSL basique, avancé grandement sur les fonctions Lambda AWS et nous avons peuplé nos bases de données pour entraîner notre modèle de recommandation.
* Objectifs pour la semaine 7 : nous souhaitons avancer la mise en place des nouvelles fonctionnalités, notamment en commençant l'entraînement du modèle.
* Nous rencontrons quelques difficultés techniques pour le moment car nous ne sommes pas familiers avec le machine learning, mais nous arrivons à progresser.


Week 05 ![flag](https://placehold.it/15/ffff00/000000?text=+)
-

* Cette semaine, nous avons fait des avancées au niveau du code suite à la restructuration de notre architecture. Nous avons commencé la prise en main des fonctions Lambda AWS, commencé la mise en place du DSL pour l'ajout des produits ainsi que pris des décisions concernant le peuplement des bases de données pour l'entraînement du modèle de machine learning.
* Objectifs pour la semaine 6 : avancer la mise en place des nouvelles fonctionnalités, peupler des bases de données pour entraîner un modèle externe.
* Nous rencontrons quelques difficultés techniques pour découvrir des modèles de machine learning et adapter nos données. En dehors de cela, l'avancée du code prend simplement du temps.


Week 04 ![flag](https://placehold.it/15/00ff00/000000?text=+)
-

* Cette semaine, suite à une intervention d'un industriel à propos des fonctions Lambda AWS, nous avons à nouveau réfléchi aux modifications à apporter à notre architecture. 
* Objectifs pour la semaine 5 : nous souhaitons avancer la mise en place des nouvelles fonctionnalités, en découvrant les nouvelles technologies à notre disposition (lambda AWS et DSL pour ajouter un produit au catalogue).
* Nous ne rencontrons aucune difficulté technique pour le moment, nous nous concentrons sur l'avancée du code et la restructuration de l'architecture.


Week 03 ![flag](https://placehold.it/15/00ff00/000000?text=+)
-

* Cette semaine, nous avons discuté des modifications à mettre en place sur notre architecture pour répondre aux nouvelles exigences du sujet.
* Objectifs pour la semaine 4 : nous souhaitons améliorer notre base de code et commencer la mise en place des nouvelles fonctionnalités.
* Nous ne rencontrons aucune difficulté technique pour le moment, nous devons nous concentrer sur l'avancée du code.


Week 46 ![flag](https://placehold.it/15/00ff00/000000?text=+)
-

* Cette semaine, nous avons terminé l'implémentation des deux premiers scénarios et préparé notre démo. Nous n'avons pas modifié l'architecture actuelle mais avons réfléchi à des façons de l'améliorer pour implémenter le scénario 3 correctement. Ainsi, nous avons prévu une architecture pour le futur, que nous avons ajouté à la fin du dossier d'architecture, en expliquant les principaux changements.
* Objectifs pour janvier : nous souhaitons implémenter le scénario 3 puis adapter notre architecture aux nouvelles exigences qui nous seront communiquées dans le futur.
* Nous ne rencontrons aucune difficulté technique pour le moment mais il a été compliqué de terminer le projet dans les temps avec un membre en moins.

Week 45 ![flag](https://placehold.it/15/00ff00/000000?text=+)
-

* Cette semaine, nous avons programmé afin d'avancer l'état du projet. Le système de recommandation est fonctionnel pour nos deux premiers scénarios. Il manque quelques fonctionnalités dans le reste du code pour terminer les deux scénarios. Nous n'avons pas modifié l'architecture.
* Objectifs de la semaine 46 : Nous souhaitons terminer l'implémentation des deux premiers scénarios, et éventuellement implémenter le troisième scénario défini dans le dossier d'architecture.
* Nous ne rencontrons aucune difficulté technique pour le moment, mais Cyril n'est malheureusement plus présent à Polytech et nous sommes donc uniquement un groupe de trois personnes pour la fin du projet.

Week 44 ![flag](https://placehold.it/15/00ff00/000000?text=+)
-

* Cette semaine, nous avons principalement programmé afin d'avancer l'état du projet. Nous avons commencé l'implémentation de nos deux premiers scénarios en parallèle, chaque membre de l'équipe s'occupant d'un bloc de composants. L'architecture n'a pas été modifiée mais nous avons apporté des éléments de détails et de justification au rapport d'architecture. Le walking skeleton est en place mais il n'est pour le moment pas automatisé.
* Objectifs de la semaine 45 : Nous souhaitons terminer l'implémentation des deux premiers scénarios et proposer des justifications complètes pour chacun de nos choix. Nous souhaitons également mettre en place des tests d'intégration pour dérouler nos scénarios automatiquement.
* Nous ne rencontrons aucune difficulté technique pour le moment, nous devons simplement concentrer nos efforts sur l'avancée du code.

Week 43 ![flag](https://placehold.it/15/ffff00/000000?text=+)
-

* Cette semaine nous avons fait les choix technologiques principaux, créé une majorité des composants (ceux qui sont utiles pour le MVP). Les composants sont écrits dans des langages différents, ils sont pour la plupart reliés à une BDD. L'ensemble du projet tourne dans un "docker-compose". À l'heure actuelle, il n'y a pas de logique "métier" entre les composants, nous n'avons fait qu'initier un "walking skeleton". En outre, en plus de Docker, nous avons introduit un "build" (à chaque "push", entre autres) par Travis CI. Rien n'a été ajouté au contenu du rapport d'architecture.
* Objectifs de la semaine 44 : mettre en place une véritable communication entre les composants, de sorte à obtenir un "walking skeleton" ; commencer à développer le bloc du système de recommandation.
* Nous ne bloquons sur aucun point pour le moment, bien que nous ayons pris du retard.

Week 42 ![flag](https://placehold.it/15/00ff00/000000?text=+)
-

* Cette semaine nous avons ajouté des composants qui manquaient au diagramme de composants. Nous avons choisi les technologies que nous allons utiliser, défini les interfaces entre les composants et mis en place le projet (créé une branche de développement, mis en place le projet au sens de Maven, avec les dépendances pour Spring).
* Objectifs de la semaine 43 : finir la mise en place du projet (introduction de Docker) et implémenter un "walking skeleton".
* Nous ne bloquons sur aucun point pour le moment.

Week 41 ![flag](https://placehold.it/15/00ff00/000000?text=+)
-

* Cette semaine nous avons réfléchi, étudié et commencé le diagramme de composants. Nous avons revu les utilisateurs (ajout du cas d'un prospect).
* Objectifs de la semaine : Finir le diagramme de composants. Créer des scénarios pour vérifier que le tout est cohérent. Réfléchir aux choix technologiques.
* Nous ne bloquons sur aucun point pour le moment.

Week 40 ![flag](https://placehold.it/15/00ff00/000000?text=+)
-

* Cette semaine nous avons défriché le sujet. Nous nous sommes concentrés sur le cœur dans un premier temps puis nous nous sommes penchés sur notre variante dans un deuxième temps. Cela nous a permis de déterminer le périmètre de notre projet.
* A l'heure actuelle nous réfléchissons à l'architecture du projet, aux technologies que nous allons utiliser ainsi qu'à la manière dont nous allons appréhender ce projet : Que faut-il mettre en place rapidement ? Quelles sont les fonctionnalités qui ont de la valeur ? Etc.
* Nous ne bloquons sur aucun point pour le moment.
