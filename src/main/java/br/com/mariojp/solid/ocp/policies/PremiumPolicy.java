package br.com.mariojp.solid.ocp.policies;

import br.com.mariojp.solid.ocp.DiscountPolicy;

public class PremiumPolicy implements DiscountPolicy {
    @Override
    public double apply(double amount) {
        return amount * 0.90;
    }
}
