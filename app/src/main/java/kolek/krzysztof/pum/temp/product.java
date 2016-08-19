package kolek.krzysztof.pum.temp;

public class product
{
    private String id;
    private String name;
    private String qty;

    @Override
    public String toString() {
        return "Product [id=" + id+ ", name= " + name+",qty="+qty+"]";
    }
}