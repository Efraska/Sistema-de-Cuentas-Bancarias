package gm.cuentas.controlador;

import gm.cuentas.modelo.Cuenta;
import gm.cuentas.servicio.CuentaServicio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ViewScoped
public class IndexControlador {

    @Autowired
    CuentaServicio cuentaServicio;
    private List<Cuenta> cuentas;
    private Cuenta cuentaSeleccionada;

    private static final Logger logger =
            LoggerFactory.getLogger(IndexControlador.class);

    @PostConstruct
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.cuentas = cuentaServicio.listarCuentas();
        cuentas.forEach((cuenta) -> logger.info(cuenta.toString()));
    }

    public void agregarCuenta(){
        this.cuentaSeleccionada = new Cuenta();
    }
}
