package hw1.task1_3_2;

interface Product {
    void doSomething();
}

abstract class Creator {
    public void someOperation() {
        Product p = createProduct();
        p.doSomething();
    }

    abstract Product createProduct();
}

class ConcreteCreator1 extends Creator {
    @Override
    Product createProduct() {
        return new Product1();
    }
}

class ConcreteCreator2 extends Creator {
    @Override
    Product createProduct() {
        return new Product2();
    }
}

class Product1 implements Product {
    public void doSomething() {}
}

class Product2 implements Product {
    public void doSomething() {}
}