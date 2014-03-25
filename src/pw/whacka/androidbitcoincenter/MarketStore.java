/**
 * 
 */
package pw.whacka.androidbitcoincenter;

import java.util.Vector;

/**
 * @author Elías
 *
 */
public interface MarketStore {

	public void saveStore(int puntos,String nombre,long fecha);

    public Vector<String> showStore(int cantidad);

}