

class Equipo {
    String nombre;
    String[] jugadores;
    int contadorJugadores;

    public Equipo(String nombre, int capacidadJugadores) {
        this.nombre = nombre;
        this.jugadores = new String[capacidadJugadores];
        this.contadorJugadores = 0;
    }

    public void agregarJugador(String jugador) {
        if (contadorJugadores < jugadores.length) {
            jugadores[contadorJugadores] = jugador;
            contadorJugadores++;
        } else {
            System.out.println("No se pueden agregar más jugadores.");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Equipo: " + nombre + ", Jugadores: ");
        for (int i = 0; i < contadorJugadores; i++) {
            sb.append(jugadores[i]);
            if (i < contadorJugadores - 1) sb.append(", ");
        }
        return sb.toString();
    }
}

class Partido {
    String equipo1;
    String equipo2;
    String fecha;
    String resultado;

    public Partido(String equipo1, String equipo2, String fecha) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.resultado = "Pendiente";
    }

    public void actualizarResultado(String resultado) {
        this.resultado = resultado;
    }

    public String toString() {
        return "Partido: " + equipo1 + " vs " + equipo2 + ", Fecha: " + fecha + ", Resultado: " + resultado;
    }
}

class Torneo {
    Equipo[] equipos = new Equipo[10];  // Capacidad fija para 10 equipos
    Partido[] partidos = new Partido[10];  // Capacidad fija para 10 partidos
    int contadorEquipos = 0;
    int contadorPartidos = 0;

    public void registrarEquipo(String nombre, String... jugadores) {
        if (contadorEquipos < equipos.length) {
            Equipo equipo = new Equipo(nombre, jugadores.length);
            for (String jugador : jugadores) {
                equipo.agregarJugador(jugador);
            }
            equipos[contadorEquipos] = equipo;
            contadorEquipos++;
        } else {
            System.out.println("No se pueden registrar más equipos.");
        }
    }

    public void crearPartido(String equipo1, String equipo2, String fecha) {
        if (contadorPartidos < partidos.length) {
            partidos[contadorPartidos] = new Partido(equipo1, equipo2, fecha);
            contadorPartidos++;
        } else {
            System.out.println("No se pueden crear más partidos.");
        }
    }

    public void listarEquipos() {
        System.out.println("=== Equipos Registrados ===");
        for (int i = 0; i < contadorEquipos; i++) {
            System.out.println(equipos[i]);
        }
    }

    public void mostrarPartidos() {
        System.out.println("=== Partidos ===");
        for (int i = 0; i < contadorPartidos; i++) {
            System.out.println(partidos[i]);
        }
    }

    public void actualizarResultado(int indice, String resultado) {
        if (indice >= 0 && indice < contadorPartidos) {
            partidos[indice].actualizarResultado(resultado);
        } else {
            System.out.println("Partido no encontrado.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Torneo torneo = new Torneo();

        // Registrar equipos
        torneo.registrarEquipo("Team Alpha", "Jugador 1", "Jugador 2");
        torneo.registrarEquipo("Team Beta", "Jugador 3", "Jugador 4");

       
        torneo.crearPartido("Team Alpha", "Team Beta", "2024-12-15"); // Crear partidos

        torneo.listarEquipos();        // Listar equipos


        torneo.mostrarPartidos();        // Mostrar partidos


        System.out.println("\nActualizando resultado...");        // Actualizar resultado

        torneo.actualizarResultado(0, "3-2");

        // Mostrar partidos actualizados
        torneo.mostrarPartidos();
    }
}
