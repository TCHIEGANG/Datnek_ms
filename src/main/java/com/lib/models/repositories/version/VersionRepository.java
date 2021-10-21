package com.lib.models.repositories.version;

import com.lib.models.models.version.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VersionRepository extends JpaRepository<Version, Integer> {
    Optional<Version> findByIdServer(String idServer);
    Optional<List<Version>> findByActiveTrueAndDeletedFalse();
    Optional<List<Version>> findByActiveTrueAndDeletedFalseAndVersionAndDescription(String version, String description);
}
