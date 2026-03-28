package VoxelizationOctree.core;

import java.util.ArrayList;
import java.util.List;

public class OctreeNode {
    private double x, y, z;
    private double size;
    private int depth;
    private OctreeNode[] childrenNodes;
    private boolean isLeaf = false;

    public OctreeNode(double x, double y, double z, double size, double depth){
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
        this.depth = depth;
        this.childrenNodes = null;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }

    public double getSize(){
        return size;
    }
}
