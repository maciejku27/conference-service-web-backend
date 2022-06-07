package com.maciejku.conferenceservicewebbackend;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserConfRepository extends JpaRepository<UserConf, Long> {
}
