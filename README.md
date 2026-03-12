[![License](https://img.shields.io/badge/License-Apache_2.0-orange)](https://opensource.org/licenses/Apache-2.0)
![GitHub Sprache](https://img.shields.io/badge/Language-Java_25-orange)
![GitHub Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-green)


# isy-batchrahmen

## Beschreibung

Der **IsyFact Batchrahmen** ist ein standardisierter technischer Rahmen zur Umsetzung und Ausführung von **Batchverarbeitungen** innerhalb einer IsyFact-konformen Anwendungslandschaft. Er stellt wiederverwendbare Querschnittsfunktionen (insbesondere für Start/Initialisierung, Konfiguration und Laufzeitverhalten) bereit, damit Batches einheitlich aufgebaut, betrieben und überwacht werden können.

## Features

- **Einheitlicher Bootstrapping-/Startmechanismus** für Batches (standardisierte Ausführung/Initialisierung im IsyFact-Kontext).
- **Gezieltes Exkludieren von Beans aus dem Batch-Kontext** über `@ExcludeFromBatchContext`, um z. B. Anwendungs-Beans nicht in den Batch-Lauf zu ziehen.

## Installation

Weiterführende Informationen zur Installation und zum Einbinden der Bibliothek findest du in der offiziellen Dokumentation:
https://isyfact.github.io/isyfact-standards-doku/dev/einstieg/tutorial/inhalt.html#einbinden-der-bibliothek

### Dokumentation

Informationen über den Aufbau eines Batches findest du in der IsyFact-Dokumentation:
https://isyfact.github.io/isyfact-standards-doku/dev/referenzarchitektur/software-technisch/batch/batchrahmen.html

### Mitwirken

Wir freuen uns über Beiträge zur Weiterentwicklung von isy-batchrahmen.

### Lizenz

Die Software des Projekts ist unter der Apache License, Version 2.0 ([Apache-2.0](LICENSE)) lizenziert.
Die Dokumentation des Projekts ist unter der Namensnennung 4.0 International ([CC-BY-4.0](docs/LICENSE)) lizenziert.

### Kontakt

__Vielen Dank für die Verwendung von isy-batchrahmen!__
Bei Fragen oder Anmerkungen können Sie uns unter folgender E-Mail-Adresse kontaktieren: [isyfact@bva.bund.de](mailto:isyfact@bva.bund.de)
