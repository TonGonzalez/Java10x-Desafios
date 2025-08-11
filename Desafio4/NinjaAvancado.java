package Desafio4;

public class NinjaAvancado extends NinjaBasico implements Ninja{

    String especialidade;

    public NinjaAvancado(String nome, int idade, String aldeia, String habilidadeBasica, String especialidade, TipoHabilidade tipoHabilidade) {
        super(nome, idade, aldeia, habilidadeBasica, tipoHabilidade);
        this.especialidade = especialidade;
    }

    @Override
    public void mostrarInformacoes() {
        super.mostrarInformacoes();
    }

    @Override
    public void executarHabilidade() {
       super.executarHabilidade();
        System.out.println("Também utilizo minha especialidade:"+especialidade+" sou um ninja avançado!");
    }
}
