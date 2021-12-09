package A_NM_matrix.Lagrange;

public class Vector_ {
    public float x;
    public float y;

    public Vector_(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Vector_ vec = (Vector_) obj;
        return vec.x == x && vec.y == y;
    }
}