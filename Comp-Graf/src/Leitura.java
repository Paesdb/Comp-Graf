
import java.util.Scanner;

public class Leitura {

    Scanner entrada;
    String name1;
    float floatX, floatY, floatZ, floatK;
    boolean error = false;

    public Leitura() {
        entrada = new Scanner(System.in);

    }

    public void proximoComando() {
        /* Selecionando o comando de acordo com a primeira palavra */
        switch (entrada.next()) { /* comando */

            case "add_shape":
                /* Formato: add_shape shape name1 */
                switch (entrada.next()) { /* shape */

                    case "cube":
                        System.out.print("estou adicionando um cubo de nome ");
                        break;
                    case "sphere":

                        break;
                    case "cone":
                        System.out.print("estou adicionando um cone de nome");
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

                floatX = entrada.nextFloat();
                floatY = entrada.nextFloat();
                floatZ = entrada.nextFloat();

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
                floatK = entrada.nextFloat();

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
                name1 = entrada.next();

                floatX = entrada.nextFloat();
                floatY = entrada.nextFloat();
                floatZ = entrada.nextFloat();

                break;
            case "scale":
                /* Formato: scale name1 float float float */
                name1 = entrada.next();

                floatX = entrada.nextFloat();
                floatY = entrada.nextFloat();
                floatZ = entrada.nextFloat();

                break;
            case "rotate":
                /* Formato: rotate name1 float float float float */
                name1 = entrada.next();

                floatK = entrada.nextFloat(); /* floatK = angulo */

                floatX = entrada.nextFloat();
                floatY = entrada.nextFloat();
                floatZ = entrada.nextFloat();

                break;
            case "lookat":
                /* Formato: lookat float float float */
                floatX = entrada.nextFloat();
                floatY = entrada.nextFloat();
                floatZ = entrada.nextFloat();

                break;
            case "cam":
                /* Formato: cam float float float */
                floatX = entrada.nextFloat();
                floatY = entrada.nextFloat();
                floatZ = entrada.nextFloat();

                break;
            case "color":
                /* Formato: color name1 float float float */
                name1 = entrada.next();

                /* floatX = R, floatY = G, floatZ = B */
                floatX = entrada.nextFloat();
                floatY = entrada.nextFloat();
                floatZ = entrada.nextFloat();

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
