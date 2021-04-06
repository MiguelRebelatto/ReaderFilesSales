package entity;

public class Client {

    private Long id;
    private String cnpj;
    private String name;
    private String segment;

    public Client() {}

    public Client(String cnpj, String name, String segment) {
        this.cnpj = cnpj;
        this.name = name;
        this.segment = segment;
    }


}
