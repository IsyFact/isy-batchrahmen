# 5.0.0
### Features
- `IFS-5259`: Maximale Anzahl automatischer Neustarts für fehlerhafte Batches konfigurierbar.
  * Über den Konfigurationsparameter `Batchrahmen.MaxWiederholungen` kann eine Obergrenze für automatische Neustarts festgelegt werden.
  * Bei Überschreitung wird eine `BatchrahmenMaxWiederholungenException` geworfen, die nur auf Info-Niveau geloggt wird.
  * Ist der Parameter nicht oder auf eine negative Nummer gesetzt, gibt es keine Begrenzung der Neustarts.

### Bug Fixes
- `IFS-4753`: Änderung der Konfigurationsreihenfolge.
  * BatchSecurityConfiguration wird nach Anwendung und BatchRahmen Konfiguration geladen.
  * Beans mit der `@ConditionalOnMissingBean(...)` Annotation können wie erwartet überschrieben werden.

### BREAKING CHANGES
- `IFS-5263`: Update auf Spring Boot 4
  - Password-Authorization wird nicht mehr unterstützt. Es ist stattdessen Client-Secret-Authorization zu nutzen. 
    Hierfür sind die betroffenden Accounts auf Service-Accounts umzustellen.