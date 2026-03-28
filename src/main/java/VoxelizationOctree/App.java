package VoxelizationOctree;

import VoxelizationOctree.model.ObjParser;
import VoxelizationOctree.core.OctreeNode;
import VoxelizationOctree.util.Statistics;
import VoxelizationOctree.util.VoxelWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("----------------------------------------");
        System.out.println("Voxelization Objek 3D menggunakan Octree");
        System.out.println("Tucil 2 IF2211 Strategi Algoritma");
        System.out.println("Dibuat oleh:");
        System.out.println("13524120 Jonathan Alveraldo Bangun");
        System.out.println("13524136 Neswa Eka Anggara");
        System.out.println("----------------------------------------");
        System.out.println();

        System.out.println("Masukkan alamat file .obj: ");
        String inputFileLocation = scan.nextLine();
        System.out.println();
        System.out.println("Nama file output: ");
        String outputFileLocation = scan.nextLine();
        System.out.println();
        System.out.println("Berapa max depthnya?: ");
        int maxDepth = scan.nextInt();

        scan.close();

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Hasil:");

        ObjParser parser = new ObjParser();
        long startTime = System.currentTimeMillis();

        try {
            parser.parse(inputFileLocation);
            
            double centerX = (parser.minX + parser.maxX) / 2.0;
            double centerY = (parser.minY + parser.maxY) / 2.0;
            double centerZ = (parser.minZ + parser.maxZ) / 2.0;
            double rootSize = parser.getMaxSize();

            OctreeNode root = new OctreeNode(centerX, centerY, centerZ, rootSize, 0);
            root.subdivide(maxDepth, parser.faces);

            List<OctreeNode> voxels = new ArrayList<>();
            root.collectLeafVoxels(voxels);

            long duration = System.currentTimeMillis() - startTime;
            VoxelWriter.writeToFile(voxels, "test/output/"+outputFileLocation+".obj");

            Statistics.display(maxDepth, duration, "test/output/"+outputFileLocation+".obj", voxels.size());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}