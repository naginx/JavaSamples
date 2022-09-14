import java.util.Set;

/**
 * 良いコード/悪いコードのサンプルコード
 */
public class MinoDrivenSample {
    public static void main(String[] args) {
    }
}

final class PurchaseHistory {
    final int totalAmount;
    final int purchaseFrequencyPerMonth;
    final float returnRate;

    PurchaseHistory(int totalAmount, int purchaseFrequencyPerMonth, float returnRate) {
        this.totalAmount = totalAmount;
        this.purchaseFrequencyPerMonth = purchaseFrequencyPerMonth;
        this.returnRate = returnRate;
    }
}

interface ExcellentCustomerRule {
    boolean ok(final PurchaseHistory history);
}

final class GoldCustomerPurchaseAmountRule implements ExcellentCustomerRule {
    @Override
    public boolean ok(final PurchaseHistory history) {
        return 10000 <= history.totalAmount;
    }
}

final class PurchaseFrequencyRule implements ExcellentCustomerRule {
    @Override
    public boolean ok(final PurchaseHistory history) {
        return 10 <= history.purchaseFrequencyPerMonth;
    }
}

final class ReturnRule implements ExcellentCustomerRule {
    @Override
    public boolean ok(PurchaseHistory history) {
        return history.returnRate <= 0.001;
    }
}

final class ExcellentCustomerPolicy {
    private final Set<ExcellentCustomerRule> rules;

    ExcellentCustomerPolicy(Set<ExcellentCustomerRule> rules) {
        this.rules = rules;
    }

    void add(final ExcellentCustomerRule rule) {
        rules.add(rule);
    }

    boolean complyWithAll(final PurchaseHistory history) {
        for (ExcellentCustomerRule each : rules) {
            if (!each.ok(history)) { return false; }
        }
        return true;
    }
}



