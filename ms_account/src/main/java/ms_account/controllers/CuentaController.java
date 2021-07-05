package ms_account.controllers;

import ms_account.models.Cuenta;
import ms_account.models.Transaccion;
import ms_account.repositories.CuentaRepository;
import ms_account.repositories.TransaccionRepository;

import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class CuentaController {

    private final CuentaRepository repositoryCuenta;

    public CuentaController(CuentaRepository repositoryCuenta, TransaccionRepository repositoryTransaccion){
        this.repositoryCuenta = repositoryCuenta;
    }

    @GetMapping("/cuentas/{idUser}")
    Cuenta getCuenta(@PathVariable String idUser){
        return repositoryCuenta.findById(idUser).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

}
