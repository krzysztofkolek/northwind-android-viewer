package kolek.krzysztof.pum.Tools;

import java.util.Comparator;

import kolek.krzysztof.pum.models.Supplier;


public class SupplierComparator implements Comparator<Supplier> {
    @Override
    public int compare(Supplier o1, Supplier o2) {
        return o1.getContactName().compareTo(o2.getContactName());
    }
}
