package CatalogoBibliotecario;

public class Libro extends Catalogo {
    private String author;
    private String genre;

    public Libro(String title, Integer publish_year, Integer pages, String author, String genre) {
        super(title, publish_year, pages);
        this.author = author.toLowerCase();
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;

    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return
                " <<Libro - " +
                        super.toString() +
                        ", Autore = " + author +
                        ", Genere = " + genre + ">>\n";
    }
}
