package com.gaia.snpc_erp.services;

import com.gaia.snpc_erp.dtos.CommuneDTO;
import com.gaia.snpc_erp.dtos.DepartmentDTO;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import com.gaia.snpc_erp.dtos.RegionDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class BaseApiClient {

    private final RestClient restClient;

    /**
     * Récupère toutes les regions
     */
    public List<RegionDTO> getAllRegions() {
        log.info("Appel API: GET /api/regions");

        return restClient.get()
                .uri("/api/regions")
                .retrieve()
                .onStatus(HttpStatusCode::isError, (request, response) -> {
                    log.error("Erreur lors de la récupération des regions: {}", response.getStatusCode());
                })
                .body(new ParameterizedTypeReference<List<RegionDTO>>() {});
    }

    /**
     * Récupère une region par Code
     */
    public RegionDTO getRegionByCode(String code) {
        log.info("Appel API: GET /api/regions/{}", code);

        return restClient.get()
                .uri("/api/regions/{code}", code)
                .retrieve()
                .body(RegionDTO.class);
    }

    /**
     * Récupère tous les departements
     */
    public List<DepartmentDTO> getAllDepartments() {
        log.info("Appel API: GET /api/departments");

        return restClient.get()
                .uri("/api/departments")
                .retrieve()
                .onStatus(HttpStatusCode::isError, (request, response) -> {
                    log.error("Erreur lors de la récupération des departements: {}", response.getStatusCode());
                })
                .body(new ParameterizedTypeReference<List<DepartmentDTO>>() {});
    }

    /**
     * Récupère un departement par ID
     */
    public DepartmentDTO getDepartmentById(String id) {
        log.info("Appel API: GET /api/departments/{}", id);

        return restClient.get()
                .uri("/api/departments/{id}", id)
                .retrieve()
                .body(DepartmentDTO.class);
    }

    /**
     * Récupère toutes les communes
     */
    public List<CommuneDTO> getAllCommunes() {
        log.info("Appel API: GET /api/communes");

        return restClient.get()
                .uri("/api/communes")
                .retrieve()
                .onStatus(HttpStatusCode::isError, (request, response) -> {
                    log.error("Erreur lors de la récupération des communes: {}", response.getStatusCode());
                })
                .body(new ParameterizedTypeReference<List<CommuneDTO>>() {});
    }

    /**
     * Récupère une commune par CODE
     */
    public CommuneDTO getCommuneByCode(String code) {
        log.info("Appel API: GET /api/communes/{}", code);

        return restClient.get()
                .uri("/api/communes/{code}", code)
                .retrieve()
                .body(CommuneDTO.class);
    }
}
