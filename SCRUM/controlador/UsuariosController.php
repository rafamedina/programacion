<?php
require_once '../modelo/class_usuario.php';

class UsuariosController
{
    private $modelo;

    public function __construct()
    {
        $this->modelo = new Usuario();
    }

    public function agregarUsuario($nombre, $apellido, $email, $telefono, $fecha_nacimiento)
    {
        return $this->modelo->agregarUsuario($nombre, $apellido, $email, $telefono, $fecha_nacimiento);
    }

    public function listarUsuarios()
    {
        return $this->modelo->obtenerUsuarios();
    }

    public function obtenerUsuarioPorId($id_usuario)
    {
        return $this->modelo->obtenerUsuarioPorId($id_usuario);
    }

    public function actualizarUsuario($id_usuario, $nombre, $apellido, $email, $telefono, $fecha_nacimiento)
    {
        $this->modelo->actualizarUsuario($id_usuario, $nombre, $apellido, $email, $telefono, $fecha_nacimiento);
    }

    public function eliminarUsuario($id_usuario)
    {
        $this->modelo->eliminarUsuario($id_usuario);
    }
}
