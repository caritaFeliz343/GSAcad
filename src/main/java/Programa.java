import java.util.Scanner;
public class Programa
{
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        menu();
    }
    public static void menu()
    {
        int numeroOpcion = 0;
        do
        {
            mostrarMenu();
            numeroOpcion = leerOpcion(scanner);
            ejecutarOpcion(numeroOpcion);
        }
        while (numeroOpcion!=7);
    }
    public static void mostrarMenu()
    {
        System.out.println("==================================");
        System.out.println("Gestor Semanal Academico\tGSAcad");
        System.out.println("==================================");
        System.out.println("Que deseas hacer?");
        System.out.println("1. Agregar ramos");
        System.out.println("2. Eliminar ramos");
        System.out.println("3. Agregar evaluaciones");
        System.out.println("4. Eliminar evaluaciones");
        System.out.println("5. Listar ramos");
        System.out.println("6. Listar evaluaciones");
        System.out.println("7. Salir del programa");
        System.out.println("==================================");
        System.out.print("Tu opcion: ");
    }
    public static int leerOpcion(Scanner in)
    {
        int opcionSeleccionada = Integer.parseInt(in.next());
        return opcionSeleccionada;
    }
    public static void ejecutarOpcion(int numero)
    {
        if (numero == 1) // agregar ramos
        {
            agregarRamos();
        }
        else if (numero == 2) // eliminar ramos
        {
            eliminarRamos();
        }
        else if (numero == 3) // agregar evaluaciones
        {
            agregarEvaluaciones();
        }
        else if (numero == 4) // eliminar evaluaciones
        {
            eliminarEvaluaciones();
        }
        else if (numero == 5) // listar ramos
        {
            listarRamos();
        }
        else if (numero == 6) // listar evaluaciones
        {
            listarEvaluaciones();
        }
    }
    public static void agregarRamos(){}

    public static void eliminarRamos(){}

    public static void agregarEvaluaciones(){}

    public static void eliminarEvaluaciones(){}

    public static void listarRamos(){}

    public static void listarEvaluaciones(){}
}
