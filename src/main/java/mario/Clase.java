package mario;

import java.util.ArrayList;

public class Clase {
    String clase;
    ArrayList<String> alumnos;

    public Clase() {
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public ArrayList<String> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<String> alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "clase='" + clase + '\'' +
                ", alumnos=" + alumnos +
                '}';
    }
}
