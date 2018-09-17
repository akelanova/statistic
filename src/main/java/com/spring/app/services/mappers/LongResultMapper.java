package com.spring.app.services.mappers;

import com.spring.app.DataNotFoundException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Map data set to single value and cast it to Long
 *
 * @author Lyubov Ruzanova
 */
public class LongResultMapper implements ResultMapper<List<Object>, Long> {
    private static final int INDEX = 0;

    /**
     * {@InheritDoc}
     */
    @Override
    public Long map(List<Object> objects) throws DataNotFoundException {
        if (objects != null && !objects.isEmpty() && objects.get(INDEX) != null) {
            Object object = objects.get(INDEX);
            if (object instanceof BigDecimal) {
                return ((BigDecimal) object).longValue();
            }else if (object instanceof BigInteger) {
                return ((BigInteger) object).longValue();
            }else if (object instanceof Double) {
                return ((Double) object).longValue();
            }
            throw new DataNotFoundException("The received value is incorrect.");
        }
        throw new DataNotFoundException("Data not found.");
    }
}