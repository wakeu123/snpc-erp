package com.gaia.snpc_erp.controllers;

import com.gaia.snpc_erp.dtos.CommuneDTO;
import lombok.RequiredArgsConstructor;
import com.gaia.snpc_erp.dtos.RegionDTO;
import com.gaia.snpc_erp.dtos.ApiResponse;
import org.springframework.http.HttpStatus;
import com.gaia.snpc_erp.dtos.DepartmentDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import com.gaia.snpc_erp.services.BaseApiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
@Tag(name = "SNPC-ERP API", description = "SNPC-ERP API Gateway qui appelle l'API de base")
public class gatewayController {

    private final BaseApiClient baseApiClient;

    /**
     * Endpoint 1: Récupère la liste de toutes les regions
     */
    @GetMapping("/regions")
    @Operation(summary = "Liste toutes les regions",
            description = "Récupère toutes les regions depuis l'API de base")
    public ResponseEntity<ApiResponse<List<RegionDTO>>> getAllRegions() {
        try {
            List<RegionDTO> regions = baseApiClient.getAllRegions();

            return ResponseEntity.ok(
                    new ApiResponse<>(true, "Regions récupérés avec succès", regions)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Erreur: " + e.getMessage(), null));
        }
    }

    /**
     * Endpoint 2: Récupère une region par son CODE
     */
    @GetMapping("/regions/{code}")
    @Operation(summary = "Récupère une region",
            description = "Récupère les détails d'une region depuis l'API de base")
    public ResponseEntity<ApiResponse<RegionDTO>> getRegion(@PathVariable String code) {
        try {
            RegionDTO region = baseApiClient.getRegionByCode(code);

            return ResponseEntity.ok(
                    new ApiResponse<>(true, "Region récupéré avec succès", region)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Erreur: " + e.getMessage(), null));
        }
    }

    /**
     * Endpoint 3: Récupère la liste de toutes les départements
     */
    @GetMapping("/departments")
    @Operation(summary = "Liste tous les départements",
            description = "Récupère tous les départements depuis l'API de base")
    public ResponseEntity<ApiResponse<List<DepartmentDTO>>> getAllDepartments() {
        try {
            List<DepartmentDTO> departments = baseApiClient.getAllDepartments();

            return ResponseEntity.ok(
                    new ApiResponse<>(true, "Départements récupérés avec succès", departments)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Erreur: " + e.getMessage(), null));
        }
    }

    /**
     * Endpoint 4: Récupère un département par son ID
     */
    @GetMapping("/departments/{id}")
    @Operation(summary = "Récupère un département",
            description = "Récupère les détails d'un département depuis l'API de base")
    public ResponseEntity<ApiResponse<DepartmentDTO>> getProduct(@PathVariable String id) {
        try {
            DepartmentDTO department = baseApiClient.getDepartmentById(id);

            return ResponseEntity.ok(
                    new ApiResponse<>(true, "Département récupéré avec succès", department)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Erreur: " + e.getMessage(), null));
        }
    }

    /**
     * Endpoint 5: Récupère la liste de toutes les communes
     */
    @GetMapping("/communes")
    @Operation(summary = "Liste tous les communes",
            description = "Récupère toutes les communes depuis l'API de base")
    public ResponseEntity<ApiResponse<List<CommuneDTO>>> getAllCommunes() {
        try {
            List<CommuneDTO> communes = baseApiClient.getAllCommunes();

            return ResponseEntity.ok(
                    new ApiResponse<>(true, "Communes récupérés avec succès", communes)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Erreur: " + e.getMessage(), null));
        }
    }

    /**
     * Endpoint 6: Récupère un commune par son CODE
     */
    @GetMapping("/communes/{code}")
    @Operation(summary = "Récupère une commune",
            description = "Récupère les détails d'une commune depuis l'API de base")
    public ResponseEntity<ApiResponse<CommuneDTO>> getCommune(@PathVariable String code) {
        try {
            CommuneDTO commune = baseApiClient.getCommuneByCode(code);

            return ResponseEntity.ok(
                    new ApiResponse<>(true, "Commune récupéré avec succès", commune)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(false, "Erreur: " + e.getMessage(), null));
        }
    }
}
