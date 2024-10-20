public class Disco {
    private String titulo;
    private String artista;
    private int anio;

    public Disco(String titulo, String artista, int anio) {
        this.titulo = titulo;
        this.artista = artista;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getAnio() {
        return anio;
    }
}