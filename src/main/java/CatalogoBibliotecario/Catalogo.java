package CatalogoBibliotecario;


public abstract class Catalogo {
    private Integer isbn;
    private static int isbnCounter = 1;
    private String title;
    private Integer publish_year;
    private Integer pages;

    public Catalogo(String title, Integer publish_year, Integer pages) {
        this.isbn = isbnCounter;
        isbnCounter++;
        this.title = title;
        this.publish_year = publish_year;
        this.pages = pages;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public static int getIsbn_counter() {
        return isbnCounter;
    }

    public static void setIsbn_counter(int isbn_counter) {
        Catalogo.isbnCounter = isbnCounter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublish_year() {
        return publish_year;
    }

    public void setPublish_year(Integer publish_year) {
        this.publish_year = publish_year;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "ISBN = " + isbn +
                ", Titolo = " + title +
                ", Anno di pubblicazione = " + publish_year +
                ", Numero di pagine = " + pages;
    }
}