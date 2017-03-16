
package forma;

public class Cube extends Forma {
    
    static float[] vertex = {   -1.000000f, -1.000000f,  1.000000f,
                                -1.000000f,  1.000000f,  1.000000f,
                                -1.000000f, -1.000000f, -1.000000f,
                                -1.000000f,  1.000000f, -1.000000f,
                                 1.000000f, -1.000000f,  1.000000f,
                                 1.000000f,  1.000000f,  1.000000f,
                                 1.000000f, -1.000000f, -1.000000f,
                                 1.000000f,  1.000000f, -1.000000f,
                                  -1.0000f,    0.0000f,    0.0000f,
                                   0.0000f,    0.0000f,   -1.0000f,
                                   1.0000f,    0.0000f,    0.0000f,
                                   0.0000f,    0.0000f,    1.0000f,
                                   0.0000f,   -1.0000f,    0.0000f,
                                   0.0000f,    1.0000f,    0.0000f};
    public static float[] getVertex;

    public Cube(String name) {
        this.nome = name;
    }
    
    public float[] getVertex()
    {
        return Cube.vertex;
    }
   //{-1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f}
}
