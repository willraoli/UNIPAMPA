package model;

public abstract class Midia {
	private static int cont = 0;
    private String caminhoDoArquivo;
    private String titulo;
    private String descricao;
    private final int codigo;

    public Midia(String titulo, String descricao, String caminhoDoArquivo) {
    	codigo = 1 + cont;
        this.titulo = titulo;
        this.descricao = descricao;
        this.caminhoDoArquivo = caminhoDoArquivo;
        Midia.cont++;
    }
public int getCodigo() {
	return codigo;
}
    
    public String getCaminhoDoArquivo() {
        return caminhoDoArquivo;
    }

    public void setCaminhoDoArquivo(String caminhoDoArquivo) {
        this.caminhoDoArquivo = caminhoDoArquivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
