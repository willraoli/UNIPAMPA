package interfaces;
import model.Midia;


public interface IMidias {

	/**
	 * Adiciona uma mídia à arraylist m
	 * @param m refere-se à mídia a ser adicionada
	 */
	void adiciona(Midia m);

	/**
	 * Remove uma mídia da arraylist listaMidias
	 * @param obj
	 */
	void remove(Midia obj);

	/**
	 * Altera uma mídia da arraylist listaMidias
	 * @param antigo mídia antiga
	 * @param novo mídia nova
	 */
	void alterar(Midia antigo, Midia novo);
	
	
	
}
