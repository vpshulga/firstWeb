package services;

import entities.cards.Diagnosys;
import java.io.Serializable;

public interface DiagnosysService {
    Diagnosys save(Diagnosys diagnosys);

    Diagnosys get(Serializable id);

    void update(Diagnosys nurse);

    int delete(Serializable id);
}
