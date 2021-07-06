package interfaces;
import model.Midia;

public interface IMidias {

	/**
	 * Adiciona uma mídia à arraylist m
	 * @param m refere-se à mídia a ser adicionada
	 */
	public void adiciona(Midia m);

	/**
	 * Remove uma mídia da arraylist listaMidias
	 * @param codigo
	 */
	public void remove(int codigo);
	
	
	
}
