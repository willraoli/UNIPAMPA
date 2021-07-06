package model;

import java.util.ArrayList;
import java.util.Date;

public class Foto extends Midia{
    private Pessoa fotografo;
    private ArrayList<Pessoa> pessoasNaFoto;
    private String local;
    private Date data;

    public Foto(String titulo, String descricao, Pessoa fotografo, ArrayList<Pessoa> pessoasNaFoto, String local, Date data, String caminhoDoArquivo){
        super(titulo, descricao, caminhoDoArquivo);
        this.fotografo = fotografo;
        this.pessoasNaFoto = pessoasNaFoto;
        this.local = local;
        this.data = data;
    }

    public Pessoa getFotografo() {
        return fotografo;
    }

    public void setFotografo(Pessoa fotografo) {
        this.fotografo = fotografo;
    }

    public ArrayList<Pessoa> getPessoasNaFoto() {
        return pessoasNaFoto;
    }

    public void setPessoasNaFoto(ArrayList<Pessoa> pessoasNaFoto) {
        this.pessoasNaFoto = pessoasNaFoto;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
