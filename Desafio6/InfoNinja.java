package Desafio6;

public class InfoNinja {

    private String nome;
    private String vila;
    private int idade;

    public InfoNinja() {}

    public InfoNinja(String vila, int idade, String nome) {
        this.vila = vila;
        this.idade = idade;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVila() {
        return vila;
    }

    public void setVila(String vila) {
        this.vila = vila;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "\nDados Ninja:" +
                "\nNome - " + getNome() +
                "\nVila - " + getVila() +
                "\nIdade - " + getIdade() +
                "\n__________________";
    }
}
