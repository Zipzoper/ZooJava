Classe Macaco:
 
public class Macaco extends Mamifero {
    private int bananasComidas = 0;
 
    public Macaco(String nome, int idade) {
        super(nome, idade, "Macaco");
    }
 
    @Override
    public void emitirSom() {
        System.out.println(getNome() + " gritou: Uh uh ah ah!");
    }
 
    @Override
    public void alimentar() {
        bananasComidas++;
        System.out.println(getNome() + " comeu uma banana! Total: " + bananasComidas);
    }
}
