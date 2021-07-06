/**
 * Interface que especifica os métodos míninos para manipular uma coleção de notas fiscais.
 * @author Aline
 */
package GerenciaDeEstoque;

public interface INotasFiscais {
            
    /**
     * Adiciona uma nota fiscal.
     * @param nf Nota fiscal a ser adicionada.
     * @return True se a nota for incluída com sucesso e False caso contrário.
     */
    boolean addNotaFiscal(NotaFiscal nf);
    
    /**
     * Remove a nota fiscal com código informado.
     * @param codigo Código da nota fiscal a ser removida.
     * @return True se a nota for removida com sucesso e False caso contrário.
     */
    boolean removeNotaFiscal(int codigo);
    
    /**
     * Captura a nota fiscal com a nota fiscal informada.
     * @param codigo Código da nota fiscal a ser capturada.
     * @return A nota fiscal com o código informado ou NULL caso a nota fiscal não seja encontrada.
     */
    NotaFiscal getNotaFiscal(int codigo);
    
	/**
     * Captura o total da nota fiscal informada.
     * @param codigo Código da nota fiscal.
     * @return O total (soma do valor de todos os items) da nota fiscal com o código informado ou NULL caso a nota fiscal não seja encontrada.
     */
    double getTotal(int codigo);

    /**
     * Adiciona um item a nota fiscal com o código informado.
     * @param codigo Código da nota fiscal na qual o item deve ser adicionado.
     * @param item Item a ser adicionado.
     * @return True caso o item foi adicionado com sucesso e False caso a nota fiscal não exista ou a quantidade do produto em estoque seja menos do que a solicitada.
     */
    boolean addItem(int codigo, Item item);
    
    /**
     * Remove um item da nota fiscal com o código informado.
     * @param codigo Código da nota fiscal na qual o item deve ser removido.
     * @param item Item a ser removido.
     * @return True caso o item foi removido com sucesso e False caso contrário.
     */
    boolean removeItem(int codigo, Item item);
}
