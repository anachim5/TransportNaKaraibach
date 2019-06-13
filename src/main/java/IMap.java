import java.util.ArrayList;
import java.util.Iterator;
/**Interfejs klasy mapa udostępniający publiczne metody obiektu
 * {@link #AddCity(ICity)} dodaje miasto do listy,
 * {@link #AddNation(INation)} dodaje nację do listy,
 * {@link #getSize()} udostępnia rozmiar mapy,
 * {@link #getNation(int)} udostępnia nację mając jego numer w liscie,
 * {@link #getCities()}udostępnia listę miast,
 * {@link #getNationsIterator()},udostępnia iterator miast.
 * {@link #findCity(int[] position)},znajduje miasto na mapie mając daną jego pozycję,
 * */
public interface IMap
{
/**Dodawanie miast
 * @param city miasto, które ma byc dodane */
void AddCity(ICity city);
/**Dodawanie nacji
 * @param nation nacja która ma być dodana */
void AddNation(INation nation);
/**Uzyskiwanie rozmiaru mapy
 * @return rozmiar mapy*/
int getSize();
/**Uzyskiwanie obiektu nacji mając danę pozycję w liście
 * @param nrNation numer nacji na mapie
 * @return obiekt nacji*/
INation getNation(int nrNation);
/**Uzyskiwanie iteratora nacji
 * @return iterator nacji*/
Iterator getNationsIterator();
/**Uzyskiwanie listy miast
 * @return lista miast*/
ArrayList getCities();
/**Wyszukiwanie miasta mając daną pozycję
 * @param position pozycja miasta na mapie
 * @return obiekt miasta*/
ICity findCity(int[] position);


}
