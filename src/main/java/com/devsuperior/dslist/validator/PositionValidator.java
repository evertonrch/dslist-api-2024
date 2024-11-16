package com.devsuperior.dslist.validator;

import com.devsuperior.dslist.exception.InvalidPositionException;
import com.devsuperior.dslist.repository.BelogingRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class PositionValidator {

    protected final BelogingRepository belogingRepository;

    public void validate(int position) {
        if (!isValid(position)) {
            throw new InvalidPositionException(getErrorMessage());
        }
    }

    protected abstract boolean isValid(int position);
    protected abstract String getErrorMessage();
}
