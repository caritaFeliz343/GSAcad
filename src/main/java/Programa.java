
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
        while (numeroOpcion!=8);
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
            eliminarEvaluaciones();
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

    public static void eliminarEvaluaciones() {
        if (ramos.isEmpty()) {
            System.out.println("No hay ramos registrados.");
            return;
        }
        listarRamos();
        System.out.print("Selecciona el número del ramo: ");
        int seleccionRamo = leerOpcion(scanner);

        if (seleccionRamo < 1 || seleccionRamo > ramos.size()) {
            System.out.println("Número de ramo inválido.");
            return;
        }

        Ramo ramoSeleccionado = ramos.get(seleccionRamo - 1);
        ArrayList<Evaluacion> evals = ramoSeleccionado.getEvaluaciones();

        if (evals.isEmpty()) {
            System.out.println("El ramo '" + ramoSeleccionado.getNombre() + "' no tiene evaluaciones asignadas.");
            return;
        }

        System.out.println("\n--- EVALUACIONES EN " + ramoSeleccionado.getNombre().toUpperCase() + " ---");
        for (int i = 0; i < evals.size(); i++) {
            System.out.println((i + 1) + ". " + evals.get(i).getNombre());
        }

        System.out.print("Selecciona el número de la evaluación a eliminar: ");
        int seleccionEval = leerOpcion(scanner);

        if (seleccionEval >= 1 && seleccionEval <= evals.size()) {
            Evaluacion evalEliminada = ramoSeleccionado.eliminarEvaluacion(seleccionEval - 1);
            System.out.println("Evaluación '" + evalEliminada.getNombre() + "' eliminada con éxito.");
        } else {
            System.out.println("Número de evaluación inválido.");
        }
    }

    public static void listarRamos() {
        for (int i = 0; i < ramos.size(); i++) {
            System.out.println((i + 1) + ". " + ramos.get(i).getNombre());
        }
    }

    public static void listarEvaluaciones()
    {
        if (ramos.isEmpty()) {
            System.out.println("No hay ramos registrados.");
            return;
        }

        System.out.println("\n--- LISTA GENERAL DE EVALUACIONES ---");
        for (int i = 0; i < ramos.size(); i++) {
            Ramo r = ramos.get(i);
            System.out.println((i + 1) + ". Ramo: " + r.getNombre());
            if (r.getEvaluaciones().isEmpty()) {
                System.out.println("   (Sin evaluaciones asignadas)");
            } else {
                for (Evaluacion e : r.getEvaluaciones()) {
                    System.out.println("   - " + e.toString());
                }
            }
        }
    }

    public static void modificarPrioridadEvaluacion() {
if (ramos.isEmpty()) {
    System.out.println("No hay ramos registrados.");
    return;
}

    listarRamos();
        System.out.print("Selecciona el número del ramo: ");
    int seleccionRamo = leerOpcion(scanner);

        if (seleccionRamo < 1 || seleccionRamo > ramos.size()) {
    System.out.println("Número de ramo inválido.");
    return;
}

    Ramo ramoSeleccionado = ramos.get(seleccionRamo - 1);
    ArrayList<Evaluacion> evals = ramoSeleccionado.getEvaluaciones();

        if (evals.isEmpty()) {
    System.out.println("El ramo '" + ramoSeleccionado.getNombre() + "' no tiene evaluaciones registradas.");
    return;
}

        System.out.println("\n--- EVALUACIONES EN " + ramoSeleccionado.getNombre().toUpperCase() + " ---");
        for (int i = 0; i < evals.size(); i++) {
    System.out.println((i + 1) + ". " + evals.get(i).toString());
}

        System.out.print("Selecciona el número de la evaluación a modificar: ");
    int seleccionEval = leerOpcion(scanner);

        if (seleccionEval < 1 || seleccionEval > evals.size()) {
    System.out.println("Número de evaluación inválido.");
    return;
}

    Evaluacion evalSeleccionada = evals.get(seleccionEval - 1);

        System.out.println("\nPrioridad actual: " + evalSeleccionada.getPrioridad() + " (" + evalSeleccionada.getPrioridadTexto() + ")");
        System.out.println("Selecciona el nuevo nivel de prioridad:");
        System.out.println("1. Baja");
        System.out.println("2. Media");
        System.out.println("3. Alta");
        System.out.print("Nueva opción (1-3): ");
    int nuevaPrioridad = leerOpcion(scanner);

        evalSeleccionada.setPrioridad(nuevaPrioridad);
        System.out.println("¡Prioridad de '" + evalSeleccionada.getNombre() + "' modificada con éxito a: " + evalSeleccionada.getPrioridadTexto() + "!");
}
}
