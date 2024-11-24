package main.java.br.fatec.product.dtos;

public record ProductResquest (   
        @NotBlank(message = "Nome não pode ser em branco")
        @Size(min=3, max=100, message = "Nome deve ter entre 3 e 100 caracteres")
        String name,

        @Min(value = 0, message = "Preço deve ser maior que zero")
        double price,

        @NotBlank(message = "Categoria não pode ser em branco")
        String category
){

}
