class Computer
{
    private String CPU;
    private int RAM;
    private int Storage;

    private Computer(Builder builder){
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
    }

    static class Builder{
        private final String CPU;
        private int RAM;
        private int Storage;

        public Builder(String CPU)
        {
            this.CPU = CPU;
        }

        public Builder setRAM(int RAM)
        {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int Storage)
        {
            this.Storage = Storage;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample{
    public static void main(String[] args) {
        Computer AMD = new Computer.Builder("AMD")
                .setRAM(4)
                .setStorage(64)
                .build();
        Computer INTEL = new Computer.Builder("INTEL")
                .setRAM(6)
                .setStorage(256)
                .build();
    }
}
