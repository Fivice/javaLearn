package top.fivice.design.patterns.creational.factory;

/**
 * @author wubin
 */
public class ScienceFactory implements Factory{
    /**
     * 生产器
     */
    @Override
    public void productor() {
        System.out.println("ScienceFactory.productor");
    }
}
