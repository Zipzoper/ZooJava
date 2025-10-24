Classe Leão:
 
public class Leao extends Mamifero {
    public Leao(String nome, int idade) {
        super(nome, idade, "Leão");
    }
 
    @Override
    public void emitirSom() {
        System.out.println(getNome() + " rugiu: Rooooar!");
    }
 
    @Override
    public void alimentar() {
        System.out.println(getNome() + " comeu carne!");
    }
}
