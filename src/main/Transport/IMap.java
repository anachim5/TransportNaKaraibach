import java.util.ArrayList;
import java.util.Iterator;
/**Interfejs klasy mapa udostępniający publiczne metody obiektu
 * {@see #AddCity(ICity)} dodaje miasto do listy,
 * {@see #AddNation(INation} dodaje nację do listy,
 * {@link #getSize()} udostępnia rozmiar mapy,
 * {@link #getNation(int)} udostępnia nację mając jego numer w liscie,
 * {@link #getCitites()}udostępnia listę miast,
 * {@link #getNationsIterator()},udostępnia iterator miast.
 * {@link #findCity(int[] position)},znajduje miasto na mapie mając daną jego pozycję,
 * @param int[]position, pozycja szukanego miasta.
 * */
public interface IMap
{
/**Dodawanie miast*/
void AddCity(ICity city);
/**Dodawanie nacji*/
void AddNation(INation nation);
/**Uzyskiwanie rozmiaru mapy*/
int getSize();
/**Uzyskiwanie obiektu nacji mając danę pozycję w liście*/
INation getNation(int nrNation);
/**Uzyskiwanie iteratora nacji*/
Iterator getNationsIterator();
/**Uzyskiwanie listy miast*/
ArrayList getCities();
/**Wyszukiwanie miasta mając daną pozycję*/
ICity findCity(int[] position);


}
