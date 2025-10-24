Classe Elefante:
 
public class Elefante extends Mamifero {
    public Elefante(String nome, int idade) {
        super(nome, idade, "Elefante");
    }
 
    @Override
    public void emitirSom() {
        System.out.println(getNome() + " trombetou: Prrrrrrr!");
    }
 
    @Override
    public void alimentar() {
        System.out.println(getNome() + " comeu amendoins!");
    }
}
