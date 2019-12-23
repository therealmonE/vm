package io.github.therealmone.cpuemulator;

public final class Config {

    public static int REG_COUNT = 16;
    public static int MEM_SIZE = 100;

    public static int TYPE_SHIFT = 20;
    public static int TYPE_MASK = 0x0000000F;

    public static int LITERAL_SHIFT = 12;
    public static int LITERAL_MASK = 0x000000FF;

    public static int DESTINATION_SHIFT = 8;
    public static int DESTINATION_MASK = 0x0000000F;

    public static int OP1_SHIFT = 4;
    public static int OP1_MASK = 0x0000000F;

    public static int OP2_SHIFT = 0;
    public static int OP2_MASK = 0x0000000F;

}
