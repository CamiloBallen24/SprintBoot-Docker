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
public class TransaccionController {

    private final CuentaRepository repositoryCuenta;
    private final TransaccionRepository repositoryTransaccion;

    public TransaccionController(CuentaRepository repositoryCuenta, TransaccionRepository repositoryTransaccion){
        this.repositoryCuenta = repositoryCuenta;
        this.repositoryTransaccion = repositoryTransaccion;
    }

    @GetMapping("/transaccions/{idUser}")
    List<Transaccion> transaccionsUser(@PathVariable String idUser){
        List<Transaccion> transaccionsOrigen = repositoryTransaccion.findByIdUserOrigen(idUser);
        List<Transaccion> transaccionsDestino = repositoryTransaccion.findByIdUserDestino(idUser);
        List<Transaccion> transaccions = Stream.concat(transaccionsOrigen.stream(), transaccionsDestino.stream()).collect(Collectors.toList());
//
        return transaccions;



    }

    @PostMapping("/transaccions")
    Transaccion newTransaccion(@RequestBody Transaccion transaccion){
        Cuenta cuentaOrigen = repositoryCuenta.findById(transaccion.getIdUserOrigen()).orElse(null);
        Cuenta cuentaDestino = repositoryCuenta.findById(transaccion.getIdUserDestino()).orElse(null);

        if (cuentaOrigen == null) throw new RuntimeException("Cuenta de origen no encontrada");
        if (cuentaDestino == null) throw new RuntimeException("Cuenta de destino no encontrada");

        if (cuentaOrigen.getSaldo() < transaccion.getValor()) throw new RuntimeException("Saldo Insuficiente");

        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - transaccion.getValor());
        cuentaOrigen.setUltimoCambio(new Date());
        repositoryCuenta.save(cuentaOrigen);

        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + transaccion.getValor());
        cuentaDestino.setUltimoCambio(new Date());
        repositoryCuenta.save(cuentaDestino);

        transaccion.setFecha(new Date());
        return repositoryTransaccion.save(transaccion);


    }
}
