package kolek.krzysztof.pum.Tools;

import java.util.Comparator;

import kolek.krzysztof.pum.models.Customer1;

public class CustomerComparator implements Comparator<Customer1> {
    @Override
    public int compare(Customer1 o1, Customer1 o2) {
        return o1.getContactName().compareTo(o2.getContactName());
    }
}
