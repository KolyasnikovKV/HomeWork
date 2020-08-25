package VendingMachine;

public class Sample {
    public static void main(String[] args){
        VendingMachine vm = VendingMachineFactory.createVendingMachine();
        long price = vm.selectItemAndGetPrice(Item.COKE);
        System.out.println("Price : " + price);
        vm.insertCoin(Coin.QUARTER);
        Bucket bucket = vm.collectionItemAndChange();
        System.out.println("{Return} " + bucket);

        vm.selectItemAndGetPrice(Item.COKE);
        vm.insertCoin(Coin.QUARTER);
        bucket = vm.collectionItemAndChange();
        System.out.println("[Return] " + bucket);

        ((VendingMachineImpl)vm).printStats();
    }
}
