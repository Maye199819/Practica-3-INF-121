public class Libro {
    private String titulo;

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Libro: " + titulo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Libro) {
            return this.titulo.equals(((Libro) obj).titulo);
        }
        return false;
    }
}
