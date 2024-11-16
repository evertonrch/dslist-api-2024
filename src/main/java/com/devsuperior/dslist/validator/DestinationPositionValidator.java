package com.devsuperior.dslist.validator;

import com.devsuperior.dslist.repository.BelogingRepository;
import org.springframework.stereotype.Component;

@Component
public class DestinationPositionValidator extends PositionValidator {

    public DestinationPositionValidator(BelogingRepository belogingRepository) {
        super(belogingRepository);
    }

    @Override
    protected boolean isValid(int position) {
        return belogingRepository.existsByPosition(position);
    }

    @Override
    protected String getErrorMessage() {
        return "Posição de destino inválida.";
    }
}