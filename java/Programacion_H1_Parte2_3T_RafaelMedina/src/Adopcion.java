public class Adopcion {
    private Animal animal;
    private String nombreAdoptante;
    private String dniAdoptante;

    // Constructor con los datos necesarios
    public Adopcion(Animal animal, String nombreAdoptante, String dniAdoptante) {
        this.animal = animal;
        this.nombreAdoptante = nombreAdoptante;
        this.dniAdoptante = dniAdoptante;
    }

    // Métodos getters para acceder a los atributos
    public Animal getAnimal() {
        return animal;
    }

    public String getNombreAdoptante() {
        return nombreAdoptante;
    }

    public String getDniAdoptante() {
        return dniAdoptante;
    }
}

