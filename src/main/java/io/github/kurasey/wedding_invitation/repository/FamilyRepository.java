package io.github.kurasey.wedding_invitation.repository;

import io.github.kurasey.wedding_invitation.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    Optional<Family> findByPersonalLink(String personalLink);

    @Query("SELECT f FROM Family f WHERE f.confirmationDeadline < :today AND f.guests IS EMPTY")
    List<Family> findProblemFamilies(LocalDate today);

    @Query("SELECT f FROM Family f WHERE NOT EXISTS " +
            "(SELECT g FROM Guest g WHERE g.family = f AND g.willAttend = true)")
    List<Family> findFamiliesWithNoConfirmedGuests();
}