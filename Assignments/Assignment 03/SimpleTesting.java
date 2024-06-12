public class SimpleTesting {
    public static void main(String[] args) {

        final String PASS = new String("PASSED");
        final String FAIL = new String("FAILED");
        
        DynamicArray elfishNames = new DynamicArray();
        DynamicArray dwarfNames = new DynamicArray();
        DynamicArray klingonNames = new DynamicArray();

        elfishNames.add("Lorfindel");
        elfishNames.add("Galadriel");
        elfishNames.add("Eldrin");
        elfishNames.add("Celeborn");
        elfishNames.add("Arwen");
        elfishNames.add("Legolas");
        elfishNames.add("Elrond");

        dwarfNames.add("Thorin");
        dwarfNames.add("Gimli");
        dwarfNames.add("Durin");
        dwarfNames.add("Balin");
        dwarfNames.add("Eldrin");
        dwarfNames.add("Fili");
        dwarfNames.add("Kili");

        klingonNames.add("Gorkon");
        klingonNames.add("Kahless");
        klingonNames.add("Kor");
        klingonNames.add("Worf");
        klingonNames.add("Duras");
        klingonNames.add("Kang");
        klingonNames.add("Gowron");

        boolean elfDwarf = elfishNames.intersects(dwarfNames); // Expect true (Eldrin)
        boolean dwarfElf = dwarfNames.intersects(elfishNames); // Expect true (Eldrin)

        boolean elfKlingon = elfishNames.intersects(klingonNames); // Expect false
        boolean klingonElf = klingonNames.intersects(elfishNames); // Expect false

        boolean dwarfDwarf = dwarfNames.intersects(dwarfNames); // Expect true 

        boolean result = elfDwarf && dwarfElf && !elfKlingon && !klingonElf && dwarfElf;
        String resultString = (result) ? PASS : FAIL;

        String report = String.format("\n\nYou %s the test\n\n", resultString);
        System.out.println(report);

    }
}