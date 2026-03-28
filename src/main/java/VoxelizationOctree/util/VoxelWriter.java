package VoxelizationOctree.util;

import VoxelizationOctree.core.OctreeNode;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class VoxelWriter {
    public static void writeToFile(List<OctreeNode> voxels, String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            int vIdx = 1;
            for (OctreeNode voxel : voxels) {
                double x = voxel.getX();
                double y = voxel.getY();
                double z = voxel.getZ();
                double h = voxel.getSize() / 2.0;

                // Ini buat vertice (1 voxel = 8 vertice)
                writer.write(String.format("v %f %f %f\n", x - h, y - h, z - h)); 
                writer.write(String.format("v %f %f %f\n", x + h, y - h, z - h)); 
                writer.write(String.format("v %f %f %f\n", x + h, y + h, z - h)); 
                writer.write(String.format("v %f %f %f\n", x - h, y + h, z - h)); 
                writer.write(String.format("v %f %f %f\n", x - h, y - h, z + h)); 
                writer.write(String.format("v %f %f %f\n", x + h, y - h, z + h)); 
                writer.write(String.format("v %f %f %f\n", x + h, y + h, z + h)); 
                writer.write(String.format("v %f %f %f\n", x - h, y + h, z + h)); 

                // Ini buat faces (1 voxel = 12 faces)
                writer.write(String.format("f %d %d %d\n", vIdx, vIdx + 1, vIdx + 2));
                writer.write(String.format("f %d %d %d\n", vIdx, vIdx + 2, vIdx + 3));
                writer.write(String.format("f %d %d %d\n", vIdx + 4, vIdx + 5, vIdx + 6));
                writer.write(String.format("f %d %d %d\n", vIdx + 4, vIdx + 6, vIdx + 7));
                writer.write(String.format("f %d %d %d\n", vIdx, vIdx + 4, vIdx + 7));
                writer.write(String.format("f %d %d %d\n", vIdx, vIdx + 7, vIdx + 3));
                writer.write(String.format("f %d %d %d\n", vIdx + 1, vIdx + 5, vIdx + 6));
                writer.write(String.format("f %d %d %d\n", vIdx + 1, vIdx + 6, vIdx + 2));
                writer.write(String.format("f %d %d %d\n", vIdx + 3, vIdx + 2, vIdx + 6));
                writer.write(String.format("f %d %d %d\n", vIdx + 3, vIdx + 6, vIdx + 7));
                writer.write(String.format("f %d %d %d\n", vIdx, vIdx + 1, vIdx + 5));
                writer.write(String.format("f %d %d %d\n", vIdx, vIdx + 5, vIdx + 4));

                vIdx += 8;
            }
        }
    }
}