<?php
function leerClientes($archivo)
{
    $clientes = [];
    if (($handle = fopen($archivo, "r")) !== false) {
        while (($data = fgetcsv($handle, 1000, ",")) !== false) {
            // Verificar si la línea tiene datos antes de agregarla al array
            if (count($data) > 1) {
                $clientes[] = $data;
            }
        }
        fclose($handle);
    } else {
        echo "No se pudo abrir el archivo.";
    }
    return $clientes;
}

function escribirClientes($archivo, $clientes)
{
    if (($handle = fopen($archivo, "w")) !== false) {
        foreach ($clientes as $cliente) {
            fputcsv($handle, $cliente);
        }
        fclose($handle);
    } else {
        echo "No se pudo abrir el archivo para escribir.";
    }
}
