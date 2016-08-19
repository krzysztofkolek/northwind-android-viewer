package kolek.krzysztof.pum.interfaces;

import java.util.List;
import java.util.Map;

/**
 * Created by Krzys on 01-11-15.
 */
public interface IModalData<T> {
    Map<String, String> GetModalData();
    String[] FormatedData();
}
