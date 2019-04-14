package Product;

public class Laptop extends Product {
    private String cpu;
    private String gpu;
    private int ram;
    private double screen_size;

    public Laptop(String name, String description, int price, String cpu, String gpu, int ram, double screen_size) {
        super(name, description, price);
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.screen_size = screen_size;
    }

    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public int getRam() {
        return ram;
    }

    public double getScreen_size() {
        return screen_size;
    }
}
