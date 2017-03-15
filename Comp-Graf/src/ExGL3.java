import java.nio.FloatBuffer;


import com.jogamp.common.nio.Buffers;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL3;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.util.GLBuffers;
import com.jogamp.opengl.util.glsl.ShaderCode;
import com.jogamp.opengl.util.glsl.ShaderProgram;

public class ExGL3 implements GLEventListener {

    private ShaderProgram shaderProgram;
    private ShaderCode vertexShader;
    private ShaderCode fragmentShader;

    private int[] vao = new int[1];
    private int[] vbo = new int[1];

    private float[] model = new float[16];

    float vertexData[] = {-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    
    
    
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
	gl.glClear(GL.GL_DEPTH_BUFFER_BIT); // GL.GL_COLOR_BUFFER_BIT

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

    
}
