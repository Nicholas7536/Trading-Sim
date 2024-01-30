import java.util.ArrayList;
import java.util.Objects;

public class Price implements Comparable<Price>{

    private final int Cents;
    public Price(int Cents) {
        this.Cents = Cents;
    }

    public int getCents() {
        return this.Cents;
    }

    public Price add(Price p) throws InvalidPriceOperation {
        if (p == null) {
            throw new InvalidPriceOperation("Cannot use null Price.");
        }
        int other = p.getCents();
        return new Price(this.Cents+other);
    }

    public Price subtract(Price p) throws InvalidPriceOperation {
        if (p == null) {
            throw new InvalidPriceOperation("Cannot use null Price.");
        }
        int other = p.getCents();
        return new Price(this.Cents-other);
    }

    public Price multiply(int n){
        return new Price(this.Cents*n);
    }

    public boolean isNegative() {
        return Cents < 0;
    }

    public boolean greaterOrEqual(Price p) throws InvalidPriceOperation {
        if (p == null) {
            throw new InvalidPriceOperation("Cannot use null Price.");
        }
        int other = p.getCents();
        return this.Cents >= other;
    }

    public boolean lessOrEqual(Price p) throws InvalidPriceOperation {
        if (p == null) {
            throw new InvalidPriceOperation("Cannot use null Price.");
        }
        int other = p.getCents();
        return this.Cents <= other;
    }

    public boolean greaterThan(Price p) throws InvalidPriceOperation {
        if (p == null) {
            throw new InvalidPriceOperation("Cannot use null Price.");
        }
        int other = p.getCents();
        return this.Cents > other;
    }

    public boolean lessThan(Price p) throws InvalidPriceOperation {
        if (p == null) {
            throw new InvalidPriceOperation("Cannot use null Price.");
        }
        int other = p.getCents();
        return this.Cents < other;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Cents == price.Cents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Cents);
    }


    @Override
    public String toString(){
        int dollars = Math.abs(this.Cents) / 100;
        int cents = Math.abs(this.Cents) % 100;

        String strCents;
        if (cents < 10) {
            strCents = "0" + cents;
        } else {
            strCents = String.valueOf(cents);
        }

        String strDollars;
        if (dollars == 0) {
            strDollars = "0";
        } else {
            strDollars = String.valueOf(dollars);
        }

        // Because cents/dollars were calculated with absolute value, determine whether
        // the string needs a negative sign from this object's cents variable.

        if (this.Cents < 0) {
            return "$-" + strDollars + "." + strCents;
        } else {
            return "$" + strDollars + "." + strCents;
        }
    }

    @Override
    public int compareTo(Price p) {
        if (p == null){
            return -1;
        }
        if (this.Cents < p.Cents) {
            return -1;
        } else if (this.Cents > p.Cents){
            return 1;
        } else {
            return 0;
        }

    }
}
