Aufgabe a)
Die Klasse Verwaltung hält zunächst alle Grundstücke in Form einer Liste Fest.
Sie dients als übergeordnete Klasse für das Verwaltungssystem und enthält Methoden um neue Grundstücke und Einbrüche hinzuzufügen. Dabei repräsentiert die Klasse Grundstück ein einziges Grundstück. Es kennzeichnet sich durch eine Straße, Hausnummer, und den Gefährdungsindex aus und besitzt an sich eine Liste aller Einbrüche, die auf diesem Grundstück geschehen sind. Ein konkreter Einbruch kennzeichnet sich durch durch die Eigenschaft aus, ob dieser aufgeklärt ist, sowie eine Tatzeit, die ein konkretest Datum mit Uhrzeit repräsentiert.

Bei der Liste der Einbrüche ist es sinnvoll diese als Liste darzustellen, da zunächst mehrere und neue Einbrüche stattfinden können, wodurch die übergreifende Datenstrukture dynamisch sein sollte.
Im Vergleich zum Stack oder Queue ist es aber auch sinnvoll auf spezifische Einbrüche zugreifen zu können, falls sich ein Einbruch aufklären sollte, weshalb nur die Datenstruktur Liste in Frage kommt.