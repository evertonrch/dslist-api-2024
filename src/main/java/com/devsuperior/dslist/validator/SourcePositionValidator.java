package com.devsuperior.dslist.validator;

import com.devsuperior.dslist.repository.BelogingRepository;
import org.springframework.stereotype.Component;

@Component
public class SourcePositionValidator extends PositionValidator {

    public SourcePositionValidator(BelogingRepository belogingRepository) {
        super(belogingRepository);
    }

    @Override
    protected boolean isValid(int position) {
        return belogingRepository.existsByPosition(position);
    }

    @Override
    protected String getErrorMessage() {
        return "Posição de origem inválida.";
    }
}
