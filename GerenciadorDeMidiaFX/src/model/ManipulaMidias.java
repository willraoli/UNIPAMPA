package model;

import interfaces.IMidias;

import java.io.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ManipulaMidias implements IMidias, Serializable {
    ArrayList<Midia> listaMidias = new ArrayList<>();

    /**
     * Método para adicionar uma mídia à ArrayList listaMidias
     * @param m refere-se à mídia a ser adicionada
     */
    @Override
    public void adiciona(Midia m) {
        try {
            listaMidias.add(m);
        } catch (Exception e) {
            System.out.println("Não é possível adicionar esta mídia.");
        }
    }

    /**
     * Método para remover uma mídia da ArrayList listaMidias
     * @param obj refere-se a uma mídia que será comparada a uma existente
     */
    @Override
    public void remove(Midia obj) {
        try {
            Midia s = null;
            for (Midia m : listaMidias) {
                if (m == obj) {
                    s = m;
                }
            }
            listaMidias.remove(s);
        } catch (Exception e) {
            System.out.println("Não é possível remover está mídia");
        }
    }

    /**
     * Método para alterar uma mídia da ArrayList listaMidias
     * @param antigo mídia antiga
     * @param novo mídia nova
     */
    @Override
    public void alterar(Midia antigo, Midia novo) {
        listaMidias.set(listaMidias.indexOf(antigo), novo);
    }

    /**
     * Método para consultar um gênero do filme na ArrayList listaMidias
     * @param busca pelo gênero de filme
     * @return a ArrayList de midias com o gênero que foi buscado
     */
    public ArrayList<Midia> consultarGeneroF(String busca) {


        ArrayList<Midia> midia = new ArrayList<>();
        for (Midia m : listaMidias) {
            if (m instanceof Filme) {
                if (((Filme) m).getGenero().equalsIgnoreCase(busca)) {
                    midia.add(m);
                }
            }
        }
        if (midia.isEmpty()) {
            throw new NoSuchElementException("Não há filme com esse gênero cadastrados no banco de mídias");
        }
        return midia;
    }

    /**
     * Método para consultar um gênero de Música na ArrayList listaMidias
     * @param busca pelo gênero de música
     * @return a ArrayList de mídias com o gênero que foi buscado
     */
    public ArrayList<Midia> consultarGeneroM(String busca) {
        ArrayList<Midia> midia = new ArrayList<>();
        for (Midia m : listaMidias) {
            if (m instanceof Musica) {
                if (((Musica) m).getGenero().equalsIgnoreCase(busca)) {
                    midia.add(m);
                }
            }
        }
        if (midia.isEmpty()) {
            throw new NoSuchElementException("Não há músicas com esse gênero cadastradas no banco de mídias.");
        }
        return midia;
    }

    /**
     *Método para verificar se a mídia é uma foto e adicioná-la na ArrayList foto
     * @return a ArrayList de fotos
     */
    public ArrayList<Foto> getFotos() {
        try {
            ArrayList<Foto> foto = new ArrayList<>();
            for (Midia m : listaMidias) {
                if (m instanceof Foto) {
                    foto.add((Foto) m);
                }
            }
            return foto;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Não foi possível encontrar a(s) foto(s)");
            return null;
        }
    }

    /**
     *Método para verificar se a mídia é uma música e adicioná-la na ArrayList musica
     * @return a ArrayList de musica
     */
    public ArrayList<Musica> getMusicas() {
        ArrayList<Musica> musica = new ArrayList<>();
        for (Midia m : listaMidias) {
            if (m instanceof Musica) {
                musica.add((Musica) m);
            }
        }
        return musica;
    }

    /**
     * Método para verificar se a mídia é um filme e adicioná-la na ArrayList filme
     * @return a ArrayList filme
     */
    public ArrayList<Filme> getFilmes() {
        try {
            ArrayList<Filme> filme = new ArrayList<>();
            for (Midia m : listaMidias) {
                if (m instanceof Filme) {
                    filme.add((Filme) m);
                }
            }
            return filme;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Não foi possível encontrar o(s) filme(s)");
            return null;
        }
    }

    /**
     * Método para realizar a gravação das informações das Mídias no arquivo 'database.bin'
     * @throws IOException foi utilizado, pois pode não haver um arquivo 'database.bin'
     */
    public void gravarNoArquivo() throws IOException {
        ObjectOutputStream output;

        output = new ObjectOutputStream(new FileOutputStream("database.bin"));
        output.writeObject(listaMidias);
        output.close();
        System.out.println("gravou");
    }

    /**
     * Método para realizar a leitura do arquivo 'database.bin'
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void lerArquivo() throws IOException, ClassNotFoundException {
        ObjectInputStream ostream = new ObjectInputStream(new FileInputStream("database.bin"));
        listaMidias = (ArrayList<Midia>) ostream.readObject();
    }
}