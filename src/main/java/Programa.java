
import java.util.Scanner;
import java.util.ArrayList;
public class Programa
{
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Ramo> ramos = new ArrayList<>();
    public static ArrayList<String> evaluaciones = new ArrayList<>();

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
            ejecutarOpcion(numeroOpcion, scanner);
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
        System.out.println("7. Modificar prioridad de evaluacion");
        System.out.println("8. Salir del programa");
        System.out.println("==================================");
        System.out.print("Tu opcion: ");
    }
    public static int leerOpcion(Scanner in) {
        try {
            return Integer.parseInt(in.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }
    public static void ejecutarOpcion(int numero, Scanner input)
    {
        if (numero == 1) // agregar ramos
        {
            System.out.println("Ingresa el nombre del ramo que quieres agregar: ");
            String ramo = input.next();
            agregarRamos(ramo);
        }
        else if (numero == 2) // eliminar ramos
        {
            System.out.println("Ingresa el nombre del ramo que quieres eliminar: ");
            eliminarRamos();
        }
        else if (numero == 3) // agregar evaluaciones
        {
            agregarEvaluaciones();
        }
        else if (numero == 4) // eliminar evaluaciones
        {
            System.out.println("Ingresa el nombre de la evaluacion que quieres eliminar: ");
            String evaluacion = input.next();
            eliminarEvaluaciones(evaluacion);
        }
        else if (numero == 5) // listar ramos
        {
            listarRamos();
        }
        else if (numero == 6) // listar evaluaciones
        {
            listarEvaluaciones();
        } else if (numero == 7) {
            modificarPrioridadEvaluacion();
        } else if (numero == 8) {
            System.out.println("Saliendo del programa...");
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public static void agregarRamos(String nombreRamo) {
        ramos.add(new Ramo(nombreRamo));
        System.out.println("Ramo '" + nombreRamo + "' agregado con éxito.");
    }
    public static void eliminarRamos() {
        if (ramos.isEmpty()) {
            System.out.println("No hay ramos registrados para eliminar.");
            return;
        }
        listarRamos();
        System.out.print("Selecciona el número del ramo que quieres eliminar: ");
        int seleccion = leerOpcion(scanner);

        if (seleccion >= 1 && seleccion <= ramos.size()) {
            Ramo ramoEliminado = ramos.remove(seleccion - 1);
            System.out.println("Ramo '" + ramoEliminado.getNombre() + "' eliminado con éxito.");
        } else {
            System.out.println("Número de selección inválido.");
        }
    }

    public static void agregarEvaluaciones() {
        if (ramos.isEmpty()) {
            System.out.println("Debes agregar al menos un ramo primero.");
            return;
        }
        listarRamos();
        System.out.print("Selecciona el número del ramo al que pertenece la evaluación: ");
        int seleccionRamo = leerOpcion(scanner);

        if (seleccionRamo < 1 || seleccionRamo > ramos.size()) {
            System.out.println("Número de ramo inválido.");
            return;
        }

        Ramo ramoSeleccionado = ramos.get(seleccionRamo - 1);
        System.out.print("Ingresa el nombre de la evaluación: ");
        String nombreEval = scanner.nextLine();

        System.out.println("Selecciona el nivel de prioridad:\n1. Baja\n2. Media\n3. Alta");
        System.out.print("Opción (1-3): ");
        int prioridad = leerOpcion(scanner);

        Evaluacion nuevaEval = new Evaluacion(nombreEval, prioridad);
        ramoSeleccionado.agregarEvaluacion(nuevaEval);
        System.out.println("Evaluación agregada con éxito al ramo " + ramoSeleccionado.getNombre() + ".");
    }

    public static void eliminarEvaluaciones(String Eval)
    {
        evaluaciones.remove(Eval);
    }

    public static void listarRamos() {
        for (int i = 0; i < ramos.size(); i++) {
            System.out.println((i + 1) + ". " + ramos.get(i).getNombre());
        }
    }

    public static void listarEvaluaciones()
    {
    }

    public static void modificarPrioridadEvaluacion() {
    }

}
