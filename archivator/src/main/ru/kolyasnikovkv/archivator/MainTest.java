package main.ru.kolyasnikovkv.archivator;

class MainTest {

    public volatile Holder holder;
    //public final Holder holder = new Holder(43);


    public static void main(String[] args)  {
            MainTest mainTest = new MainTest();

    }

    public MainTest(){
        //int var = 20;
        holder = new Holder(43);
        print();
    }


    public int print()
    {
        int var = 2;
        System.out.println(var);
        return var;
    }
}




