package CatalogoBibliotecario;

public class Rivista extends Catalogo {
    private Periodicità periodicity;

    public Rivista(String title, Integer publish_year, Integer pages, Periodicità periodicity) {
        super(title, publish_year, pages);
        this.periodicity = periodicity;
    }

    public Periodicità getPeriodicità() {
        return periodicity;
    }

    public void setPeriodicity(Periodicità periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return " <<Rivista - " +
                super.toString() +
                ", Periodicità = " + periodicity +
                ">>\n";
    }
}
