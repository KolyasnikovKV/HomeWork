package main.ru.kolyasnikovkv.archivator;

public class ResourceFactory {
    private static class ResourceHolder {
        static {
            System.out.println("static class ResourceHolder");
        }
        public static Holder resource = new Holder(43);
    }
    public static Holder getResource() {
        System.out.println("static getResource");
        return ResourceHolder.resource;
    }
  //-verbose:class
    public static void main(String[] args)  {
        System.out.println("static void main");
        Holder holder = ResourceFactory.getResource();
        System.out.println();
    }

}
