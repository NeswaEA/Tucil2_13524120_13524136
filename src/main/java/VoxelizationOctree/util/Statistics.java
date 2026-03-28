package VoxelizationOctree.util;

import java.util.TreeMap;
import java.util.Map;

public class Statistics {
    private static final Map<Integer, Integer> nodesDibentuk = new TreeMap<>();
    private static final Map<Integer, Integer> nodesTidakPerlu = new TreeMap<>();

    public static void catatNodeDibentuk(int depth) {
        if (depth > 0) {
            nodesDibentuk.put(depth, nodesDibentuk.getOrDefault(depth, 0) + 1);
        }
    }

    public static void catatNodeTidakPerlu(int depth) {
        if (depth > 0) {
            nodesTidakPerlu.put(depth, nodesTidakPerlu.getOrDefault(depth, 0) + 1);
        }
    }

    public static void display(int maxDepth, long durationMs, String outputPath, int totalVoxels) {
        System.out.println();
        System.out.println("Banyaknya voxel yang terbentuk: " + totalVoxels);
        System.out.println("Banyaknya vertex yang terbentuk: " + totalVoxels*8);
        System.out.println("Banyaknya faces yang terbentuk: " + totalVoxels*12);
        
        System.out.println();
        System.out.println("Banyaknya node octree yang terbentuk (tiap depth):");
        for (int i = 1; i <= maxDepth; i++) {
            System.out.printf("%d : %d", i, nodesDibentuk.getOrDefault(i, 0));
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Banyaknya node yang tidak perlu ditelusuri (tiap depth):");
        for (int i = 1; i <= maxDepth; i++) {
            System.out.printf("%d : %d", i, nodesTidakPerlu.getOrDefault(i, 0));
            System.out.println();
        }

        System.out.println();
        System.out.println("Kedalaman octree: " + maxDepth);
        System.out.println("Lama waktu program berjalan: " + durationMs + " ms");
        System.out.println("File disimpan di: " + outputPath);
    }
}