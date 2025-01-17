package Servizi;

import CatalogoBibliotecario.Catalogo;

import java.util.List;
import java.util.Optional;

public interface ArchivioSvc {
    void addElement();
    void deleteElementByISBN();
    List<Catalogo> getByISBN(Integer isbn);
    List<Catalogo> getByPublishYear(Integer year);
    List<Catalogo> getByAuthor(String author);
}
