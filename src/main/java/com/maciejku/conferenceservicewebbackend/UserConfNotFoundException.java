package com.maciejku.conferenceservicewebbackend;

class UserConfNotFoundException extends RuntimeException {
    UserConfNotFoundException(Long id) {
        super("Nie znaleziono uzytkownika " + id);
    }
}
