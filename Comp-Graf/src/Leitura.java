
import java.util.Scanner;

public class Leitura {

    Scanner entrada;
    String name1;
    float floatX, floatY, floatZ, floatK;
    boolean error = false;

    public Leitura() {
        entrada = new Scanner(System.in);

    }

    public void next() {
        /* Selecionando o comando de acordo com a primeira palavra */
        switch (entrada.next()) { /* comando */

            case "add_shape":
                /* Formato: add_shape shape name1 */
                switch (entrada.next()) { /* shape */

                    case "cube":
                        
                        break;
                    case "sphere":

                        break;
                    case "cone":
                        
                        break;
                    case "torus":

                        break;
                    default:
                        error = true;
                        break;
                }

                name1 = entrada.next();
                System.out.println(name1);
                break;
            case "remove_shape":
                /* Formato: remove_shape name1 */
                name1 = entrada.next();

                break;
            case "add_light":
                /* Formato: add_light name1 floatX floatY floatZ (max. 10) */
                name1 = entrada.next();

                floatX = Float.parseFloat(entrada.next());
                floatY = Float.parseFloat(entrada.next());
                floatZ = Float.parseFloat(entrada.next());

                break;
            case "remove_light":
                /* Formato: remove_light name1 */
                name1 = entrada.next();

                break;
            case "reflection_on":
                /* Formato: reflection_on type float*/
                switch (entrada.next()) { /* type */

                    case "specular":

                        break;
                    case "diffuse":

                        break;
                    case "ambient":

                        break;
                    default:
                        error = true;
                        break;
                }
                floatK = Float.parseFloat(entrada.next());

                break;
            case "reflection_off":
                /* Formato: reflection_off type */
                switch (entrada.next()) { /* type */

                    case "specular":

                        break;
                    case "diffuse":

                        break;
                    case "ambient":

                        break;
                    default:
                        error = true;
                        break;
                }

                break;
            case "shading":
                /* Formato: shading type */
                switch (entrada.next()) { /* type */

                    case "flat":

                        break;
                    case "smooth":

                        break;
                    case "phong":

                        break;
                    default:
                        error = true;
                        break;
                }

                break;
            case "projection":
                /* Formato: projection type */
                switch (entrada.next()) { /* type */

                    case "ortho":

                        break;
                    case "perspective":

                        break;
                    default:
                        error = true;
                        break;
                }

                break;
            case "translate":
                /* Formato: translate name1 float float float */
                Matriz m = new Matriz();
                float[] t = new float[16];
                
                name1 = entrada.next();

                floatX = Float.parseFloat(entrada.next());
                floatY = Float.parseFloat(entrada.next());
                floatZ = Float.parseFloat(entrada.next());
                
                m.translate(t, floatX, floatX, floatX);

                break;
            case "scale":
                /* Formato: scale name1 float float float */
                name1 = entrada.next();

                floatX = Float.parseFloat(entrada.next());
                floatY = Float.parseFloat(entrada.next());
                floatZ = Float.parseFloat(entrada.next());

                break;
            case "rotate":
                /* Formato: rotate name1 float float float float */
                name1 = entrada.next();

                floatK = Float.parseFloat(entrada.next()); /* floatK = angulo */

                floatX = Float.parseFloat(entrada.next());
                floatY = Float.parseFloat(entrada.next());
                floatZ = Float.parseFloat(entrada.next());

                break;
            case "lookat":
                /* Formato: lookat float float float */
                floatX = Float.parseFloat(entrada.next());
                floatY = Float.parseFloat(entrada.next());
                floatZ = Float.parseFloat(entrada.next());

                break;
            case "cam":
                /* Formato: cam float float float */
                floatX = Float.parseFloat(entrada.next());
                floatY = Float.parseFloat(entrada.next());
                floatZ = Float.parseFloat(entrada.next());

                break;
            case "color":
                /* Formato: color name1 float float float */
                name1 = entrada.next();

                /* floatX = R, floatY = G, floatZ = B */
                floatX = Float.parseFloat(entrada.next());
                floatY = Float.parseFloat(entrada.next());
                floatZ = Float.parseFloat(entrada.next());

                break;
            case "axis":
                /* Formato: axis */

                break;
            case "save":
                /* Formato: save filename */
                name1 = entrada.next();

                break;
            case "quit":
                /* Formato: quit */
                break;
            default:
                /* Formato inválido */
                error = true;
                break;

        }
        if (error == true) {
            System.out.println("Comando inválido");
        }
    }
}
