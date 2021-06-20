package com.learn.spring.mongo.springmongodbdemo.designpattern;


public class Decorator {
    public static void main(String[] args) {
         CoffeeService espresso = new WithExtraSugar(new WithExtraMilk(new Espresso()));
         System.out.println("Item : "+ espresso.getDescription() + " Total Cost: "+espresso.getCost());
    }
}

/** 
 * CoffeeService -> Espresso, Latte, 
*/
interface CoffeeService {
    String getDescription();
    double getCost();
}

class Espresso implements CoffeeService {


    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 1.99;
    }
}


abstract class CoffeeDecorator implements CoffeeService{
    protected CoffeeService coffeeService;

    public CoffeeDecorator (final CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }
}


class WithExtraSugar extends CoffeeDecorator {
    

    public WithExtraSugar(CoffeeService coffeeService) {
        super(coffeeService);
    }

    @Override
    public String getDescription() {
        return "Added extra sugar, " + coffeeService.getDescription();
    }

    @Override
    public double getCost() {
        return 0.99 + coffeeService.getCost();
    }
}



class WithExtraMilk extends CoffeeDecorator {
    

    public WithExtraMilk(CoffeeService coffeeService) {
        super(coffeeService);
    }

    @Override
    public String getDescription() {
        return "Added extra milk, " + coffeeService.getDescription();
    }

    @Override
    public double getCost() {
        return 0.25 + coffeeService.getCost();
    }
}
