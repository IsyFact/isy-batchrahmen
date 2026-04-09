# 5.0.0
### Bug Fixes
- `IFS-4753`: Änderung der Konfigurationsreihenfolge.
  * BatchSecurityConfiguration wird nach Anwendung und BatchRahmen Konfiguration geladen.
  * Beans mit der `@ConditionalOnMissingBean(...)` Annotation können wie erwartet überschrieben werden.

### BREAKING CHANGES
- `IFS-5263`: Update auf Spring Boot 4
  - Password-Authorization wird nicht mehr unterstützt. Es ist stattdessen Client-Secret-Authorization zu nutzen. 
    Hierfür sind die betroffenden Accounts auf Service-Accounts umzustellen.