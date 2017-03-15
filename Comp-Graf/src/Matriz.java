
public class Matriz {

    public Matriz() {
    }
    
    /* Normalização em vec3 */
    public void norma(float a[]) {
        float i = (float) Math.sqrt(a[0]*a[0] + a[1]*a[1] + a[2] * a[2]);
        a[0] /= i;
        a[1] /= i;
        a[2] /= i;
    }
    
    /* Criar matriz identidade em matrix n x n*/
    public void setIdentidade(float a[], int n) {
        int i;
        for (i = 0; i < n * n; i++)
            a[i] = 0.0f;
        for (i = 0; i < n; i++)
            a[i + i * n] = 1.0f;
    }
    
    /* Criar matriz de translação. mat é 4x4*/
    public void translate (float[] mat, float x, float y, float z) {
        setIdentidade(mat, 4);
        mat[3] = x;
        mat[7] = y;
        mat[11] = z;
    }

    public void rotate(float[] mat, float ang, float x, float y, float z) {
        setIdentidade(mat, 4);
    }
    
    public void scale(float[] mat, float x, float y, float z) {
        setIdentidade(mat, 4);
        mat[0] = x;
        mat[5] = y;
        mat[10] = z;
    }
}
