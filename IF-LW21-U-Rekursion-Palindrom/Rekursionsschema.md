## Rekursionschema 

wenn das Problem elementar ist
    antworte nicht rekursiv
ansonsten
    führe das Problem einen rekursiven Zweig aus,
    der das Problem verkleinert


Für Palindrome:
    wenn wort-länge <=1
        antworte wahr
    sonst
        wenn erster und letzter Buchstabe gleich
            und prüfe palindrom mit wort ohne erstes und letztes zeichen
            antworte wahr
        
        ansonsten
            antworte falsch