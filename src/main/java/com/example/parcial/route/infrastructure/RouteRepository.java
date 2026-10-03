package com.example.parcial.route.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public class RouteRepository {
    public static boolean existsByRoute;

    public interface RoutRepository extends JpaRepository
    boolean existsByRoute(String Route)
}
