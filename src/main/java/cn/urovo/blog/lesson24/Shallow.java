package cn.urovo.blog.lesson24;

/**
 * @url https://blog.csdn.net/Handsome_Le_le/article/details/110097341
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-02-25 06:29
 **/
public class Shallow {

    public static void main(String[] args) throws CloneNotSupportedException {
        //原始对象
        ShallowCopy shallowCopy = new ShallowCopy();
        shallowCopy.setBaseType(1);
        shallowCopy.setObjectClass("我是孤焰");

        //复制对象
        ShallowCopy shallowCopy2 = (ShallowCopy) shallowCopy.clone();

        shallowCopy.setBaseType(2);
        shallowCopy.setObjectClass("我是修改后的孤焰");

        System.out.println("原始对象的基础类型值为：" + shallowCopy.getBaseType());
        System.out.println("原始对象的引用类型的地址为：" + shallowCopy.getObjectClass());

        System.out.println();

        System.out.println("复制对象的基础类型值为：" + shallowCopy2.getBaseType());
        System.out.println("复制对象的引用类型的地址为：" + shallowCopy2.getObjectClass());
    }


}


class ObjectClass implements Cloneable {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ObjectClass{" +
                "content='" + content + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class ShallowCopy implements Cloneable {
    private int baseType;
    /**
     * 深复制和浅复制的主要区别就是在于对应用类型变量的拷贝.
     * 引用类型的成员对象没有被复制
     */
    private ObjectClass objectClass;

    public ShallowCopy() {
        objectClass = new ObjectClass();
    }

    public int getBaseType() {
        return baseType;
    }

    public void setBaseType(int baseType) {
        this.baseType = baseType;
    }

    public ObjectClass getObjectClass() {
        return objectClass;
    }

    public void setObjectClass(String value) {
        this.objectClass.setContent(value);
    }

    //浅拷贝的clone方法
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    //深度拷贝的clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        ShallowCopy shallowCopy = (ShallowCopy) super.clone();
        shallowCopy.objectClass = (ObjectClass) this.objectClass.clone();
        return shallowCopy;
    }
}