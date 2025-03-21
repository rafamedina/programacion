<?php
require_once '../controlador/UsuariosController.php';

$usuariosController = new UsuariosController();

if (isset($_GET['id'])) {
    $id_usuario = $_GET['id'];
    $usuario = $usuariosController->obtenerUsuarioPorId($id_usuario);

    // Check if the usuario exists
    if (!$usuario) {
        echo "Usuario no encontrado.";
        exit();
    }
} else {
    header("Location: lista_usuarios.php");
    exit();
}

// Handle form submission
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $id_usuario = $_POST['id'];
    $usuariosController->eliminarUsuario($id_usuario);
    header("Location: lista_usuarios.php");
    exit();
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Eliminar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <h1 class="mt-4">Eliminar Usuario</h1>
        <form method="POST">
            <div class="mb-3">
                <label for="id" class="form-label">ID:</label>
                <input type="text" name="id" class="form-control" value="<?php echo htmlspecialchars($usuario['id_usuario']); ?>" required>
            </div>
            <button type="submit" class="btn btn-danger">Eliminar Usuario</button>
        </form>
        <a href="lista_usuarios.php" class="btn btn-secondary mt-3">Volver a la lista de usuarios</a>
    </div>
</body>

</html>
