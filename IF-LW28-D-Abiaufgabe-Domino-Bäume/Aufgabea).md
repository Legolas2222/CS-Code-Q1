# Aufgabe a)
Zunächst sollte man sich bewusst machen, das im rudimentären Binärbaum lediglich die Knoten gespeichert werden und nicht n-viele Dominosteine. Daher muss die Information für die Anzahl der Dominosteine, die in diesem Teilstück stehen, mit in den Knoten gespeichert werden. Dies wird mit einem generischen BinaryTree des Contenttypes Integer erreicht. 

Der entsprechende Baum für Abbildung 1:

              Root / Anstoßpunkt (3) 
        /                                \
        7                                7
     /      \                         /      \
    11       4                       4       11
        /        \               /         \
       3          4             4           3
                /   \         /   \
               12    4       4     12 


Benötigte Takte, bis alle Dominosteine aus Abbildung 1 umgefallen sind:
3 + 7 + 4 + 4 + 12 = 30 Takte 
Dies lässt sich berechnen, indem man den Weg durch den Binärbaum nimmt, dessen Summe der Werte der einzelnen Knoten auf diesem Weg die höchste ist. 

Die Tiefe dieses Binärbaums beträgt 4 (Root Node nicht mitgezählt).

## Der Zusammenhang zwischen der Tiefe des Baumes und der Anzahl der Takte, bis der letzte Stein frühestens fällt:
Im Idealfall, dass jeder Knoten einen Wert von 1 besitzt, ergo das nach jedem Dominostein direkt eine Abzweigung exisitert würde man genau Tiefe-des-Baumes viele Takte benötigen, bis der letzte Stein (frühestens) umfällt.


# Aufgabe b)
Zunächste sollte man eine rekursive Hilfsmethode schreiben, die die Anzahl der Knoten in einem arbiträren BinaryTree zurückgibt, den Sie auch als Parameter übergeben bekommt. Der Rekursionsanker ist dabei die Kondition, dass der als Parameter übergeben BinaryTree leer ist. Für den Fall, dass der Baum nicht leer ist, gibt die Methode die Summe der Knoten der beiden Subbäume wieder, wobei sie sich selbst rekursiv mit den beiden Subbäumen des Paramters aufruft. 
Um schließlich die Anzahl der Verzweigungen in der Dominofigur zu ermitteln, ruft die Methode ```public int ermittleAnzahlVerzweigungen()``` die zuvor erstellte Rekursive Methode ein und übergibt den gesamten Binärbaum der Dominofigur als Parameter. Zuletzt gibt sie das Ergebniss des Aufrufs als Integer zurück