package top.fivice.design.patterns.creational.factory;

/**
 * @author wubin
 */
public class WorldFactory {
    public static Factory getFactory(String factory){
        Factory f = null;
        switch (factory){
            case "art": f = new ArtFactory();break;
            case "science": f = new ScienceFactory();break;
            default:
        }
        return f;
    }

    public static void main(String[] args) {
        Factory factory = WorldFactory.getFactory("art");
        factory.productor();
        factory = WorldFactory.getFactory("science");
        factory.productor();
    }
}
