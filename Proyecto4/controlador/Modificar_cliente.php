<?php
require_once 'funciones.php'; // Importar las funciones

$archivo = "../datos/clientes.csv";
$clientes = leerClientes($archivo);
?>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Cliente</title>
</head>

<body>
    <h1>Listado de Clientes</h1>

    <?php
    // Depuración: Verificar si se están leyendo los datos correctamente
    echo "<pre>";
    var_dump($clientes);
    echo "</pre>";
    ?>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Correo</th>
            <th>Teléfono</th>
        </tr>

        <?php
        // Verificar si $clientes tiene datos
        if (count($clientes) > 0) {
            foreach ($clientes as $index => $cliente) {
                // Saltar la cabecera del archivo CSV (si la hay)
                if ($index > 0) { // Saltar la primera fila (cabecera)
                    echo "<tr>";
                    echo "<td>" . htmlspecialchars($cliente[0]) . "</td>";
                    echo "<td>" . htmlspecialchars($cliente[1]) . "</td>";
                    echo "<td>" . htmlspecialchars($cliente[2]) . "</td>";
                    echo "<td>" . htmlspecialchars($cliente[3]) . "</td>";
                    echo "</tr>";
                }
            }
        } else {
            echo "<tr><td colspan='4'>No hay clientes disponibles.</td></tr>";
        }
        ?>
    </table>

    <h2>Modificar Cliente</h2>
    <form action="actualizar_cliente.php" method="POST">
        <label for="id">ID del Cliente a Modificar:</label>
        <input type="number" name="id" id="id" required>
        <button type="submit">Seleccionar</button>
    </form>
</body>

</html>