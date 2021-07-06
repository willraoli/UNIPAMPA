package model;


public class Foto extends Midia {
    private String fotografo;
    private String local;
    private String data;
    private String pessoasNaFoto;


    public Foto() {
    }

    /**
     * Método de acesso ao atributo fotografo
     * @return uma string do atributo fotógrafo do objeto Foto
     */
    public String getFotografo() {
        return fotografo;
    }

    /**
     * Método para definir o fotógrafo da foto
     * @param fotografo recebe a string do nome do fotógrafo
     */
    public void setFotografo(String fotografo) {
        if (fotografo.chars().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Fotografo não definido");
        } else {
            this.fotografo = fotografo;
        }
    }

    /**
     * Método de acesso para o atributo foto
     * @return a string de pessoasNaFoto do atributo
     */
    public String getPessoasNaFoto() {
        return pessoasNaFoto;
    }

    /**
     * Método para definir o atributo pessoasNaFoto
     * @param pessoasNaFoto recebe o nome das pessoas na foto
     */
    public void setPessoas(String pessoasNaFoto) {
        if (pessoasNaFoto.chars().anyMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Nenhuma pessoa na foto foi identificada");
        } else {
            this.pessoasNaFoto = pessoasNaFoto;
        }
    }

    /**
     * Método de acesso ao atributo local
     * @return o local da foto do objeto foto
     */
    public String getLocal() {
        return local;
    }

    /**
     * Metódo para definir o atributolcal
     * @param local recebe o local da foto
     */
    public void setLocal(String local) {
        if (local.chars().anyMatch(Character::isDigit) || local.isBlank()) {
            throw new IllegalArgumentException("Local na foto não especificado");
        } else {
            this.local = local;
        }
    }

    /**
     * Método de acesso ao atributo data
     * @return uma string do atributo data do objeto foto
     */
    public String getData() {
        return data;
    }

    /**
     * Método de definição do atributo data
     * @param data recebe uma data do objeto foto
     */
    public void setData(String data) {
        this.data = data;
    }
}
