package by.training.test1.service;

import by.training.test1.entity.Test1;

public class Service {
    public int sumVars(Test1 obj) {
        return obj.getVar1() + obj.getVar2();
    }

    public int maxVars(Test1 obj) {
        return Math.max(obj.getVar1(), obj.getVar2());
    }
}
