    package com.example.Prestamos.controllers;

    import com.example.Prestamos.models.Prestamos;
    import com.example.Prestamos.repositories.PrestamoRepository;
    import com.example.Prestamos.service.PrestamoService;
    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.Parameter;
    import io.swagger.v3.oas.annotations.media.Content;
    import io.swagger.v3.oas.annotations.media.Schema;
    import io.swagger.v3.oas.annotations.responses.ApiResponse;
    import io.swagger.v3.oas.annotations.responses.ApiResponses;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import reactor.core.publisher.Flux;
    import reactor.core.publisher.Mono;
    import java.util.Optional;

    @RestController
    @RequestMapping("/v1/prestamos")
    @Tag(name = "Prestamos Controller", description = "Operaciones relacionadas con libros")
    public class LibroPrestamoController {
        private PrestamoRepository prestamoRepository;
        private PrestamoService prestamoService;

        @Autowired
        public LibroPrestamoController(PrestamoRepository prestamoRepository,  PrestamoService prestamoService) {
            this.prestamoRepository = prestamoRepository;
            this.prestamoService = prestamoService;
        }

        @PostMapping("/")
        @Operation(summary = "CrearPrestamo", description ="Permite Crear un Prestamo")
        @Parameter(name = "Prestamo", description = "Prestamo a crear", content = @Content(schema = @Schema(implementation = Prestamos.class)))
        @ApiResponse(responseCode = "200", description = "Prestamo Creado")
        public ResponseEntity<String> crearPrestamo(@RequestBody Prestamos prestamo) {
            try {
                prestamoService.crearPrestamo(prestamo);
                return ResponseEntity.status(HttpStatus.CREATED).body("Prestamo creado exitosamente");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear prestamo");
            }
        }

        @GetMapping("/{id}")
        @Operation(summary = "Consultar Prestamos por Id", description = "Permite consultar un Prestamo por id")
        @Parameter(name = "Id", description = "Id del Prestamo a buscar")
        @ApiResponse(responseCode = "200", description = "Prestamo Encontrado")
        public ResponseEntity<Prestamos> findById(@PathVariable Long id){
            Optional<Prestamos> prestamo = Optional.ofNullable(prestamoService.obtenerPorId(id));
            return prestamo.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @GetMapping("")
        @Operation(summary = "Buscar todos los Prestamos", description = "Permite obtener el listado de todos los Prestamos")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Prestamos creados en el sistema",
                        content = @Content(schema = @Schema(implementation = Prestamos.class)))
        })
        public Flux<Prestamos> findAll() {
            return prestamoService.obtenerTodosLosPrestamos();
        }

        @PutMapping("{id}")
        @Operation(summary = "Actualizar un Prestamo", description = "Permite actualizar un Prestamo existente")
        @Parameter(name = "Prestamo", description = "Prestamo a actualizar", content = @Content(schema = @Schema(implementation = Prestamos.class)))
        @ApiResponse(responseCode = "200", description = "Prestamo actualizado",
                content = @Content(schema = @Schema(implementation = Prestamos.class)))
        public Mono<Prestamos> actualizarPrestamo(@PathVariable Long id, @RequestBody Prestamos prestamos) {
            return prestamoService.actualizarPrestamo(id, prestamos);
        }

        @DeleteMapping("/{id}")
        @ResponseBody
        @Operation(summary = "Borrar un Prestamo por Id", description = "Permite borrar un Prestamo, dado un Id")
        @Parameter(name = "Id", description = "Id del Prestamo a borrar")
        @ApiResponse(responseCode = "204", description = "Prestamo eliminado")
        public Mono<Void> delete(@PathVariable Long id) {
            return prestamoService.eliminarPrestamo(id);
        }

        @GetMapping("/actuator/health")
        public String health(){
            return "OK";
        }


        @GetMapping("/actuator/metrics")
        public String metrics(){
            return "Metrics";
        }

        @GetMapping("/actuator/info")
        public String info() {
            return "info";
        }

    }
