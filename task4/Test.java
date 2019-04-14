public class Test {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name").toLowerCase();

        OsFactory factory = null;
        if (osName.equals("windows 10")){
            factory= new WindowsFactory();
        }
        if (osName.equals("linux")){
            factory= new LinuxFactory();
        }
        if (osName.equals("mac os x")){
            factory= new MacFactory();
        }

        assert factory != null;
        Item button = factory.create("Button_");
        Item cmd = factory.create("cmd");
        button.display();
        cmd.display();

    }
}