# Tucil2_13524120_13524136

| NIM | Nama |
| ---- | --- |
13524120 | Jonathan Alveraldo Bangun
13524136 | Neswa Eka Anggara

## Requirements

### Java
- **Version:** 21 or higher
- **Download links:**
  - [Oracle JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)

### Maven
- **Version:** 3.9.11 or higher
- **Download links:**
  - [Direct Apache Maven Official Downloads](https://maven.apache.org/docs/3.9.11/release-notes.html)

## How to run
1. Compile
```bash
mvn clean package
```
or
```bash
mvn clean compile
```

2. Run
```bash
mvn exec:java -Dexec.mainClass="VoxelizationOctree.App"