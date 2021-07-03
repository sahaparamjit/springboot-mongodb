package com.learn.spring.mongo.springmongodbdemo.designpattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractFactory {

    private static final String LOG = "Object {}";

    public static void main(String[] args) {
        IFactory roundFactory = FactoryProducer.getAbstractFactory(true);
        IFactory normalFactory = FactoryProducer.getAbstractFactory(false);
        Shape shape = roundFactory.getShape(ShapeType.RECTANGLE);
        log.info(LOG, shape.draw());
        shape = roundFactory.getShape(ShapeType.SQUARE);
        log.info(LOG, shape.draw());
        shape = normalFactory.getShape(ShapeType.RECTANGLE);
        log.info(LOG, shape.draw());
        shape = normalFactory.getShape(ShapeType.SQUARE);
        log.info(LOG, shape.draw());
    }
}

class FactoryProducer {
    private FactoryProducer() {}
    public static IFactory getAbstractFactory(boolean roundShape) {
        if (roundShape) {
            return new RoundFactory();
        }
        return new NormalFactory();
    }
}

interface IFactory {
    Shape getShape(ShapeType type);
}

class RoundFactory implements IFactory {

    @Override
    public Shape getShape(ShapeType type) {
        switch (type) {
            case RECTANGLE:
                return new RoundRectangle();
            case SQUARE:
                return new RoundSquare();
            default:
                throw new RuntimeException("Shape not supported" + type);

        }
    }

}

class NormalFactory implements IFactory {

    @Override
    public Shape getShape(ShapeType type) {
        switch (type) {
            case RECTANGLE:
                return new NormalRectangle();
            case SQUARE:
                return new NormalSquare();
            default:
                throw new RuntimeException("Shape not supported" + type);
        }
    }

}

class RoundRectangle implements Shape {

    @Override
    public String draw() {
        return "Drawing round rectangle";   
    }
}


class RoundSquare implements Shape {
    @Override
    public String draw() {
        return "Drawing Round Square!";
    }
}


class NormalSquare implements Shape {
    
    @Override
    public String draw() {
       return "Drawing normal square!";
    }
}


class NormalRectangle implements Shape {

    @Override
    public String draw() {
        return "Drawing normal rectangle!";
    }
}

interface Shape {
    String draw();
}

enum ShapeType {
    RECTANGLE, SQUARE
}
