
 [******   ENONCE COPIé DU SITE CODINGAME.COM     **********]
 Objectif
Vous avez un tableau de width * height cases dans lequel chaque case représente l'état d'une cellule : vivante '1' ou morte '0'. Chaque cellule interagit avec ses huit voisins (horizontalement, verticalement et sur les diagonales) suivant ces quatre règles.

1. Une cellulle vivante qui a moins de deux voisins meurt, pour cause de sous-population.
2. Une cellule vivante qui a deux ou trois voisins reste en vie
3. Une cellule vivante qui a plus de trois voisins meurt, pour cause de sur-population
4. Une cellule morte qui a exactement trois voisins retrouve la vie, grâce à la reproduction des cellules

Écrivez un programme qui calcule l'état suivant du tableau (après une mise à jour) selon son état initial.
Entrée
Ligne 1: Deux entiers séparés par un espace width et height, respectivement la largeur et hauteur du tableau
height lignes suivantes: width caractères ('0' ou '1') qui représentent l'état initial d'une cellule
Sortie
height lignes: width caractères ('0' or '1') qui représentent l'état mis à jour d'une cellule
Contraintes
1 ≤ N, M ≤ 100
Exemple
Entrée

3 3
000
111
000

Sortie

010
010
010


