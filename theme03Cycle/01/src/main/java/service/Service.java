package service;

import java.math.BigInteger;

public class Service {
    public BigInteger calculate()
    {
        BigInteger composition = BigInteger.valueOf(1);
        for (int i = 1; i <= 200; i++)
        {
            composition = composition.multiply(BigInteger.valueOf(i * i));
        }
        return composition;
    }
}
