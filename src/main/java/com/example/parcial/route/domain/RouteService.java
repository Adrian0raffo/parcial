package com.example.parcial.route.domain;

import com.example.parcial.config.ModelMapper;
import com.example.parcial.route.dto.RouteRequest;
import com.example.parcial.route.dto.RouteResponse;
import com.example.parcial.route.infrastructure.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;
    public RouteResponse create(RouteRequest request, Userowner){
        if (RouteRepository.existsByRoute(request.getClass())){

        }
    }
}
