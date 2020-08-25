package VendingMachine;


import java.util.List;

public class VendingMachineFactory {
    public static VendingMachine createVendingMachine(){
        return new VendingMachineImpl();
    }
}
