package Desafio4;

public class Main {
    public static void main(String[] args) {

        NinjaBasico nakamura = new NinjaBasico("Nakamura", 15, "Konoha", "Lançar Shuriken", TipoHabilidade.TAIJUTSU);
        nakamura.mostrarInformacoes();
        nakamura.executarHabilidade();
        System.out.println();
        NinjaAvancado naruto = new NinjaAvancado("Naruto Uzumaki", 19, "Konoha", "Lançar Kunai", "Rasengan", TipoHabilidade.NINJUTSU);
        naruto.mostrarInformacoes();
        naruto.executarHabilidade();

    }
}
