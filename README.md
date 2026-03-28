# Tugas Kecil 2 IF2211 Strategi Algoritma 

| NIM | Nama |
| ---- | --- |
13524120 | Jonathan Alveraldo Bangun
13524136 | Neswa Eka Anggara

## VoxelizationOctree
Sebuah program yang dapat mengkonversi model .obj yang umum menjadi model .obj yang terdiri dari voxel dengan memanfaatkan properti Octree. Program melakukan konversi model dengan menggunakan algoritma divide and conquer.


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

2. Run

Windows
```bash
mvn exec:java "-Dexec.mainClass=VoxelizationOctree.App"
```
  Linux
```bash
mvn exec:java -Dexec.mainClass="VoxelizationOctree.App"
```

3. Ikuti petunjuk pada CLI
