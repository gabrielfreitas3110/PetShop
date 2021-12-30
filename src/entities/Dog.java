package entities;

public class Dog {
    private Integer cod;
    private String nome;
    private String raca;
    private Integer idade;;
    private Double peso;
    private String sexo;
    private String cor;

    public Dog() {
    }

    public Dog(Integer cod, String nome, String raca, Integer idade, Double peso, String sexo, String cor) {
        this.cod = cod;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.sexo = sexo;
        this.cor = cor;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Dog{" + "cod=" + cod + ", nome=" + nome + ", raca=" + raca + ", idade=" + idade + ", peso=" + peso + ", sexo=" + sexo + ", cor=" + cor + '}';
    }
}