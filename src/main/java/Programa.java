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
        while (numeroOpcion!=5);
    }
    public static void mostrarMenu()
    {
        System.out.println("==================================");
        System.out.println("Gestor Semanal Academico\tGSAcad");
        System.out.println("==================================");
        System.out.println("Que deseas hacer?");
        System.out.println("1. Agregar/Eliminar ramos");
        System.out.println("2. Agregar/Eliminar evaluaciones");
        System.out.println("3. Listar ramos");
        System.out.println("4. Listar evaluaciones");
        System.out.println("5. Salir del programa");
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
        if (numero == 1)
        {
            System.out.println("hola");
        }
        else if (numero == 2)
        {
            System.out.println("como");
        }
        else if (numero == 3)
        {
            System.out.println("estas");
        }
        else if (numero == 4)
        {
            System.out.println("tu");
        }
    }

}
