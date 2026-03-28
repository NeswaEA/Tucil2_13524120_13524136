package VoxelizationOctree.util;

import VoxelizationOctree.model.Triangle;
import VoxelizationOctree.core.OctreeNode;
import java.util.List;

public class Geometry {
    public static boolean isIntersecting(OctreeNode node, List<Triangle> faces) {
        double half = node.getSize() / 2.0;
        double minX = node.getX() - half, maxX = node.getX() + half;
        double minY = node.getY() - half, maxY = node.getY() + half;
        double minZ = node.getZ() - half, maxZ = node.getZ() + half;

        for (Triangle t : faces) {
            if (triangleOverlapsAABB(t, minX, maxX, minY, maxY, minZ, maxZ)) {
                return true;
            }
        }
        return false;
    }

    private static boolean triangleOverlapsAABB(Triangle t, double minX, double maxX, double minY, double maxY, double minZ, double maxZ) {
        double tMinX = Math.min(t.v0.x, Math.min(t.v1.x, t.v2.x));
        double tMaxX = Math.max(t.v0.x, Math.max(t.v1.x, t.v2.x));
        double tMinY = Math.min(t.v0.y, Math.min(t.v1.y, t.v2.y));
        double tMaxY = Math.max(t.v0.y, Math.max(t.v1.y, t.v2.y));
        double tMinZ = Math.min(t.v0.z, Math.min(t.v1.z, t.v2.z));
        double tMaxZ = Math.max(t.v0.z, Math.max(t.v1.z, t.v2.z));

        return !(tMaxX < minX || tMinX > maxX || tMaxY < minY || tMinY > maxY || tMaxZ < minZ || tMinZ > maxZ);
    }
}