package Product;

public class CPU extends Product {
    private String processor_number;
    private String lithography;
    private String no_cores;
    private String base_freq;

    public CPU(String name, String description, int price, String processor_number, String lithography, String no_cores, String base_freq) {
        super(name, description, price);
        this.processor_number = processor_number;
        this.lithography = lithography;
        this.no_cores = no_cores;
        this.base_freq = base_freq;
    }


    public String getProcessor_number() {
        return processor_number;
    }

    public String getLithography() {
        return lithography;
    }

    public String getNo_cores() {
        return no_cores;
    }

    public String getBase_freq() {
        return base_freq;
    }
}
