package Desafio4;

public class NinjaBasico implements Ninja{

    String nome;
    int idade;
    String aldeia;
    String habilidadeBasica;
    TipoHabilidade tipoHabilidade;

    public  NinjaBasico(String nome, int idade, String aldeia, String habilidadeBasica, TipoHabilidade tipoHabilidade) {
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        this.habilidadeBasica = habilidadeBasica;
        this.tipoHabilidade = tipoHabilidade;
    }
    public NinjaBasico(){}

    @Override
    public void mostrarInformacoes() {
        System.out.println(
                "Nome:"+nome+
                "\nIdade:"+idade+
                "\nAldeia:"+aldeia+
                "\nTipo de Habilidade:"+tipoHabilidade);
    }

    @Override
    public void executarHabilidade() {
        System.out.println(
                "Sou um ninja, tenho o ataque base de:"+habilidadeBasica);
    }
}
