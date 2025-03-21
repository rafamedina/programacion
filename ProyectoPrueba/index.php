<?php
require_once 'class_conexion.php';
require_once 'class_socios.php';
$conexion = new Conexion();

if ($conexion->conexion) {
    echo "Conexión exitosa al club deportivo.";
} else {
    echo "Error al conectar.";
}
$socios = new Socios();
$socios->obtenerSocios();
$conexion->cerrar();
