package VoxelizationOctree.model;

import java.io.*;
import java.util.*;

public class ObjParser {
    public List<Vector3> vertices = new ArrayList<>();
    public List<Triangle> faces = new ArrayList<>();
    
    public double minX = Double.MAX_VALUE, maxX = -Double.MAX_VALUE;
    public double minY = Double.MAX_VALUE, maxY = -Double.MAX_VALUE;
    public double minZ = Double.MAX_VALUE, maxZ = -Double.MAX_VALUE;

    public void parse(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("v ")) {
                String[] tokens = line.split("\\s+");
                double x = Double.parseDouble(tokens[1]);
                double y = Double.parseDouble(tokens[2]);
                double z = Double.parseDouble(tokens[3]);
                
                Vector3 v = new Vector3(x, y, z);
                vertices.add(v);

                minX = Math.min(minX, x); maxX = Math.max(maxX, x);
                minY = Math.min(minY, y); maxY = Math.max(maxY, y);
                minZ = Math.min(minZ, z); maxZ = Math.max(maxZ, z);

            } else if (line.startsWith("f ")) {
                String[] tokens = line.split("\\s+");
                int i = Integer.parseInt(tokens[1].split("/")[0]) - 1;
                int j = Integer.parseInt(tokens[2].split("/")[0]) - 1;
                int k = Integer.parseInt(tokens[3].split("/")[0]) - 1;
                
                faces.add(new Triangle(vertices.get(i), vertices.get(j), vertices.get(k)));
            }
        }
        reader.close();
    }

    public double getMaxSize() {
        return Math.max(maxX - minX, Math.max(maxY - minY, maxZ - minZ));
    }
}