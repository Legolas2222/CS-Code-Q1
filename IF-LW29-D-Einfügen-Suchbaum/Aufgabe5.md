a)
1 Schritt:
75
2 Schritte:
42, 102
3 Schritte:
15, 46, 92, 113
4 Schritte:
8, 17, 45, 50, 80, 99, 106, 151


Best case: 
1 Schritt (gesuchtes Element ist gleich der Wurzel)

Worst case: 
4 Schritte (gesuchtes Element befindet sich auf der tiefsten Ebene des Baumes)

Average case:
(1 * 1 + 2 * 2 + 4 * 3 + 8 * 4) / 16 = 3.0625

b)  
Wenn die Wurzel nicht in die Tiefe des Baumes miteinbezogen wird:
Anzahl der Elemente in einem vollständigen Binärbaum der Tiefe n:
$$ Anzahl = 2 ^ {n + 1} $$
Tiefe 4: 
$$2 ^ {4 + 1} = 32$$
Tiefe 5: 
$$2 ^ {5 + 1} = 65$$
Tiefe 6: 
$$2 ^ {6 + 1} = 128$$
 
...
Tiefe 10:
$$2^{10 + 1} = 2048$$ 