package br.com.mariojp.solid.ocp;

import br.com.mariojp.solid.ocp.policies.PartnerPolicy;
import br.com.mariojp.solid.ocp.policies.PremiumPolicy;
import br.com.mariojp.solid.ocp.policies.RegularPolicy;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {
    private final Map<CustomerType, DiscountPolicy> policies;

    // Construtor padrão para compatibilidade com Main e Test
    public DiscountCalculator() {
        this.policies = new HashMap<>();
        this.policies.put(CustomerType.REGULAR, new RegularPolicy());
        this.policies.put(CustomerType.PREMIUM, new PremiumPolicy());
        this.policies.put(CustomerType.PARTNER, new PartnerPolicy());
    }

    public DiscountCalculator(Map<CustomerType, DiscountPolicy> policies) {
        this.policies = policies;
    }

    public double apply(double amount, CustomerType type) {
        DiscountPolicy policy = policies.get(type);
        return (policy != null) ? policy.apply(amount) : amount;
    }
}
