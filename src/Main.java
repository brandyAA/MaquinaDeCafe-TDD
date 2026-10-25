import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Crear los componentes de la máquina
        Cafetera cafetera = new Cafetera(50);

        Vaso vasosPequeno = new Vaso(5, 10);
        Vaso vasosMediano = new Vaso(5, 20);
        Vaso vasosGrande = new Vaso(5, 30);

        Azucarero azucarero = new Azucarero(20);

        // Crear la máquina
        MaquinaDeCafe maquina = new MaquinaDeCafe();

        maquina.setCafetera(cafetera);
        maquina.setVasosPequeno(vasosPequeno);
        maquina.setVasosMediano(vasosMediano);
        maquina.setVasosGrande(vasosGrande);
        maquina.setAzucarero(azucarero);

        System.out.println("=== MAQUINA DE CAFE ===");

        System.out.println("Seleccione el tamaño del vaso:");
        System.out.println("1. Pequeno");
        System.out.println("2. Mediano");
        System.out.println("3. Grande");

        int opcion = teclado.nextInt();

        Vaso vasoSeleccionado = null;

        if (opcion == 1) {
            vasoSeleccionado = maquina.getTipoDeVaso("pequeno");
        } else if (opcion == 2) {
            vasoSeleccionado = maquina.getTipoDeVaso("mediano");
        } else if (opcion == 3) {
            vasoSeleccionado = maquina.getTipoDeVaso("grande");
        } else {
            System.out.println("Opcion invalida");
            teclado.close();
            return;
        }

        System.out.println("Cuantos vasos desea?");
        int cantidadVasos = teclado.nextInt();

        System.out.println("Cuantas cucharadas de azucar desea?");
        int cantidadAzucar = teclado.nextInt();

        String resultado =
                maquina.getVasoDeCafe(
                        vasoSeleccionado,
                        cantidadVasos,
                        cantidadAzucar
                );

        System.out.println();
        System.out.println("Resultado: " + resultado);

        System.out.println();
        System.out.println("Estado de la maquina:");

        System.out.println(
                "Cafe restante: "
                        + maquina.getCafetera().getCantidadCafe()
        );

        System.out.println(
                "Azucar restante: "
                        + maquina.getAzucarero().getCantidadAzucar()
        );

        System.out.println(
                "Vasos pequenos restantes: "
                        + maquina.getVasosPequeno().getCantidadVasos()
        );

        System.out.println(
                "Vasos medianos restantes: "
                        + maquina.getVasosMediano().getCantidadVasos()
        );

        System.out.println(
                "Vasos grandes restantes: "
                        + maquina.getVasosGrande().getCantidadVasos()
        );

        teclado.close();
    }
}
