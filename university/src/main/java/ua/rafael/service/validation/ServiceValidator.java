package ua.rafael.service.validation;

public interface ServiceValidator<T> {
	void validateBySimilarObject(T object);
}
