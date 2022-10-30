package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.Report;

public class ReportImpl implements Report {
    private static final String STRING_SEPARATOR = ",";
    private static final String DATA_TYPE_MAKER = "fruit" + STRING_SEPARATOR + "quantity";
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public String makeReport() {
        StringBuilder builder = new StringBuilder();
        builder.append(DATA_TYPE_MAKER).append(System.lineSeparator());
        fruitDao.getStorage().forEach(i ->
                builder.append(i.getType())
                .append(STRING_SEPARATOR)
                        .append(i.getQuantity())
                        .append(System.lineSeparator()));

        return builder.toString();
    }
}
