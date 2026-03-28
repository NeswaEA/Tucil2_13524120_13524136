package VoxelizationOctree.core;

import java.util.List;

import VoxelizationOctree.model.Triangle;
import VoxelizationOctree.util.Statistics;
import VoxelizationOctree.util.Geometry;

public class OctreeNode {
    private double x, y, z;
    private double size;
    private int depth;
    private OctreeNode[] childrenNodes;
    private boolean isLeaf = false;

    public OctreeNode(double x, double y, double z, double size, int depth){
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
        this.depth = depth;
        this.childrenNodes = null;
        Statistics.catatNodeDibentuk(depth);
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

    public void subdivide(int maxDepth, List<Triangle> faces) {
        boolean hasIntersection = Geometry.isIntersecting(this, faces);

        if (!hasIntersection) {
            Statistics.catatNodeTidakPerlu(depth);
            return;
        }

        if (this.depth == maxDepth) {
            this.isLeaf = true;
            return;
        }

        this.childrenNodes = new OctreeNode[8];
        double childSize = this.size / 2.0;
        double offset = this.size / 4.0;

        int index = 0;
        for (int i : new int[]{-1, 1}) {
            for (int j : new int[]{-1, 1}) {
                for (int k : new int[]{-1, 1}) {
                    double cx = this.x + (i * offset);
                    double cy = this.y + (j * offset);
                    double cz = this.z + (k * offset);
                    
                    childrenNodes[index] = new OctreeNode(cx, cy, cz, childSize, depth + 1);
                    childrenNodes[index].subdivide(maxDepth, faces);
                    index++;
                }
            }
        }
    }

    public void collectLeafVoxels(List<OctreeNode> leafList) {
        if (this.isLeaf) {
            leafList.add(this);
        } else if (this.childrenNodes != null) {
            for (OctreeNode child : childrenNodes) {
                if (child != null) child.collectLeafVoxels(leafList);
            }
        }
    }
}
