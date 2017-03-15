
//need lib jogamp
import java.nio.FloatBuffer;

import javax.swing.JFrame;

import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL3;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.GLBuffers;
import com.jogamp.opengl.util.glsl.ShaderCode;
import com.jogamp.opengl.util.glsl.ShaderProgram;
import java.util.Scanner;

public class ExGL3 implements GLEventListener {

    private ShaderProgram shaderProgram;
    private ShaderCode vertexShader;
    private ShaderCode fragmentShader;

    private int[] vao = new int[1];
    private int[] vbo = new int[1];

    private float[] model = new float[16];

    static float vertexData[] = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    
    /* Multiplicação de matriz 4 x 4. a = a.b */
    static void matrizMult (float a[], float b[]) {
        float result[] = new float[16];
        int i, j, k;
        for (i = 0; i < 4; ++i) {
            for (j = 0; j < 4; ++j) {
                result[j * 4 + i] = 0.0f;
                for (k = 0; k < 4; k++) {
                    result[j * 4 + i] += a[k * 4 + i] * b[j * 4 + k];
                } 
            }
        }
        System.arraycopy(result, 0, a, 0, 16);
    }
    
    /* Normalização em vec3 */
    void norma(float a[]) {
        float i = (float) Math.sqrt(a[0]*a[0] + a[1]*a[1] + a[2] * a[2]);
        a[0] /= i;
        a[1] /= i;
        a[2] /= i;
    }
    
    /* Criar matriz identidade em matrix n x n*/
    static void setIdentidade(float a[], int n) {
        int i;
        for (i = 0; i < n * n; i++)
            a[i] = 0.0f;
        for (i = 0; i < n; i++)
            a[i + i * n] = 1.0f;
    }
    
    /* Criar matriz de translação. mat é 4x4*/
    static void matrizTranslate (float[] mat, float x, float y, float z) {
        setIdentidade(mat, 4);
        mat[3] = x;
        mat[7] = y;
        mat[11] = z;
    }

    public void matrizRotate(float[] mat, float ang, float x, float y, float z) {
        setIdentidade(mat, 4);
    }
    
    static public void matrizScale(float[] mat, float x, float y, float z) {
        setIdentidade(mat, 4);
        mat[0] = x;
        mat[5] = y;
        mat[10] = z;
    }
    
    public void shape(GL3 gl) {
        
    }

    @Override
    public void init(GLAutoDrawable canvas) {
        GL3 gl = canvas.getGL().getGL3();
        gl.glClearColor(1f, 1f, 1f, 0f);

        createShaders(gl);

        // Create and Bind the Vertex Array Object first, then bind and set vertex buffer(s) and attribute pointer(s).
        gl.glGenVertexArrays(1, vao, 0);
        gl.glBindVertexArray(vao[0]);
            

	// Set up vertex data (and buffer(s)) and attribute pointers
        FloatBuffer vertexDataBuffer = GLBuffers.newDirectFloatBuffer(vertexData);
        gl.glGenBuffers(1, vbo, 0);
        gl.glBindBuffer(GL.GL_ARRAY_BUFFER, vbo[0]);
        gl.glBufferData(GL.GL_ARRAY_BUFFER, Buffers.SIZEOF_FLOAT * vertexDataBuffer.limit(), vertexDataBuffer, GL.GL_STATIC_DRAW);

		// 0=location do atributo no shader
        // penultimo zero pode ser 3 * Float.BYTES
        gl.glVertexAttribPointer(0, 3, GL.GL_FLOAT, false, 0, 0);// first 0 is the location in shader

        // tem que ativar todos os atributos inicialmente sao desabilitados por padrao
        gl.glEnableVertexAttribArray(0);
        gl.glBindAttribLocation(shaderProgram.program(), 0, "vertexPosition");// name of attribute in shader
        // Note that this is allowed, the call to glVertexAttribPointer registered VBO
        // as the currently bound vertex buffer object so afterwards we can safely unbind
        gl.glBindBuffer(GL.GL_ARRAY_BUFFER, 0);
        // Unbind VAO (it's always a good thing to unbind any buffer/array to prevent strange bugs)
        gl.glBindVertexArray(0);
    }

    private void createShaders(GL3 gl) {
        vertexShader = ShaderCode.create(gl, GL3.GL_VERTEX_SHADER, getClass(), "shader", null, "ExGL3", false);
        fragmentShader = ShaderCode.create(gl, GL3.GL_FRAGMENT_SHADER, getClass(), "shader", null, "ExGL3", false);

        if (!vertexShader.compile(gl, System.err)) {
            throw new GLException("Couldn't compile shader: " + vertexShader);
        }
        if (!fragmentShader.compile(gl, System.err)) {
            throw new GLException("Couldn't compile shader: " + fragmentShader);
        }

        shaderProgram = new ShaderProgram();
        shaderProgram.add(gl, vertexShader, System.err);
        shaderProgram.add(gl, fragmentShader, System.err);
        shaderProgram.link(gl, System.out);
    }

    @Override
    public void display(GLAutoDrawable canvas) {
        GL3 gl = canvas.getGL().getGL3();
		//gl.glClear(GL.GL_DEPTH_BUFFER_BIT | GL.GL_COLOR_BUFFER_BIT);

        // load everthing back
        gl.glUseProgram(shaderProgram.program());
        gl.glBindVertexArray(vao[0]);
        gl.glBindBuffer(GL.GL_ARRAY_BUFFER, vbo[0]);
        // Draw our first triangle
        gl.glDrawArrays(GL.GL_TRIANGLES, 0, 3);

        // clean things up
        gl.glUseProgram(0);
    }

    @Override
    public void reshape(GLAutoDrawable canvas, int x, int y, int width, int height) {
        System.out.println("reshape");

        GL3 gl3 = canvas.getGL().getGL3();
        gl3.glViewport(x, y, width, height);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
        System.out.println("dispose");

        GL3 gl3 = drawable.getGL().getGL3();
        gl3.glDeleteBuffers(1, vbo, 0);
        gl3.glDeleteVertexArrays(1, vao, 0);

        gl3.glDeleteProgram(shaderProgram.id());
        gl3.glDeleteShader(vertexShader.id());
        gl3.glDeleteShader(fragmentShader.id());
    }

    public static void main(String[] args) {
        JFrame app = new JFrame("Minimal OpenGL 3 with shader");
        app.setSize(640, 480);
        // this.setResizable(false);
        app.setLocationRelativeTo(null);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GLProfile profile = GLProfile.get(GLProfile.GL3);

        GLJPanel canvas = new GLJPanel(new GLCapabilities(profile));
        canvas.addGLEventListener(new ExGL3());
        app.getContentPane().add(canvas);

        canvas.requestFocusInWindow();
        app.setVisible(true);
        
        Scanner entrada = new Scanner(System.in);
        
        vertexData[0] = entrada.nextFloat();
        
        app.repaint();
        
        System.out.println(vertexData[0]);
    }
}
